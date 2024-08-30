import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateReportServlet")
public class UpdateReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reportId = Integer.parseInt(request.getParameter("Rep_Id"));

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT * FROM reports WHERE Rep_Id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, reportId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        request.setAttribute("Rep_Id", rs.getInt("Rep_Id"));
                        request.setAttribute("Report_Title", rs.getString("Report_Title"));
                        request.setAttribute("Report_Description", rs.getString("Report_Description"));
                        // Forward to JSP to display form
                        request.getRequestDispatcher("updateReport.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Report not found.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reportId = Integer.parseInt(request.getParameter("Rep_Id"));
        String reportTitle = request.getParameter("Report_Title");
        String reportDescription = request.getParameter("Report_Description");

        try (Connection con = DBUtil.getConnection()) {
            String sql = "UPDATE reports SET Report_Title = ?, Report_Description = ? WHERE Rep_Id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, reportTitle);
                ps.setString(2, reportDescription);
                ps.setInt(3, reportId);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("ManageReportServlet"); // Redirect to the view reports page
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
