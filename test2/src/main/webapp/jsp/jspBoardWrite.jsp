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
<title>jspBoardWrite</title>
</head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<script>
function fn_delete(){
	var unq = document.getElementById("unq").value;
	if(confirm(unq+"번 게시물을 삭제하겠습니까?")){
		document.getElementById("crudgbn").value = "delete";
		document.getElementById("jspBoardVO").submit();
	}
}
</script>
<body>
	<div id="wapper">
		<header>
			<c:import url="jspBoardHeader.jsp"/>
		</header>
		<nav>
			<c:import url="jspBoardTopMenu.jsp"/>
		</nav>
		<section>
			<form:form method="post" action="jspBoardWriteSave.do"
				commandName="jspBoardVO">
 				<form:hidden path="crudgbn" value="${jspBoardVO.crudgbn}" />
				<form:hidden path="unq" value="${jspBoardVO.unq}" />
				<table style="width:100%;text-align:center;">
					<caption>게시물작성(${jspBoardVO.crudgbn})</caption>
					<tr>
						<th style="width:15%;">제목</th>
						<td style="width:*;text-align:left;"><form:input path="title" style="width:300px;" />
							<form:errors path="title" /></td>
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
						<th>내용</th>
						<td style="text-align:left;"><form:textarea path="content"
								style="margin-top:3px;width:400px;height:100px;" /><br/>
							<form:errors path="content" /></td>
					</tr>
				</table>
				<div style="text-align:center;margin-top:10px;float:bottom;">
					<button type="submit">저장</button>	
					<button type="reset">취소</button>
					<button type="button" onclick="location='jspBoardList.do'">게시판</button>
					<button type="button" onclick="fn_delete();return false;">삭제</button>
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