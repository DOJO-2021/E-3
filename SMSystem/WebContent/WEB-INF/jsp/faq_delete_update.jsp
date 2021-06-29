<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ編集 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class="wrapper">
<h3>${genre}に関するFAQ一覧(全${count}件)(${current_pager}/${count_maxpager}ページ)</h3>
<c:forEach var="e" items="${faqList}">
	<form method="POST" action="/SMSystem/Faq_Delete_UpdateServlet">
		<input type="hidden" name="question_id" value="${e.question_id}">

		<div class="question">
			<p><span class="under">質問</span></p>
			<textarea class="textQuestion" name="question">${e.question}</textarea>
		</div>

		<div class="answer">
			<p><span class="under">回答</span></p>
			<textarea class="textAnswer" name="answer">${e.answer}</textarea>
		</div>

		<div class="button">
			<input type="submit" name="SUBMIT" value="登録">
			<input type="submit" name="SUBMIT" value="削除">
		</div>
	</form>
</c:forEach>

<br>
	 	<div class="pager">
		<a href="/SMSystem/Faq_Delete_UpdateServlet?page=small">${pagerSmall}</a>
		<a href="/SMSystem/Faq_Delete_UpdateServlet?page=1">${pager1}</a>
		<a href="/SMSystem/Faq_Delete_UpdateServlet?page=2">${pager2}</a>
		<a href="/SMSystem/Faq_Delete_UpdateServlet?page=3">${pager3}</a>
		<a href="/SMSystem/Faq_Delete_UpdateServlet?page=big">${pagerBig}</a>
		</div>
<br>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
</body>
</html>