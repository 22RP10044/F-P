import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateMissionServlet")
public class UpdateMissionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "edit";
        }

        try (PrintWriter out = response.getWriter()) {
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));

                try (Connection con = DBUtil.getConnection()) {
                    String sql = "SELECT * FROM creation WHERE Id = ?";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, id);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                out.println("<!DOCTYPE html>");
                                out.println("<html lang='en'>");

                                out.println("<head>");
                                out.println("<meta charset='utf-8'>");
                                out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                                out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
                                out.println("<meta name='description' content=''>");
                                out.println("<meta name='author' content=''>");
                                out.println("<title>Edit Mission</title>");
                                out.println("<link href='vendor/fontawesome-free/css/all.min.css' rel='stylesheet' type='text/css'>");
                                out.println("<link href='https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i' rel='stylesheet'>");
                                out.println("<link href='css/sb-admin-2.min.css' rel='stylesheet'>");
                                out.println("<style>");
                                out.println(".scrollable-form-container {");
                                out.println("max-height: 500px;");
                                out.println("overflow-y: auto;");
                                out.println("padding: 20px;");
                                out.println("border: 1px solid #ccc;");
                                out.println("border-radius: 5px;");
                                out.println("box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
                                out.println("margin: 20px auto;");
                                out.println("}");
                                out.println("</style>");
                                out.println("</head>");

                                out.println("<body id='page-top'>");

                                out.println("<div id='wrapper'>");

                                out.println("<ul class='navbar-nav bg-gradient-primary sidebar sidebar-dark accordion' id='accordionSidebar'>");

                                out.println("<a class='sidebar-brand d-flex align-items-center justify-content-center' href='dashboard.jsp'>");
                                String username = (String) request.getSession().getAttribute("username");
                                if (username == null) {
                                    username = request.getParameter("username");
                                    request.getSession().setAttribute("username", username);
                                }
                                out.println("<div class='sidebar-brand-text mx-3'>Mission Order Management System | " + username + "</div>");
                                out.println("</a>");

                                out.println("<hr class='sidebar-divider my-0'>");
                                out.println("<center><p style='color: white;'>Current time: " + new java.util.Date() + "</p></center>");
                                out.println("<br>");
                                out.println("<center><a href='secretary.jsp'><h7 style='color: white;'>HOME</h7></a></center>");
                                out.println("<br>");

                                out.println("<li class='nav-item'>");
                                out.println("<a class='nav-link collapsed' href='#' data-toggle='collapse' data-target='#collapsePages1' aria-expanded='true' aria-controls='collapsePages1'>");
                                out.println("<i class='fas fa-fw fa-users'></i>");
                                out.println("<span>Missions</span>");
                                out.println("</a>");
                                out.println("<div id='collapsePages1' class='collapse' aria-labelledby='headingPages' data-parent='#accordionSidebar'>");
                                out.println("<div class='bg-white py-2 collapse-inner rounded'>");
                                out.println("<a class='collapse-item' href='missionform.jsp'>Add</a>");
                                out.println("<a class='collapse-item' href='RetrieveMissionServlet'>Manage</a>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</li>");

                                out.println("<hr class='sidebar-divider d-none d-md-block'>");
                                out.println("<div class='text-center d-none d-md-inline'>");
                                out.println("<button class='rounded-circle border-0' id='sidebarToggle'></button>");
                                out.println("</div>");

                                out.println("</ul>");

                                out.println("<div id='content-wrapper' class='d-flex flex-column'>");

                                out.println("<div id='content'>");

                                out.println("<nav class='navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow'>");

                                out.println("<button id='sidebarToggleTop' class='btn btn-link d-md-none rounded-circle mr-3'>");
                                out.println("<i class='fa fa-bars'></i>");
                                out.println("</button>");

                                out.println("<ul class='navbar-nav ml-auto'>");
                                out.println("<div class='topbar-divider d-none d-sm-block'></div>");
                                out.println("<li class='nav-item dropdown no-arrow'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='userDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>");
                                out.println("<span class='mr-2 d-none d-lg-inline text-gray-600 small'>Secretary&nbsp;&nbsp;<img class='img-profile rounded-circle' src='uploadeddata/1.png'></span>");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu dropdown-menu-right shadow animated--grow-in' aria-labelledby='userDropdown'>");
                                out.println("<a class='dropdown-item' href='profile.jsp'>");
                                out.println("<i class='fas fa-user fa-sm fa-fw mr-2 text-gray-400'></i>");
                                out.println("Profile");
                                out.println("</a>");

                                out.println("<div class='dropdown-divider'></div>");
                                out.println("<a class='dropdown-item' href='#' data-toggle='modal' data-target='#logoutModal'>");
                                out.println("<i class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400'></i>");
                                out.println("Logout");
                                out.println("</a>");
                                out.println("</div>");
                                out.println("</li>");
                                out.println("</ul>");
                                out.println("</nav>");

                                out.println("<div class='container-fluid'>");
                                out.println("<div class='row'>");

                                out.println("<div class='scrollable-form-container'>");
                                out.println("<h2>Edit Mission</h2>");
                                out.println("<form action='UpdateMissionServlet' method='post' style='padding:20px;'>");
                                out.println("<input type='hidden' name='id' value='" + id + "'>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='person-name'>Person Name</label>");
                                out.println("<input type='text' class='form-control' id='person-name' name='Person_Name' value='" + rs.getString("Person_Name") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='person-function'>Function of the Person</label>");
                                out.println("<input type='text' class='form-control' id='person-function' name='Function_of_person' value='" + rs.getString("Function_of_person") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='mission-purpose'>Purpose of the Mission</label>");
                                out.println("<textarea class='form-control' id='mission-purpose' name='Purpose_of_mission' rows='4' required>" + rs.getString("Purpose_of_mission") + "</textarea>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='destination'>Destination</label>");
                                out.println("<input type='text' class='form-control' id='destination' name='Destination' value='" + rs.getString("Destination") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='transportation'>Means of Transportation</label>");
                                out.println("<input type='text' class='form-control' id='transportation' name='Means_of_transportation' value='" + rs.getString("Means_of_transportation") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='date-of-departure'>Date of Departure</label>");
                                out.println("<input type='date' class='form-control' id='date-of-departure' name='Date_of_Depature' value='" + rs.getString("Date_of_Depature") + "'>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='return-date'>Return Date</label>");
                                out.println("<input type='date' class='form-control' id='return-date' name='Return_Date' value='" + rs.getString("Return_Date") + "'>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='duration-days'>Duration (Days)</label>");
                                out.println("<input type='number' class='form-control' id='duration-days' name='Duration_days' value='" + rs.getInt("Duration_days") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='account-number'>Account Number</label>");
                                out.println("<input type='number' class='form-control' id='account-number' name='Account_number' value='" + rs.getInt("Account_number") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='mission-allowance'>Mission Allowance</label>");
                                out.println("<input type='number' class='form-control' id='mission-allowance' name='Mission_Allowance' value='" + rs.getInt("Mission_Allowance") + "' required>");
                                out.println("</div>");
                                out.println("<div class='form-group'>");
                                out.println("<label for='name-of-supervisor'>Name of Supervisor</label>");
                                out.println("<input type='text' class='form-control' id='name-of-supervisor' name='Name_of_supervisor' value='" + rs.getString("Name_of_supervisor") + "' required>");
                                out.println("</div>");

                                out.println("<button type='submit' class='btn btn-primary' name='action' value='update'>Update</button>");
                                out.println("<a href='RetrieveMissionServlet' class='btn btn-secondary'>Cancel</a>");
                                out.println("</form>");
                                out.println("</div>");

                                out.println("</div>");
                                out.println("</div>");
                                out.println("</div>");
                                out.println("</div>");

                                out.println("</body>");
                                out.println("</html>");
                            } else {
                                response.sendRedirect("RetrieveMissionServlet");
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
                }
            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String personName = request.getParameter("Person_Name");
                String functionOfPerson = request.getParameter("Function_of_person");
                String purposeOfMission = request.getParameter("Purpose_of_mission");
                String destination = request.getParameter("Destination");
                String meansOfTransportation = request.getParameter("Means_of_transportation");
                String dateOfDeparture = request.getParameter("Date_of_Depature");
                String returnDate = request.getParameter("Return_Date");
                int durationDays = Integer.parseInt(request.getParameter("Duration_days"));
                int accountNumber = Integer.parseInt(request.getParameter("Account_number"));
                int missionAllowance = Integer.parseInt(request.getParameter("Mission_Allowance"));
                String nameOfSupervisor = request.getParameter("Name_of_supervisor");

                try (Connection con = DBUtil.getConnection()) {
                    String sql = "UPDATE creation SET Person_Name = ?, Function_of_person = ?, Purpose_of_mission = ?, Destination = ?, Means_of_transportation = ?, Date_of_Depature = ?, Return_Date = ?, Duration_days = ?, Account_number = ?, Mission_Allowance = ?, Name_of_supervisor = ? WHERE Id = ?";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setString(1, personName);
                        ps.setString(2, functionOfPerson);
                        ps.setString(3, purposeOfMission);
                        ps.setString(4, destination);
                        ps.setString(5, meansOfTransportation);
                        ps.setString(6, dateOfDeparture);
                        ps.setString(7, returnDate);
                        ps.setInt(8, durationDays);
                        ps.setInt(9, accountNumber);
                        ps.setInt(10, missionAllowance);
                        ps.setString(11, nameOfSupervisor);
                        ps.setInt(12, id);

                        int result = ps.executeUpdate();
                        if (result > 0) {
                            response.sendRedirect("RetrieveMissionServlet");
                        } else {
                            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Update failed");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
                }
            } else {
                response.sendRedirect("RetrieveMissionServlet");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "UpdateMissionServlet";
    }
}
