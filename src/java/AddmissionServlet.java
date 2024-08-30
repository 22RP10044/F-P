import DBUtil.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddmissionServlet")
public class AddmissionServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AddmissionServlet.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve parameters from the request
        String Person_Name = request.getParameter("Person_Name");
        String email = request.getParameter("email");
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

        logger.log(Level.INFO, "Inserting mission: {0}",
            new Object[]{Person_Name, email,Function_of_person, Purpose_of_mission, Destination, Means_of_transportation, Date_of_Depature, Return_Date, Duration_days, Account_number, Mission_Allowance, Name_of_supervisor});

        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO creation (Person_Name,email, Function_of_person, Purpose_of_mission, Destination, Means_of_transportation, Date_of_Depature, Return_Date, Duration_days, Account_number, Mission_Allowance, Name_of_supervisor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, Person_Name);
                ps.setString(2, email);
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

                int rowsAffected = ps.executeUpdate();
                logger.log(Level.INFO, "Rows affected: {0}", rowsAffected);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQL error", e);
        }

        response.sendRedirect("secretary.jsp");
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
        return "AddmissionServlet for inserting mission data";
    }
}
