<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <style>
        h1 {
            font-size: 20px;
            color: #003366;
        }

        .table-container {
            width: 100%;
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
        }

        .back-button {
            margin: 20px 0;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .back-button:hover {
            background-color: #0056b3;
        }

        .status-pending {
            color: brown;
            font-weight: bold;
            display: flex;
            align-items: center;
        }

        .revolving-arrow {
            margin-left: 5px;
            animation: rotate 2s linear infinite;
        }

        @keyframes rotate {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }

        .action-buttons {
            display: flex;
            gap: 10px;
            margin-top: 5px;
        }

        .btn {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .btn-success {
            background-color: #28a745;
            color: white;
        }

        .btn-success:hover {
            background-color: #218838;
        }

        .btn-danger {
            background-color: #dc3545;
            color: white;
        }

        .btn-danger:hover {
            background-color: #c82333;
        }

    </style>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <div id="wrapper">

        <div id="content-wrapper" class="d-flex flex-column">

            <div id="content">

                <%
                    String userRole = (String) session.getAttribute("userRole");
                    String backButtonUrl = "cdsm.jsp";
                    if ("CSDM".equals(userRole)) {
                        backButtonUrl = "cdsm.jsp";
                    }
                %>
                <a href="<%= backButtonUrl %>">
                    <button class="back-button">BACK</button>
                </a>

                <%
                    String url = "jdbc:mysql://localhost:3306/mission__order";
                    String user = "root";
                    String password = "";
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection(url, user, password);
                        stmt = conn.createStatement();

                        String sql = "SELECT * FROM creation";
                        rs = stmt.executeQuery(sql);
                %>

                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Person Name</th>
                                <th>Function of Person</th>
                                <th>Purpose of Mission</th>
                                <th>Destination</th>
                                <th>Means of Transportation</th>
                                <th>Date of Departure</th>
                                <th>Return Date</th>
                                <th>Duration (days)</th>
                                <th>Account Number</th>
                                <th>Mission Allowance</th>
                                <th>Name of Supervisor</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                while (rs.next()) {
                                    int id = rs.getInt("Id");
                                    String names = rs.getString("Person_Name");
                                    String fx = rs.getString("Function_of_person");
                                    String dest = rs.getString("Destination");
                                    String status = rs.getString("Status");
                            %>
                            <tr>
                                <td><%= id %></td>
                                <td><%= names %></td>
                                <td><%= fx %></td>
                                <td><%= rs.getString("Purpose_of_mission") %></td>
                                <td><%= dest %></td>
                                <td><%= rs.getString("Means_of_transportation") %></td>
                                <td><%= rs.getDate("Date_of_Depature") %></td>
                                <td><%= rs.getDate("Return_Date") %></td>
                                <td><%= rs.getInt("Duration_days") %></td>
                                <td><%= rs.getString("Account_number") %></td>
                                <td><%= rs.getDouble("Mission_Allowance") %></td>
                                <td><%= rs.getString("Name_of_supervisor") %></td>
                                <td>
                                    <% if("Pending".equals(status)) { %>
                                        <div class="status-pending">
                                            Pending
                                            <i class="fas fa-sync revolving-arrow"></i>
                                        </div>
                                        <div class="action-buttons">
                                            <a href="ApproveRejectMission?id=<%=id%>&action=approve"><button type="button" class="btn btn-success" onclick="return confirm('Confirm mission for <%=names%> (<%=fx%>) to <%=dest%>?')">Approve</button></a>
                                            <a href="ApproveRejectMission?id=<%=id%>&action=reject"><button type="button" class="btn btn-danger" onclick="return confirm('Reject mission for <%=names%> (<%=fx%>) to <%=dest%>?')">Reject</button></a>
                                        </div>
                                    <% } else { %>
                                        <%= status %>
                                    <% } %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>

                <%
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>

                <% String emailErrorMessage = (String) request.getAttribute("emailErrorMessage"); %>
                <% if (emailErrorMessage != null && !emailErrorMessage.isEmpty()) { %>
                <div id="errorMessage" class="message error-message">
                    Status Report: <%= emailErrorMessage %>
                </div>
                <% } %>

            </div>

            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Mission order Management System</span>
                    </div>
                </div>
            </footer>

        </div>

    </div>

    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="js/sb-admin-2.min.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>