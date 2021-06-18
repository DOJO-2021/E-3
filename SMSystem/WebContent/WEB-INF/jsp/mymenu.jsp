<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>マイメニュー</h2>
<c:forEach var="e" items= "${userInfo}">
<div id="pro" class="show">
	<div class = "profile">
	<p>名前</p>
	<h4> ${e.user_name}</h4>
	<p>企業名</p>
	<h4>${e.user_company}</h4>
	<p>クラス</p>
	<h4>${e.user_class}</h4>
	<p>ID</p>
	<h4>${e.user_id}</h4>
	<p>PASSWORD</p>
	<h4>${e.user_id}</h4>
	<a href = "/SMSystem/ChangeServlet">パスワード変更はこちら</a>
	</div>



</div>
</c:forEach>
</body>
</html>