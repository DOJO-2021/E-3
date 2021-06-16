<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create_id | SMSystem</title>
<link rel ="stylesheet" href ="css/profile.css">
</head>
<body>
<h1>受講者管理システム</h1>
<div class="box">
<form method ="post"action="/SMSystem/Create_IdServlet" class="form_createID" id="form">
<br><br>

<div class = "radio">
<label><input type="radio" name="user_role" value="1">受講者</label>
<label><input type="radio" name="user_role" value="0">講師</label>
</div>
<p id="role_op"></p>
<br>
  <table class="profile">
	<tr>
	<th><img src = "img/name.png"></th>
		<td><input type = "text" name = "user_name" placeholder = "氏名"></td>
	</tr>

	<tr>
	<th><img src = "img/name.png"></th>
		<td><input type = "text" name = "user_name_kana" placeholder = "氏名（かな）"></td>
	</tr>

	<tr>
	<th><img src = "img/company.png"></th>
		<td><input type="text" name="user_company" placeholder="企業名"></td>
	</tr>

	<tr>
	<th><img src = "img/company.png"></th>
		<td><input type="text" name="user_company_kana" placeholder="企業名（かな）"></td>
	</tr>

	<tr>
	<th><img src = "img/id.png"></th>
		<td><input type="text" name="user_id" placeholder="ID"></td>
	</tr>

	<tr>
	<th><img src = "img/password.png"></th>
		<td><input type="text" name="user_pw" placeholder="パスワード"></td>
	</tr>

	<tr>
	<th><img src = "img/class.png"></th>
		<td><input type="text" name="user_class" placeholder="クラス名(A～Z)"></td>
	</tr>
  </table>
  <p id="op"></p>
  <div class ="button">
	<input type = "submit" name = "submit_regist" value ="登録">
  </div>
</form>
</div>
<script src="/SMSystem/js/create_id.js"></script>
</body>
</html>