<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="common/head.jsp" />
<body>
<jsp:include page="common/header.jsp" />
<main>
  <article>
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
        <td class="no-border"><input type="button" value="編集"></td>
        <td class="no-border"><input type="button" value="削除"></td>
      </tr>
    </c:forEach>
  </table>
  </article>
  <jsp:include page="common/aside.jsp" />
</main>
<jsp:include page="common/footer.jsp" />
</body>
</html>