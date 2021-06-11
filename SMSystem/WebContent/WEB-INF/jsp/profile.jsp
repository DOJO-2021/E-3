<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール確認 | SMSystem</title>
<link rel ="stylesheet" href ="css/profile2.css">
</head>
<body>
<h1>受講者管理システム</h1>
<div class="box">
<p>プロフィール確認</p>
	<form method = "POST" action = "/SMSystem/ProfileServlet">
		<table class="profile">
		<tr>
		<th><img src = "img/name.png" alt = "氏名"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/name.png" alt = "氏名かな"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/company.png" alt = "企業名"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/company.png" alt = "企業名かな"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/blood.png" alt = "血液型"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/career.png" alt = "文理"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/club.png" alt = "部活"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/hobby.png" alt = "趣味"></th>
			<td></td>
		</tr>
		<tr>
		<th><img src = "img/intro.png" alt = "自己紹介"></th>
		<td class ="textarea"></td>
		</tr>
		</table>
		<div class ="button">
			<input type = "button" name = "submit_create" value ="メニュー">
		</div>



	</form>
	</div>
</body>
</html>