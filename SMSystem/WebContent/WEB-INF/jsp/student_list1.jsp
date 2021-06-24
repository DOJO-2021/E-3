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
<div class = "wrapper">
	<h3>${studentClass}の受講者一覧(全${count}人)(${current_pager}/${count_maxpager}ページ)</h3>

	<div class = "table-menu" id = "table">
		<table class = "mytable" id = "list">
			<thead>
				<tr>
 					<th class="white0"></th><th class="white">氏名</th><th class="white">氏名(かな)</th><th class="white">企業名</th><th class="white"></th>
				</tr>
			</thead>
			<c:forEach var="e" items="${studentList}" >
			<form method = "POST" action = "/SMSystem/Student_ListServlet">
				<tbody>
					<tr class = "data_row">
						<td class="white0"><input type = "hidden" name = "user_id" value = "${e.user_id }"></td>
						<td class="white">${e.user_name}</td>
						<td class="white">${e.user_name_kana}</td>
						<td class ="white">${e.user_company}</td>
						<td class="white"><input type = "submit" name = "search" value = "プロフィールへ"></td>
					</tr>
				</tbody>
			</form>
			</c:forEach>
		</table>
	</div>
		<br>
	 	<div class="pager">
		<a href = "/SMSystem/Student_ListServlet?page=small">＜</a>
		<a href = "/SMSystem/Student_ListServlet?page=1">${pager1}</a>
		<a href = "/SMSystem/Student_ListServlet?page=2">${pager2}</a>
		<a href = "/SMSystem/Student_ListServlet?page=3">${pager3}</a>
		<a href = "/SMSystem/Student_ListServlet?page=big">＞</a>
		</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>