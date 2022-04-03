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
<title>jspPlanWrite</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
<script src="<c:url value='/' />/script/jquery-3.6.0.js"></script>
<script src="<c:url value='/' />/script/jquery-ui.js"></script>
<script>
	$(function() {
		$("#pdate").datepicker({
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			changeYear : true
		});
		$("#btn_submit").click(function() {
			document.getElementById("jspPlanVO").submit();
		});
		$("#btn_close").click(function() {
			self.close();
		});
	});
	function fn_onload(){
		document.getElementById("title").focus();
	}
</script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body onload="fn_onload();">
	<form:form method="post" action="jspPlanWriteSave.do" commandName="jspPlanVO">
	<form:hidden path="unq"/>
	<form:hidden path="crudgbn"/>
	<c:if test="${rslt == 'success' }">
		<script>
		opener.parent.location="jspPlanList.do?userid=${ssuserid}";
		//alert("${msg}");
		self.close();
		</script>
	</c:if>
		<table style="width: 100%; text-align: center;">
			<caption>일정등록${crudgbn}</caption>
			<tr>
				<th style="width: 15%;">사용자ID</th>
				<td style="width: *; text-align: left;"><form:hidden
						path="userid" /> ${jspPlanVO.userid}</td>
			</tr>
			<tr>
				<th>일자</th>
				<td style="text-align: left;"><form:input path="pdate"
						style="width:100px;" /> <form:errors path="pdate" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td style="text-align: left;"><form:input path="title"
						style="width:300px;" /> <form:errors path="title" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td style="text-align: left;"><form:textarea path="content"
						style="width:300px;height:200px;" /> <form:errors path="content" />
				</td>
			</tr>
		</table>
		<div style="text-align: center; margin-top: 10px; float: bottom;">
			<button type="button" id="btn_submit">저장</button>
			<button type="button" id="btn_close">닫기</button>
		</div>
	</form:form>
</body>
</html>