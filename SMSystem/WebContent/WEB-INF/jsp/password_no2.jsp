<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>パスワード変更失敗！ | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel ="stylesheet" href ="css/profile2.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<br>
<br>
<h1>パスワードの変更に失敗しました！</h1>
		<div class ="button">
			<button onclick = "location.href = '/SMSystem/Menu_TeacherServlet'">メニュー</button>
		</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</body>
</html>
