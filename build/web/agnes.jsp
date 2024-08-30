<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Super Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #003366; /* Dark blue color for header */
            color: white;
            padding: 1px;
            text-align: center;
            margin-top: -40px;
        }

        .header a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-size: 18px;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }

        .user-actions,
        .user-list {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
            width: 80%;
        }

        .user-actions {
            display: flex;
            justify-content: center; /* Centering user actions */
            gap: 20px; /* Space between buttons */
        }

        .user-actions button {
            background-color: #003366; /* Dark blue color for buttons */
            border: none;
            color: white;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
        }

        .user-actions button:hover {
            background-color: #0056b3;
        }

        .back-button {
            margin-top: 20px;
            background-color:#003366; /* Dark blue color for back button */
            border: none;
            color: white;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
            text-align: center;
        }

        .back-button:hover {
            background-color: #0056b3;
        }

        .user-form {
            display: none;
            margin-top: 20px;
        }

        .user-form h3 {
            margin-top: 0;
            color: darkblue;
        }

        .user-form label {
            display: block;
            margin: 10px 0 5px;
        }

        .user-form input,
        .user-form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #003366;
            border-radius: 5px;
        }

        .user-form button {
            background-color: #003366;
            border: none;
            color: white;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            text-align: center;
        }

        .user-form button:hover {
            background-color: #0056b3;
        }

        .user-list h2 {
            color: #003366;
            margin-top: 0;
        }

        .user-list table {
            width: 100%;
            border-collapse: collapse;
        }

        .user-list th,
        .user-list td {
            border: 1px solid #003366;
            padding: 10px;
            text-align: left;
        }

        .user-list th {
            background-color: #003366;
            color: white;
        }

        .footer {
            background-color: #003366; /* Dark blue color for footer */
            color: white;
            text-align: center;
            padding: 20px 0;
            margin-top: auto;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        h1 {
            text-align: center;
            font-size: 40px;
            padding-bottom: 8px;
        }

        p {
            font-size: 20px;
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="header">
        <h1>Mission Order Management System- IPRC karongi</h1>
    </div>
    <h1>Welcome to Admin Dashboard</h1>
    <p>Here admin can create users, manage user accounts, edit, and delete users in this system</p>

    <div class="container">
        <div class="user-actions">
            <button onclick="window.location.href='Adduser.jsp'">Add User</button>
            <button onclick="window.location.href='DisplayUserServlet'">Manage User</button>
        </div>
        
        <!-- Back Button -->
        <button class="back-button" onclick="window.location.href='LogoutServlet'">Logout</button>
    </div>

    <div class="footer">
        &copy; 2024 IPRC Karongi. All rights reserved.
    </div>
</body>

</html>
