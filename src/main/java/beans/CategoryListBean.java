package beans;

import backend.Category;
import backend.Database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created by smint on 08.06.17.
 */
@ManagedBean
@SessionScoped
public class CategoryListBean {

    private List<Category> categories = Database.getInstance().getCategoryList();
    private Category currentCategory;

    public String changeCategory(Category category) {
        currentCategory = category;
        return "/categories.xhtml";
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCurrentCategory() {
        if(currentCategory == null) {
            currentCategory = categories.get(0);
        }
        return currentCategory;
    }
}
