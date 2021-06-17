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
<p class="title">受講者管理システム</p>
	<ul id="nav">
		<li><a href="/SMSystem/Menu_StudentServlet">メニュー</a></li>
		<li><a href="/SMSystem/Faq_ListServlet">FAQ</a></li>
		<li><a href="#">質問</a>
			<ul>
				<li><a href="/SMSystem/Question_FillinServlet">記入</a></li>
				<li><a href="/SMSystem/Question_AnswerServlet">回答</a></li>
			</ul>
		</li>
		<li><a href="/SMSystem/LogoutServlet">ログアウト</a></li>
	</ul>
</header>
</body>
</html>