package servlets;

import backend.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by smint on 31.05.17.
 */
public class RemoveCategoryServlet extends HttpServlet {

    private Database database;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        //insert HTML-File here
        printWriter.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Hinzufügen</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form method=\"post\" >\n" +
                "            <h4>Kategorie hinzufügen</h4>\n" +
                "\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                      <span style=\"width:110px; display: inline-block;\">Kuerzel:</span><input type=\"shortcut\" name=\"shortcut\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "            </table>\n" +
                "            <input type='submit' value='Hinzuf&uuml;gen'/>\n" +
                "        </form>\n" +
                "\n" +
                "\n" +
                "    </body>\n" +
                "</html>\n");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter printWriter = response.getWriter();

        try {
            String shortcut = request.getParameter("shortcut");

            database = Database.getInstance();
            database.removeCategory(shortcut);
            database.save();

            response.sendRedirect("/categories");

        } catch(Exception e) {

            printWriter.print(e.getLocalizedMessage());

        }

    }
}
