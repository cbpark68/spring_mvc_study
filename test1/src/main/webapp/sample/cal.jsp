<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cal</title>
</head>
<body>
<%
Calendar cal = Calendar.getInstance();
int y = cal.get(Calendar.YEAR);
int m = cal.get(Calendar.MONTH);
int d = cal.get(Calendar.DATE);
%>
<%=y %> 년 <%=m+1 %> 월 <%=d %> 일
</body>
</html>