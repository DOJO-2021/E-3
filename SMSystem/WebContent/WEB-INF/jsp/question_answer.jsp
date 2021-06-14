<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問回答確認 | SMSystem</title>
<link rel ="stylesheet" href ="css/question_answer.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<div class="wrapper">
	<form method="GET" action="/SMSystem/Question_ResponseServlet">
		<div class="question">
			<p>質問</p>
			<input type>
		</div>
	</form>
	<form method="GET" action="/SMSystem/Question_ResponseServlet">
		<div class="answer">
			<p>回答</p>
			<textarea class="textAnswer" name="answer"></textarea>
		</div>
	</form>
		<div class="button">
		<input type="button" name="submit_menu" value="メニュー">
	</div>
	</div>

</body>
</html>