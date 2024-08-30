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

@WebServlet("/ManageReportServlet")
public class ManageReportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
            out.println("<meta name='description' content=''>");
            out.println("<meta name='author' content=''>");
            out.println("<title>Manage Reports</title>");
            out.println("<link href='vendor/fontawesome-free/css/all.min.css' rel='stylesheet' type='text/css'>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i' rel='stylesheet'>");
            out.println("<link href='css/sb-admin-2.min.css' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { background-color: #f8f9fc; margin: 0; padding: 0; }");
            out.println(".header { background-color: #003366; color: white; padding: 15px; text-align: center; }");
            out.println(".footer { background-color: #003366; color: white; padding: 10px; text-align: center; position: fixed; width: 100%; bottom: 0; }");
            out.println(".container-fluid { padding: 20px; }");
            out.println(".scrollable-form-container { max-height: 500px; overflow-y: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); margin: 20px 0; }");
            out.println("table {width: 100%; border-collapse: collapse; margin-bottom: 20px;}");
            out.println("table, th, td {border: 1px solid #ddd;}");
            out.println("th, td {padding: 12px; text-align: left;}");
            out.println("thead {background-color: black; color: white;}");
            out.println("tbody tr:nth-child(even) {background-color: #f2f2f2;}");
            out.println(".back-button { margin-bottom: 20px; padding: 5px 20px; background-color: black; color: white; border: none; border-radius: 5px; cursor: pointer; text-decoration: none; font-size: 16px; }");
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
            out.println("<a href='receiver.jsp' class='back-button'>Back</a>");
            out.println("<div class='scrollable-form-container'>");
            out.println("<h2>Reports List</h2>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Report ID</th>");
            out.println("<th>Report Title</th>");
            out.println("<th>Report Description</th>");
            out.println("<th>Uploaded File</th>");
            out.println("<th>Actions</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            try (Connection con = DBUtil.getConnection()) {
                String sql = "SELECT * FROM reports";
                try (PreparedStatement ps = con.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getInt("Rep_Id") + "</td>");
                        out.println("<td>" + rs.getString("Report_Title") + "</td>");
                        out.println("<td>" + rs.getString("Report_Description") + "</td>");
                        String filePath = rs.getString("Upload_Report");
                        out.println("<td>");
                        if (filePath != null && !filePath.isEmpty()) {
                            out.println("<a href='uploads/" + filePath + "' target='_blank'>View Report</a>");
                        } else {
                            out.println("No file uploaded");
                        }
                        out.println("</td>");
                        out.println("<td>");
                        out.println("<a href='UpdateReportServlet?Rep_Id=" + rs.getInt("Rep_Id") + "'>Edit</a> | ");
                        out.println("<a href='DeleteReportServlet?Rep_Id=" + rs.getInt("Rep_Id") + "'>Delete</a>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                }
            } catch (SQLException e) {
                out.println("<tr><td colspan='5'>Error retrieving data: " + e.getMessage() + "</td></tr>");
                e.printStackTrace();
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            // Footer
            out.println("<div class='footer'>");
            out.println("<p>&copy; 2024 Mission Order Management System. All rights reserved.</p>");
            out.println("</div>");

            // Scroll to Top Button
            out.println("<a class='scroll-to-top rounded' href='#page-top'>");
            out.println("<i class='fas fa-angle-up'></i>");
            out.println("</a>");

            // Logout Modal
            out.println("<div class='modal fade' id='logoutModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel' aria-hidden='true'>");
            out.println("<div class='modal-dialog' role='document'>");
            out.println("<div class='modal-content'>");
            out.println("<div class='modal-header'>");
            out.println("<h5 class='modal-title' id='exampleModalLabel'>Ready to Leave?</h5>");
            out.println("<button class='close' type='button' data-dismiss='modal' aria-label='Close'>");
            out.println("<span aria-hidden='true'>×</span>");
            out.println("</button>");
            out.println("</div>");
            out.println("<div class='modal-body'>Select 'Logout' below if you are ready to end your current session.</div>");
            out.println("<div class='modal-footer'>");
            out.println("<button class='btn btn-secondary' type='button' data-dismiss='modal'>Cancel</button>");
            out.println("<a class='btn btn-primary' href='LogoutServlet'>Logout</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            // Bootstrap core JavaScript
            out.println("<script src='vendor/jquery/jquery.min.js'></script>");
            out.println("<script src='vendor/bootstrap/js/bootstrap.bundle.min.js'></script>");
            out.println("<script src='vendor/jquery-easing/jquery.easing.min.js'></script>");
            out.println("<script src='js/sb-admin-2.min.js'></script>");
            out.println("<script src='vendor/chart.js/Chart.min.js'></script>");
            out.println("<script src='js/demo/chart-area-demo.js'></script>");
            out.println("<script src='js/demo/chart-pie-demo.js'></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ManageReportServlet for managing report data";
    }
}
