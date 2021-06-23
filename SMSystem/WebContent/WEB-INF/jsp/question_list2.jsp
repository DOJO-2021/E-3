<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問一覧｜SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/question_list.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class="wrapper">
	<h3>質問一覧</h3>

	<p class="emergent1">緊急</p>
	<div class="table-QuestionList">
	<div id="overflow">
		<table class="emergent">
			<thead>
				<tr>
					<th class="white0"></th><th class="white">氏名</th><th class="white">ジャンル</th><th class="white"></th>
				</tr>
			</thead>
			<c:forEach var="e" items="${emergent}" >
			<form method="POST" action="/SMSystem/Question_ResponseServlet">
				<tbody>
					<tr>
						<td class="white0"><input type="hidden" name="question_id" value="${e.question_id}"></td>
						<td class="white">${e.user_name}</td>
						<td class="white">${e.genre}</td>
						<td class="white"><input type="submit" name="search" value="回答する"></td>
					</tr>
				</tbody>
			</form>
			</c:forEach>
		</table>
	</div>
	</div>

	<p class="emergent2">通常</p>
	<div class="table-QuestionList">
	<div id="overflow">
		<table class="normal">
			<thead>
				<tr>
					<th class="white0"></th><th class="white">氏名</th><th class="white">ジャンル</th><th class="white"></th>
				</tr>
			</thead>
			<c:forEach var="f" items="${not_emergent}" >
			<form method="POST" action="/SMSystem/Question_ResponseServlet">
				<tbody>
					<tr>
						<td class="white0"><input type="hidden" name="question_id" value="${f.question_id}"></td>
						<td class="white">${f.user_name}</td>
						<td class="white">${f.genre}</td>
						<td class="white"><input type="submit" name="search" value="回答する"></td>
					</tr>
				</tbody>
			</form>
			</c:forEach>
		</table>
	</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>