<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ一覧 | SMSystem</title>
<link rel="stylesheet" href="/SMSystem/css/faq_list_2.css">
</head>
<body>
<h1>FAQ</h1>

<main>
<c:forEach var="f" items="${faqList}">
  <div class="question">
 	<p><span class="under">質問</span></p>
	<input type ="text" class="textquestion" name = "question" value = "${f.question}" readonly>
  </div>

  <div class="answer">
	<p><span class="under">回答</span></p>
	<input type ="text" class="textAnswer" name ="answer" value = "${f.answer}" readonly>
  </div>

</c:forEach>
</main>

		<div class ="button">
			<button onclick = "location.href = '/SMSystem/Menu_StudentServlet'">メニュー</button>
		</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>