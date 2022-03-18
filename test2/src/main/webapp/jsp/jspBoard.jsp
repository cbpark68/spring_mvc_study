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
<link type="text/css" rel="stylesheet" href="<c:url value='/css/jspBoard.css'/>" />
<body>
	<div id="wapper">
		<header> <%@ include file="jspBoardHeader.jsp"%> </header>
		<nav> <%@ include file="jspBoardTopMenu.jsp"%> </nav>
		<section>
			<p>section</p>
		</section>
		<aside> <%@ include file="jspBoardLeftMenu.jsp"%> </aside>
		<footer> <%@ include file="jspBoardFooter.jsp"%> </footer>	
	</div>
</body>
</html>