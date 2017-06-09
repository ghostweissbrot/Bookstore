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

    public String changeBook(Book book) {
        currentBook = book;
        return "/book.xhtml";
    }

    public Book getCurrentBook() {
        return currentBook;
    }
}
