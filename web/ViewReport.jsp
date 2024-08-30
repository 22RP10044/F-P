<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Report</title>
    <style>
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: auto;
        }
        .form-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group textarea {
            resize: vertical;
            height: 100px;
        }
        .form-group button {
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Report Details</h2>
        <form action="ViewReport" method="get">
            <input type="hidden" name="Rep_Id" value="${report.getInt('Rep_Id')}">
            <div class="form-group">
                <label for="reportTitle">Report Title</label>
                <input type="text" id="reportTitle" name="reportTitle" value="${report.getString('Report_Title')}" readonly>
            </div>
            <div class="form-group">
                <label for="reportDescription">Report Description</label>
                <textarea id="reportDescription" name="reportDescription" readonly>${report.getString('Report_Description')}</textarea>
            </div>
            <div class="form-group">
                <label for="reportFile">Uploaded File</label>
                <a href="ViewReport?Rep_Id=${report.getInt('Rep_Id')}&action=download">Download File</a>
            </div>
            <div class="form-group">
                <button type="submit" name="action" value="delete">Delete Report</button>
                <button type="submit" name="action" value="update">Update Report</button>
            </div>
        </form>
    </div>
</body>
</html>
