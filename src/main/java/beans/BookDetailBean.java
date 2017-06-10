package beans;

import backend.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by smint on 09.06.17.
 */

@ManagedBean
@SessionScoped
public class BookDetailBean {

    private Book currentBook;
    private int quantity = 1;

    public String changeBook(Book book) {
        currentBook = book;
        quantity = 1;
        return "/book.xhtml";
    }

    public Book getCurrentBook() {
        return currentBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
