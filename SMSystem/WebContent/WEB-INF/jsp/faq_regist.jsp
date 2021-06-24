<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ登録 | SMSystem</title>
<link rel = "stylesheet" href = "css/common.css">
<link rel ="stylesheet" href = "css/question_fillin.css">
</head>
<body>
<jsp:include page = "/WEB-INF/jsp/header_teacher.jsp" />
<form id="form" method = "POST" action = "/SMSystem/Faq_RegistServlet">
<div class = "wrapper">
	<h3>FAQ登録 </h3>
	<div class="genre">
		<select name = "genre">
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
		<textarea name = "question" class="textQuestion"></textarea>
	</div>
	<div class = "answer">
		<p><span class = "under">回答</span></p>
		<textarea name = "answer" class="textAnswer"></textarea>
	</div>
	<p id="alert"></p>
	<div class = "button">
		<input type = "submit" name ="regist" value = "登録">
	</div>
</div>
</form>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<script src="/SMSystem/js/faq_regist.js"></script>
</body>
</html>