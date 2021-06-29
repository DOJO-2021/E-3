<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/login.css">
</head>

<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div class="wrapper">
	<p>ログイン</p>
	<form method="POST" action="/SMSystem/LoginServlet" id="form">
		<table class="profile">
			<tr>
			<th><img src="img/id.png" alt="ID" class="img"></th>
				<td><input type="text" name="user_id" placeholder="ID"></td>
			</tr>
			<tr>
			<th><img src="img/password.png" alt="PW" class="img"></th>
				<td><input type="password" name="user_pw" placeholder="password"></td>
			</tr>
		</table>
		<div class="radio">
			<label><input type="radio" name="user_role" value="1">受講者</label>
			<label><input type="radio" name="user_role" value="0">講師</label>
		</div>
		<br>
		<div class="button">
			<input type="submit" name="submit_create" value="ログイン">
		</div>
		<p class="regist"><a href="/SMSystem/Create_IdServlet">新規登録はこちら</a></p>
		<p id="output"></p>
	</form>
</div>
<script src="/SMSystem/js/login.js"></script>
</body>
</html>