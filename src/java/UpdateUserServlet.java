import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mission__order";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        int userId = Integer.parseInt(request.getParameter("userId"));
        String name = request.getParameter("Name");
        String role = request.getParameter("userRole");
        String password = request.getParameter("Password");

        // Debugging output
        System.out.println("Updating user with ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Password: " + password);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET Name = ?, Role = ?, Password = ? WHERE user_id = ?")) {

            // Set parameters for the SQL statement
            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setString(3, password);
            stmt.setInt(4, userId);

            // Execute the update statement
            int rowsUpdated = stmt.executeUpdate();

            // Check if update was successful
            if (rowsUpdated > 0) {
                response.sendRedirect("DisplayUserServlet");
            } else {
                response.getWriter().println("<html><body><h2>No user found with ID: " + userId + "</h2></body></html>");
            }
        } catch (SQLException e) {
            // Print the stack trace and return a friendly error message
            e.printStackTrace();
            response.getWriter().println("<html><body><h2>Error updating user: " + e.getMessage() + "</h2></body></html>");
        }
    }
}
