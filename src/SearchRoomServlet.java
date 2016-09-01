import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/huurder")
public class SearchRoomServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("fouteinlog.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("huurder.html");
    }
}

//String username = request.getParameter("username");
//(Entities) this.getServletConfig().getServletContext().getAttribute("entities")
//User user = entities.findUser(username);
//request.getSession().setAttribute("user", user);