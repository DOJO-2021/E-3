<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受講者一覧 | SMSystem</title>
<link rel = "stylesheet" href = "css/student.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<div class = "wrapper">
<br><br><br><br>
<form method = "GET" action = "/SMSystem/ProfileServlet" >
	<div class = "table-menu" id = "table">
		<table class = "mytable" id = "list">
			 <tr>
 				<th class="n">氏名</th><th class="nk">氏名(かな)</th><th class="c">企業名</th><th></th>
			 </tr>
			 <c:forEach var="e" items="${studentList}" >
			 <input type = "hidden" name = "user_id" value = "${e.user_id }">
			 <tr class = "data_row">

 				<td>${e.user_name}</td>
 				<td>${e.user_name_kana}</td>
 				<td>${e.user_company}</td>
 				<td><input type = "submit" name = "search" value = "プロフィールへ"></td>
 			<tr>
 			</c:forEach>

 		</table>
 		</div>
  </form>
  </div>
</body>
</html>