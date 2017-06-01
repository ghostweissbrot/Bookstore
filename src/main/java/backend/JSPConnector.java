package backend;

import java.util.Map;

/**
 * Created by smint on 01.06.17.
 */
public class JSPConnector {

    public static String getBooklist(String category) {
        Database db = Database.getInstance();
        StringBuilder stb = new StringBuilder();
        if(db.getCategorys().get(category) == null) {
         return "error";
        }

        if(db.getCategorys().get(category).getBooks().size() < 2) {
            if(db.getCategorys().get(category).getBooks().contains("placeholder")) {
                return "Keine Bücher vorhanden.";
            }
        }
        for(String isbn : db.getCategorys().get(category).getBooks()) {
            stb.append("<div class=\"column is-2\">\n" +
                    "                        <a href=\"\">\n" +
                    "                            <div class=\"card has-text-centered\">\n" +
                    "                                <div class=\"card-image\">\n" +
                    "                                    <img\n" +
                    "                                            src=\""+ db.getBooks().get(isbn).getImage_url() + "\"\n" +
                    "                                            width=\"150\" height=\"200\">\n" +
                    "                                </div>\n" +
                    "                                <div class=\"card-content\">\n" +
                    "                                    <p class=\"title is-4\">"+db.getBooks().get(isbn).getTitle()+"</p>\n" +
                    "                                    <p class=\"subtitle is-6\">"+db.getBooks().get(isbn).getAuthor()+"</p>\n" +
                    "                                </div>\n" +
                    "\n" +
                    "                                <footer class=\"card-footer\">\n" +
                    "                                    <a href=\"shoppingcart.html\" class=\"card-footer-item\">\n" +
                    "                                        \n" +
                    "                                         <figure class=\"image is-16x16\" style=\"margin-right: 8px;\">\n" +
                    "                                             <img src=\"http://www.kingbutton.de/generator/images/warenkorb.png\"\n" +
                    "                                                  height=\"60\"\n" +
                    "                                                  width=\"60\">\n" +
                    "                                         </figure>\n" +
                    "                                         In den Warenkorb - "+db.getBooks().get(isbn).getPrice()+"&euro;\n" +
                    "                                    </a>\n" +
                    "                                </footer>\n" +
                    "                            </div>\n" +
                    "                        </a></div>");
        }

        return stb.toString();
    }

    public static String getCategoryList() {
        Database db = Database.getInstance();
        StringBuilder stb = new StringBuilder();

        for (Map.Entry<String, Category> entry : db.getCategorys().entrySet()) {
            stb.append("<div class=\"column is-2\">\n" +
                    "                        <div class=\"card has-text-centered\">\n" +
                    "                            <div class=\"card-image\">\n" +
                    "                                <a href=\"categories.jsp?category="+entry.getKey()+"\"><img\n" +
                    "                                        src=\""+db.getBooks().get(entry.getValue().getBooks().get(0)).getImage_url()+"\"\n" +
                    "                                        width=\"200\" height=\"200\"></a>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"card-content\"><a href=\"categories.jsp?category="+entry.getKey()+"\"\n" +
                    "                                                         class=\"title\">"+entry.getValue().getName()+"\n" +
                    "                            </a></div>\n" +
                    "                        </div>\n" +
                    "                    </div>");
        }

        return stb.toString();
    }
}
