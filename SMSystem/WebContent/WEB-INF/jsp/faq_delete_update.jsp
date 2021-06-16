<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ編集 | SMSystem</title>
</head>
<body>
<p>${ganre}に関するFAQ一覧(全${count}件)</p>
<form method = "POST" action = "/SMSystem/Faq_Delete_UpdateServlete">
<c:forEach var = "e" items = "${faqList}">
<input type = "hidden" name = "question_id" value = "${e.question_id}">
<table>
<tr>
<th>質問</th>
</tr>
<tr>
<td><textarea name = "question">${e.question}</textarea></td>
</tr>

</table>
<table>
<tr>
<th>回答</th>
</tr>
<tr>
<td><textarea name = "answer">${e.answer}</textarea></td>
</tr>
</table>

<input type = "submit" name ="submit" value = "登録">
<input type = "submit" name = "submit" value = "削除">
</c:forEach>
</form>
</body>
</html>