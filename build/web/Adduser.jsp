<%-- 
    Document   : Adduser
    Created on : Aug 19, 2024, 12:32:36 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New User</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #ecf0f1; /* Light background for the page */
            }
            header, footer {
                background-color: #003366; /* Dark blue color */
                color: #fff;
                padding: 2px;
                text-align: center;
            }
            footer {
                position: fixed;
                width: 100%;
                bottom: 0;
            }
            .user-form {
                width: 100%;
                max-width: 500px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff; /* White background for the form */
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }
            h3 {
                color: #003366; /* Blue color for the heading */
            }
            label {
                color: #007BFF;
                font-weight: bold;
                display: block;
                margin-bottom: 5px;
            }
            input[type="text"], input[type="password"], select {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #007BFF;
                border-radius: 5px;
                box-sizing: border-box;
            }
            button {
                width: 100%;
                background-color: #003366; /* Blue color for the button */
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
            }
            button:hover {
                background-color: #0056b3; /* Darker blue on hover */
            }
            .back-button {
                background-color: #007BFF; /* Blue color for the back button */
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                text-decoration: none;
                display: inline-block;
                margin-bottom: 20px;
            }
            .back-button:hover {
                background-color: #0056b3; /* Darker blue on hover */
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Mission order management system- IPRC karongi</h1>
        </header>

        <div id="addUserForm" class="user-form">
            <a href="agnes.jsp" class="back-button">Back</a> <!-- Back button -->
            <h3>Add New User</h3>
            <form action="AddUserServlet" method="POST">
                <label for="Name">Name:</label>
                <input type="text" id="Name" name="Name" required>

                <label for="Role">Role:</label>
                <select id="Role" name="userRole">
                    <option value=" User"> User</option>
                    <option value="Supervisor">Supervisor</option>
                    <option value="Secretary">Secretary</option>
                    <option value="csdm">csdm</option>
                    <option value="daf">daf</option>
                    <option value="Admin">Admin</option>
                </select>

                <label for="Password">Password:</label>
                <input type="password" id="Password" name="Password" required>

                <button type="submit">Submit</button>
            </form>
        </div>

        <footer>
            <p>&copy; 2024 Mission Order Management System</p>
        </footer>
    </body>
</html>
