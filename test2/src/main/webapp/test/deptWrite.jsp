<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deptWrite</title>
</head>
<style>
table{
	width:400px;
	border-collapse:collapse;
}
th,td{
	border:1px solid #cccccc;
	padding:5px;
}
</style>
<body>
	<c:set var="kor" value="90"/>
	<c:set var="eng" value="80"/>
	<c:set var="hap" value="${kor + eng}"/>
	<c:set var="str" value="abcjavajdefghijklmn"/>
	국어점수 : ${kor}<br/>
	영어점수 : ${eng}<br/>
	합계1 :${kor}+${eng}<br/>
	합계2 :${kor + eng}</br>
	합계 : ${hap} <br/>
	문자열길이 : ${fn:length(str)}</br>
	치환 : ${fn:replace(str,"java","oracle")}<br/>
	범위설정 : ${fn:substring(str,0,3)}<br/>
	<c:set var="foo" value="3.7"/>
	foo = <c:out value="${foo}"/> <br/>
	floor = ${foo - (foo%1) } <br/>
	ceil = ${foo + (1 - (foo%1))} <br/>
	round = ${(foo+0.5)-((foo+0.5)%1) }<br/>
	<c:if var="result" test="${kor >= 90}">
		국어점수는 수<br/>
	</c:if>
	<c:if var="result" test="${kor < 90 && kor >= 80}">
		국어점수는 우<br/>
	</c:if>
	<c:set var="title" value="java"/>
	<c:if test="${title == 'java'}">
		같음<br/>	
	</c:if>
	<c:forEach var="i" begin="1" end="10">
		<c:out value="${i}"/>
	</c:forEach>
	<br/>
	<form name="frm" method="post" action="">
		<table>
			<tr>
				<th>부서번호</th>
				<td><input type="text" name="deptno" /></td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td><input type="text" name="dname" /></td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td><input type="text" name="loc" /></td>
			</tr>
			<tr>
				<th colspan="2"><button type="submit">저장</button></th>
			</tr>
		</table>
	</form>
</body>
</html>