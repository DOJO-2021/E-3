<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイメニュー | SMSystem</title>
<link rel = "stylesheet" href = "css/mymenu.css">
</head>

<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<main>
<br><br><br>
<div class = "index">
<h3>マイメニュー</h3>
</div>

<div class = "profile">
	<c:forEach var="e" items= "${userInfo}">
		<table class = "mymenu">
			<tr>
				<th>名前</th>
				<td> ${e.user_name}</td>
			</tr>
			<tr>
				<th>企業名</th>
				<td>${e.user_company}</td>
			</tr>
			<tr>
				<th>クラス</th>
				<td>${e.user_class}</td>
			</tr>
			<tr>
				<th>ID</th>
				<td>${e.user_id}</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td>${e.user_pw}</td>
			</tr>
		</table>
	</c:forEach>
</div>
<div class = "link">
	<a href = "/SMSystem/ChangePasswordServlet2">パスワード変更はこちら</a>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</main>
</body>
</html>