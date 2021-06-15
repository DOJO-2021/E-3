<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール確認 | SMSystem</title>
<link rel ="stylesheet" href ="css/profile2.css">

</head>
<body>

<h1>受講者管理システム</h1>

<h3>プロフィール確認</h3>
<c:forEach var = "e" items = "${userProfileList}">
		<table class="profile">
		<tr>
		<th><img src = "img/name.png" alt = "氏名"></th>
			<td>${e.user_name}</td>
		</tr>
		<tr>
		<th><img src = "img/name.png" alt = "氏名かな"></th>
			<td>${e.user_name_kana}</td>
		</tr>
		<tr>
		<th><img src = "img/company.png" alt = "企業名"></th>
			<td>${e.user_company}</td>
		</tr>
		<tr>
		<th><img src = "img/company.png" alt = "企業名かな"></th>
			<td>${e.user_company_kana}</td>
		</tr>
		<tr>
		<th><img src = "img/blood.png" alt = "血液型"></th>
			<td>${e.user_blood}</td>
		</tr>
		<tr>
		<th><img src = "img/career.png" alt = "文理"></th>
			<td>${e.user_career}</td>
		</tr>
		<tr>
		<th><img src = "img/club.png" alt = "部活"></th>
			<td>${e.user_club}</td>
		</tr>
		<tr>
		<th><img src = "img/hobby.png" alt = "趣味"></th>
			<td>${e.user_hobby}</td>
		</tr>
		<tr>
		<th><img src = "img/intro.png" alt = "自己紹介"></th>
		<td class ="textarea">${e.user_intro}</td>
		</tr>
		</table>
		</c:forEach>
		<div class ="button">
			<button onclick = "location.href = '/SMSystem/Menu_TeacherServlet'">メニュー</button>
		</div>





	<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</body>
</html>