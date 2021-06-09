<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ編集 | SMSystem</title>
<link rel = "stylesheet" href = "css/pager.css">
</head>
<body>
<p>ジャンルを選択してください</p>
<form method = "Get" action = "/SMSystem/Faq_RegistServlet" id = form-genre>
<select name = "select">
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
</form>

<form method = "POST" action = "/SMSystem/Faq_EdittServlet">
<table>
<tr>
<th>質問</th>
</tr>
<tr>
<td><textarea name = "question"></textarea></td>
</tr>

</table>
<table>
<tr>
<th>回答</th>
</tr>
<tr>
<td><textarea name = "answer"></textarea></td>
</tr>
</table>
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

<input type = "submit" name ="regist" value = "登録">
<input type = "submit" name = "delete" value = "削除">
</form>
</body>
</html>
