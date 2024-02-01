<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ARTICLE DETAIL</title>
</head>
<body>
	<h1>게시물 상세보기</h1>

	<hr />

	<table border="1">

		<thead>
			<tr>
				<th>번호</th>
				<th>날짜</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>

		<tr>
			<td>${article.id }</td>
			<td>${article.regDate.substring(0,10) }</td>
			<td>${article.nickname }</td>
			<td>${article.title }</td>
			<td>${article.body }</td>
		</tr>


	</table>
</body>
</html>