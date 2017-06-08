<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.06.2017
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cat Database</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
  </head>
  <style>
    a, a:visited, a:focus{
      text-decoration: none;
      color: black;

    }
    a:hover {
      color: #4793b5;
    }
    td {
      text-align: center;
    }
  </style>
  <body>
  <center><form action="/add" method="get">
    <input type="text" name="name">
    <input type="text" name="weight">
    <input type="submit" value="Add to Database">
  </form></center>

  <table id="example" class="display" width="100%" cellspacing="0">
    <thead><tr>
      <th>Id</th>
      <th>Name</th>
      <th>Weigh</th>
      <th>Delete</th>
      <th>Edit</th>
    </tr></thead>
    <tbody>
      <c:forEach items="${catList}" var="cat">
        <tr>
          <td>${cat.catId}</td>
          <td>${cat.name}</td>
          <td>${cat.weight}</td>
          <td><a href="/delete/${cat.catId}">Delete</a></td>
          <td><a href="/edit/${cat.catId}">Edit</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <script>
      $(function(){
          $("#example").dataTable();
      });
  </script>
  </body>
</html>
