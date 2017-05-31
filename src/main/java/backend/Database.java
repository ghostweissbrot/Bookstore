package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.imut.ec.keyvaluestore.KeyValueStore;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        System.out.println("Errorr addBook 1");
        if(!categorys.containsKey(book.getCategory())) {
            Category cg = new Category(book.getCategory(), book.getCategory());
            cg.getBooks().add(book.getIsbn());
            addCategory(cg);
        }

        System.out.println("Errorr addBook 2");
    }

    public void removeBook(Book book) {
        categorys.get(book.getCategory()).getBooks().remove(book.getIsbn());
        books.remove(book.getIsbn());
    }

    public void removeBook(String isbn) {
        categorys.get(books.get(isbn).getCategory()).getBooks().remove(isbn);
        books.remove(isbn);
    }

    public void addCategory(String name, String shortcut) {
        Category cg = new Category(name, shortcut);
        categorys.put(shortcut, cg);
        getCategorys();
    }

    public void addCategory(Category category) {
        categorys.put(category.getShortcut(),category);
    }

    public void removeCategory(String shortcut) {
        if(categorys.containsKey(shortcut)) {
            String temp = "";
            while(!categorys.get(shortcut).getBooks().isEmpty()) {
                temp = categorys.get(shortcut).getBooks().get(0);
                books.remove(temp);
                categorys.get(shortcut).getBooks().remove(temp);
            }
            categorys.remove(shortcut);
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
        Type categorysType = new TypeToken<HashMap<String, Category>>() {}.getType();

        books = gson.fromJson(kvs.get(booksKey), booksType);
        categorys = gson.fromJson(kvs.get(categorysKey), categorysType);
    }

    public Map<String, Book> getBooks() {
        load();
        if(books == null) {
            books = new HashMap<String, Book>();
        }
        if(books.size() == 0) {
            addBook(getBookPlaceholder());
        } else if(books.size() > 1 && books.containsKey("placeholder")){
            books.remove("placeholder");
        }
        return books;
    }

    public Map<String, Category> getCategorys() {
        load();
        if(categorys == null) {
            categorys = new HashMap<String, Category>();
        }
        if(categorys.size() == 0) {
           addCategory(getCategoryPlaceholder());
        } else if(categorys.size() > 1 && categorys.containsKey("placeholder")){
            removeCategory("placeholder");
        }
        return categorys;
    }

    private Category getCategoryPlaceholder() {
        Category cg = new Category("Keine Vorhanden","placeholder");
        cg.getBooks().add("placeholder");
        return cg;
    }

    private Book getBookPlaceholder() {
        Book book = new Book();
        book.initPlaceholder();
        return book;
    }
    public void setCategorys(Map<String, Category> categorys) {
        this.categorys = categorys;
    }
}
