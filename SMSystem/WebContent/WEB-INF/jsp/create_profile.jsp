<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール記入 | SMSystem</title>
<link rel ="stylesheet" href ="css/profile.css">
</head>
<body>
<h1>受講者管理システム</h1>
<div class="box">
<p>プロフィール記入</p>
	<form method = "POST" action = "/SMSystem/Create_ProfileServlet">
		<table class="profile">
		<tr>
		<th><img src ="img/name.png" alt = "氏名"></th>
			<td><input type = "text" name = "user_name" placeholder = "氏名"></td>
		</tr>
		<tr>
		<th><img src ="img/name.png" alt = "氏名かな"></th>
			<td><input type = "text" name = "user_name_kana" placeholder = "氏名（かな）"></td>
		</tr>
		<tr>
		<th><img src ="img/blood.png" alt = "血液型"></th>
			<td><input type = "text" name = "user_blood" placeholder = "血液型"></td>
		</tr>
		<tr>
		<th><img src ="img/career.png" alt = "文理"></th>
			<td><input type = "text" name = "user_career" placeholder = "文系？理系？"></td>
		</tr>
		<tr>
		<th><img src ="img/club.png" alt = "部活"></th>
			<td><input type = "text" name = "user_club" placeholder = "部活"></td>
		</tr>
		<tr>
		<th><img src ="img/hobby.png" alt = "趣味"></th>
			<td><input type = "text" name = "user_hobby" placeholder = "趣味"></td>
		</tr>
		<tr>
		<th><img src ="img/intro.png" alt = "自己紹介"></th>
			<td><textarea class ="textlines" name ="user_intro" placeholder = "自己紹介"></textarea></td>
		</tr>
		</table>
		<div class ="button">
			<input type = "submit" name = "submit_create" value ="登録">
		</div>



	</form>
	</div>
</body>
</html>