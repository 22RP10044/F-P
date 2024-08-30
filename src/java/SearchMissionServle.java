import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchMissionServlet")
public class SearchMissionServle extends HttpServlet {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/mission_order";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Method to initialize database connection
    private Connection initializeDatabase() throws SQLException {
        Connection conn = null;
        try {
            // Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found.", e);
        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            throw e;
        }
        return conn;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String personName = request.getParameter("personName");

        if (personName == null || personName.trim().isEmpty()) {
            response.sendRedirect("search.jsp"); // Redirect to search form if no name provided
            return;
        }

        try {
            Connection conn = initializeDatabase();
            String sql = "SELECT * FROM creation WHERE Person_Name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + personName + "%");
            ResultSet rs = pstmt.executeQuery();

            request.setAttribute("searchResults", rs);
            request.getRequestDispatcher("searchResults.jsp").forward(request, response);

            // Close the resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error retrieving data: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Handle POST requests in the same way as GET
    }

    @Override
    public String getServletInfo() {
        return "SearchMissionServlet for searching missions by person name";
    }
}
