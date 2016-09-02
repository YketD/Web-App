package servlet;

import Model.Appartement;
import Model.ApplicationData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class ShowRoomsServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ApplicationData
                .getInstance()
                .getAppartements()
                .add(
                        new Appartement(
                                Integer.parseInt(request.getParameter("roomsize")),
                                Integer.parseInt(request.getParameter("price")),
                                request.getParameter("location")));

        request.setAttribute("table", getTable());
        request.getRequestDispatcher("/rooms.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("table", getTable());
        request.getRequestDispatcher("/rooms.jsp").forward(request, response);
    }

    private String getTable(){
        ArrayList<Appartement> appartements = ApplicationData.getInstance().getAppartements();
        String tablecontent = "";
        for (Appartement ap: appartements) {
            tablecontent +=
                    "<tr>" +
                            "<th>" + ap.getSqrmtr() + "</th>" +
                            "<th>" + ap.getMaxprijs() + "</th>" +
                            "<th>" + ap.getPlaats() + "</th>" +
                            "</tr>";
        }
        return tablecontent;

    }
}
