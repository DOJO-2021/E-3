<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<p>クラスを入力してください
		<input type = "text" name = "class" placeholder = "A～E">
		<input type = "submit" name = "search" value = "検索"></p>
	</form>
	<div class = "table-menu">
		<table class = "mytable">
			 <tr>
 				<th>氏名</th><th>氏名(かな)</th><th>企業名</th>
			 </tr>
			 <tr>
 				<td>岡田</td><td>おかだ</td><td>日本システム</td>
 			<tr>
 		</table>
 	</div>
	<div id = "pager" class = "pagination"></div>
	<div class = "infomation-menu">
	<h3>お知らせ</h3>
	</div>
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