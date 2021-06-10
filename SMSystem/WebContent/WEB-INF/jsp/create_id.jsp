<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create_id | SMSystem</title>
</head>
<body>
<h1>受講者管理システム</h1>

<input type="radio" name="first" value=1>受講者
<input type="radio" name="first" value=0>講師

<form method ="post"action="/SMSystem/Create_IdServlet" class="form_createID">
  <table class="regist">
	<tr>
	<th>氏名</th>
		<td><input type = "text" name = "regist_name" placeholder = "氏名"></td>
	</tr>

	<tr>
	<th>氏名かな</th>
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
	<th>ID</th>
		<td><input type="text" name="regist_id" placeholder="ID"></td>
	</tr>

	<tr>
	<th>パスワード</th>
		<td><input type="text" name="regist_password" placeholder="パスワード"></td>
	</tr>

	<tr>
	<th>クラス名(A～Z)</th>
		<td><input type="text" name="regist_class" placeholder="クラス名(A～Z)"></td>
	</tr>
  </table>

  <div class ="regist_button">
	<input type = "submit" name = "submit_regist" value ="登録">
  </div>
</form>
</body>
</html>