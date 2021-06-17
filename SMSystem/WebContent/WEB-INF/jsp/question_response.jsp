<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回答記入｜SMSystem</title>
<link rel="stylesheet" href="css/question_response.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class="wrapper">
	<div class="question">
		<p><span class="under">質問</span></p>
		<!-- <input type="hidden" name="question_id" value="${question_id}"> -->
		<input type="text" class="textquestion" name="question" value="${all_question}" readonly>
	</div>
	<form method="POST" action="/SMSystem/Question_ResponseServlet">
		<div class="answer">
			<p><span class="under">回答</span></p>
			<textarea class="textAnswer" name="answer"></textarea>
		</div>
		<div class="radio">
			<label><input type="radio" name="faq" value="1">FAQに登録する</label>
			<label><input type="radio" name="faq" value="0">FAQに登録しない</label>
		</div>
		<div class="button">
			<input type="submit" name="submit_response" value="登録">
		</div>
	</form>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>
