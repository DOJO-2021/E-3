<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ一覧 | SMSystem</title>
<link rel = "stylesheet" href = "css/common.css">
<link rel = "stylesheet" href = "css/faq_list2.css">
</head>
<body>
<jsp:include page = "/WEB-INF/jsp/header.jsp" />
<div class = "wrapper">
<h3>${genre}に関するFAQ(全${count}件)</h3>
<c:forEach var = "f" items = "${faqList}">
	<div class = "question">
		<p><span class = "under">質問</span></p>
		<input type = "text" class = "textquestion" name = "question" value = "${f.question}" readonly>
	</div>
	<div class = "answer">
		<p><span class = "under">回答</span></p>
		<input type ="text" class = "textAnswer" name = "answer" value = "${f.answer}" readonly>
	</div>
</c:forEach>

<ul class = "pagination">
	<form method = "GET" action = "/SMSystem/Faq_ListServlet3">
		<input type = "submit" name = "pager" value = "1">
		<input type = "submit" name = "pager" value = "2">
		<input type = "submit" name = "pager" value = "3">
	</form>
</ul>

	<div class ="button">
		<button onclick = "location.href = '/SMSystem/Menu_TeacherServlet'">メニュー</button>
	</div>
<jsp:include page = "/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>