<%--
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
<div style="width: 600px; text-align: center">
    <h3>Login</h3>
    <form action="/index" method="post">
        <p>
            <label for="email" style="display: inline-block; width: 65px; text-align: right;">Email</label>
            <input type="email" id="email" name="email">
        </p>
        <p>
            <label for="password" style="display: inline-block; width: 65px; text-align: right;">Password</label>
            <input type="password" id="password" name="password">
        </p>
        <button type="submit" style="width: 75px;">login</button>
    </form>
</div>
</body>
</html>
