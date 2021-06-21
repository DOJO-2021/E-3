<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更 | SMSystem</title>
</head>
<body>
<c:forEach var="e" items= "${userInfo}">
<p>現パスワード</p>
<h4>${e.user_pw}</h4>

<form method = "POST" action = "/SMSystem/ChangePasswordServlet">
<input type = "hidden" name = "user_id" value = "${e.user_id}">
<p>新パスワード</p>
<input type = "text" name = "new_pw" >
<p>確認</p>
<input type = "text" name = "comfirm_pw">
<input type = "submit" name = "change" value = "変更">
</form>
</c:forEach>

</body>
</html>