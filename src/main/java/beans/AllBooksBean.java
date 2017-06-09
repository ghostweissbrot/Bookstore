package beans;

import backend.Book;
import backend.Category;
import backend.Database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smint on 09.06.17.
 */

@ManagedBean
@SessionScoped
public class AllBooksBean {

    private List<Book> allBooks;

    public List<Book> getAllBooks() {
        allBooks = new ArrayList<Book>();
        for(Category category : Database.getInstance().getCategorys().values()) {
            for(Book book : category.getBooks().values()) {
                allBooks.add(book);
            }
        }
        return allBooks;
    }
}
