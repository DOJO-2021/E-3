<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/question_list.css">
<title>質問一覧｜SMSystem</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class="wrapper">
	<form method="POST" action="/SMSystem/Question_ListServlet">
		<p class="text">
		<input type="text" name="class" placeholder="A～E">
		<input type="submit" name="search" value="検索">
		</p>
	</form>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>