<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard</title>
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="<c:url value='/css/sb-admin-2.min.css'/>" rel="stylesheet">
    <style>
        .header, .footer {
            background-color: #003366;
            color: white;
            padding: 15px 20px;
            text-align: center;
        }
        .footer {
            margin-top: 20px;
            font-size: 12px;
        }
        .form-container {
            background-color: white;
            padding: 15px;
            border-radius: 6px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: auto;
        }
        .form-container h2 {
            margin-bottom: 15px;
            font-size: 20px;
        }
        .form-group {
            margin-bottom: 10px;
        }
        .form-group label {
            display: block;
            margin-bottom: 3px;
            font-size: 14px;
        }
        .form-group input[type="text"],
        .form-group input[type="file"],
        .form-group textarea {
            width: 100%;
            padding: 6px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        .form-group textarea {
            resize: vertical;
            height: 80px;
        }
        .form-buttons {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .form-buttons button {
            padding: 8px 12px;
            background-color: #003366;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .form-buttons button:hover {
            background-color: #002244;
        }
        .back-button {
            margin-top: 10px;
            text-align: right;
        }
        .back-button button {
            background-color: #007bff;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            font-size: 14px;
        }
        .back-button button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body id="page-top">
    <div id="wrapper">
        <!-- Sidebar and Topbar omitted for brevity -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <div class="header">
                    <h1>Mission order management system- IPRC karongi</h1>
                </div>
                <!-- Topbar omitted for brevity -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Report the mission</h1>
                    </div>
                    <!-- Content Row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-container">
                                <h2>Submit Report</h2>
                                <form action="ReportServlet" method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="reportTitle">Report Title</label>
                                        <input type="text" id="reportTitle" name="reportTitle" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="reportDescription">Report Description</label>
                                        <textarea id="reportDescription" name="reportDescription" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="reportFile">Upload Report</label>
                                        <input type="file" id="reportFile" name="reportFile" accept=".pdf,.doc,.docx" required>
                                    </div>
                                    <div class="form-buttons">
                                        <button type="submit">Submit Report</button>
                                        <div class="back-button">
                                            <button type="button" onclick="window.location.href='receiver.jsp'">Back to Dashboard</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- End Content Row -->
                </div>
                <!-- End of Container Fluid -->
                <div class="footer">
                    <p>© 2024 Your Company. All rights reserved.</p>
                </div>
                <!-- Footer omitted for brevity -->
            </div>
        </div>
        <!-- Scroll to Top Button and Logout Modal omitted for brevity -->
        <!-- Bootstrap core JavaScript -->
        <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
        <script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
        <!-- Core plugin JavaScript -->
        <script src="<c:url value='/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
        <!-- Custom scripts for all pages -->
        <script src="<c:url value='/js/sb-admin-2.min.js'/>"></script>
    </div>
</body>
</html>
