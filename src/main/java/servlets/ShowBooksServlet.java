package servlets;

import backend.Book;
import backend.Category;
import backend.Database;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;


public class ShowBooksServlet extends HttpServlet {

    private Database database;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        database = Database.getInstance();

       // Map<String, Category> categorys = database.getCategorys();
        Iterator iterator = database.getCategorys().entrySet().iterator();
        Category tempCategory;

        printWriter.print("<html>\n" +
                "    <head>\n" +
                "        <title>Ansicht</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <table border=1>\n" +
                "            <tr>\n" +
                "                <th>ISBN</th>\n" +
                "                <th>Bild</th>\n" +
                "                <th>Titel</th>\n" +
                "                <th>Autor</th>\n" +
                "                <th>Verlag</th>\n" +
                "                <th>Kategorie</th>\n" +
                "                <th>Erscheinungsdatum</th>\n" +
                "                <th>Preis</th>        \n" +
                "                <th>Beschreibung</th>\n" +
                "            </tr>\n");

        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            tempCategory = (Category) pair.getValue();
            Iterator iterator1 = tempCategory.getBooks().entrySet().iterator();

            Book temp;
            while(iterator1.hasNext()) {
                temp = (Book) iterator1.next();
                printWriter.print("<tr>"
                        +"<td> " + temp.getIsbn() + " </td>"
                        +"<td><img src=\"" + temp.getImage_url() + "\" width=\"50\" height=\"70\">" + " </td>"
                        +"<td> " + temp.getTitle() + " </td>"
                        +"<td> " + temp.getAuthor() + " </td>"
                        +"<td> " + temp.getPublisher() + " </td>"
                        +"<td> " + temp.getCategory() + " </td>"
                        +"<td> " + temp.getReleasedate() + " </td>"
                        +"<td> " + temp.getPrice() + "&euro; </td>"
                        +"<td> " + temp.getDescription() + " </td>"
                        +"</tr>");
            }
        }

        printWriter.print("</table>\n" +
                "    </body>\n" +
                "</html>");
    }

}
