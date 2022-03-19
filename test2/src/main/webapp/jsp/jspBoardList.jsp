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
<title>jspBoardList</title>
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
				<table style="width:100%;text-align:center;">
					<caption>게시물조회</caption>
					<thead>
					<tr>
						<th>번호</th>	
						<th>제목</th>	
						<th>작성자</th>	
						<th>조회수</th>	
						<th>작성일</th>	
					</tr>
					</thead>
					<tbody>
					<c:forEach var="list" items="${list}">
						<tr>
							<td>${list.unq}</td>	
							<td><a href="jspBoardInfo.do?crudgbn=update&unq=${list.unq}">${list.title}</a></td>	
							<td>${list.name}</td>	
							<td>${list.hits}</td>	
							<td>${list.rdate}</td>	
						</tr>	
					</c:forEach>
					</tbody>
				</table>
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