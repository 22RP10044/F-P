import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ForgotPasswordServlet.class.getName());
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (email == null || email.isEmpty()) {
            out.println("<html><body>");
            out.println("<h3>Please enter your email</h3>");
            out.println("<a href='forgot_password.html'>Try again</a>");
            out.println("</body></html>");
            return;
        }

        String password = generatePassword(12);
        
        try {
            sendEmail(email, password);
            out.println("<html><body>");
            out.println("<h3>Password has been sent to your email</h3>");
            out.println("</body></html>");
        } catch (EmailException ex) {
            LOGGER.log(Level.SEVERE, "Failed to send email: {0}", ex.getMessage());
            out.println("<html><body>");
            out.println("<h3>Failed to send email. Please try again later.</h3>");
            out.println("</body></html>");
        }
    }
    
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+[]{}|;:,.<>?";
    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SPECIAL;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generatePassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("Password length should be at least 8 characters");
        }

        StringBuilder password = new StringBuilder(length);

        // Ensure the password has at least one of each type of character
        password.append(UPPER.charAt(RANDOM.nextInt(UPPER.length())));
        password.append(LOWER.charAt(RANDOM.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(RANDOM.nextInt(SPECIAL.length())));

        // Fill the rest of the password with random characters
        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARS.charAt(RANDOM.nextInt(ALL_CHARS.length())));
        }

        // Shuffle the characters in the password to avoid predictable sequences
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }
    
    private void sendEmail(String useremail, String password) throws EmailException {
        // Send email using JavaMail API and Apache Commons Email library
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);

        email.setAuthenticator(new DefaultAuthenticator("irihodcl@gmail.com", "plfiviblixakekuk"));

        email.setSSLOnConnect(true);
        email.setFrom("noreply@gmail.com");
        email.setSubject("Reset Password");

        String messageText = "Here is your password: " + password;

        email.setMsg(messageText);
        email.addTo(useremail);
        email.send();
    }
}
