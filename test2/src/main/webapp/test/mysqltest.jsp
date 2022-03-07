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
<title>mysqltest</title>
</head>
<body>
<h1>Mysql Test</h1>
<p>test cnt : ${testcnt}</p>
<p>list</p>
<table>
<tr>
<th>순번</th><th>제목</th>
</tr>
<c:forEach var="list" items="${boardlist}">
<tr>
	<td>${list.unq}</td>
	<td>${list.title}</td>
</tr>
</c:forEach>
<tr><td>부서</td></tr>
<c:forEach var="deptList" items="${deptList}">
<tr>
	<td>${deptList.deptno}</td>
	<td>${deptList.dname}</td>
	<td>${deptList.loc}</td>
</tr>
</c:forEach>
</table>
</body>
</html>