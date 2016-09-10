package servlet;

import model.Customer;
import model.Owner;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        if (getServletContext().getAttribute("users") == null){
            getServletContext().setAttribute("users", new ArrayList<User>());
        }
        if (type.equals("o"))
        {
            Owner user = new Owner(username, password);

            ((ArrayList<User>)getServletContext().getAttribute("users")).add(user);

        }
        else
        {
            Customer user = new Customer(username, password);
            ((ArrayList<User>)getServletContext().getAttribute("users")).add(user);

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
