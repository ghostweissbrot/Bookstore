package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.imut.ec.keyvaluestore.KeyValueStore;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static Database INSTANCE;

    public KeyValueStore getKvs() {
        return kvs;
    }

    private KeyValueStore kvs;
    private Map<String, Category> categorys;
    private Map<String, Customer> customers;
    private Map<String, List<Order>> orders;

    private Gson gson;

    private String categorysJSON;
    private String customersJSON;
    private String ordersJSON;

    private static final String categorysKey= "rFmN7V4NVROK29doJcAsOos6T4OVXtiqup7DF5ui";
    private static final String customersKey= "si51I7duWBzNK3XUhB2LXBAsK8y25XriIZH6dgmx";
    private static final String ordersKey= "4n9QUgsY1zasQM4Ka080jKXODKERdBX4t6xeodeg";

    private Database() {
        gson = new Gson();
        kvs = new KeyValueStore();
        categorys = new HashMap<String, Category>();
        customers = new HashMap<String, Customer>();
        orders = new HashMap<String, List<Order>>();
        loadCategorys();
        loadCustomers();
        loadOrders();
    }

    public static Database getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public void removeBook(String isbn) {
        for(Map.Entry<String, Category> entry: categorys.entrySet()) {
            if(entry.getValue().containsBook(isbn)) {
                entry.getValue().removeBook(isbn);
                //TODO check
                if(entry.getValue().getBooks().isEmpty()) {
                    categorys.remove(entry.getKey());
                }
            }
        }
    }

    public boolean containsBook(String isbn) {
        for(Map.Entry<String, Category> entry: categorys.entrySet()) {
            if(entry.getValue().containsBook(isbn)) {
                return  true;
            }
        }
        return false;
    }

    public void addBook(Book book) {
        loadCategorys();
        if(!categorys.containsKey(book.getCategory())) {
            categorys.put(book.getCategory(), new Category(book.getCategory()));
        }
        categorys.get(book.getCategory()).addBook(book);
        saveCategorys();
    }

    public void saveCategorys() {
        categorysJSON = gson.toJson(categorys);
        kvs.put(categorysKey, categorysJSON);
    }

    public void loadCategorys() {
        Type categorysType = new TypeToken<HashMap<String, Category>>() {}.getType();
        categorys = gson.fromJson(kvs.get(categorysKey), categorysType);
        if(categorys == null) {
            categorys = new HashMap<String, Category>();
        }
    }

    private void saveCustomers() {
        customersJSON = gson.toJson(customers);
        kvs.put(customersKey, customersJSON);
    }

    private void loadCustomers() {
        Type customersType = new TypeToken<HashMap<String, Customer>>() {}.getType();
        customers = gson.fromJson(kvs.get(customersKey), customersType);
        if(customers == null) {
            customers = new HashMap<String, Customer>();
        }
    }

    private void saveOrders() {
        ordersJSON = gson.toJson(orders);
        kvs.put(ordersKey, ordersJSON);
    }

    private void loadOrders() {
        Type ordersType = new TypeToken<HashMap<String, List<Order>>>() {}.getType();
        orders = gson.fromJson(kvs.get(ordersKey), ordersType);
        if(orders == null) {
            orders = new HashMap<String, List<Order>>();
        }
    }

    public void addOrder(Order order) {
        loadOrders();
        if(!orders.containsKey(order.getCustomerEmail())) {
            orders.put(order.getCustomerEmail(), new ArrayList<Order>());
        }
        orders.get(order.getCustomerEmail()).add(order);
        saveOrders();
    }

    public Map<String, Category> getCategorys() {
        return categorys;
    }

    public void addCategory(String name) {
        loadCategorys();
        if(!categorys.containsKey(name)) {
            categorys.put(name, new Category(name));
        }
        saveCategorys();
    }

    public List<Category> getCategoryList() {
        return new ArrayList<Category>(getCategorys().values());
    }

    public void removeCategory(String name) {
        if(categorys.containsKey(name)) {
            categorys.remove(name);
        }
    }

    public void addCustomer(Customer customer) {
        loadCustomers();
        customers.put(customer.getEmail(), customer);
        saveCustomers();
    }

    public void setCategorys(Map<String, Category> categorys) {
        this.categorys = categorys;
    }
}
