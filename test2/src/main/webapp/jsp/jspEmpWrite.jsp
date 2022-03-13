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
<title>empWrite</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#hiredate" ).datepicker({ dateFormat: 'yy-mm-dd', changeMonth: true, changeYear: true });
  } );
  </script>
</head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/test2.css'/>" />
<validator:javascript formName="jspEmpVO" staticJavascript="false"
	xhtml="true" cdata="false" />
<script>
function fn_delete(empno){
	if(confirm("삭제하시겠습니까?")){
		location='jspEmpDelete.do?empno='+empno;
	}
}
</script>
<body>
	<form:form method="post" action="jspEmpWriteSave.do"
		commandName="jspEmpVO">
		<form:hidden path="empno" value="${jspEmpVO.empno}"/>
		<form:hidden path="crudgbn" value="${jspEmpVO.crudgbn}"/>
		<table align="center">
			<caption style="font-size: 20px; font-wdith: bold;">
				<spring:message code="jsp.emp" /> 
			</caption>
			<tr><td class="input_td" colspan="5">mode : <c:out value="${jspEmpVO.crudgbn}"/></td></tr>
			<tr>
				<th width="20%"><label for="empno"><spring:message
							code="jsp.emp.empno" /></label></th>
				<td width="80%" class="input_td">
				<c:if test="${jspEmpVO.crudgbn == 'insert'}">
					<form:input path="empno" value="${jspEmpVO.empno}" />
				</c:if>
				<c:if test="${jspEmpVO.crudgbn == 'update'}">
					${jspEmpVO.empno}
				</c:if>
				<form:errors path="empno" />
				</td>
			</tr>
			<tr>
				<th><label for="ename"><spring:message
							code="jsp.emp.ename" /></label></th>
				<td class="input_td"><form:input path="ename"
						value="${jspEmpVO.ename}" />
					<form:errors path="ename" /></td>
			</tr>
			<tr>
				<th><label for="job"><spring:message code="jsp.emp.job" /></label></th>
				<td class="input_td"><form:input path="job"
						value="${jspEmpVO.job}" />
					<form:errors path="job" /></td>
			</tr>
			<tr>
				<th><label for="sal"><spring:message code="jsp.emp.sal" /></label></th>
				<td class="input_td"><form:input path="sal"
						value="${jspEmpVO.sal}" />
					<form:errors path="sal" /></td>
			</tr>
			<tr>
				<th><label for="hiredate"><spring:message
							code="jsp.emp.hiredate" /></label></th>
				<td class="input_td"><form:input id="hiredate" path="hiredate"
						value="${jspEmpVO.hiredate}" />
					<form:errors path="hiredate" /></td>
			</tr>
			<tr>
				<th><label for="deptno"><spring:message
							code="jsp.emp.deptno" /></label></th>
				<td class="input_td"><form:select path="deptno">
						<c:forEach items="${deptList}" var="deptList">
							<form:option value="${deptList.deptno}">${deptList.dname}</form:option>
						</c:forEach>
					</form:select> <form:errors path="deptno" /></td>
			</tr>
		</table>
		<div style="width: 100%; text-align: center; margin-top: 10px">
			<button type="submit">저장</button>
			<button type="button" onclick="fn_delete(${empno})">삭제</button>
			<button type="reset">취소</button>
			<button type="button" onclick="location='jspEmpList.do'">목록</button>
		</div>
	</form:form>
</body>
</html>