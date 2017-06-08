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

    private DataModel<Category> categories;
    private Category currentCategory;

    public List<Category> getCategories() {
        categories = new ListDataModel<Category>();
        List<Category> categoriesList = Database.getInstance().getCategoryList();
        categories.setWrappedData(categoriesList);
        return categoriesList;
    }
}
