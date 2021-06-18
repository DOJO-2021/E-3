<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel = "stylesheet" href = "css/menu.css">
</head>
<body>


<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<main>
<div class = "wrapper">

	<form method = "POST" action = "/SMSystem/Menu_TeacherServlet">
		<p class="text">クラスを入力してください
		<input type = "text" name = "user_class" placeholder = "A～E">
		<input type = "submit" name = "search" value = "検索"></p>
	</form>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</div>
</main>
<script>
'use stirct';

const now = new Date();
const year = now.getFullYear();
const month = now.getMonth();
const date = now.getDate();
const hour = now.getHours();
const min = now.getMinutes();

const output = `\${year}/\${month + 1}/\${date} \${hour}:\${min}`;
document.getElementById('time').textContent = output;
</script>
</body>

</html>