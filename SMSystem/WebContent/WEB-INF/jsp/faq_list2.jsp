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
<jsp:include page = "/WEB-INF/jsp/header_student.jsp" />
<div class = "wrapper">
<h3>${genre}に関するFAQ(全${count}件)(${current_pager}/${count_maxpager}ページ)</h3>
<c:forEach var = "f" items = "${faqList}">
	<div class = "question">
		<p><span class = "under">質問</span></p>
		<textarea class = "textQuestion" name = "question" readonly>${f.question}</textarea>
	</div>
	<div class = "answer">
		<p><span class = "under">回答</span></p>
		<textarea class = "textAnswer" name = "answer" readonly>${f.answer}</textarea>
	</div>
	<hr>
</c:forEach>

<br>
 	<div class="pager">
	<a href = "/SMSystem/Faq_ListServlet4?page=small">${pagerSmall}</a>
	<a href = "/SMSystem/Faq_ListServlet4?page=1">${pager1}</a>
	<a href = "/SMSystem/Faq_ListServlet4?page=2">${pager2}</a>
	<a href = "/SMSystem/Faq_ListServlet4?page=3">${pager3}</a>
	<a href = "/SMSystem/Faq_ListServlet4?page=big">${pagerBig}</a>
	</div>
<br>

	<div class = "button">
		<button onclick = "location.href = '/SMSystem/Menu_StudentServlet'">メニュー</button>
	</div>

<jsp:include page = "/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>