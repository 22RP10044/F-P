<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, java.util.Map" %>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>User Management</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Role</th>
                    <th>Password</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Map<String, String>> userList = (List<Map<String, String>>) request.getAttribute("userList");
                    if (userList != null && !userList.isEmpty()) {
                        for (Map<String, String> user : userList) {
                %>
                <tr>
                    <td><%= user.get("name") %></td>
                    <td><%= user.get("role") %></td>
                    <td><%= user.get("password") %></td>
                    <td>
                        <a href="UpdateUserServlet?id=<%= user.get("id") %>">Edit</a> |
                        <a href="DeleteUserServlet?id=<%= user.get("id") %>">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">No users found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
    <div class="table-responsive">
        <jsp:include page="/RetrieveUserServlet" />
    </div>
</html>
