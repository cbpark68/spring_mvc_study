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
<title>jspMemberList</title>
</head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspIndex.css'/>" />
<body>
	<div>
		<header>
			<h1>친구관리</h1>
		</header>
		<nav>
			<%@ include file="jspIndexTopMenu.jsp"%>
		</nav>
		<section>
			<div style="background-color: pink; text-align: center;">
				<h2>친구조회</h2>
			</div>
			<div align="center">
				<table>
					<tr>
						<th>회원번호</th>
						<th>회원ID</th>		
						<th>이름</th>		
						<th>등급</th>		
						<th>취미</th>		
						<th>등록일자</th>		
					</tr>	
					<c:forEach var="list" items="${list}">
					<tr>
 						<td><a href="jspMemberWrite.do?crudgbn=update&member_no=${list.memberNo}" style="color:blue" >${list.memberNo}</a></td>
						<td>${list.memberId}</td>
						<td>${list.memberName}</td>
						<td>${list.memberGrade}</td>
						<td>${list.memberHobby}</td>
						<td>${list.memberDate}</td>
					</tr>
					</c:forEach>
				</table>	
			</div>
		</section>
		<footer> 쿠팡주식회사 Copyright@2022 </footer>
	</div>
</body>
</html>