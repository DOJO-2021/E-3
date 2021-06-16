<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ登録 | SMSystem</title>
</head>
<body>
<p>ジャンルを選択してください
<form method = "POST" action = "/SMSystem/Faq_RegistServlet">
<select name = "genre">
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
<input type = "submit" name ="regist" value = "登録">
</form>
</body>
</html>