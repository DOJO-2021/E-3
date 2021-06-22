<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/time.css">

</head>
<body>
<br>
<div class ="wrapper">
<section class = "timeex">

<span id ="time"></span>


<script>

'use stirct';
const now = new Date();
const year = now.getFullYear();
const month = now.getMonth();
const date = now.getDate();
const output = `\${year}/\${month + 1}/\${date}`;
document.getElementById('time').textContent = output;

//時間帯で画像を切り替える
var myimg = new Array();
myimg[0] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[1] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[2] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[3] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[4] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[5] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[6] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[7] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[8] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[9] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[10] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[11] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[12] = 'src="img/gohan.png" alt="14時" width="44px" height="44px"';
myimg[13] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[14] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[15] = 'src="img/syusya.png" alt="15時" width="44px" height="44px"';
myimg[16] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[17] = 'src="img/syusya.png" alt="14時" width="44px" height="44px"';
myimg[18] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[19] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[20] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[21] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[22] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
myimg[23] = 'src="img/ie.png" alt="14時" width="44px" height="44px"';
var mynow = new Date();
var myhour = mynow.getHours();
document.write("<img "+myimg[myhour]+">");</script>
</section>
</div>
<footer>

</footer>
</body>
</html>