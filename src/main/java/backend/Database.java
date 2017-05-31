package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.imut.ec.keyvaluestore.KeyValueStore;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smint on 10.05.17.
 */
public class Database {

    private static Database INSTANCE;

    public KeyValueStore getKvs() {
        return kvs;
    }

    private KeyValueStore kvs;
    private Map<String, Category> categorys;
    private Map<String, Book> books;
    private Gson gson;
    private String booksJSON;
    private String categorysJSON;

    private static final String booksKey = "rFmN7V4NVROK29doJcAsOos6T4OVXtiqup7DF5uu";
    private static final String categorysKey= "rFmN7V4NVROK29doJcAsOos6T4OVXtiqup7DF5ui";

    private Database() {
        gson = new Gson();
        booksJSON = "";
        categorysJSON="";
        kvs = new KeyValueStore();
        books = new HashMap<String, Book>();
        categorys = new HashMap<String, Category>();
    }

    public static Database getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);

    }

    public void removeBook(Book book) {
        books.remove(book.getIsbn());
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void addCategory(String name, String shortcut) {
        if(!categorys.containsKey(name)) {
            categorys.put(name, new Category(name, shortcut));
        }
    }

    public boolean containsBook(String isbn) {
        return books.containsKey(isbn);
    }

    public void save() {
        booksJSON = gson.toJson(books);
        kvs.put(booksKey, booksJSON);

        categorysJSON = gson.toJson(categorys);
        kvs.put(categorysKey, categorysJSON);
    }

    public void load() {
        Type booksType = new TypeToken<HashMap<String, Book>>() {}.getType();
        Type categorysType = new TypeToken<HashMap<String, Book>>() {}.getType();

        books = gson.fromJson(kvs.get(booksKey), booksType);
        categorys = gson.fromJson(kvs.get(categorysKey), categorysType);
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, Category> getCategorys() {
        //load(); //TODO remove
        return categorys;
    }

    public void setCategorys(Map<String, Category> categorys) {
        this.categorys = categorys;
    }
}
