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

@WebServlet("/RetrieveSingleMissionServlet")
public class RetrieveSingleMissionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Search Mission by Name</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f4f4f4;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("header {");
            out.println("    background-color: #003366;");
            out.println("    color: white;");
            out.println("    padding: 1px 0;");
            out.println("}");
            out.println("footer {");
            out.println("    background-color: #003366;");
            out.println("    color: white;");
            out.println("    padding: 1px 0;");
            out.println("    position: fixed;");
            out.println("    bottom: 0;");
            out.println("    width: 100%;");
            out.println("}");
            out.println("h2 {");
            out.println("    color: #333;");
            out.println("    margin: 20px 0;");
            out.println("}");
            out.println("table {");
            out.println("    margin: 5px auto;");
            out.println("    border-collapse: collapse;");
            out.println("    width: 60%;");
            out.println("    max-width: 500px;");
            out.println("    background-color: #fff;");
            out.println("    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);");
            out.println("}");
            out.println("th, td {");
            out.println("    padding: 3px;");
            out.println("    border: 1px solid #ddd;");
            out.println("    text-align: left;");
            out.println("    font-size: 14px;");
            out.println("}");
            out.println("th {");
            out.println("    background-color:white;");
            out.println("    color: black;");
            out.println("}");
            out.println("tr:nth-child(even) {");
            out.println("    background-color: #f2f2f2;");
            out.println("}");
            out.println(".status-approved {");
            out.println("    color: green;");
            out.println("    font-weight: bold;");
            out.println("}");
            out.println(".status-rejected {");
            out.println("    color: red;");
            out.println("    font-weight: bold;");
            out.println("}");
            out.println(".status-pending {");
            out.println("    color: orange;");
            out.println("    font-weight: bold;");
            out.println("    position: relative;");
            out.println("}");
            out.println(".status-pending::before {");
            out.println("    content: '⮌';");
            out.println("    font-size: 16px;");
            out.println("    position: absolute;");
            out.println("    top: 50%;");
            out.println("    transform: translateY(-50%);");
            out.println("    animation: rotate 1s linear infinite;");
            out.println("}");
            out.println(".status-pending::before {");
            out.println("    left: -30px;");
            out.println("}");
            out.println(".status-pending::after {");
            out.println("    left: 10px;");
            out.println("}");
            out.println("@keyframes rotate {");
            out.println("    0% { transform: rotate(0deg); }");
            out.println("    100% { transform: rotate(360deg); }");
            out.println("}");
            out.println(".button-container {");
            out.println("    margin-top: 20px;");
            out.println("}");
            out.println(".button-container button {");
            out.println("    padding: 8px 16px;");
            out.println("    font-size: 14px;");
            out.println("    color: white;");
            out.println("    background-color: #000000;"); // Changed to black
            out.println("    border: none;");
            out.println("    border-radius: 3px;");
            out.println("    cursor: pointer;");
            out.println("}");
            out.println(".button-container button:hover {");
            out.println("    background-color: #333333;"); // Darker shade of black for hover
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            // Header
            out.println("<header>");
            out.println("<h1>Mission Management System</h1>");
            out.println("</header>");
            
            String personName = request.getParameter("personName");
            if (personName != null && !personName.isEmpty()) {
                try (Connection con = DBUtil.getConnection()) {
                    String sql = "SELECT * FROM creation WHERE Person_Name like  ?";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setString(1, personName);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                out.println("<h2>Mission Details for: " + personName + "</h2>");
                                out.println("<table>");
                                out.println("<tr><th>Mission ID</th><td>" + rs.getInt("Id") + "</td></tr>");
                                out.println("<tr><th>Person Name</th><td>" + rs.getString("Person_Name") + "</td></tr>");
                                out.println("<tr><th>Function of Person</th><td>" + rs.getString("Function_of_person") + "</td></tr>");
                                out.println("<tr><th>Purpose of Mission</th><td>" + rs.getString("Purpose_of_mission") + "</td></tr>");
                                out.println("<tr><th>Destination</th><td>" + rs.getString("Destination") + "</td></tr>");
                                out.println("<tr><th>Means of Transportation</th><td>" + rs.getString("Means_of_transportation") + "</td></tr>");
                                out.println("<tr><th>Date of Departure</th><td>" + rs.getString("Date_of_Depature") + "</td></tr>");
                                out.println("<tr><th>Return Date</th><td>" + rs.getString("Return_Date") + "</td></tr>");
                                out.println("<tr><th>Duration (Days)</th><td>" + rs.getInt("Duration_days") + "</td></tr>");
                                out.println("<tr><th>Account Number</th><td>" + rs.getString("Account_number") + "</td></tr>");
                                out.println("<tr><th>Mission Allowance</th><td>" + rs.getDouble("Mission_Allowance") + "</td></tr>");
                                out.println("<tr><th>Name of Supervisor</th><td>" + rs.getString("Name_of_supervisor") + "</td></tr>");
                                
                                // Status
                                String status = rs.getString("Status");
                                String statusClass;
                                switch (status.toLowerCase()) {
                                    case "approved":
                                        statusClass = "status-approved";
                                        break;
                                    case "rejected":
                                        statusClass = "status-rejected";
                                        break;
                                    case "pending":
                                        statusClass = "status-pending";
                                        break;
                                    default:
                                        statusClass = "";
                                }
                                out.println("<tr><th>Status</th><td class='" + statusClass + "'>" + status + "</td></tr>");
                                
                                out.println("</table>");
                                
                                // Add a button to download the mission details as a PDF
                                out.println("<div class='button-container'>");
                                out.println("<form action='DownloadMissionPDFServlet' method='post'>");
                                out.println("<input type='hidden' name='missionId' value='" + rs.getInt("Id") + "'>");
                                out.println("<button type='submit'>Download Mission PDF</button>");
                                out.println("</form>");
                                out.println("</div>");
                            } else {
                                out.println("<p>No mission found for the name: " + personName + "</p>");
                            }
                        }
                    }
                } catch (SQLException e) {
                    out.println("<p>Error retrieving mission: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            }
            
            // Back button
            out.println("<div class='button-container'>");
            out.println("<form action='searchmission.jsp' method='get'>");
            out.println("<button type='submit'>Back to Search</button>");
            out.println("</form>");
            out.println("</div>");

            out.println("</body>");

            // Footer
            out.println("<footer>");
            out.println("<p>&copy; 2024 Mission Management System. All rights reserved.</p>");
            out.println("</footer>");
            
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet to retrieve a single mission based on the name from the database.";
    }
}
