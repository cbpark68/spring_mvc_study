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
	<select name="year">
		<c:set var="sely" value=""/>
		<c:set var="selm" value=""/>
		<c:forEach var="i" begin="${sysy - 10}" end="${sysy +  5}" step="1">
			<c:if test="${y == i}"><c:set var="sely" value="selected"/></c:if>
			<c:if test="${y != i}"><c:set var="sely" value=""/></c:if>
			<option value="${i}" ${sely}>${i}년</option>	
		</c:forEach>
	</select>
	<select name="month">
		<c:forEach var="i"	begin="1" end="12" step="1">
			<c:if test="${m+1 == i}"><c:set var="selm" value="selected"/></c:if>
			<c:if test="${m+1 != i}"><c:set var="selm" value=""/></c:if>
			<option value="${i}" ${selm}>${i}월</option>
		</c:forEach>
	</select>
 	<button type="submit">조회</button>
</form>
<body>
	<table>
		<caption>
		<button type="button" onclick="location='jspcal1.do?year=${by}&month=${bm}'">이전</button>
		${y}년${m+1}월
		<button type="button" onclick="location='jspcal1.do?year=${ny}&month=${nm}'">다음</button>
		</caption>
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
			<c:set var="cnt" value="0" />
			<c:set var="cnt2" value="0" />
			<c:forEach var="i" begin="1" end="${dayOfWeek-1}" step="1">
				<td></td>
				<c:set var="cnt" value="${cnt+1}" />
				<c:set var="cnt2" value="${cnt2+1}" />
			</c:forEach>
			<c:forEach var="d" begin="1" end="${lastday}" step="1">
				<c:set var="cnt" value="${cnt+1}" />
				<c:set var="cnt2" value="${cnt2+1}" />
				<c:set var="color" value="#555555"/>
				<c:if test="${cnt2 == 7}"> <c:set var="color" value="blue"/> </c:if>
				<c:if test="${cnt2 == 1}"> <c:set var="color" value="red"/> </c:if>
				<td style="color:${color}">${d}</td>
				<c:if test="${cnt % 7  == 0}">
					<c:set var="cnt2" value="0" />
					</tr><tr>
				</c:if>
			</c:forEach>
			<c:if test="${cnt2 > 0 }">
				<c:forEach var="j" begin="1" end="${7 - cnt2}" step="1"> <td></td> </c:forEach>
			</c:if>
		</tr>
	</table>
</body>
</html>