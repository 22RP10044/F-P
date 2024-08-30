import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class superAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch the username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Sample validation logic (you should replace this with your actual authentication logic)
        if ("admin".equals(username) && "123456".equals(password)) {
            // Create a session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to agnes.jsp
            response.sendRedirect("agnes.jsp");
        } else {
            // Redirect to the login page with an error message
            response.sendRedirect("index.html?error=Invalid username or password");
        }
    }
}
