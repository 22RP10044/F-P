<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select User</title>
</head>
<body>
    <h2>Select User Information</h2>

    <!-- Form for selecting user information -->
    <form action="SelectUserServlet" method="get">
        <label for="Name">User Name:</label><br>
        <input type="text" id="Name" name="Name" required><br><br>
        
        <button type="submit">Get User Details</button>
    </form>

    <!-- Optional: Display user details here if needed -->
    <br>
    <a href="adminDashboard.jsp">Back to Dashboard</a>

</body>
</html>
