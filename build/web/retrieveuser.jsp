<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Retrieve User</title>
</head>
<body>
    <h2>Retrieve User Information</h2>

    <!-- Form for retrieving user information -->
    <form action="RetrieveUserServlet" method="get">
        <label for="user_id">User ID:</label><br>
        <input type="text" id="user_id" name="user_id" required><br><br>
        
        <button type="submit">Get User Details</button>
    </form>

    <!-- Optional: Link to navigate to other pages -->
    <br>
    <a href="adminDashboard.jsp">Back to Dashboard</a>

</body>
</html>
