package backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Category {

    private String name;
    private String shortcut;
    private ArrayList<String> books;

    public Category(String name, String shortcut) {
        setName(name);
        setShortcut(shortcut);
        books = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }
}
