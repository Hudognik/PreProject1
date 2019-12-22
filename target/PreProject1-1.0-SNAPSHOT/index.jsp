<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>
<%@ page import="service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: mikhailkopev
  Date: 14.12.2019
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<% UserService service = UserService.getInstance();%>
<% List<User> users = service.getAllUsers(); %>
<div style="width: 600px; text-align: center">
    <h3>New User</h3>
    <form action="IndexServlet" method="post">
        <p>
            <label for="name" style="display: inline-block; width: 65px; text-align: right;">Name</label>
            <input type="text" id="name" name="name">
        </p>
        <p>
            <label for="email" style="display: inline-block; width: 65px; text-align: right;">Email</label>
            <input type="email" id="email" name="email">
        </p>
        <p>
            <label for="password" style="display: inline-block; width: 65px; text-align: right;">Password</label>
            <input type="password" id="password" name="password">
        </p>
        <button type="submit" style="width: 75px;">Add</button>
    </form>
    <h3>Users List</h3>
    <table style="text-align: center; border: 4px double black; width: 100%;">
        <% for (User user : users) { %>
        <tr style="text-align: center">
            <td bgcolor="aqua"><%= user.getId() %>
            </td>
            <td bgcolor="yellow"><%= user.getName() %>
            </td>
            <td bgcolor="yellow"><%= user.getEmail() %>
            </td>
            <td bgcolor="#a52a2a">
                <a href="/delete?id=<%=user.getId()%>">Delete</a>
            </td>
            <td bgcolor="aqua">
                <a href="/update?id=<%=user.getId()%>&name=<%=user.getName()%>&password=<%=user.getPassword()%>&email=<%=user.getEmail()%>">Update</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
