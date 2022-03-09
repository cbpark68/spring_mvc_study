<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empWrite</title>
</head>
<validator:javascript formName="jspEmpVO" staticJavascript="false" xhtml="true" cdata="false"/>
<style>
body{
	font-size:12px;
	color:#555555;
}
a{
	text-decoration:none;
}
table{
	width:500px;
	border-collapse:collapse;
}
th,td{
	border:1px solid #cccccc;
	text-align:center;
	padding:5px;
}
td{
	text-align:left;
}
</style>
<script>
function fn_delete(empno){
	if(confirm("삭제하시겠습니까?")){
		location='jspEmpDelete.do?empno='+empno;
	}
}
</script>
<body>

	<form:form name="jspEmpVO" method="post" action="jspEmpWriteSave.do" commandName="jspEmpVO">
		<c:if test="${jspEmpVO.empno != null}">
			<c:set var="empno" value="${jspEmpVO.empno}" />
			<c:set var="sal" value="${jspEmpVO.sal}" />
			<c:set var="deptno" value="${jspEmpVO.deptno}" />
			<c:set var="rogbn" value="readonly" />
			<input type="hidden" name="crudgbn" value="update" />
		</c:if>
		<c:if test="${jspEmpVO.empno == null}">
			<c:set var="empno" value="" />
			<c:set var="sal" value="" />
			<c:set var="deptno" value="" />
			<c:set var="rogbn" value="" />
			<input type="hidden" name="crudgbn" value="insert" />
		</c:if>
		<table align="center">
			<caption style="font-size:20px;font-decoration:bold;">사원정보</caption>
			<tr>
				<th width="20%">사원번호</th>
				<td width="80%"><input type="text" name="empno" value="${empno}" ${rogbn} /><form:errors path="empno"/></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><input type="text" name="ename" value="${jspEmpVO.ename}"  /><form:errors path="ename"/></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="job" value="${jspEmpVO.job}"  /><form:errors path="job"/></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" name="sal" value="${sal}"  /></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="hiredate" value="${jspEmpVO.hiredate}"  /></td>
			</tr>
			<tr>
				<th>부서</th>
				<td><input type="text" name="deptno" value="${deptno}"  /></td>
			</tr>
		</table>
		<div style="width:100%; text-align:center; margin-top:10px">
			<button type="submit">저장</button>
			<button type="button" onclick="fn_delete(${empno})">삭제</button>
			<button type="reset">취소</button>
			<button type="button" onclick="location='jspEmpList.do'">목록</button>
		</div>
	</form:form>
</body>
</html>