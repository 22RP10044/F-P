import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/mission__order";
        String dbUser = "root";
        String dbPassword = ""; // Replace with your actual DB password

        String role = null;
        boolean isAuthenticated = false;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Prepare and execute query
            String sql = "SELECT Role FROM users WHERE Name = ? AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                role = resultSet.getString("Role");
                isAuthenticated = true;
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            switch (role) {
                case "daf":
                    response.sendRedirect("daf.jsp");
                    break;
                case "CSDM":
                    response.sendRedirect("cdsm.jsp");
                    break;
                case "Secretary":
                    response.sendRedirect("secretary.jsp");
                    break;
                case "Supervisor":
                    response.sendRedirect("supervisor.jsp");
                    break;
                case "Receiver":
                    response.sendRedirect("receiver.jsp");
                    break;
                case "Admin":
                    response.sendRedirect("agnes.jsp");
                    break;
                default:
                    response.sendRedirect("home.jsp?error=Invalid Role");
                    break;
            }
        } else {
            // Redirect to home.jsp with error parameter
            response.sendRedirect("home.jsp?error=Invalid Credentials, User does not exist.");
        }
    }
}
