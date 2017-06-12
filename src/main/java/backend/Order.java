package backend;

import java.util.List;
import java.util.Map;

/**
 * Created by smint on 12.06.17.
 */
public class Order {

    private String customerEmail;
    private Map<String, Integer> books;
    private double summary;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Map<String, Integer> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Integer> books) {
        this.books = books;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }
}
