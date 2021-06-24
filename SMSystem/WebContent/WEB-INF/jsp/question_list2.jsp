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

	<p class="emergent1">緊急(全${e_count}件)</p>
	<div class="table-QuestionList">
	<div id="overflow">
		<table class="emergent">
			<thead>
				<tr>
					<th class="white0"></th><th class="white1">氏名</th><th class="white1">ジャンル</th><th class="white2"></th>
				</tr>
			</thead>
			<c:forEach var="e" items="${emergent}" >
			<form method="POST" action="/SMSystem/Question_ResponseServlet">
				<tbody>
					<tr>
						<td class="white0"><input type="hidden" name="question_id" value="${e.question_id}"></td>
						<td class="white1">${e.user_name}</td>
						<td class="white1">${e.genre}</td>
						<td class="white2"><input type="submit" name="search" value="回答する"></td>
					</tr>
				</tbody>
			</form>
			</c:forEach>
		</table>
	</div>
	</div>

	<p class="emergent2">通常(全${n_count}件)</p>
	<div class="table-QuestionList">
	<div id="overflow">
		<table class="normal">
			<thead>
				<tr>
					<th class="white0"></th><th class="white1">氏名</th><th class="white1">ジャンル</th><th class="white2"></th>
				</tr>
			</thead>
			<c:forEach var="f" items="${not_emergent}" >
			<form method="POST" action="/SMSystem/Question_ResponseServlet">
				<tbody>
					<tr>
						<td class="white0"><input type="hidden" name="question_id" value="${f.question_id}"></td>
						<td class="white1">${f.user_name}</td>
						<td class="white1">${f.genre}</td>
						<td class="white2"><input type="submit" name="search" value="回答する"></td>
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