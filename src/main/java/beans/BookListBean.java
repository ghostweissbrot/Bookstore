package beans;

import backend.Book;
import backend.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by smint on 08.06.17.
 */

@ManagedBean
@SessionScoped
public class BookListBean {
    List<Book> books = new ArrayList<Book>();
    Category currentCategory;

    public void changeCategory(Category category) {
        currentCategory = category;
        books = new ArrayList<Book>(currentCategory.getBooks().values());
    }

    public List<Book> getBooks() {
        return books;
    }
}
