<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問回答確認 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<div class="wrapper">
	<h3>質問への回答確認（全質問回数${question_count}件）(${current_pager}/${count_maxpager}ページ)</h3>
	<c:forEach var="e" items="${AList}">
		<div class="question_ro">
			<p><span class="under">質問</span></p>
			<textarea class="textQuestion" name="question" readonly>${e.question}</textarea>
		</div>

		<div class="answer_ro">
			<p><span class="under">回答</span></p>
			<textarea class="textAnswer" name="answer" readonly>${e.answer}</textarea>
		</div>
	</c:forEach>

	<br>
		<div class="pager">
		<a href="/SMSystem/Question_AnswerServlet2?page=small">${pagerSmall}</a>
		<a href="/SMSystem/Question_AnswerServlet2?page=1">${pager1}</a>
		<a href="/SMSystem/Question_AnswerServlet2?page=2">${pager2}</a>
		<a href="/SMSystem/Question_AnswerServlet2?page=3">${pager3}</a>
		<a href="/SMSystem/Question_AnswerServlet2?page=big">${pagerBig}</a>
		</div>
	<br>

	<div class="button">
		<button onclick="location.href='/SMSystem/Menu_StudentServlet'">メニュー</button>
	</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>