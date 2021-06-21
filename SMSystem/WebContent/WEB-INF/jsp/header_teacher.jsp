<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/header_footer.css">
</head>
<body>
<header>
<div class="logo">
	<img src="img/title.png" alt="SMSystem" class="headerLogo">
</div>
	<ul id="nav">
		<li><a href="/SMSystem/Menu_TeacherServlet">メニュー</a></li>
		<li><a href="#">FAQ</a>
			<ul>
				<li><a href="/SMSystem/Faq_ListServlet2">一覧</a></li>
				<li><a href="/SMSystem/Faq_RegistServlet">登録</a></li>
				<li><a href="/SMSystem/Faq_EditServlet">編集</a></li>
			</ul>
		</li>
		<li><a href="/SMSystem/Question_ListServlet">質問</a></li>
		<li><a href="#">マイメニュー</a>
			<ul>
				<li><a href="/SMSystem/MyMenuServlet2">プロフィール・PW変更</a></li>
				<li><a href="/SMSystem/LogoutServlet">ログアウト</a></li>
			</ul>
		</li>
	</ul>
</header>
</body>
</html>