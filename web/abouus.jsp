<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Us - Mission Order Management System</title>
    <style>
        /* General styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            color: #333;
        }

        header {
            background-color: #003366;
            color: white;
            padding: 10px 0;
        }

        .header-content {
            width: 80%;
            margin: 0 auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header-content h1 {
            margin: 0;
        }

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
        }

        nav ul li {
            margin-left: 20px;
        }

        nav ul li a {
            color: white;
            text-decoration: none;
        }

        nav ul li a:hover {
            text-decoration: underline;
        }

        main {
            padding: 20px;
            width: 80%;
            margin: 0 auto;
        }

        .about-us {
            margin-top: 20px;
        }

        .about-us h2 {
            color: #003366;
        }

        footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        /* Back button styles */
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #003366;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .back-button:hover {
            background-color: #005599;
        }
    </style>
</head>
<body>
    <header>
        <div class="header-content">
            <h1>Mission Order Management System</h1>
            
            
            <nav>
                <ul>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="aboutUs.jsp">About us</a></li>
                    <!-- Add more navigation links as needed -->
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <section class="about-us">
            <h2>About Us</h2>
            <p>The Mission Order Management System at the Integrated Polytechnic Regional College (IPRC) Karongi is a dedicated platform designed to streamline and manage the mission orders of our institution. As part of our commitment to excellence in Technical and Vocational Education Training, this system plays a crucial role in ensuring efficient and transparent management of all mission-related activities.</p>
            <p>Our Mission Order Management System is built to support the diverse needs of our five departments—Agricultural Engineering, Electrical & Electronics Engineering, Hospitality Management, Information & Communication Technology, and Mechanical Engineering. The system allows for the seamless processing of mission requests, approvals, and tracking, ensuring that all missions are aligned with our institutional goals of equipping students with practical knowledge and skills.</p>
            <p>Through this platform, we aim to enhance the efficiency of mission operations, reduce paperwork, and ensure that our staff and students can focus on what they do best—innovating, creating jobs, and competing in the labor market.</p>
        </section>

        <!-- Back button -->
      
        
    </main>

    <footer>
        <div class="footer-content">
            <p>&copy; 2024 Integrated Polytechnic Regional College (IPRC) Karongi. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
