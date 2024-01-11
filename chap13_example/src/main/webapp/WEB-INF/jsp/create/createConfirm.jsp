<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp" />
<body>
<jsp:include page="../common/header.jsp" />
<main>
	<article>
		<h2>新規社員情報確認</h2>
		<ul>
	    	<li>
	      	ID:<c:out value="${emp.id}" />
	    	</li>
		    <li>
			  名前:<c:out value="${emp.name}" />
		    </li>
		    <li>
		      年齢:<c:out value="${emp.age}" />
		    </li>
		  </ul>
		  <form action="register" method="post">
			<input type="hidden" name="id" value="<c:out value="${emp.id}" />">
			<input type="hidden" name="name" value="<c:out value="${emp.name}" />">
			<input type="hidden" name="age" value="<c:out value="${emp.age}" />">
		 	<input type="submit" value="確認">
		 	<input type="submit" value="取消"
		  		formaction="list" formmethod="get">
			</form>
	</article>
		<jsp:include page="../common/aside.jsp" />
</main>
<jsp:include page="../common/footer.jsp" />
</body>
</html>