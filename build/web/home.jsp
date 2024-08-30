<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mission Order Management System - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            height: 100vh;
        }

        header {
            background-color: #003366;
            color: white;
            padding: 20px;
            display: flex;
            align-items: center;
        }

        .header-content {
            display: flex;
            align-items: center;
            flex-grow: 1;
        }

        .header-content img {
            margin-right: 20px;
            width: 80px; /* Increased size */
            height: 80px; /* Increased size */
            border-radius: 50%; /* Make the image circular */
            border: 2px solid #fff; /* Add a white border */
        }

        .header-content h1 {
            margin: 0; /* Remove default margin */
        }

        nav {
            background-color: #333;
            padding: 10px;
            display: flex;
            justify-content: center;
        }

        nav a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
            margin: 0 10px;
            border-radius: 5px;
        }

        nav a:hover {
            background-color: #003366;
        }

        .container {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative;
            text-align: center;
        }

        footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 10px;
        }

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
            z-index: 1000;
        }

        .popup-content {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 400px;
            position: relative;
            text-align: center;
        }

        .popup-content h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: darkblue;
        }

        .input-container {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .input-container .icon {
            padding: 12px;
            background-color: #eee;
            border-radius: 4px 0 0 4px;
            border-right: none;
            color: #333;
        }

        .input-container input {
            padding: 12px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 0 4px 4px 0;
            border-left: none;
        }

        button {
            background-color: #003366;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 4px;
            width: 100%;
            cursor: pointer;
            font-size: 18px;
            text-decoration: none;
        }

        button:hover {
            background-color: navy;
        }

        .close-btn {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            color: #aaa;
            cursor: pointer;
        }

        .close-btn:hover {
            color: black;
        }

        /* Styling and animation for the moving text */
        .moving-text {
            font-family: "Times New Roman", serif;
            font-size: 36px; /* Increased font size */
            text-align: center;
            position: relative;
            animation: moveHorizontally 5s linear infinite, colorChange 5s linear infinite;
            background: black;
                
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            white-space: nowrap; /* Ensures the text stays on a single line */
        }

        
    </style>
</head>

<body>
    <header>
        <div class="header-content">
            <img src="iprc.png" alt="IPRC Logo">
            <h1>Mission Order Management System - IPRC Karongi</h1>
        </div>
    </header>

    <nav>
        <a href="#">Home</a>
        <a href="abouus.jsp">About</a>
        <a href="index.html">Login Page</a>
        <a href="contactus.jsp">Contact</a>
    </nav>

    <div class="container">
        <p class="moving-text">WELCOME TO MISSION ORDER MANAGEMENT SYSTEM IN IPRC KARONGI</p>
    </div>

    <footer>
        <p>&copy; 2024 IPRC Karongi. All rights reserved.</p>
    </footer>

    <div class="popup" id="adminPopup">
        <div class="popup-content">
            <span class="close-btn" onclick="closeAdminLogin()">&times;</span>
            <h2>Admin Login</h2>
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
        </div>
    </div>

    <script>
        function openAdminLogin() {
            document.getElementById('adminPopup').style.display = 'flex';
        }

        function closeAdminLogin() {
            document.getElementById('adminPopup').style.display = 'none';
        }

        window.onclick = function(event) {
            var popup = document.getElementById('adminPopup');
            if (event.target == popup) {
                popup.style.display = "none";
            }
        }
    </script>
</body>

</html>
