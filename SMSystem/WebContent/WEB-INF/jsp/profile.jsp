<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール確認 | SMSystem</title>
</head>
<body>
<h1>受講者管理システム</h1>
<div class="box">
<p>プロフィール確認</p>
	<form method = "POST" action = "/SMSystem/ProfileServlet">
		<table class="profile">
		<tr>
		<th><img src ="img/name.png" alt = "氏名"></th>
			<td><input type = "text" name = "user_name" ></td>
		</tr>
		<tr>
		<th><img src ="img/name.png" alt = "氏名かな"></th>
			<td><input type = "text" name = "user_name_kana" ></td>
		</tr>
		<tr>
		<th><img src ="img/blood.png" alt = "血液型"></th>
			<td><input type = "text" name = "user_blood" ></td>
		</tr>
		<tr>
		<th><img src ="img/career.png" alt = "文理"></th>
			<td><input type = "text" name = "user_career" ></td>
		</tr>
		<tr>
		<th><img src ="img/club.png" alt = "部活"></th>
			<td><input type = "text" name = "user_club" ></td>
		</tr>
		<tr>
		<th><img src ="img/hobby.png" alt = "趣味"></th>
			<td><input type = "text" name = "user_hobby" ></td>
		</tr>
		<tr>
		<th><img src ="img/intro.png" alt = "自己紹介"></th>
		<td><textarea class ="textlines" name ="user_info" ></textarea></td>
		</tr>
		</table>
		<div class ="button">
			<input type = "button" name = "submit_create" value ="登録">
		</div>



	</form>
	</div>
</body>
</html>