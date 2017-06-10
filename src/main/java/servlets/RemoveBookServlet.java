package servlets;

import backend.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RemoveBookServlet extends HttpServlet {

    private Database database;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>\n" +
                "    <head>\n" +
                "        <title>L&ouml;schen</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h4>Buch aus der Datenbank l&ouml;schen</h4>\n" +
                "        <form method=\"post\" action=\"removeBook\" >\n" +
                "            <span style=\"width:100px; display: inline-block;\">ISBN: </span><input type=\"isbn\" name=\"isbn\" required/>\n" +
                "            <input type=\"submit\" value = \"L&ouml;schen\"/>\n" +
                "        </form>\n" +
                "    </body>\n" +
                "</html>\n");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter printWriter = response.getWriter();
        database = Database.getInstance();

        try {
            String isbn = request.getParameter("isbn");

            if(database.containsBook(isbn)) {
                database.removeBook(isbn);
                database.saveCategorys();
                response.sendRedirect("/listBooks");
            } else {
                printWriter.println("Book not present.");
            }

        } catch (Exception e) {

            e.printStackTrace();
           printWriter.print(e.getLocalizedMessage());

        }
    }

}
