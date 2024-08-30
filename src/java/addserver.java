import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addserver")
public class addserver extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mission__order";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Update with your DB password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieving form parameters
        String Person_Name = request.getParameter("Person_Name");
        String email = request.getParameter("email"); // Retrieve email from form
        String Function_of_person = request.getParameter("function_person");
        String Purpose_of_mission = request.getParameter("mission_purpose");
        String Destination = request.getParameter("destination");
        String Means_of_transportation = request.getParameter("transportation");
        String Date_of_Depature = request.getParameter("departure-date");
        String Return_Date = request.getParameter("return_date");
        String Duration_days = request.getParameter("duration");
        String Account_number = request.getParameter("account_number");
        String Mission_Allowance = request.getParameter("mission_allowance");
        String Name_of_supervisor = request.getParameter("supervisor_name");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Insert data into the creation table
                String sql = "INSERT INTO creation (Person_Name, email, Function_of_person, Purpose_of_mission, Destination, Means_of_transportation, Date_of_Depature, Return_Date, Duration_days, Account_number, Mission_Allowance, Name_of_supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, Person_Name);
                    ps.setString(2, email); // Set email parameter
                    ps.setString(3, Function_of_person);
                    ps.setString(4, Purpose_of_mission);
                    ps.setString(5, Destination);
                    ps.setString(6, Means_of_transportation);
                    ps.setString(7, Date_of_Depature);
                    ps.setString(8, Return_Date);
                    ps.setString(9, Duration_days);
                    ps.setString(10, Account_number);
                    ps.setString(11, Mission_Allowance);
                    ps.setString(12, Name_of_supervisor);

                    int rowsInserted = ps.executeUpdate();
                    if (rowsInserted > 0) {
                        out.print("<script>alert('Mission has been created');window.location.href='missionform.jsp';</script>");
                    } else {
                        out.print("<script>alert('Mission has not been created');window.location.href='missionform.jsp';</script>");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<h2>Error: " + e.getMessage() + "</h2>");
            } finally {
                out.close();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}