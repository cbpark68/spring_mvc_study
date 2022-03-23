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
<title>Insert title here</title>
</head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body>
	<div id="wapper">
		<header>
			<c:import url="jspBoardHeader.jsp"/>
		</header>
		<nav>
			<c:import url="jspBoardTopMenu.jsp"/>
		</nav>
		<section>
			<form:form method="post" action="jspMemberWriteSave2.do"
				commandName="jspMemberVO2">
				<table style="width:100%;text-align:center;">
					<caption>회원등록</caption>
					<tr>
						<th style="width:15%;">사용자ID</th>
						<td style="width:*;text-align:left;"><form:input path="userid" style="width:100px;" />
							<form:errors path="userid" /></td>
					</tr>
					<tr>
						<th>암호</th>
						<td style="text-align:left;"><form:password path="pass" style="width:100px;" />
							<form:errors path="pass" /></td>
					</tr>
					<tr>
						<th>이름</th>
						<td style="text-align:left;"><form:input path="name" style="width:100px;" />
							<form:errors path="name" /></td>
					</tr>
					<tr>
						<th>생일</th>
						<td style="text-align:left;"><form:input path="birthday" style="width:100px;" />
							<form:errors path="birthday" /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td style="text-align:left;">
							<form:radiobutton path="gender" value="M" label="남자" />
							<form:radiobutton path="gender" value="F" label="여자" />
							<form:errors path="gender" /></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td style="text-align:left;"><form:input path="mobile" style="width:100px;" />
							<form:errors path="mobile" /></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td style="text-align:left;"><form:input path="zipcode" style="width:50px;" />
							<form:errors path="zipcode" /></td>
					</tr>
					<tr>
						<th>주소</th>
						<td style="text-align:left;"><form:input path="addr" style="width:400px;" />
							<form:errors path="addr" /></td>
					</tr>
				</table>
				<div style="text-align:center;margin-top:10px;float:bottom;">
					<button type="submit">저장</button>	
					<button type="reset">취소</button>
				</div>
			</form:form>
		</section>
		<aside>
			<c:import url="jspBoardLeftMenu.jsp"/>
		</aside>
		<footer>
			<c:import url="jspBoardFooter.jsp"/>
		</footer>
	</div>

</body>
</html>