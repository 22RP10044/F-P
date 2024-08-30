import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayUserServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mission__order";
    private static final String DB_USER = "root"; // Replace with your database username
    private static final String DB_PASSWORD = ""; // Replace with your database password

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare and execute query
            String query = "SELECT * FROM users";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Check if any data is returned
            if (!rs.next()) {
                out.println("<html><body><h2>No data found in the users table.</h2></body></html>");
                return;
            }
            // Reset the cursor to the beginning
            rs.beforeFirst();

            // HTML content with embedded Java code
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mission Order Management System</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; color: #333; background-color: #ecf0f1; }");
            out.println("header { background-color:  #003366; padding: 10px; text-align: center; color: #fff; }");
            out.println("footer { background-color:  #003366; padding: 10px; text-align: center; color: #fff; position: fixed; width: 100%; bottom: 0; }");
            out.println("main { padding: 20px; }");
            out.println("table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            out.println("th { background-color: black; color: #fff; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("tr:nth-child(odd) { background-color: #ffffff; }");
            out.println(".back-button {");
            out.println("    display: inline-block;");
            out.println("    background-color: #007BFF;");
            out.println("    color: white;");
            out.println("    padding: 10px 20px;");
            out.println("    border: none;");
            out.println("    border-radius: 5px;");
            out.println("    font-size: 16px;");
            out.println("    cursor: pointer;");
            out.println("    text-decoration: none;");
            out.println("    margin: 20px 0;");
            out.println("}");
            out.println(".back-button:hover {");
            out.println("    background-color: #0056b3;");
            out.println("}");
            out.println(".action-button {");
            out.println("    background-color: #007BFF;");
            out.println("    color: white;");
            out.println("    border: none;");
            out.println("    padding: 5px 10px;");
            out.println("    border-radius: 5px;");
            out.println("    font-size: 14px;");
            out.println("    cursor: pointer;");
            out.println("    text-decoration: none;");
            out.println("    margin-right: 5px;");
            out.println("}");
            out.println(".action-button:hover {");
            out.println("    background-color: #0056b3;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header><h1>Mission Order Management System- IPRC karongi</h1></header>");
            
            out.println("<main>");
            out.println("<a href='agnes.jsp' class='back-button'>Back</a>");
            out.println("<table>");
            out.println("<tr><th>User ID</th><th>Name</th><th>Role</th><th>Password</th><th>Actions</th></tr>");
            
            // Iterate over result set and display data
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String name = rs.getString("Name");
                String role = rs.getString("Role");
                String password = rs.getString("Password");

                out.println("<tr>");
                out.println("<td>" + userId + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + role + "</td>");
                out.println("<td>" + password + "</td>");
                out.println("<td>");
                out.println("<a href='UpdateUser.jsp?userId=" + userId + "' class='action-button'>Update</a>");
                out.println("<a href='DeleteUserServlet?userId=" + userId + "' class='action-button'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</main>");
            
            out.println("<footer><p>&copy; 2024 Mission Order Management System</p></footer>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<html><body><h2>JDBC Driver not found.</h2></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body><h2>Error fetching data from database.</h2></body></html>");
        } finally {
            // Ensure resources are closed
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}
