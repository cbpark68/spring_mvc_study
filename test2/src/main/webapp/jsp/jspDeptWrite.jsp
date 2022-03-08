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
<title>deptWrite</title>
</head>
<script>
function fn_delete(deptno){
	if(confirm("삭제하시겠습니까?")){
		location='jspDeptDelete.do?deptno='+deptno;
	}
}
</script>
<body>
	<form name="frm" method="post" action="jspDeptWriteSave.do">
		<c:if test="${deptinfo.deptno != 0}">
			<c:set var="deptno" value="${deptinfo.deptno}" />
			<c:set var="rogbn" value="readonly" />
			<input type="hidden" name="crudgbn" value="update" />
		</c:if>
		<c:if test="${deptinfo.deptno == 0}">
			<c:set var="deptno" value="" />
			<c:set var="rogbn" value="" />
			<input type="hidden" name="crudgbn" value="insert" />
		</c:if>
		<table border="1" width="400">
			<tr>
				<th>부서코드</th>
				<td><input type="text" name="deptno" value="${deptno}" ${rogbn} /></td>
			</tr>
			<tr>
				<th>부서명</th>
				<td><input type="text" name="dname" value="${deptinfo.dname}" /></td>
			</tr>
			<tr>
				<th>위치</th>
				<td><input type="text" name="loc" value="${deptinfo.loc}" /></td>
			</tr>
		</table>
		<p>
			<button type="submit">저장</button>
			<button type="button" onclick="fn_delete(${deptno})">삭제</button>
		</p>
	</form>
</body>
</html>