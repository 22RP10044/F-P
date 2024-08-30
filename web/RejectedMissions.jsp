<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rejected Missions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #003366;
            color: white;
            padding: 20px 0;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
        }

        footer {
            background-color: #003366;
            color: white;
            padding: 10px 0;
            text-align: center;
            font-size: 14px;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin: 20px 0;
        }

        .table-responsive {
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: black;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .back-button {
            margin: 20px;
            text-align: center;
        }

        .back-button button {
            background-color: black;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        .back-button button:hover {
            background-color: #005599;
        }
    </style>
</head>
<body>
    <header>
        Mission Order Management System - iprc karongi
    </header>

    <div class="back-button">
        <button onclick="window.location.href='cdsm.jsp'">Back to Dashboard</button>
    </div>

    <div class="table-responsive">
        <jsp:include page="/RetrieveRejectedMissions" />
    </div>

    <footer>
        &copy; 2024 Mission Order Management System. All rights reserved.
    </footer>
</body>
</html>
