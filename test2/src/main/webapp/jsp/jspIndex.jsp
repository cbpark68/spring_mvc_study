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
<title>jspIndex</title>
</head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/jspIndex.css'/>" />
<body>
<div>
<header>
<h1>친구관리</h1>
</header>
<nav>
<%@ include file="jspIndexTopMenu.jsp" %>
</nav>
<section>
<div style="background-color:pink;text-align:center;"><h2>친구관리 프로그램</h2></div>
<div>
<h4>회원정보,친구정보를 저장하는 데이터베이스를 구축한다.<br/>
&nbsp;프로그램 작성순서</h4>
<ol>
<li>회원정보테이블을 생성한다.</li>
<li>친구정보테이블을 생성한다.</li>
<li>회원정보 입력프로그램을 작성한다.</li>
<li>회원정보 조회/수정프로그램을 작성한다.</li>
<li>친구정보 조회프로그램을 작성한다.</li>
</ol>
</div>
</section>
<footer>
쿠팡주식회사 Copyright@2022
</footer>
</div>
</body>
</html>