<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SMSystem | Login</title>
<link rel="stylesheet" href="/SMSystem/css/login.css">
</head>
<body>

<h1>受講者管理システム</h1>

  <form method="POST" action="">
	<img src="/SMSystem/img/id.png" width = "5%" height = "5%" alt="ID"><input type="text" name="newid"><br>
	<img src="/SMSystem/img/password.png" width = "5%" height = "5%" alt="PW"><input type="password" name="newpassword"><br>
	<input type="submit" name="regist" value="新規登録">
	<input type="submit" name="login" value="ログイン">
  </form>

</body>
</html>