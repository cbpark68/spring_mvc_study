<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deptDetail</title>
</head>
<style>
table {
	width: 400px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	padding: 5px;
}
</style>
<body>
	<table>
		<tr>
			<th>부서번호</th>
			<td>${deptVO.deptno}</td>
		</tr>
		<tr>
			<th>부서이름</th>
			<td>${deptVO.dname}</td>
		</tr>
		<tr>
			<th>부서위치</th>
			<td>${deptVO.loc}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button" onclick="location='deptModifyWrite.do?deptno=${deptVO.deptno}'">수정</button>
				<button type="button" onclick="location='deptDelete.do?deptno=${deptVO.deptno}'">삭제</button>
			</th>
		</tr>
	</table>
</body>
</html>