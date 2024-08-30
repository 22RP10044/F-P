import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadReportServlet")
public class DownloadReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reportId = Integer.parseInt(request.getParameter("Rep_Id"));

        // Set content type and attachment header for PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Document" + reportId + ".pdf");

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT Upload_Report FROM reports WHERE Rep_Id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, reportId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Fetch file from database
                        InputStream inputStream = rs.getBinaryStream("Upload_Report");
                        if (inputStream != null) {
                            try (OutputStream outputStream = response.getOutputStream()) {
                                byte[] buffer = new byte[4096];
                                int bytesRead;
                                while ((bytesRead = inputStream.read(buffer)) != -1) {
                                    outputStream.write(buffer, 1, bytesRead);
                                }
                                outputStream.flush();
                            } catch (IOException e) {
                                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error writing file to output stream.");
                                e.printStackTrace();
                            }
                        } else {
                            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
                        }
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
}
