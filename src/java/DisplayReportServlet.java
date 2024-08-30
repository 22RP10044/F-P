import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/DisplayReportServlet")
public class DisplayReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mission__order";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Update with your DB password

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String reportId = request.getParameter("Rep_Id");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
            out.println("<meta name='description' content=''>");
            out.println("<meta name='author' content=''>");
            out.println("<title>View Report</title>");
            out.println("<link href='vendor/fontawesome-free/css/all.min.css' rel='stylesheet' type='text/css'>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i' rel='stylesheet'>");
            out.println("<link href='css/sb-admin-2.min.css' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { background-color: #f8f9fc; margin: 0; padding: 0; }");
            out.println(".header { background-color: #003366; color: white; padding: 15px; text-align: center; }");
            out.println(".footer { background-color: #003366; color: white; padding: 10px; text-align: center; position: fixed; width: 100%; bottom: 0; }");
            out.println(".container-fluid { padding: 20px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body id='page-top'>");

            // Header
            out.println("<div class='header'>");
            out.println("<h1>Mission Order Management System - IPRC Karongi</h1>");
            out.println("</div>");

            // Content Wrapper
            out.println("<div id='content-wrapper' class='d-flex flex-column'>");

            // Main Content
            out.println("<div id='content'>");

            // Begin Page Content
            out.println("<div class='container-fluid'>");

            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    // Query to get the report data
                    String sql = "SELECT * FROM reports WHERE Rep_Id = ?";
                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setInt(1, Integer.parseInt(reportId));
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                out.println("<h2>Report Details</h2>");
                                out.println("<p><strong>Report ID:</strong> " + rs.getInt("Rep_Id") + "</p>");
                                out.println("<p><strong>Title:</strong> " + rs.getString("Report_Title") + "</p>");
                                out.println("<p><strong>Description:</strong> " + rs.getString("Report_Description") + "</p>");
                                String filePath = rs.getString("Upload_Report");
                                if (filePath != null && !filePath.isEmpty()) {
                                    out.println("<p><strong>Uploaded File:</strong> <a href='uploads/" + filePath + "' target='_blank'>View Report</a></p>");
                                } else {
                                    out.println("<p>No file uploaded.</p>");
                                }
                            } else {
                                out.println("<p>No report found with the given ID.</p>");
                            }
                        }
                    }
                } catch (SQLException e) {
                    out.println("<p>Error retrieving data: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                out.println("<p>Error loading database driver: " + ex.getMessage() + "</p>");
                ex.printStackTrace();
            }

            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            // Footer
            out.println("<div class='footer'>");
            out.println("<p>&copy; 2024 Mission Order Management System. All rights reserved.</p>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for displaying a single report based on ID";
    }
}
