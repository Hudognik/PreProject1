<%--
  Created by IntelliJ IDEA.
  User: mikhailkopev
  Date: 17.12.2019
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/admin/update" method="post">
    <input type="hidden" name="id" value=<%=request.getParameter("id")%>>
    <label>name</label>
    <input type="text" name="name" value=<%=request.getParameter("name")%>>
    <label>email</label>
    <input type="email" name="email" value=<%=request.getParameter("email")%>>
    <label>password</label>
    <input type="password" name="password" value=<%=request.getParameter("password")%>>
    <label>role</label>
    <input type="text" name="role" value=<%=request.getParameter("role")%>>
    <button type="submit">Add</button>
</form>
</body>
</html>
