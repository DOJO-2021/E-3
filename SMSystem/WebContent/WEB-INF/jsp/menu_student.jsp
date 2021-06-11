<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/menu.css">
<link rel = "stylesheet" href = "css/PaginateMyTable.css">
<title>メニュー | SMSystem</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<main>
<div class = "wrapper">
	<form method = "GET" action = "/SMSystem/Menu_StudentServlet">
		<p class="text">クラスを入力してください
		<input type = "text" name = "class" placeholder = "A～E">
		<input type = "submit" name = "search" value = "検索">
		</p>
	</form>
	<c:forEach var="e" items="${studentList}" >
	<div class = "table-menu">
		<table class = "mytable">
			 <tr>
 				<th>氏名</th><th>氏名(かな)</th><th>企業名</th>
			 </tr>
			 <tr>
 				<td><a href="/SMSystem/ProfileServlet" ${e.user_name}></a></td>
 				<td><a href="/SMSystem/ProfileServlet" ${e.user_name_kana}></a></td>
 				<td><a href="/SMSystem/ProfileServlet" ${e.user_company}></a></td>
 			<tr>
 		</table>
 	</div>
 	</c:forEach>
	<div class = "infomation-menu">
	<h3>お知らせ</h3>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</main>
<script src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<script src = "jquery/PagenateMyTable.js"></script>
<script>
'use strict';

$(document).ready(function() {
	  $(".mytable").paginate();
	});

</script>
</body>
</html>