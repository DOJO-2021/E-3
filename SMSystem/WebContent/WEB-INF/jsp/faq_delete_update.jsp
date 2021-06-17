<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ編集 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel ="stylesheet" href ="css/faq_delete_update.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class = "wrapper">
<br><br><br>
<p>${ganre}に関するFAQ一覧(全${count}件)</p>
<c:forEach var = "e" items = "${faqList}">
<form method = "POST" action = "/SMSystem/Faq_Delete_UpdateServlet">

<input type = "hidden" name = "question_id" value = "${e.question_id}">
<div class = "question">
<p><span class = "under">質問</span></p>

<input type = "text" class = "textquestion" name = "question" value = "${e.question}">

</div>

<div class = "answer">
<p><span class = "under">回答</span></p>
<input type = "text" class = "textAnswer" name = "answer" value = "${e.answer}">
</div>
<input type = "submit" name ="SUBMIT" value = "登録">
<input type = "submit" name = "SUBMIT" value = "削除">

</form>
</c:forEach>
</div>
</body>
</html>