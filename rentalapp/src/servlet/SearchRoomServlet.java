package servlet;

import model.Apartment;
import model.Model;
import model.Owner;
import util.RoomFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/searchRoom")
public class SearchRoomServlet extends HttpServlet
{
    private Model model;

    @Override
    public void init() throws ServletException
    {
        model = (Model) getServletContext().getAttribute("model");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Check if user is logged in and is a Customer
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null)
        {
            response.sendRedirect("/index.html");
            return;
        }
        else if (model.getUser((String) session.getAttribute("username")) instanceof Owner)
        {
            response.sendRedirect("/index.html");
            return;
        }

        // What do we need
        ArrayList<Apartment> apartments;
        RoomFilter roomFilter = new RoomFilter();

        String location;
        double priceMax, sizeMin, sizeMax;

        // The response
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Attempt to extract query string parameters
        try {
            priceMax = Double.parseDouble(request.getParameter("maxprice"));
        } catch (Exception nfe){
            priceMax = -1.0;
        }

        try {
            sizeMin = Double.parseDouble(request.getParameter("roomsizeMin"));
        } catch (Exception nfe){
            sizeMin = 0.0;
        }

        try {
            sizeMax = Double.parseDouble(request.getParameter("roomsizeMax"));
        } catch (Exception nfe){
            sizeMax = -1.0;
        }

        location = request.getParameter("location");

        // Set up our room filter
        roomFilter.location(location).priceMax(priceMax).sizeMax(sizeMax).sizeMin(sizeMin);
        apartments = model.getApartments(roomFilter);

        // Show what we got
        out.print("<a href=\"/login\">Back to search</a> // <a href=\"/logout\">Logout</a><br /><br />");
        out.print(model.apartmentsToHTML(apartments));
    }
}
