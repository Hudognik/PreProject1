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
    <title>Delete</title>
</head>
<body>
<form method="post">
    <input type="hidden" value="<%=request.getParameter("id")%>">
    <p>Do you really want delete user?</p>
    <button type="submit">Delete</button>
</form>
</body>
</html>
