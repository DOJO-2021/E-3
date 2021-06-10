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
<form method ="post"action="/SMSystem/Create_IdServlet" class="form_createID">
<br><br>
<div class = "radio">
<input type="radio" name="first" value="1">受講者
<input type="radio" name="first" value="0">講師
</div>
<br>
  <table class="profile">
	<tr>
	<th><img src = "img/name.png"></th>
		<td><input type = "text" name = "regist_name" placeholder = "氏名"></td>
	</tr>

	<tr>
	<th><img src = "img/name.png"></th>
		<td><input type = "text" name = "regist_name_kana" placeholder = "氏名（かな）"></td>
	</tr>

	<tr>
	<th>企業名</th>
		<td><input type="text" name="regist_company" placeholder="企業名"></td>
	</tr>

	<tr>
	<th>企業名（かな）</th>
		<td><input type="text" name="regist_company_kana" placeholder="企業名（かな）"></td>
	</tr>

	<tr>
	<th><img src = "img/id.png"></th>
		<td><input type="text" name="regist_id" placeholder="ID"></td>
	</tr>

	<tr>
	<th><img src = "img/password.png"></th>
		<td><input type="text" name="regist_password" placeholder="パスワード"></td>
	</tr>

	<tr>
	<th>クラス名(A～Z)</th>
		<td><input type="text" name="regist_class" placeholder="クラス名(A～Z)"></td>
	</tr>
  </table>

  <div class ="button">
	<input type = "submit" name = "submit_regist" value ="登録">
  </div>
</form>
</div>
</body>
</html>