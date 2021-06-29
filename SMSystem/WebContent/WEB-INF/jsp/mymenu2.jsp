<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイメニュー | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/changepassword.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class="wrapper">
	<h3>マイメニュー</h3>
	<div class="mymenu">
		<form method="GET" action="/SMSystem/ChangePasswordServlet2">
		<c:forEach var="e" items="${userInfo}">

			<p><span class="item">名前</span></p>
			<input type="text" name="user_name" value="${e.user_name}" readonly><br>

			<p><span class="item">企業名</span></p>
			<input type="text" name="user_company" value="${e.user_company}" readonly><br>

			<p><span class="item">クラス</span></p>
			<input type="text" name="user_class" value="${e.user_class}" readonly><br>

			<p><span class="item">ID</span></p>
			<input type="text" name="user_id" value="${e.user_id}" readonly><br>

			<p><span class="item">パスワード</span></p>
			<input type="text" name="user_pw" value="${e.user_pw}" readonly><br>

		</c:forEach>
		<div class="button">
			<input type="submit" name="toChange" value="PW変更">
		</div>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>