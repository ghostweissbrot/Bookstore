package beans;

import backend.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private double summary = 0.0;

    public List<Book> getBasket() {
        return basket;
    }

    public double getSummary() {
        return summary;
    }

    public String addBook(Book book) {
        if (basket.contains(book)) {
            quantities.put(book, quantities.get(book) + 1);
        } else {
            basket.add(book);
            quantities.put(book, 1);
        }
        summary += book.getPrice();
        summary = round(summary);
        return "/shoppingcart.xhtml";
    }

    public String addBook(Book book, int quantity) {
        if (basket.contains(book)) {
            quantities.put(book, quantities.get(book) + quantity);
        } else {
            basket.add(book);
            quantities.put(book, quantity);
        }
        summary += ((double)quantity) * book.getPrice();
        summary = round(summary);
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

    public void setQuantity(Book book, int quantity) {
        if (basket.contains(book)) {
            quantities.put(book, quantity);
            updateSummary();
        }
    }

    public String decreaseQuantity(Book book) {
        if (basket.contains(book)) {
            if (quantities.get(book) == 1) {
                basket.remove(book);
                quantities.remove(book);
            } else {
                quantities.put(book, quantities.get(book) - 1);
            }
            summary -= book.getPrice();
            summary = round(summary);
        }
        summary = round(summary);
        return "shoppingcart.xhtml";
    }

    private void updateSummary() {
        double temp = 0;
        for(Map.Entry<Book, Integer> entry : quantities.entrySet()) {
            temp += entry.getKey().getPrice() * ((double)entry.getValue());
        }
        temp = round(temp);
        summary = temp;
    }

    public String removeBook(Book book) {
        if (basket.contains(book)) {
            basket.remove(book);
            summary -= ((double) quantities.get(book)) * book.getPrice();
        }
        if(basket.isEmpty()) {
            summary = 0.0;
        }
        summary = round(summary);
        return "shoppingcart.xhtml";
    }

    public static double round(double value) {
        int places = 2;
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String finish() {
        //TODO save order details in KVS
        reset();
        return "/finish.jsf";
    }

    public void reset() {
        basket = new ArrayList<Book>();
        quantities = new HashMap<Book, Integer>();
        summary = 0.0;
    }

    public Map<Book, Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Book, Integer> quantities) {
        this.quantities = quantities;
    }

    public void valueChangeListener(ValueChangeEvent e) {
        Book book = (Book) ((UIInput) e.getSource()).getAttributes().get("currentBook");
        int quantity = Integer.parseInt(e.getNewValue().toString());
        quantities.put(book,quantity);
        updateSummary();
    }
}
