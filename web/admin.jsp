<%@ page import="service.UserService" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mikhailkopev
  Date: 26.12.2019
  Time: 03:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<% UserService service = UserService.getInstance();%>
<% List<User> users = service.getAllUsers(); %>
<div style="width: 600px; text-align: center">
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
            <td bgcolor="yellow"><%= user.getRole() %>
            </td>
            <td bgcolor="#a52a2a">
                <a href="/admin/delete?id=<%=user.getId()%>">Delete</a>
            </td>
            <td bgcolor="aqua">
                <a href="/admin/update?id=<%=user.getId()%>&name=<%=user.getName()%>&password=<%=user.getPassword()%>&email=<%=user.getEmail()%>&role=<%=user.getRole()%>">Update</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
