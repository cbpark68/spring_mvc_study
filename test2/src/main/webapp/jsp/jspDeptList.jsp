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
<title>deptList</title>
</head>
<body>
<button type="button" onclick="location='jspDeptWrite.do'">부서등록</button>
<table border="1">
<tr>
	<th>번호</th>
	<th>부서코드</th>
	<th>부서명</th>
	<th>위치</th>
</tr>
<c:set var="no" value="${0}"/>
<c:forEach var="dept" items="${deptList}" >
	<tr>
		<c:set var="no" value="${no+1}"/>
		<td>${no}</td>	
		<td><a href="jspDeptWrite.do?deptno=${dept.deptno}">${dept.deptno}</a></td>	
		<td>${dept.dname}</td>	
		<td>${dept.loc}</td>	
	</tr>
</c:forEach>
</table>
</body>
</html>