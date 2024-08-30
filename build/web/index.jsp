zz<%-- 
    Document   : index
    Created on : Jul 29, 2024, 8:08:01 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="controller.LoginServlet"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Login</title>
    <style>
        /* Styles from style.css */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }

        h1 {
            margin: 0;
            font-size: 24px;
            color: darkblue;
        }

        h2 {
            margin: 10px 0;
            font-size: 20px;
            color: darkblue;
        }

        .input-container {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        .input-container .icon {
            padding: 10px;
            background-color: #eee;
            border-radius: 4px 0 0 4px;
            border-right: none;
            color: #333;
        }

        .input-container input {
            padding: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 0 4px 4px 0;
            border-left: none;
        }

        button {
            background-color: darkblue;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            width: 100%;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }

        button:hover {
            background-color: darkblue;
        }

        p {
            margin: 10px 0;
            font-size: 14px;
        }

        a {
            color: darkblue;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Modal styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 23%;
        }
         .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        /* Popup Form */
        .popup {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }

        .popup-content {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        .close {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            cursor: pointer;
        }
      
    </style>
</head>
<body>
    <div class="login-container">
        <h1>WISEWAY</h1>
        <h2>LOGIN</h2>
        <form action="LoginServlet" method="post">
            <div class="input-container">
                <span class="icon">&#128100;</span>
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="input-container">
                <span class="icon">&#128274;</span>
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <button type="submit">Login</button>
        </form>
        <p>
            Forgot your password? Click here to <a href="#" onclick="openPopup()">RESET</a>
        </p>
         <a href="home.jsp">back</a>
    </div>

    <!-- Popup Form -->
    <div id="popupForm" class="popup">
        <div class="popup-content">
            <span class="close" onclick="closePopup()">&times;</span>
            <h2>Reset Password</h2>
            <form action="ForgotPasswordServlet" method="post">
                <div class="input-container">
                    <input type="email" name="email" placeholder="Enter your email" required>
                </div>
                <button type="submit">Send Reset Link</button>
            </form>
        </div>
    </div>

    <!-- Modal for forgot password -->
    <div id="forgotPasswordModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Forgot Password Form</h2>
            <form action="ForgotPasswordServlet" method="post">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email"><br><br>
                <input type="submit" value="Send New Password">
                <a href="index.html">Go Back</a>
            </form>
        </div>
    </div>

    <script>
        function openPopup() {
            document.getElementById('popupForm').style.display = 'block';
        }

        function closePopup() {
            document.getElementById('popupForm').style.display = 'none';
        }

        // Modal logic for the forgot password link
        var modal = document.getElementById("forgotPasswordModal");
        var span = document.getElementsByClassName("close")[1]; // Adjusted index for the second close button

        var link = document.querySelector('a[href="#"]');
        link.onclick = function() {
            modal.style.display = "block";
        }

        span.onclick = function() {
            modal.style.display = "none";
        }

        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</body>
</html>

