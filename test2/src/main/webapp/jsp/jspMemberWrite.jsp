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
<title>jspMemberWrite</title>
</head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspIndex.css'/>" />
<body>
	<div>
		<header>
			<h1>친구관리</h1>
		</header>
		<nav>
			<%@ include file="jspTopMenu.jsp"%>
		</nav>
		<section>
			<form:form method="post" action="jspMemberWriteSave.do"
				commandName="jspMemberVO">
				<div style="background-color: pink; text-align: center;">
					<h2>친구등록 (${jspMemberVO.crudgbn})</h2>
				</div>
				<div>
					<form:hidden path="crudgbn" value="${jspMemberVO.crudgbn}" />
					<table border="1" width="600px" align="center">
						<tr>
							<th>회원번호</th>
							<td class="input_td"><form:input path="member_no"
									value="${jspMemberVO.member_no}" /> <form:errors path="member_no" /></td>
						</tr>
						<tr>
							<th>회원ID</th>
							<td class="input_td"><form:input path="member_id"
									value="${jspMemberVO.member_id}" /> <form:errors path="member_id" /></td>
						</tr>
						<tr>
							<th>이름</th>
							<td class="input_td"><form:input path="member_name"
									value="${jspMemberVO.member_name}" /> <form:errors path="member_name" /></td>
						</tr>
						<tr>
							<th>등급</th>
							<td class="input_td"><form:select path="member_grade">
									<form:errors path="member_grade" />
									<form:option value="A" label="특별회원" />
									<form:option value="B" label="우수회원" />
									<form:option value="C" label="일반회원" />
								</form:select></td>
						</tr>
						<tr>
							<th>취미</th>
							<td class="input_td">
							<form:checkbox path="member_hobby" value="독서" label="독서" />
							<form:checkbox path="member_hobby" value="운동" label="운동" />
							<form:checkbox path="member_hobby" value="영화" label="영화" />
							<form:errors path="member_hobby" />
							</td>
						</tr>
						<tr>
							<th>등록일자</th>
							<td class="input_td"><form:input path="member_date"
									value="${jspMemberVO.member_date}" /> <form:errors path="member_date" /></td>
						</tr>
					</table>
					<br />
					<div style="text-align: center; width: 100%">
						<button type="submit">등록</button>
						&nbsp&nbsp
						<button type="button">조회</button>
					</div>
				</div>
			</form:form>
		</section>
		<footer> 쿠팡주식회사 Copyright@2022 </footer>
	</div>
</body>
</html>