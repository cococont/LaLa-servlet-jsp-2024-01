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
	      <th>部署名</th>
	    </tr>
    <c:forEach var="d" items="${deptList}">
      <tr>
        <td><c:out value="${d.id}" /></td>
        <td><c:out value="${d.name}" /></td>
        <td class="no-border">
        	<form action="update" method="post">
        		<button type="submit">編集</button>
        	</form>
        </td>
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