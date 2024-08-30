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
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@WebServlet("/ApproveRejectMission")
public class ApproveRejectMission extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mission_id = request.getParameter("id");
        String action = request.getParameter("action");
        String act = action.equals("approve") ? "Approved" : "Rejected";
        String user_email = null;
        String names = null;
        String dest = null;
        String purpose = null;
        String emailErrorMessage = null;

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement pst = con.prepareStatement("UPDATE creation SET Status=? WHERE Id=?");
            pst.setString(1, act);
            pst.setString(2, mission_id);

            int success = pst.executeUpdate();

            if (success == 1) {
                String missionQuery = "SELECT * FROM creation WHERE Id=?";

                try (PreparedStatement missionStmt = con.prepareStatement(missionQuery)) {
                    missionStmt.setInt(1, Integer.parseInt(mission_id));
                    ResultSet missionRes = missionStmt.executeQuery();

                    if (missionRes.next()) {
                        names = missionRes.getString("Person_Name");
                        user_email = missionRes.getString("email");
                        dest = missionRes.getString("Destination");
                        purpose = missionRes.getString("Purpose_of_mission");
                        String subject = act.equals("Approved") ? "Mission Accepted" : "Mission Rejected";
                        sendEmail(user_email, subject, names, dest, purpose, act);

                        request.setAttribute("result", act + " Successful");
                    } else {
                        emailErrorMessage = "Mission not found.";
                    }
                } catch (SQLException ex) {
                    emailErrorMessage = "Database Query Error: " + ex.getMessage();
                } catch (EmailException ex) {
                    emailErrorMessage = "Email Sending Error: " + ex.getMessage();
                }
            } else {
                emailErrorMessage = "Approval/Rejection Failed: Database update failed.";
            }
        } catch (SQLException ex) {
            emailErrorMessage = "Database Connection Error: " + ex.getMessage();
        }

        request.setAttribute("emailErrorMessage", emailErrorMessage);
        PrintWriter out = response.getWriter();
        if (emailErrorMessage != null) {
            out.println(emailErrorMessage);
        } else {
            out.println("Operation Successful. Email sent to: " + user_email);
        }
        // Redirect or forward to appropriate page if necessary
    }

    private void sendEmail(String user_email, String subject, String names, String dest, String purpose, String decision) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("uwimpuweagripine@gmail.com", "kiltsqgizbynwesz"));
        email.setSSLOnConnect(true);
        email.setFrom("noreply@gmail.com");
        email.setSubject(subject);

        String messageText = "Dear " + names + ",\n"
                + "\n"
                + "I want to inform you that your trip for " + purpose + " to " + dest + "\n"
                + "has been " + decision + ".\n";

        email.setMsg(messageText);
        email.addTo(user_email);
        email.send();
    }
}
