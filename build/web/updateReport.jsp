<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Report</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fc;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            color: #4e73df;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            display: inline-block;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus, textarea:focus {
            border-color: #4e73df;
            outline: none;
        }

        button {
            background-color: #4e73df;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #2e59d9;
        }

        a {
            color: #4e73df;
            text-decoration: none;
            display: block;
            margin-top: 15px;
            text-align: center;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Update Report</h2>
    <form action="UpdateReportServlet" method="post" id="updateForm">
        <input type="hidden" name="Rep_Id" value="${Rep_Id}">
        <p>
            <label for="Report_Title">Report Title:</label>
            <input type="text" name="Report_Title" id="Report_Title" value="${Report_Title}" required>
        </p>
        <p>
            <label for="Report_Description">Report Description:</label>
            <textarea name="Report_Description" id="Report_Description" required>${Report_Description}</textarea>
        </p>
        <p>
            <button type="submit">Update</button>
        </p>
    </form>
    <a href="ViewReportServlet">Back to Reports List</a>

    <script>
        // JavaScript to enhance the form experience
        document.getElementById('updateForm').addEventListener('submit', function(event) {
            let title = document.getElementById('Report_Title').value.trim();
            let description = document.getElementById('Report_Description').value.trim();

            if (title === "" || description === "") {
                alert("Please fill out all fields.");
                event.preventDefault();
            }
        });
    </script>
</body>
</html>
