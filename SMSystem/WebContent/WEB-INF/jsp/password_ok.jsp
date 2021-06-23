<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>パスワード変更成功！ | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<h1><span class="done">パスワードの変更に成功しました！</span></h1>
	<div class ="button">
		<button onclick = "location.href = '/SMSystem/Menu_StudentServlet'">メニュー</button>
	</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</body>
</html>