<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        header {
            background-color: #003366; /* Dark blue color for header */
            color: #fff;
            padding: 10px 20px;
            position: fixed;
            width: 100%;
            top: 0;
            left: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            z-index: 1000; /* Ensure header is above other content */
        }
        header h1 {
            color: #fff; /* White color for header text */
            margin: 0;
            text-align: center;
        }
        nav {
            margin-left: auto;
           
            
        }
        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
            font-size: 16px;
        }
        nav a:hover {
            text-decoration: underline;
            width: 80px;
        }
        footer {
            background-color: #003366; /* Dark blue color for footer */
            color: #fff;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
            left: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 80px auto 40px auto; /* Added top margin to avoid overlap with the fixed header */
            max-width: 600px;
            position: relative;
        }
        h2 {
            color: #1a73e8; /* Color for the Contact Us heading */
            margin-top: 0;
        }
        .contact-info {
            font-size: 18px;
            margin: 20px 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .contact-info a {
            text-decoration: none;
            color: #1a73e8;
            display: flex;
            align-items: center;
            margin: 7px 0;
        }
        .contact-info a:hover {
            text-decoration: underline;
        }
        .contact-info i {
            margin-right: 10px;
            font-size: 20px;
        }
        .social-media {
            margin-top: 20px;
            display: flex;
            justify-content: center; /* Center align icons */
        }
        .social-media a {
            text-decoration: none;
            color: green;
            margin: 0 10px;
            font-size: 24px;
        }
        .social-media a:yellow {
            color: #cfcfcf;
        }
    </style>
    <!-- Link to Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <header>
        <h1>Mission Order Management System - IPRC Karongi</h1>
        <nav>
            <a href="home.jsp">Home</a>
            <a href="abouus.jsp">About Us</a>
        </nav>
    </header>

    <div class="container">
        <h2>Contact Us</h2>
        <div class="contact-info">
            <a href="tel:+250788871075">
                <i class="fas fa-phone"></i> (+250) 788871075
            </a>
            <a href="mailto:info@iprckarongi.rp.ac.rw">
                <i class="fas fa-envelope"></i> info@iprckarongi.rp.ac.rw
            </a>
            <!-- Social media icons -->
            <div class="social-media">
                <a href="https://facebook.com" target="_blank" title="Facebook">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a href="https://twitter.com" target="_blank" title="Twitter">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="https://instagram.com" target="_blank" title="Instagram">
                    <i class="fab fa-instagram"></i>
                </a>
                <a href="https://youtube.com" target="_blank" title="YouTube">
                    <i class="fab fa-youtube"></i>
                </a>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 IPRC Karongi. All rights reserved.</p>
    </footer>
</body>
</html>
