<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = (String)application.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>練習11-2</h1>
  <form action="ex" method="post">
    name:<input type="text" name="name">
    <input type="submit" value="send">
  </form>
  <p>name:<%= name %>
</body>
</html>