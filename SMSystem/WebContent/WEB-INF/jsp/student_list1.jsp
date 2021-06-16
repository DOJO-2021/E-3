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
<main>
<div class = "wrapper">
<br><br><br><br>
<p>${studentClass}の受講者一覧(全${count}人)</p>

	<div class = "table-menu" id = "table">
		<table class = "mytable" id = "list">
			 <tr>
 				<th></th><th class="n">氏名</th><th class="nk">氏名(かな)</th><th class="c">企業名</th><th></th>
			 </tr>

			<c:forEach var="e" items="${studentList}" >
			<form method = "POST" action = "/SMSystem/Student_ListServlet">
			 	<tr class = "data_row">
	 				<td><input type = "hidden" name = "user_id" value = "${e.user_id }"></td>
	 				<td>${e.user_name}</td>
	 				<td>${e.user_name_kana}</td>
	 				<td>${e.user_company}</td>
	 				<td><input type = "submit" name = "search" value = "プロフィールへ"></td>
 				 </tr>
 			</form>
 			</c:forEach>

 		</table>

	 	<nav id=pagefeed>
			<span id="prev"></span>
			<span id="page"></span>
			<span id="next"></span>
		</nav>

 	</div>

  </div>
</main>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>

<script>
'use strict';
​
$(function() {
  var page = 0;
  function draw() {
    $('#page').html(page + 1);
    $('tr').hide();
    $('tr:first,tr:gt(' + page * 23 + '):lt(23)').show();
  }
  function draw2() {
    $('#page').html(page + 1);
    $('tr').hide();
    $('tr:first,tr:gt(' + page * 24 + '):lt(24)').show();
  }
​
  $('#prev').click(function() {
    if (page > 0) {
      page--;
      draw2();
    }
  });
  $('#next').click(function() {
    if (page < ($('tr').size() - 1) / 23 - 1) {
      page++;
      draw2();
    }
  });
  draw();
});


</script>
</body>
</html>