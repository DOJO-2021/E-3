<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問記入 | SMSystem</title>
<link rel ="stylesheet" href ="css/question_fillin.css">
</head>
<body>
<div class = "box">
<p>ジャンルを選択してください</p>
<form method = "GET" action = "/SMSystem/Question_ListServlet" id = form-genre>
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
<input type = "submit" name = "search" value = "検索">
</form>

<form method = "POST" action = "/SMSystem/Question_ListServret">
<p>質問</p>
<textarea  name = "question" ></textarea>
	<div class = "radio">
		<label><input type="radio" name="emergent" value="1">緊急</label>
		<label><input type="radio" name="emergent" value="0">緊急でない</label>
		</div>
	<div class ="button">
			<input type = "submit" name = "submit_create" value ="送信">
	</div>

</form>
</div>
</body>
</html>