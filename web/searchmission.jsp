<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Mission</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .header {
            background-color:#003366;
            color: white;
            padding: 20px 0;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }

        .search-container {
            margin-top: 50px;
        }

        input[type="text"] {
            padding: 10px;
            width: 300px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #003366;
        }

        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: black;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #003366;
        }

        .back-button {
            margin-top: 20px;
        }

        .back-button a {
            text-decoration: none;
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: black;
            border-radius: 5px;
            display: inline-block;
        }

        .back-button a:hover {
            background-color: #003366;
        }

        .footer {
            background-color: #003366;
            color: white;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="header">
        Mission Order Management System- IPRC karongi
    </div>

    <div class="search-container">
        <h1>Search for a Mission</h1>
        <form action="RetrieveSingleMissionServlet" method="get">
            <input type="text" name="personName" placeholder="Enter Person Name" required>
            <input type="submit" value="Search">
        </form>
    </div>

    <div class="back-button">
        <a href="receiver.jsp">Back</a>
    </div>

    <div class="footer">
        &copy; 2024 Mission Order Management System
    </div>
</body>
</html>
