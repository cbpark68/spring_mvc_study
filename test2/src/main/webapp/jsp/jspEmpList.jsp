<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator"
	uri="http://www.springmodules.org/tags/commons-validator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspEmpList</title>
</head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/test2.css'/>"/>
<body>

	<table align="center">
		<caption><spring:message code="jsp.emp" /></caption>
		<colgroup>
			<col width="10%" />
			<col width="20%" />
			<col width="20%" />
			<col width="25%" />
			<col width="25%" />
		</colgroup>
		<tr>
			<th>행번호</th>
			<th><spring:message code="jsp.emp.ename" /></th>
			<th><spring:message code="jsp.emp.job" /></th>
			<th><spring:message code="jsp.emp.hiredate" /></th>
			<th><spring:message code="jsp.emp.deptno" /></th>
		</tr>
		<c:set var="listno" value="${totcnt}"/>
		<c:forEach var="list" items="${result}">
		<tr>
			<td>${listno}</td>
			<td><a href="jspEmpWrite.do?empno=${list.empno}">${list.ename}</a></td>
			<td>${list.job}</td>
			<td>${list.hiredate}</td>
			<td>${list.deptno}</td>
		</tr>
		<c:set var="listno" value="${listno - 1}"/>
		</c:forEach>
		<tr>
			<td colspan="5">총인원 : ${totcnt}</td>	
		</tr>
	</table>
</body>
</html>