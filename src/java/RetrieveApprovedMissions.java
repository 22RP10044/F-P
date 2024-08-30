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

@WebServlet("/RetrieveApprovedMissions")
public class RetrieveApprovedMissions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT * FROM creation WHERE Status = 'Approved'";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Approved Missions</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>List of Approved Missions</h1>");
                out.println("<table border='1'>");
                out.println("<tr><th>Mission ID</th><th>Person Name</th><th>Destination</th><th>Purpose</th><th>Status</th></tr>");
                
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String personName = rs.getString("Person_Name");
                    String destination = rs.getString("Destination");
                    String purpose = rs.getString("Purpose_of_mission");
                    String status = rs.getString("Status");
                    
                    out.println("<tr>");
                    out.println("<td>" + id + "</td>");
                    out.println("<td>" + personName + "</td>");
                    out.println("<td>" + destination + "</td>");
                    out.println("<td>" + purpose + "</td>");
                    out.println("<td>" + status + "</td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Error retrieving approved missions</h1>");
            out.println("<p>" + ex.getMessage() + "</p>");
            out.println("</body>");
            out.println("</html>");
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet to retrieve and display approved missions from the database.";
    }
}
