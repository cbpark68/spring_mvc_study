<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	Calendar cal = Calendar.getInstance();
%>
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
<%
int y = cal.get(Calendar.YEAR);
int m = cal.get(Calendar.MONTH);
y = 2020;
m = 10;
cal.set(y, m, 1);
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
int lastday = cal.getActualMaximum(Calendar.DATE);
%>
	<table>
		<caption><%=y%>년
			<%=m+1%>월
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
			<%
				int cnt = 0;
				for (int s=1;s<dayOfWeek;s++){
					out.print("<td></td>");
					cnt++;
				}
				for (int d = 1; d <= lastday; d++) {
					cnt++;
			%>
			<td><%=d%></td>
			<%
				if (cnt%7 == 0) {
					out.print("</tr><tr>");
				}
			}
			%>
		</tr>


	</table>
</body>
</html>