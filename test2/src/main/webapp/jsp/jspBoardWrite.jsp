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
<title>jspMain</title>
</head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body>
	<div id="wapper">
		<header>
			<%@ include file="jspBoardHeader.jsp"%>
		</header>
		<nav>
			<%@ include file="jspBoardTopMenu.jsp"%>
		</nav>
		<section>
			<form:form method="post" action="jspBoardWriteSave.do"
				commandName="jspBoardVO">
				<table style="width:600px;">
					<caption>게시물 작성</caption>
					<colgroup>
						<col width="30%" />
						<col width="*" />
					</colgroup>
					<form:hidden path="unq" value="${jspBoardVO.unq}" />
					<tr>
						<th>제목</th>
						<td style="text-align:left;"><form:input path="title" />
							<form:errors path="title" /></td>
					</tr>
					<tr>
						<th>암호</th>
						<td style="text-align:left;"><form:input path="pass" />
							<form:errors path="pass" /></td>
					</tr>
					<tr>
						<th>이름</th>
						<td style="text-align:left;"><form:input path="name" />
							<form:errors path="name" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td style="text-align:left;"><form:textarea path="content"
								style="margin-top:3px;width:500px;height:100px;" />
							<form:errors path="content" /></td>
					</tr>
				</table>
			</form:form>
		</section>
		<aside>
			<%@ include file="jspBoardLeftMenu.jsp"%>
		</aside>
		<footer>
			<%@ include file="jspBoardFooter.jsp"%>
		</footer>
	</div>
</body>
</html>