<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問記入 | SMSystem</title>
<link rel ="stylesheet" href ="css/question_fillin.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<br>
<br>
<div class = "box">
<input class = "text" type = "text" name = "student_name" placeholder = "氏名">

<form method = "POST" action = "/SMSystem/Question_FillinServlet">
<input type = "hidden" name = "user_id" value = "${sessionScope.id}">
<p>ジャンルを選択してください</p>
<select name = "select" >
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

<p>質問</p>
<textarea  name = "question" ></textarea>
	<div class = "radio">
		<label><input type="radio" name="emergent" value="0">緊急</label>
		<label><input type="radio" name="emergent" value="1">緊急でない</label>
		</div>
	<div class ="button">
			<input type = "submit" name = "submit_create" value ="送信">
	</div>

</form>
</div>
</body>
</html>