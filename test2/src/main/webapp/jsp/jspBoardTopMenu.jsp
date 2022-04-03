<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div style="width: 100%; float: right;">
		<ul>
			<li class="topmenu"><a href="jspBoard.do">홈</a></li>
			<li class="topmenu"><a href="jspBoardList.do">게시판</a></li>
			<li class="topmenu"><a href="jspBoardWrite.do?crudgbn=insert">글쓰기</a></li>
			<c:if test="${empty ssuserid}">
				<li class="topmenu"><a href="jspPlanList.do">일정관리</a></li>
				<li class="topmenu"><a href="jspMemberWrite2.do?crudgbn=insert">회원가입</a></li>
				<li class="topmenu"><a href="jspMemberLogin2.do">로그인</a></li>
			</c:if>
			<c:if test="${! empty ssuserid}">
				<li class="topmenu"><a href="jspPlanList.do?userid=${ssuserid}">일정관리</a></li>
				<li class="topmenu"><a href="jspMemberWrite2.do?crudgbn=update&userid=${ssuserid}">회원정보</a></li>
				<li class="topmenu"><a href="jspMemberLogout2.do">${ssuserid}님 로그아웃</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>