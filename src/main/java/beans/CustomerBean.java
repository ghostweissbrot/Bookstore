package beans;

import backend.Customer;
import backend.Database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by smint on 10.06.17.
 */
@ManagedBean
@SessionScoped

public class CustomerBean {

    private String firstname;
    private String lastname;
    private String street;
    private String number;
    private String postcode;
    private String location;
    private String email;
    private String paymentMethod;
    private String cardType;
    private String creditCardNumber;
    private String checksum;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public void save() {
        Customer c = new Customer();
        c.setFirstname(firstname);
        c.setLastname(lastname);
        c.setStreet(street);
        c.setNumber(number);
        c.setPostcode(postcode);
        c.setLocation(location);
        c.setEmail(email);
        c.setPaymentMethod(paymentMethod);
        c.setCardType(cardType);
        c.setCreditCardNumber(creditCardNumber);
        c.setChecksum(checksum);
        Database.getInstance().addCustomer(c);
    }
}
