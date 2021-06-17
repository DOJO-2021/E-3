<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ一覧 | SMSystem</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="/SMSystem/css/faq_list.css">
</head>
<body>

<jsp:include page="/WEB-INF/jsp/header_student.jsp"></jsp:include>
<main>
  <form method="POST" action="/SMSystem/Faq_ListServlet">
    <p class="genre">ジャンルを選択してください
    <select name="genre">
      <option value="0">ドリル</option>
      <option value="1">HTML</option>
      <option value="2">CSS</option>
      <option value="3">JavaScript</option>
      <option value="4">Java</option>
      <option value="5">データベース</option>
      <option value="6">サーブレット＆JSP</option>
      <option value="7">名刺管理アプリ</option>
      <option value="8">その他</option>
    </select>

  <input type="submit" name="genre" value="検索"></p>

  </form>

  <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</main>
</body>
</html>