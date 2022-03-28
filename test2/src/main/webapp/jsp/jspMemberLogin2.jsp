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
<title>jspMemberLogin2</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
<script src="<c:url value='/' />/script/jquery-3.6.0.js"></script>
<script src="<c:url value='/' />/script/jquery-ui.js"></script>
<script>
	$(function() {
	});
</script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body onload="document.getElementById('userid').focus();">
	<div id="wapper">
		<header>
			<c:import url="jspBoardHeader.jsp" />
		</header>
		<nav>
			<c:import url="jspBoardTopMenu.jsp" />
		</nav>
		<section>
			<form:form method="post" action="jspMemberLoginProc2.do"
				commandName="jspMemberVO3">
				<table style="width: 100%; text-align: center;">
					<caption>로그인</caption>
					<tr>
						<th style="width: 15%;">사용자ID</th>
						<td style="width: *; text-align: left;"><form:input
								path="userid" style="width:100px;" />
							 <form:errors path="userid" /></td>
					</tr>
					<tr>
						<th>암호</th>
						<td style="text-align: left;"><form:password path="pass"
								style="width:100px;" /> <form:errors path="pass" /></td>
					</tr>
				</table>
				<div style="text-align: center; margin-top: 10px; float: bottom;">
					<button type="submit">로그인</button>
					<button type="reset">취소</button>
				</div>
			</form:form>
		</section>
		<aside>
			<c:import url="jspBoardLeftMenu.jsp" />
		</aside>
		<footer>
			<c:import url="jspBoardFooter.jsp" />
		</footer>
	</div>

</body>
</html>