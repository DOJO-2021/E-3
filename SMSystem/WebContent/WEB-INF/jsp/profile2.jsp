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
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<div class = "wrapper">
	<h3>プロフィール確認</h3>
	<c:forEach var = "e" items = "${userProfileList}">

		<div class="intro">
			<p><span class="item">氏名</span></p>
			<input type = "text" name = "user_name" value = "${e.user_name}" readonly><br>

			<p><span class="item">氏名かな</span></p>
			<input type = "text" name = "user_name_kana" value = "${e.user_name_kana}" readonly><br>

			<p><span class="item">企業名</span></p>
			<input type = "text" name = "user_company" value = "${e.user_company}" readonly><br>

			<p><span class="item">企業名かな</span></p>
			<input type = "text" name = "user_company_kana" value = "${e.user_company_kana}" readonly><br>

			<p><span class="item">血液型</span></p>
			<input type = "text" name = "user_blood" value = "${e.user_blood}" readonly><br>

			<p><span class="item">文理</span></p>
			<input type = "text" name = "user_career" value = "${e.user_career}" readonly><br>

			<p><span class="item">部活</span></p>
			<input type = "text" name = "user_club" value = "${e.user_club}" readonly><br>

			<p><span class="item">趣味</span></p>
			<input type = "text" name = "user_hobby" value = "${e.user_hobby}" readonly><br>
		</div>

		<div class="intro2">
			<p><span class="item">自己紹介</span></p>
			<textarea name = "user_intro"  readonly>${e.user_intro}</textarea><br>
		</div>



		<div class ="button">
			<button onclick = "location.href = '/SMSystem/Menu_TeacherServlet'">メニュー</button>
		</div>

	</c:forEach>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>