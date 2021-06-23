<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール確認 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel ="stylesheet" href ="css/changepassword.css">

</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
<div class = "wrapper">
	<h3>プロフィール確認</h3>
	<c:forEach var = "e" items = "${userProfileList}">

		<div class="intro">
			<p>氏名</p><br>
			<input type = "text" name = "user_name" value = "${e.user_name}" readonly><br>

			<p>氏名かな</p><br>
			<input type = "text" name = "user_name_kana" value = "${e.user_name_kana}" readonly><br>

			<p>企業名</p><br>
			<input type = "text" name = "user_company" value = "${e.user_company}" readonly><br>

			<p>企業名かな</p><br>
			<input type = "text" name = "user_company_kana" value = "${e.user_company_kana}" readonly><br>

			<p>血液型</p><br>
			<input type = "text" name = "user_blood" value = "${e.user_blood}" readonly><br>

			<p>文理</p><br>
			<input type = "text" name = "user_career" value = "${e.user_career}" readonly><br>

			<p>部活</p><br>
			<input type = "text" name = "user_club" value = "${e.user_club}" readonly><br>

			<p>趣味</p><br>
			<input type = "text" name = "user_hobby" value = "${e.user_hobby}" readonly><br>

			<p>自己紹介</p><br>
			<textarea class="intro" name = "user_intro"  readonly>${e.user_intro}</textarea><br>
		</div>

		<div class ="button">
			<button onclick = "location.href = '/SMSystem/Menu_StudentServlet'">メニュー</button>
		</div>

	</c:forEach>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>