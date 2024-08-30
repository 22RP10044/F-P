<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="your.package.MissionApproval" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Mission Approvals</title>
    <!-- Include Bootstrap CSS for styling -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <h2 class="my-4">Mission Approvals</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Approved By</th>
                    <th>Approval Status</th>
                    <th>Approval Date</th>
                    <th>Comments</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<MissionApproval> missionApprovalList = (ArrayList<MissionApproval>) request.getAttribute("missionApprovalList");
                    if (missionApprovalList != null) {
                        for (MissionApproval missionApproval : missionApprovalList) {
                %>
                <tr>
                    <td><%= missionApproval.getOrderId() %></td>
                    <td><%= missionApproval.getApprovedBy() %></td>
                    <td><%= missionApproval.getApprovalStatus() %></td>
                    <td><%= missionApproval.getApprovalDate() %></td>
                    <td><%= missionApproval.getComments() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" class="text-center">No mission approvals found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
