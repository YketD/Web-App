package servlet;

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

/**
 * Created by yketd on 1-9-2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
    boolean type;
    String redirectURL;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Find a user matching the given username and password
        for(User findUser : (ArrayList<User>)getServletContext().getAttribute("users"))
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                user = findUser;

        // Login if user is found
        if (user != null)
        {
            request.getSession().setAttribute("username", username);

            boolean isOwner = user instanceof Owner;
            if (isOwner)
                redirectURL = "WEB-INF/rooms.html";
            else
                redirectURL = "WEB-INF/huurder.html";
        }
        else
        {
            redirectURL = "fouteinlog.html";
        }

        // And off we go
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectURL);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
}
