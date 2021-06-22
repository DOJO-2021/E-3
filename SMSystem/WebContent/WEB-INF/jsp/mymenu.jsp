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
	<c:forEach var="e" items= "${userInfo}">


	<p>名前</p><br>
	<p class = "infomation">${e.user_name}</p><br>

	<p>企業名</p><br>
	<p class = "infomation">${e.user_company} </p><br>

	<p>クラス</p><br>
	<p class = "infomation">${e.user_class}</p><br>

	<p>ID</p><br>
	<p class = "infomation">${e.user_id}</p><br>

	<p>PASSWORD</p><br>
	<p class = "infomation">${e.user_pw} </p><br>

	</c:forEach>
	</div>
	<div class = "link">
	<a href = "/SMSystem/ChangePasswordServlet">パスワード変更はこちら</a>

	</div>
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</main>
</body>
</html>