<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ編集 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/faq_list_t.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<form method = "POST" action = "/SMSystem/Faq_EditServlet" id = form-genre>
<br>
<div class = "wrapper">
<h3>FAQ検索</h3>
<p class = "genre">

<select name = "genre">
	<option value = "">ジャンルを選択してください</option>
	<option value = "0">ドリル</option>
	<option value = "1">HTML</option>
	<option value = "2">CSS</option>
	<option value = "3">JavaScript</option>
	<option value = "4">Java</option>
	<option value = "5">データベース</option>
	<option value = "6">サーブレット＆JSP</option>
	<option value = "7">名刺管理アプリ</option>
	<option value = "8">その他</option>
</select>
<input type = "submit" name = "search" value = "検索">

</p>
</div>
</form>


<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>
