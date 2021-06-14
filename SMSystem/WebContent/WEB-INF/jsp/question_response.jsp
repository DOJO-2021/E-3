<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回答記入｜SMSystem</title>
<link rel="stylesheet" href="css/question_response.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<div class="wrapper">
	<form method="GET" action="/SMSystem/Question_ResponseServlet">
		<div class="question">
			<p>質問</p>
		</div>
	</form>
	<form method="POST" action="/SMSystem/Question_ResponseServlet">
		<div class="answer">
			<p>回答</p>
			<textarea class="textAnswer" name="answer"></textarea>
		</div>
	</form>
	<div class="radio">
		<label><input type="radio" name="emergent" value="1">FAQに登録する</label>
		<label><input type="radio" name="emergent" value="0">FAQに登録しない</label>
	</div>
	<div class="button">
		<input type="submit" name="submit_response" value="登録">
	</div>
</div>
</body>
</html>
