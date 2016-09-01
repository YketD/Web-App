package servlet;

import Model.ApplicationData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (ApplicationData.getInstance().getUser(username, password) != null)
        {
            request.getSession().setAttribute("username", username);
            
            type = ApplicationData.getInstance().getUser(username).isOwner();
            if (type)
                redirectURL = "rooms.jsp";
            else
                redirectURL = "huurder.html";
        }
        else
        {
            redirectURL = "fouteinlog.html";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectURL);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
