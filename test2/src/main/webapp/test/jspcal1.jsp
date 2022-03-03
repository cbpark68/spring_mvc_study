<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cal1</title>
</head>
<style>
body {
	font-size: 9pt;
	color: #555555;
}

table {
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	width: 50px;
	height: 25px;
	text-align: center;
}

caption {
	margin-bottom: 10px;
	font-size: 15px;
}
</style>
<form name="frm" method="post" action="jspcal1.do">

	<input type="text" name="year" size="3">년
	<input type="text" name="month" size="3">월
	<button type="submit">조회</button>
</form>
<body>
	<table>
 		<caption>${y}년 ${m}월</caption>
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		<tr>
			<c:set var="cnt" value="0"/>
			<c:forEach var="i" begin="1" end="${dayOfWeek-1}" step="1">
				<td></td>	
				<c:set var="cnt" value="${cnt+1}" />
			</c:forEach>
			<c:forEach var="d" begin="1" end="${lastday}" step="1">
				<c:set var="cnt" value="${cnt+1}" />
				<td>${d}</td>	
				<c:if test="${cnt % 7  == 0}">
					</tr></td>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>