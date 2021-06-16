<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<c:forEach var = "e" items = "Alist">
				<div class="question">
					<p><span class="under">質問</span></p>
					<input type ="text" class="textquestion" name = "question" value = "${e.question}"readonly>

				</div>

				<div class="answer">
					<p><span class="under">回答</span></p>
					<input type ="text" class="textAnswer" name ="answer" value = "${e.answer}" readonly>
				</div>

</c:forEach>

		<div class="button">
			<button onclick = "location.href = '/SMSystem/Menu_TeacherServlet'">メニュー</button>
		</div>
</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>