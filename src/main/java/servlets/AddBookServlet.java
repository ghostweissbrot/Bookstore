package servlets;

import backend.Book;
import backend.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AddBookServlet extends HttpServlet {

    private Database database;
    private static final String key = "rFmN7V4NVROK29doJcAsOos6T4OVXtiqup7DF5uu";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        //insert HTML-File here
        printWriter.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Buch hinzufügen</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <form method=\"post\" action=\"addBook\">\n" +
                "            <h4>Buch hinzufügen</h4>\n" +
                "\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                      <span style=\"width:110px; display: inline-block;\">Titel:</span><input type=\"titel\" name=\"title\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                       <span style=\"width:110px; display: inline-block;\">Autor:</span><input type=\"autor\" name=\"author\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                       <span style=\"width:110px; display: inline-block;\">Kategorie:</span><input type=\"Categorie\" name=\"category\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                       <span style=\"width:110px; display: inline-block;\">Release:</span><input type=\"Releasedate\" name=\"releasedate\" required/>\n" +
                "                    <td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                       <span style=\"width:110px; display: inline-block;\">Preis:</span><input type=\"price\" name=\"price\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                       <span style=\"width:110px; display: inline-block;\">Publisher:</span><input type=\"publisher\" name=\"publisher\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <span style=\"width:110px; display: inline-block;\">ISBN:</span><input type=\"isbn\" name=\"isbn\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                       <span style=\"width:110px; display: inline-block;\">Bild:</span><input type=\"imageurl\" name=\"image_url\" required/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <span style=\"width:110px; display: inline-block;\">Beschreibung</span><input type=\"description\" name=\"description\" required/>\n" +
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
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            String category = request.getParameter("category");
            String releasedate = request.getParameter("releasedate");
            String isbn = request.getParameter("isbn");
            String description = request.getParameter("description");
            String image_url = request.getParameter("image_url");
            double price = Double.parseDouble(request.getParameter("price"));

            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setCategory(category);
            book.setReleasedate(releasedate);
            book.setIsbn(isbn);
            book.setDescription(description);
            book.setImage_url(image_url);
            book.setPrice(price);

            database = Database.getInstance();
            database.addBook(book);
            database.saveCategorys();

            response.sendRedirect("/categories?category="+category);
            //printWriter.print(database.getKvs().get(key));

        } catch(Exception e) {

            printWriter.print(e.getLocalizedMessage());

        }

    }

}
