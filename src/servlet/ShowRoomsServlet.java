package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class ShowRoomsServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*
        AppContext
                .getInstance()
                .getApartments()
                .add(
                        new Apartment(
                                Integer.parseInt(request.getParameter("roomsize")),
                                Integer.parseInt(request.getParameter("price")),
                                request.getParameter("location")));
        */

        request.setAttribute("table", getTable());
        request.getRequestDispatcher("/rooms.html").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("table", getTable());
        request.getRequestDispatcher("/rooms.html").forward(request, response);
    }

    private String getTable()
    {
        /*
        ArrayList<Apartment> apartments = AppContext.getInstance().getApartments();
        String tablecontent = "";
        for (Apartment ap: apartments) {
            tablecontent +=
                    "<tr>" +
                            "<th>" + ap.getSqrmtr() + "</th>" +
                            "<th>" + ap.getMaxprijs() + "</th>" +
                            "<th>" + ap.getPlaats() + "</th>" +
                            "</tr>";
        }
        return tablecontent;
        */
        return "";
    }
}
