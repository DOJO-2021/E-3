<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/changepassword.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class = "wrapper">
<h3>パスワード変更</h3>
<c:forEach var="e" items= "${userInfo}">
<p>現パスワード</p><br>
<input type = "text" name = now_pw value = "${e.user_pw}" readonly><br>

<form method = "POST" action = "/SMSystem/ChangePasswordServlet2">
<input type = "hidden" name = "user_id" value = "${e.user_id}">
<p>新パスワード</p><br>
<input type = "text" name = "new_pw"placeholder="PW(8～16字以内 大文字 小文字 数字 必須)" ><br>
<p>確認</p><br>
<input type = "text" name = "confirm_pw">
<input type = "submit" name = "change" value = "変更" placeholder="PW(8～16字以内 大文字 小文字 数字 必須)">
</form>
</c:forEach>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>