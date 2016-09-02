package servlet;

import Model.Appartement;
import Model.ApplicationData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/huurder")
public class SearchRoomServlet extends HttpServlet
{
    ArrayList<Appartement> appartements;
    ArrayList<Appartement> resultAppartements;

    int prijsmax, sqrmtrmin, sqrmtrmax;
    String location;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("fouteinlog.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        appartements = ApplicationData.getInstance().getAppartements();
        resultAppartements = new ArrayList<>();

        try {
            prijsmax = Integer.parseInt(request.getParameter("maxprice"));
        }catch (NumberFormatException nfe){
            prijsmax = 0;
        }
        try {
        sqrmtrmax = Integer.parseInt(request.getParameter("roomsizeMax"));
        }catch (NumberFormatException nfe){
            sqrmtrmax = Integer.MAX_VALUE;
        }
        try {
            sqrmtrmin = Integer.parseInt(request.getParameter("roomsizeMin"));
        }catch (NumberFormatException nfe){
            sqrmtrmin = 0;
        }
        location = request.getParameter("location");

        for (Appartement ap : appartements)
            if (prijsmax == 0 || prijsmax > ap.getMaxprijs())
                if (sqrmtrmin == 0 || sqrmtrmin < ap.getSqrmtr())
                    if (sqrmtrmax == 0 || sqrmtrmax > ap.getSqrmtr())
                        if (location == "" || location.equalsIgnoreCase(ap.getPlaats()))
                            resultAppartements.add(ap);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(getSearchResultTable(resultAppartements));


    }

    private String getSearchResultTable(ArrayList<Appartement> resultappartements){
        String tablecontent = "";

        tablecontent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p>\n" +
                "        <a href=\"login.html\">Logout</a>\n" +
                "        <br /><br />\n" +
                "    </p>\n" +
                "\n" +
                "    <form method=\"get\" action=\"/huurder\">\n" +
                "        <fieldset>\n" +
                "            <legend>Room search</legend>\n" +
                "\n" +
                "            <h3>Appartement size in Square Meters:</h3>\n" +
                "            <label for=\"roomsizeMin\">\n" +
                "                Min:\n" +
                "            </label>\n" +
                "            <input type=\"text\" name=\"roomsizeMin\" id=\"roomsizeMin\" />\n" +
                "            <label for=\"roomsizeMax\">\n" +
                "                Max:\n" +
                "            </label>\n" +
                "            <input type=\"text\" name=\"roomsizeMax\" id=\"roomsizeMax\" />\n" +
                "            <br />\n" +
                "\n" +
                "            <label for=\"maxprice\">\n" +
                "                Max. rental price\n" +
                "            </label>\n" +
                "            <input type=\"text\" name=\"maxprice\" id=\"maxprice\" />\n" +
                "            <br />\n" +
                "\n" +
                "            <label for=\"location\">\n" +
                "                Location\n" +
                "            </label>\n" +
                "            <input type=\"text\" name=\"location\" id=\"location\" />\n" +
                "            <br />\n" +
                "\n" +
                "            <input type=\"submit\" value=\"Search\" />\n" +
                "        </fieldset>\n" +
                "    </form>" +
                "<table style=\"border: groove\">";

        for (Appartement ap: resultappartements) {
            tablecontent +=
                    "<tr>" +
                            "<th>" + ap.getSqrmtr() + "</th>" +
                            "<th>" + ap.getMaxprijs() + "</th>" +
                            "<th>" + ap.getPlaats() + "</th>" +
                            "</tr>";
        }

        tablecontent += "</table>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(tablecontent);

        return tablecontent;

    }
}
