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
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<main>

<div class = "wrapper">
<h3>マイメニュー</h3>


	<div class = "profile">
	<form method = "GET" action = "/SMSystem/ChangePasswordServlet">
	<c:forEach var="e" items= "${userInfo}">


	<p>名前</p><br>
	<input type = "text" name = "user_name" value = "${e.user_name}" readonly><br>

	<p>企業名</p><br>
	<input type = "text" name = "user_company" value = "${e.user_company}" readonly><br>

	<p>クラス</p><br>
	<input type = "text" name = "user_class" value = "${e.user_class}" readonly><br>

	<p>ID</p><br>
	<input type = "text" name = "user_id" value = "${e.user_id}" readonly><br>

	<p>パスワード</p><br>
	<input type = "text" name = "user_pw" value = "${e.user_pw}" readonly>

	</c:forEach>


	<input type = "submit" name = "toChange" value = "PW変更">
	</form>

	</div>
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</main>
</body>
</html>