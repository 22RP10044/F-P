import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteReportServlet")
public class DeleteReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reportId = Integer.parseInt(request.getParameter("Rep_Id"));

        try (Connection con = DBUtil.getConnection()) {
            String sql = "DELETE FROM reports WHERE Rep_Id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, reportId);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("ViewReportServlet"); // Redirect to the view reports page
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Report not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }
}
