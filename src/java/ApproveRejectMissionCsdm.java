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
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@WebServlet("/ApproveRejectMissionCsdm")
public class ApproveRejectMissionCsdm extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mission_id = request.getParameter("id");
        String action = request.getParameter("action");
        String status = action.equals("approve") ? "Approved" : "Rejected";

        String user_email = null;
        String names = null;
        String dest = null;
        String purpose = null;
        String function = null;
        String supervisor = null;
        String emailErrorMessage = null;

        try (Connection con = DBUtil.getConnection()) {
            // Update the mission status in the database
            PreparedStatement pst = con.prepareStatement("UPDATE creation SET Status=? WHERE Id=?");
            pst.setString(1, status);
            pst.setString(2, mission_id);

            int success = pst.executeUpdate();

            if (success == 1) {
                // Retrieve the mission details
                String query = "SELECT Person_Name, email, Function_of_person, Purpose_of_mission, "
                             + "Destination, Name_of_supervisor FROM creation WHERE Id=?";
                try (PreparedStatement stmt = con.prepareStatement(query)) {
                    stmt.setInt(1, Integer.parseInt(mission_id));
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        names = rs.getString("Person_Name");
                        user_email = rs.getString("email");
                        function = rs.getString("Function_of_person");
                        purpose = rs.getString("Purpose_of_mission");
                        dest = rs.getString("Destination");
                        supervisor = rs.getString("Name_of_supervisor");

                        String subject = status.equals("Approved") ? "Mission Approved" : "Mission Rejected";
                        sendEmail(user_email, subject, names, function, dest, purpose, supervisor, status);

                        request.setAttribute("result", status.equals("Approved") ? "Approval Successful" : "Rejection Successful");
                        request.getRequestDispatcher("approveRejectConfirmation.jsp").forward(request, response);
                    } else {
                        emailErrorMessage = "Approval/Rejection Failed: No matching mission found";
                    }
                } catch (SQLException ex) {
                    emailErrorMessage = "Database Query Error: " + ex.getMessage();
                } catch (EmailException ex) {
                    emailErrorMessage = "Email Sending Error: " + ex.getMessage();
                }
            } else {
                emailErrorMessage = "Approval/Rejection Failed: Database update failed";
            }
        } catch (SQLException ex) {
            emailErrorMessage = "Database Connection Error: " + ex.getMessage();
        } catch (Exception ex) {
            emailErrorMessage = "General Error: " + ex.getMessage();
        }

        if (emailErrorMessage != null) {
            request.setAttribute("emailErrorMessage", emailErrorMessage);
            request.getRequestDispatcher("approveRejectConfirmation.jsp").forward(request, response);
        }
    }

    private void sendEmail(String user_email, String subject, String names, String function, String dest, String purpose, String supervisor, String decision) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("your-email@gmail.com", "your-email-password"));
        email.setSSLOnConnect(true);
        email.setFrom("noreply@example.com");
        email.setSubject(subject);
        String messageText = "Dear " + names + ",\n"
                + "\n"
                + "Your mission for the purpose of " + purpose + " to " + dest + " has been " + decision + ".\n"
                + "Your function during this mission was: " + function + ".\n"
                + "Approved/Rejected by: " + supervisor + ".\n"
                + "\n"
                + "Thank you.";
        email.setMsg(messageText);
        email.addTo(user_email);
        email.send();
    }
}
