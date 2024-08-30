import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();

        String jdbcURL = "jdbc:mysql://localhost:3306/mission__order";
        String jdbcUsername = "root"; // Replace with your MySQL username
        String jdbcPassword = ""; // Replace with your MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded.");

            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Database connected.");

            String sql = "SELECT Name, Role, Password FROM users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("SQL query executed.");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String role = resultSet.getString("Role");
                String password = resultSet.getString("Password");
                userList.add(new User(name, role, password));
                System.out.println("User fetched: " + name);
            }

            System.out.println("Number of users fetched: " + userList.size());

            request.setAttribute("userList", userList);
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Database resources closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("viewuser.jsp").forward(request, response);
    }

    public static class User {
        private String name;
        private String role;
        private String password;

        public User(String name, String role, String password) {
            this.name = name;
            this.role = role;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
