<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Report Submission Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
        .form-group input[type="file"],
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
        <h2>Submit Report</h2>
        <form action="/ReportServlet" method="post" enctype="multipart/form-data">
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
            <div class="form-group">
                <button type="submit">Submit Report</button>
            </div>
        </form>
    </div>
</body>
</html>

