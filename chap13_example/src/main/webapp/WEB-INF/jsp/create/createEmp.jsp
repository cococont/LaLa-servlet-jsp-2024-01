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
	<h2>新規社員登録</h2>
	<form action="create" method="post">
	  <ul>
	    <li>
	      <label>ID:<input type="text" name="id"></label>
	    </li>
	    <li>
	      <label>名前:<input type="text" name="name"></label>
	    </li>
	    <li>
	      <label>年齢:<input type="number" name="age"></label>
	    </li>
	  </ul>
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