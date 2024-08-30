<%@ page import="java.sql.*" %>
<%
    // Database connection parameters
    String dbURL = "jdbc:mysql://localhost:3306/mission__order";
    String dbUser = "root";
    String dbPassword = "";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    // Fetch user ID from request parameter
    int userId = Integer.parseInt(request.getParameter("userId"));
    
    if (request.getMethod().equalsIgnoreCase("POST")) {
        // Update user data
        String name = request.getParameter("Name");
        String role = request.getParameter("userRole");
        String password = request.getParameter("Password");

        try {
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            String updateQuery = "UPDATE users SET Name = ?, Role = ?, Password = ? WHERE user_id = ?";
            stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setString(3, password);
            stmt.setInt(4, userId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                response.sendRedirect("DisplayUserServlet"); // Redirect after successful update
                return;
            } else {
                out.println("<html><body><h2>Error updating user.</h2></body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body><h2>Error updating user.</h2></body></html>");
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    } else {
        // Display user data
        try {
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            String selectQuery = "SELECT * FROM users WHERE user_id = ?";
            stmt = conn.prepareStatement(selectQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                String role = rs.getString("Role");
                String password = rs.getString("Password");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #007BFF;
            border-radius: 5px;
        }
        .form-group button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #0056b3;
        }
        header, footer {
            background-color: #003366;
            padding: 10px;
            color: white;
            text-align: center;
        }
        footer {
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <header><h1>Mission order management system-IPRC karongi</h1></header>
    <div class="container">
        <form action="UpdateUser.jsp" method="POST">
            <input type="hidden" name="userId" value="<%= userId %>">
            <div class="form-group">
                <label for="Name">Name:</label>
                <input type="text" id="Name" name="Name" value="<%= name %>" required>
            </div>
            <div class="form-group">
                <label for="Role">Role:</label>
                <select id="Role" name="userRole">
                    <option value="Local User" <%= role.equals("Local User") ? "selected" : "" %>>Local User</option>
                    <option value="Supervisor" <%= role.equals("Supervisor") ? "selected" : "" %>>Supervisor</option>
                    <option value="Admin" <%= role.equals("Admin") ? "selected" : "" %>>Admin</option>
                </select>
            </div>
            <div class="form-group">
                <label for="Password">Password:</label>
                <input type="password" id="Password" name="Password" value="<%= password %>" required>
            </div>
            <div class="form-group">
                <button type="submit">Update</button>
                <button type="submit">Back </button>
            </div>
        </form>
    </div>
    <footer>
        &copy; 2024 Mission Order Management System
    </footer>
</body>
</html>
<%
            } else {
                out.println("<html><body><h2>User not found.</h2></body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body><h2>Error retrieving user data.</h2></body></html>");
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
%>
