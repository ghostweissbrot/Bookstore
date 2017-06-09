package beans;

import backend.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smint on 09.06.17.
 */

@ManagedBean
@SessionScoped

public class ShoppingCartBean {

    private List<Book> basket = new ArrayList<Book>();
    private Map<Book, Integer> quantities = new HashMap<Book, Integer>();
    private double summary = 0;

    public List<Book> getBasket() {
        return basket;
    }

    public double getSummary() {
        summary *= 100;
        int temp = (int) summary;
        summary = (double) temp / 100.0;
        return summary;
    }

    public String addBook(Book book) {
        if (basket.contains(book)) {
            quantities.put(book, quantities.get(book) + 1);
        } else {
            basket.add(book);
            quantities.put(book, 1);
        }
        if (book != null) {
            summary += book.getPrice();
        }
        return "/shoppingcart.xhtml";
    }

    public int getQuantity(Book book) {
        return quantities.get(book);
    }

    public List<Integer> getAllowedQuantities() {
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        return temp;
    }

    public String setQuantity(Book book, int quantity) {
        if(basket.contains(book)) {
            quantities.put(book, quantity);
        }
        return "shoppingcart.xhtml";
    }

    public String decreaseBook(Book book) {
        if (basket.contains(book)) {
            if (quantities.get(book) == 1) {
                basket.remove(book);
                quantities.remove(book);
            } else {
                quantities.put(book, quantities.get(book) - 1);
            }
            summary -= book.getPrice();
        }
        return "shoppingcart.xhtml";
    }

    public String removeBook(Book book) {
        if (basket.contains(book)) {
            basket.remove(book);
            if (quantities.containsKey(book)) {
                quantities.remove(book);
            }
        }
        return "shoppingcart.xhtml";
    }
}
