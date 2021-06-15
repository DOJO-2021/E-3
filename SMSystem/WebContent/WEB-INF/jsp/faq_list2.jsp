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
  <div id="faq_table">
    <dl>
      <dt><textarea>${f.question}></textarea></dt>
      <dd><textarea>${f.answer}</textarea></dd>
    </dl>
  </div>
</c:forEach>
</main>
<p class="back"><a href="/SMSystem/Menu_StudentServlet">メニューに戻る</a></p>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</body>
</html>