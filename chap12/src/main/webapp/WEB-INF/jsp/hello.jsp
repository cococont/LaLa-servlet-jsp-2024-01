<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body>
<jsp:include page="common/header.jsp" />
  <h1>どこつぶへようこそ</h1>
  <p><%= name %>さんの<%= today %>の運勢は...</p>
  <div>${requestScope.human}</div>
  <div>${requestScope.human.name}</div>
  <div>${requestScope.human.age}</div>
  <div>${sessionScope.human}</div>
  <div>${sessionScope.human.name}</div>
  <div>${sessionScope.human.age}</div>
  <p>「どこつぶ」は...</p>
  <jsp:include page="common/footer.jsp" />
</body>
</html>