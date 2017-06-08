<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.06.2017
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<center><form action="/edit" method="get">
    <input hidden="true" type="text" name="catId" value="${cat.catId}">
    <input type="text" name="name" value="${cat.name}">
    <input type="text" name="weight" value="${cat.weight}">
    <input type="submit" value="Edit">
</form></center>
</body>
</html>
