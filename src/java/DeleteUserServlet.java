import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUserServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mission__order";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE user_id = ?")) {

            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                response.sendRedirect("DisplayUserServlet");
            } else {
                response.getWriter().println("<html><body><h2>Error deleting user.</h2></body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<html><body><h2>Error deleting user.</h2></body></html>");
        }
    }
}
