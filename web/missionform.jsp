<%-- 
    Document   : missionform
    Created on : Jul 21, 2024, 4:44:26 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <style>
        .scrollable-form-container {
            max-height: 500px;
            overflow-y: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
        }
    </style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.php">
           <%
                String username =(String)session.getAttribute("username");
                if(username == null){
                username = request.getParameter("username");
                session.setAttribute("username", username);
    }
%>
              
                <div class="sidebar-brand-text mx-3"> Mission Order Management System</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            <center> <p style="color: white;">Current tim: <%= new Date()%></p></center>

            

            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages1"
                    aria-expanded="true" aria-controls="collapsePages1">
                    <i class="fas fa-fw fa-users"></i>
                    <span>Missions</span>
                </a>
                <div id="collapsePages1" class="collapse" aria-labelledby="headingPages"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="missionform.jsp">Add</a>
                        <a class="collapse-item" href="RetrieveMissionServlet">Manage</a>
                    </div>
                </div>
            </li>

           
            

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                    &nbsp;&nbsp;<img class="img-profile rounded-circle"
                                        src="uploadeddata/1.png">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="profile.php">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="change-password.php">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Change Password
                                </a>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Scrollable Mission Authorization Form -->
                        <div class="scrollable-form-container">
                            <h2>Mission Authorization Form</h2>
                            <form action="addserver" method="post">
                                <div class="form-group">
                                    <label for="person-name">Person Name</label>
                                    <input type="text" class="form-control" id="person-name" name="Person_Name" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" required>
                                </div>
                                <div class="form-group">
                                    <label for="person-function">Function of the Person</label>
                                    <input type="text" class="form-control" id="person-function" name="function_person" required>
                                </div>
                                <div class="form-group">
                                    <label for="mission-purpose">Purpose of the Mission</label>
                                    <textarea class="form-control" id="mission-purpose" name="mission_purpose" rows="4" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="destination">Destination</label>
                                    <input type="text" class="form-control" id="destination" name="destination" required>
                                </div>
                                <div class="form-group">
                                    <label for="transportation">Means of Transportation</label>
                                    <input type="text" class="form-control" id="transportation" name="transportation" required>
                                </div>
                                <div class="form-group">
                                    <label for="departure-date">Date of Departure</label>
                                    <input type="date" class="form-control" id="departure-date" name="departure-date" required>
                                </div>
                                <div class="form-group">
                                    <label for="return-date">Return Date</label>
                                    <input type="date" class="form-control" id="return-date" name="return_date" required>
                                </div>
                                <div class="form-group">
                                    <label for="duration">Duration (days)</label>
                                    <input type="number" class="form-control" id="duration" name="duration" required>
                                </div>
                                <div class="form-group">
                                    <label for="account-number">Account Number</label>
                                    <input type="text" class="form-control" id="account-number" name="account_number" required>
                                </div>
                                <div class="form-group">
                                    <label for="mission-allowance">Mission Allowance</label>
                                    <input type="number" class="form-control" id="mission-allowance" name="mission_allowance" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="supervisor-name">Name of the Supervisor</label>
                                    <input type="text" class="form-control" id="supervisor-name" name="supervisor_name" required>
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary" value="Submit">
                                </div>
                            </form>
                        </div>

                    </div>
                    <!-- Content Row -->

                    <!-- Footer -->
                   <jsp:include page="footer.jsp" />
                    <!-- End of Footer -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="LogoutServlet">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>

            <!-- Page level plugins -->
            <script src="vendor/chart.js/Chart.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="js/demo/chart-area-demo.js"></script>
            <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>

