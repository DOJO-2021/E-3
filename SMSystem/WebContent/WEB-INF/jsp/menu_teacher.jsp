<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/menu.css">

<title>メニュー | SMSystem</title>
</head>
<body>


<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<main>
<div class = "wrapper">

	<form method = "POST" action = "/SMSystem/Menu_TeacherServlet">
		<p class="text">クラスを入力してください
		<input type = "text" name = "user_class" placeholder = "A～E">
		<input type = "submit" name = "search" value = "検索"></p>
	</form>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</div>
</main>

</body>

</html>