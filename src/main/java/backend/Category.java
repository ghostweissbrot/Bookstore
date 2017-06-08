package backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Category {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("books")
    @Expose
    private Map<String, Book> books;

    public Category(String name) {
        setName(name);
        books = new HashMap<String, Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public boolean containsBook(String isbn) {
        return books.containsKey(isbn);
    }

    public String getFirstBookURL() {
        return books.entrySet().iterator().next().getValue().getImage_url();
    }
}
