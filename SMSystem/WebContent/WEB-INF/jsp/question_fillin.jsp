<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問記入 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel ="stylesheet" href ="css/question_fillin.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<div class = "wrapper">
	<h3>質問記入</h3>
	<p><span class = "under">氏名</span></p>
	<c:forEach var = "e" items = "${userInfo}">
		<input class = "text" type = "text" name = "student_name" value = "${e.user_name}" readonly>
	</c:forEach>

	<p><span class = "under">ジャンル</span></p>
	<form id="form" method = "POST" action = "/SMSystem/Question_FillinServlet">
		<input type = "hidden" name = "user_id" value = "${sessionScope.id}">
		<div class = "genre">
			<select name = "select" >
				<option value = "">ジャンルを選択してください</option>
				<option value = "0">ドリル</option>
				<option value = "1">HTML</option>
				<option value = "2">CSS</option>
				<option value = "3">JavaScript</option>
				<option value = "4">Java</option>
				<option value = "5">データベース</option>
				<option value = "6">サーブレット＆JSP</option>
				<option value = "7">名刺管理アプリ</option>
				<option value = "8">その他</option>
			</select>
		</div>

		<div class = "question">
			<p><span class = "under">質問</span></p>
			<textarea  name = "question" class="textQuestion"></textarea>
		</div>

		<div class = "radio">
			<label><input type="radio" name="emergent" value="0">緊急</label>
			<label><input type="radio" name="emergent" value="1">緊急でない</label>
		</div>
		<p id="alert"></p>
		<div class ="button">
			<input type = "submit" name = "submit_create" value ="送信">
		</div>
	</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<script src="/SMSystem/js/question_fillin.js"></script>
</div>
</body>
</html>