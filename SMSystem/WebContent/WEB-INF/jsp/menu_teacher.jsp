<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー | SMSystem</title>
<link rel = "stylesheet" href = "css/menu.css">

</head>
<body>
<form method = "POST" action = "/SMSystem/Menu_TeacherServlet">
<p>クラスを入力してください</p>
<input type = "text" name = "class">
<input type = "submit" name = "search" value = "検索">
</form>
<div class = "table-menu">
<table>

 <tr>

 <th>氏名</th><th>氏名(かな)</th><th>企業名</th>

 </tr>

 <tr>
 <td>岡田</td><td>おかだ</td><td>日本システム</td>
 <tr>
 </table>
 </div>

<div class ="pagerCont">
    <ul class="pager">
        <li class="prev"><a href="hoge">« PREV</a></li>

        <li><a href="hoge">1</a></li>

        <li><em>2</em></li>

        <li><a href="hoge">3</a></li>

        <li><a href="hoge">4</a></li>

        <li><a href="hoge">5</a></li>

        <li class="next"><a href="hoge">NEXT »</a></li>

    </ul>

</div>

</body>
</html>