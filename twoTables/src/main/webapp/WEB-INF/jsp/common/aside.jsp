<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
  <h2>aside</h2>    
    <a href="create">新規作成</a><br>
    <a href="deptlist">部署一覧</a><br>
    <input type="text"><input type="button" value="検索"/></input>
    <form action="">
     	<select name="dept_id">
    		<c:forEach var="d" items="${deptList}">
    			<option value="${d.id}">${d.name}</option>
    		</c:forEach>
    	</select>
    </form>

  </ul>
</aside>