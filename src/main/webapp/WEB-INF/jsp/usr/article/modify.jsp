<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="ARTICLE MODIFY"></c:set>
<%@ include file="../common/head.jspf"%>

<form action="../article/doModify" method="POST">
			<table class="login-box table-box-1" border="1">
				<tbody>
					<tr>
						<th>수정 게시물 번호</th>
						<td>{article.id}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input autocomplete="off" type="text" placeholder="제목를 입력해주세요" name="title" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><input autocomplete="off" type="text" placeholder="비밀번호를 입력해주세요" name="body" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="수정" /></td>
					</tr>
				</tbody>
			</table>
		</form>

<div class="btns">
	<button><a href="../article/doModify?id=${article.id }">수정</a></button>

</div>