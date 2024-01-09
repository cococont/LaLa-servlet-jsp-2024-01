<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empList</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
  <h1>empList</h1>
  <table>
    <tr>
      <th>ID</th>
      <th>名前</th>
      <th>年齢</th>
    </tr>
    <c:forEach var="e" items="${empList}">
      <tr>
        <td><c:out value="${e.id}" /></td>
        <td><c:out value="${e.name}" /></td>
        <td><c:out value="${e.age}" /></td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>