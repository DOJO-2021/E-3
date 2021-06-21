<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel = "stylesheet" href = "css/menu2.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_teacher.jsp" />
<main>
<div class = "wrapper">
<section>
<p class="time"><span id ="time"></span></p>
</section>
<h2 class="pageTitle">メニュー</h2>
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

//時間帯で画像を切り替える
var myimg = new Array();

myimg[0] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[1] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[2] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[3] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[4] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[5] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[6] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[7] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[8] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[9] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[10] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[11] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[12] = 'src="img/gohan.png" alt="14時" width="64px" height="64px"';
myimg[13] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[14] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[15] = 'src="img/syusya.png" alt="15時" width="64px" height="64px"';
myimg[16] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[17] = 'src="img/syusya.png" alt="14時" width="64px" height="64px"';
myimg[18] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[19] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[20] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[21] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[22] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';
myimg[23] = 'src="img/ie.png" alt="14時" width="64px" height="64px"';

var mynow = new Date();
var myhour = mynow.getHours();
document.write("<p><img "+myimg[myhour]+"></p>");
</script>
</body>

</html>