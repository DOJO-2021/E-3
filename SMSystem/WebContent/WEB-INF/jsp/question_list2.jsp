<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/question_list.css">
<title>質問一覧｜SMSystem</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class="wrapper">
	<div class="table-QuestionList">
		<table class="emergent">
			<tr>
				<th class="orange">緊急</th><th class="orange"> </th>
			</tr>
			<tr>
				<th></th><th class="white">氏名</th><th class="white">ジャンル</th>
			</tr>
			<c:forEach var="e" items="${userAll_questionList}" >
			<form method="POST" action="/SMSystem/Question_ResponseServlet">
				<tr>
					<td><input type="hidden" name="question_id" value="${e.question_id}"></td>
					<td>${e.user_name}</td>
					<td>${e.genre}</td>
					<td><input type="submit" name="search" value="回答する"></td>
				</tr>
			</form>
			</c:forEach>
		</table>
	</div>

	<div class="table-QuestionList">
		<table class="normal">
			<tr>
				<th class="white">氏名</th><th class="white">ジャンル</th>
			</tr>
			<c:forEach var="e" items="${userAll_questionList2}" >
			<form method="POST" action="/SMSystem/Question_ResponseServlet">
				<tr>
					<td><input type="hidden" name="question_id" value="${e.question_id}"></td>
					<td>${e.user_name}</td>
					<td>${e.genre}</td>
					<td><input type="submit" name="search" value="回答する"></td>
				</tr>
			</form>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>