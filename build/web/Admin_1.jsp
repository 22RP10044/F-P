<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Super Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style type="text/css">
    body {
    font-family: Arial, sans-serif;
    background-color: #f0f8ff; /* Light blue background */
    margin: 0;
    padding: 0;
}

.header {
    background-color: #007BFF; /* Blue background */
    color: white;
    padding: 20px;
    text-align: center;
}

.nav {
    margin-top: 10px;
}

.nav button {
    background-color: white;
    border: 1px solid #007BFF;
    color: #007BFF;
    padding: 10px 20px;
    margin: 0 5px;
    cursor: pointer;
    border-radius: 5px;
}

.nav button:hover {
    background-color: #007BFF;
    color: white;
}

.container {
    display: flex;
    justify-content: space-around;
    margin-top: 50px;
}

.user-actions {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.user-actions button {
    background-color: #007BFF;
    border: none;
    color: white;
    padding: 10px 20px;
    margin: 10px 0;
    cursor: pointer;
    border-radius: 5px;
}

.user-actions button:hover {
    background-color: #0056b3;
}

.user-form {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
    display: none;
}

.user-form h3 {
    margin-top: 0;
}

.user-form label {
    display: block;
    margin: 10px 0 5px;
}

.user-form input, .user-form select {
    width: calc(100% - 22px);
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #007BFF;
    border-radius: 5px;
}

.user-form button {
    background-color: #007BFF;
    border: none;
    color: white;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 5px;
}

.user-form button:hover {
    background-color: #0056b3;
}

.user-list {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 60%;
}

.user-list table {
    width: 100%;
    border-collapse: collapse;
}

.user-list th, .user-list td {
    border: 1px solid #007BFF;
    padding: 10px;
    text-align: left;
}

.user-list th {
    background-color: #007BFF;
    color: white;
}

</style>>
<body>
    <div class="header">
        <h1>Super Admin Dashboard</h1>
        <div class="nav">
            <button onclick="signIn()">Sign In</button>
            <button onclick="signOut()">Sign Out</button>
        </div>
    </div>

    <div class="container">
        <div class="user-actions">
            <button onclick="toggleAddUserForm()">Add User</button>
            <button onclick="removeUser()">Remove User</button>
        </div>

        <div id="addUserForm" class="user-form">
            <h3>Add New User</h3>
            <label for="userName">Name:</label>
            <input type="text" id="userName" name="userName">
            <label for="userRole">Role:</label>
            <select id="userRole" name="userRole">
                <option value="Local User">Local User</option>
                <option value="Supervisor">Supervisor</option>
                <option value="Secretary">Secretary</option>
                <option value="CSDM">CSDM</option>
                <option value="DAF">DAF</option>
            </select>
            <label for="userPassword">Password:</label>
            <input type="password" id="userPassword" name="userPassword">
            <button onclick="addUser()">Submit</button>
        </div>

        <div class="user-list">
            <h2>User List</h2>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody id="userList">
                    <!-- Users will be listed here -->
                </tbody>
            </table>
        </div>
    </div>

    <script>
        function signIn() {
            alert('Sign In clicked');
        }

        function signOut() {
            alert('Sign Out clicked');
        }

        function toggleAddUserForm() {
            const form = document.getElementById('addUserForm');
            form.style.display = form.style.display === 'none' || form.style.display === '' ? 'block' : 'none';
        }

        function addUser() {
            const userList = document.getElementById('userList');
            const userName = document.getElementById('userName').value;
            const userRole = document.getElementById('userRole').value;
            const userPassword = document.getElementById('userPassword').value;

            if (userName && userRole && userPassword) {
                const row = document.createElement('tr');
                row.innerHTML = `<td>${userName}</td><td>${userRole}</td><td>${userPassword}</td>`;
                userList.appendChild(row);

                // Clear the form
                document.getElementById('userName').value = '';
                document.getElementById('userRole').value = 'Local User';
                document.getElementById('userPassword').value = '';
                toggleAddUserForm();
            } else {
                alert('All fields are required.');
            }
        }

        function removeUser() {
            const userList = document.getElementById('userList');
            const userName = prompt('Enter the name of the user to remove:');
            if (userName) {
                const rows = userList.getElementsByTagName('tr');
                for (let i = 0; i < rows.length; i++) {
                    if (rows[i].cells[0].textContent === userName) {
                        userList.removeChild(rows[i]);
                        break;
                    }
                }
            }
        }
    </script>
</body>
</html>
