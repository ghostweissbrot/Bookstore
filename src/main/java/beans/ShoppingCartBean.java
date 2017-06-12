package beans;

import backend.Book;
import backend.Database;
import backend.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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

    @ManagedProperty(value="#{customerBean}")
    private CustomerBean customerBean;

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
            if(quantity+quantities.get(book)>5) {
                quantities.put(book, 5);
                summary += ((double) 5-quantities.get(book)) * book.getPrice();
            } else {
                quantities.put(book, quantities.get(book) + quantity);
                summary += ((double)quantity) * book.getPrice();
            }
        } else {
            basket.add(book);
            quantities.put(book, quantity);
            summary += ((double)quantity) * book.getPrice();
        }
        summary = round(summary);
        return "/shoppingcart.xhtml";
    }

    public int getQuantity(Book book) {
        return quantities.get(book);
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
        summary = round(temp);
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
        Order order = new Order();
        order.setSummary(round(2.0+summary));
        ArrayList<String> booknames = new ArrayList<String>();
        for(Book book : basket) {
            booknames.add(book.getTitle());
        }
        order.setCustomerEmail(customerBean.getEmail());
        order.setBooknames(booknames);
        Database.getInstance().addOrder(order);
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
        UIInput temp = (UIInput) e.getSource();
        Object object =temp.getAttributes().get("currentBook");
        Book book = (Book) object;

        summary -= ((double)quantities.get(book)) * book.getPrice();
        int quantity = Integer.parseInt(e.getNewValue().toString());
        summary += quantity * book.getPrice();
        quantities.put(book, quantity);
        summary = round(summary);
    }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }
}
