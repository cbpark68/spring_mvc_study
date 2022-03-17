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
<link type="text/css" rel="stylesheet" href="<c:url value='/css/jspMain.css'/>" />
<body>
	<div id="wapper">
		<header> <%@ include file="jspMainHeader.jsp"%> </header>
		<nav> <%@ include file="jspMainTopMenu.jsp"%> </nav>
		<section>
			<p>section</p>
		</section>
		<aside> <%@ include file="jspMainLeftMenu.jsp"%> </aside>
		<footer> <%@ include file="jspMainFooter.jsp"%> </footer>	
	</div>
</body>
</html>