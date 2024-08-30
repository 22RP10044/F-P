import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ReportServlet")
@MultipartConfig
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mission__order";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Update with your DB password

    private static final String[] ALLOWED_EXTENSIONS = { "pdf", "jpg", "jpeg" };

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String reportTitle = request.getParameter("reportTitle");
        String reportDescription = request.getParameter("reportDescription");
        Part filePart = request.getPart("reportFile"); // Get the file part from the request

        String fileName = filePart.getSubmittedFileName();
        String fileExtension = getFileExtension(fileName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (!isValidFileExtension(fileExtension)) {
            out.print("<script>alert('Invalid file type. Only PDF and JPG/JPEG files are allowed.');window.location.href='reportupload.jsp';</script>");
            return;
        }

        // Ensure uploads directory exists
        String uploadsDir = getServletContext().getRealPath("/") + "uploads";
        File uploadsDirFile = new File(uploadsDir);
        if (!uploadsDirFile.exists()) {
            uploadsDirFile.mkdirs(); // Create directory if it doesn't exist
        }

        // Save the file to the uploads directory
        String filePath = uploadsDir + File.separator + fileName;
        filePart.write(filePath);

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Insert data into the database
                String sql = "INSERT INTO reports (Report_Title, Report_Description, Upload_Report) VALUES (?, ?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, reportTitle);
                    ps.setString(2, reportDescription);
                    ps.setString(3, filePath);

                    int rowsInserted = ps.executeUpdate();
                    if (rowsInserted > 0) {
                        out.print("<script>alert('Report has been successfully submitted');window.location.href='reportupload.jsp';</script>");
                    } else {
                        out.print("<script>alert('Failed to submit the report'); window.location.href='reportupload.jsp';</script>");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<h2>Error: " + e.getMessage() + "</h2>");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1).toLowerCase();
    }

    private boolean isValidFileExtension(String fileExtension) {
        for (String ext : ALLOWED_EXTENSIONS) {
            if (ext.equals(fileExtension)) {
                return true;
            }
        }
        return false;
    }
}
