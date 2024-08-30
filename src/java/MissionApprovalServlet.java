import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MissionApprovalServlet")
public class MissionApprovalServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Load MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "MySQL JDBC Driver not found: " + e.getMessage());
            return;
        }
        
        // Get parameters from the request
        String orderId = request.getParameter("order_id");
        String approvedBy = request.getParameter("approved_by");
        String approvalStatus = request.getParameter("approval_status");
        String approvalDate = request.getParameter("approval_date");
        String comments = request.getParameter("comments");
        
        // Database connection parameters
        String dbURL = "jdbc:mysql://localhost:3306/mission__order";
        String dbUser = "root";
        String dbPass = "";
        
        // SQL insert statement
        String sql = "INSERT INTO approval (OrderId, Approved_By, Approval_Status, Approval_Date, Comments) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Set parameters for the prepared statement
            ps.setString(1, orderId);
            ps.setString(2, approvedBy);
            ps.setString(3, approvalStatus);
            ps.setDate(4, java.sql.Date.valueOf(approvalDate));
            ps.setString(5, comments);
            
            // Execute the update
            int rowsAffected = ps.executeUpdate();
            
            // Redirect based on the result
            if (rowsAffected > 0) {
                response.sendRedirect("Approvel.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
        }
    }
}
