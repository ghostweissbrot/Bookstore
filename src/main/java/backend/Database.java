package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.imut.ec.keyvaluestore.KeyValueStore;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Database INSTANCE;

    public KeyValueStore getKvs() {
        return kvs;
    }

    private KeyValueStore kvs;
    private Map<String, Category> categorys;
    private Gson gson;

    private String categorysJSON;

    private static final String categorysKey= "rFmN7V4NVROK29doJcAsOos6T4OVXtiqup7DF5ui";

    private Database() {
        gson = new Gson();
        categorysJSON="";
        kvs = new KeyValueStore();
        categorys = new HashMap<String, Category>();
        load();
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
        if(!categorys.containsKey(book.getCategory())) {
            categorys.put(book.getCategory(), new Category(book.getCategory()));
        }
        categorys.get(book.getCategory()).addBook(book);
    }

    public void save() {
        categorysJSON = gson.toJson(categorys);
        kvs.put(categorysKey, categorysJSON);
    }

    public void load() {
        Type categorysType = new TypeToken<HashMap<String, Category>>() {}.getType();
        categorys = gson.fromJson(kvs.get(categorysKey), categorysType);
        if(categorys == null) {
            categorys = new HashMap<String, Category>();
        }
    }

    public Map<String, Category> getCategorys() {
        return categorys;
    }

    public void addCategory(String name) {
        if(!categorys.containsKey(name)) {
            categorys.put(name, new Category(name));
        }
    }

    public void removeCategory(String name) {
        if(categorys.containsKey(name)) {
            categorys.remove(name);
        }
    }

    public void setCategorys(Map<String, Category> categorys) {
        this.categorys = categorys;
    }
}
