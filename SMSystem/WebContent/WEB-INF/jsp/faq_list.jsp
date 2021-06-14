<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ一覧 | SMSystem</title>
</head>
<body>

<form method="POST" action="/SMSystem/Faq_ListServlet">
  <select name="genre">
    <option value="drill">ドリル</option>
    <option value="html">HTML</option>
    <option value="css">CSS</option>
    <option value="js">JavaScript</option>
    <option value="java">Java</option>
    <option value="db">データベース</option>
    <option value="servlet_jsp">サーブレット＆JSP</option>
    <option value="bc">名刺管理アプリ</option>
    <option value="other">その他</option>
  </select>

  <input type="submit" name="submit" value="検索">

</form>
</body>
</html>