<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pass</title>
</head>
<script type="text/javascript">
function fn_submit(){
	document.getElementById("jspMemberVO4").submit();
	//if(confirm("창을 닫을까요?")){
	//	window.open("about:blank","_self").close();	
	//}
}
function fn_onload(){
	document.getElementById('bpass').focus();
}
</script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body onload="fn_onload();">
	<c:if test="${rslt == 'success' }">
		<script>
		alert("${msg}");
		self.close();
		</script>
	</c:if>
	<form:form method="post" action="jspMemberPassProc2.do"
		commandName="jspMemberVO4">
		<form:hidden path="userid" />
		<table style="width: 100%; text-align: center;">
			<caption>비밀번호 변경${result}</caption>
			<tr>
				<th style="width: 30%;">현재 비밀번호</th>
				<td style="width: *; text-align: left;"><form:password
						path="bpass" style="width:100px;" /> <form:errors path="bpass" />
				</td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td style="text-align: left;"><form:password path="pass"
						style="width:100px;" />
					<form:errors path="pass" /></td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td style="text-align: left;"><form:password path="apass"
						style="width:100px;" />
					<form:errors path="apass" /></td>
			</tr>
		</table>
		<br />
		<button type="button" onclick="fn_submit();return false;">비밀번호변경</button>
		<button type="button" onclick="self.close();">닫기</button>
	</form:form>
	<br />
	<br />
</body>
</html>