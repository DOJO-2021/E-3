<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/profile.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<div class="wrapper">
<form method="post"action="/SMSystem/Create_IdServlet" class="form_createID" id="form">

	<div class="radio">
		<label><input type="radio" name="user_role" value="1">受講者</label>
		<label><input type="radio" name="user_role" value="0">講師</label>
	</div>
	<p id="role_op">登録に失敗すればログイン画面に戻ります。</p>
	  <table class="profile">
		<tr>
			<th><img src="img/name.png"></th>
			<td><input type="text" name="user_name" placeholder="氏名"></td>
		</tr>

		<tr>
			<th><img src="img/name.png"></th>
			<td><input type="text" name="user_name_kana" placeholder="氏名（かな）"></td>
		</tr>

		<tr>
			<th><img src="img/company.png"></th>
			<td><input type="text" name="user_company" placeholder="企業名"></td>
		</tr>

		<tr>
			<th><img src="img/company.png"></th>
			<td><input type="text" name="user_company_kana" placeholder="企業名（かな）"></td>
		</tr>

		<tr>
			<th><img src="img/id.png"></th>
			<td><input type="text" name="user_id" placeholder="ID(半角英数字 6～20字以内)"></td>
		</tr>

		<tr>
			<th><img src="img/password.png"></th>
			<td><input type="text" name="user_pw" placeholder="PW(8～16字以内 大文字 小文字 数字 必須)"></td>
		</tr>

		<tr>
			<th><img src="img/class.png"></th>
			<td><input type="text" name="user_class" placeholder="クラス名(A～Z)"></td>
		</tr>
	</table>
	<p id="op"></p>
	<p id="id_pw"></p>
	<div class="button">
		<input type="submit" name="submit_regist" value="登録">
	</div>
</form>
</div>
<script src="/SMSystem/js/create_id.js"></script>
</body>
</html>