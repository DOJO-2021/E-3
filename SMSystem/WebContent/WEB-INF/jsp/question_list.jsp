<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問一覧｜SMSystem</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<main>
<div class="wrapper">
	<form method="GET" action="/SMSystem/Question_ListServlet">
		<p class="text">
		<input type="text" name="class" placeholder="A～E">
		<input type="submit" name="search" value="検索">
		</p>
	</form>
	<c:forEach var="e" items="${questionList}" >
	<div class="table_QuestionList">
		<table class="emergent">
			<tr>
				<th>緊急</th>
			</tr>
			<tr>
				<th>氏名</th><th>ジャンル</th>
			</tr>
			<tr>
				<td><a href="/SNSystem/Question_ResponseServlet" ${e.user_name}></a></td>
				<td><a href="/SNSystem/Question_ResponseServlet" ${e.genre}></a></td>
			</tr>
		</table>
		<table class="normal">
			<tr>
				<th>氏名</th><th>ジャンル</th>
			</tr>
			<tr>
				<td><a href="/SNSystem/Question_ResponseServlet" ${e.user_name}></a></td>
				<td><a href="/SNSystem/Question_ResponseServlet" ${e.genre}></a></td>
			</tr>
		</table>
	</div>
	</c:forEach>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</main>
</body>
</html>