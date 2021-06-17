<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受講者一覧 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
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

	<ul class="pagination">
		<form method = "GET" action = "/SMSystem/Student_ListServlet">
			<li id="prev">＜</li>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li id="next">＞</li>
		</form>
    </ul>


 	</div>

  </div>
</main>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />


</body>
</html>