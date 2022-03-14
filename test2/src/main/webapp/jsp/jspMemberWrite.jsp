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
			<div style="background-color: pink; text-align: center;">
				<h2>친구등록</h2>
			</div>
			<div>
				<form:form method="post" action="jspMemberWriteSave.do"
					commandName="jspMemberVO">
					<table border="1" width="600px" align="center">
						<tr>
							<th>회원번호</th>
							<td class="input_td"><form:input path="member_no" value="${member_no}" /></td>
						</tr>
						<tr>
							<th>회원ID</th>
							<td class="input_td"><form:input path="member_id" value="${member_id}" /></td>
						</tr>
						<tr>
							<th>이름</th>
							<td class="input_td"><form:input path="member_name" value="${member_name}" /></td>
						</tr>
						<tr>
							<th>등급</th>
							<td class="input_td"><form:select path="member_grade">
									<form:option value="특별회원" />
									<form:option value="우수회원" />
									<form:option value="일반회원" />
								</form:select></td>
						</tr>
						<tr>
							<th>취미</th>
							<td class="input_td">
							<form:radiobutton path="member_hobby" value="독서" label="독서" />
							<form:radiobutton path="member_hobby" value="운동" label="운동" />
							<form:radiobutton path="member_hobby" value="영화" label="영화" />
							</td>
						</tr>
						<tr>
							<th>등록일자</th>
							<td class="input_td"><form:input path="member_date" value="${member_date}" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</section>
		<footer> 쿠팡주식회사 Copyright@2022 </footer>
	</div>
</body>
</html>