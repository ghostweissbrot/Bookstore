package backend;

import java.util.List;

/**
 * Created by smint on 12.06.17.
 */
public class Order {

    private String customerEmail;
    private List<String> booknames;
    private double summary;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<String> getBooknames() {
        return booknames;
    }

    public void setBooknames(List<String> booknames) {
        this.booknames = booknames;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }
}
