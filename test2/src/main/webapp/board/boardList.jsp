<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<style>
body {
	font-size: 9pt;
}

button {
	font-size: 9pt;
}

table {
	width: 600px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	padding: 3px;
}

.input1 {
	width: 98%;
}

.textarea {
	width: 98%;
	height: 70px;
}
</style>
<body>
	<table>
		<tr>
			<th width="15%">번호</th>
			<th width="40%">제목</th>
			<th width="15%">글쓴이</th>
			<th width="15%">등록일</th>
			<th width="15%">조회수</th>
		</tr>
		<c:set var="cnt" value="1"/>
		<c:forEach var="list" items="${result}">
		<tr>
			<td>${cnt}</td>
			<td>${list.title}</td>
			<td>${list.name}</td>
			<td>${list.rdate}</td>
			<td>${list.hits}</td>
		</tr>
		<c:set var="cnt" value="${cnt+1}"/>
		</c:forEach>
	</table>
	<div style="width:600px; margin-top:5px; text-align:right;">
		<button type="button" onclick="location='boardWrite.do'">글쓰기</button>	
	</div>
</body>
</html>