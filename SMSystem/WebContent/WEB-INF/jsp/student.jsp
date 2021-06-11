<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受講者一覧 | SMSystem</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header_student.jsp" />
	<c:forEach var="e" items="${studentList}" >
	<div class = "table-menu">
		<table class = "mytable">
			 <tr>
 				<th class="n">氏名</th><th class="nk">氏名(かな)</th><th class="c">企業名</th>
			 </tr>
			 <tr>
 				<td>${e.user_name}</td><td>${e.user_name_kana}</td><td>${e.user_company}</td>
 			<tr>
 		</table>
 	</div>
</c:forEach>

</body>
</html>