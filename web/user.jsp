<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: mikhailkopev
  Date: 26.12.2019
  Time: 04:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getSession().getAttribute("user");%>

<html>
<head>
    <title>User</title>
</head>
<body>
<form method="post">
    <div style="width: 600px; text-align: center">
        <h3>USER INFO</h3>
        <table style="text-align: center; border: 4px double black; width: 100%;">
            <tr style="text-align: center">
                <td bgcolor="aqua"><%= user.getId() %>
                </td>
                <td bgcolor="yellow"><%= user.getName() %>
                </td>
                <td bgcolor="yellow"><%= user.getEmail() %>
                </td>
                <td bgcolor="yellow"><%= user.getPassword() %>
                </td>
                <td bgcolor="yellow"><%= user.getRole() %>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
