import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user details from the request
        String name = request.getParameter("Name");
        String role = request.getParameter("userRole");
        String password = request.getParameter("Password");

        // Password validation
        if (!isValidPassword(password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Password is not strong enough. It must be at least 8 characters long and include an uppercase letter, a lowercase letter, a digit, and a special character.');");
            out.println("location='Adduser.jsp';"); // Redirect back to form if validation fails
            out.println("</script>");
            return;
        }

        // Database connection
        String jdbcURL = "jdbc:mysql://localhost:3306/mission__order";
        String dbUser = "root"; // Change as per your database credentials
        String dbPassword = "";  // Change as per your database credentials

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String sql = "INSERT INTO users (Name, Role, Password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, role);
            statement.setString(3, password); // Consider hashing the password before storing it.

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User added successfully!');");
                out.println("location='Adduser.jsp';"); // Redirect back to form after success
                out.println("</script>");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidPassword(String password) {
        // Minimum 8 characters, at least one uppercase letter, one lowercase letter, one digit, and one special character
       String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
return password != null && password.matches(passwordPattern);
    }
}