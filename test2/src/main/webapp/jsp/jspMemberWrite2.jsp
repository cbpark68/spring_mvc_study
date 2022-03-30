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
<title>jspMemberWrite2</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
<script src="<c:url value='/' />/script/jquery-3.6.0.js"></script>
<script src="<c:url value='/' />/script/jquery-ui.js"></script>
<script>
	$(function() {
		$("#birthday").datepicker({
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			changeYear : true
		});
		$("#btn_pass").click(function(){
			var w = window.screen.width/2 - 250;
			var h = window.screen.height/2 - 150;
			var userid = document.getElementById("userid").value;
			window.open("jspMemberPass2.do?userid="+userid,"pass","width=500,height=300,left="+w+",top="+h);
		});
		$("#btn_zipcode").click(function(){
			var w = window.screen.width/2 - 250;
			var h = window.screen.height/2 - 150;
			window.open("jspPost.do","post","width=500,height=300,left="+w+",top="+h);
		});
		$("#btn_idchk").click(function() {
			var userid = document.getElementById("userid").value;
			$.ajax({
				url : "jspMemberIdChk.do",
				data : "userid="+userid,
				type : "POST",
				datatype : "json",
				success : function(obj) {
					$.each(obj,function(index,item){
						var result=item["idchk"];
						alert(result);
					});
				},
				error : function() {
					alert("오류가 발생했습니다.")
				}
			});
		});
	});
</script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body onload="document.getElementById('userid').focus();">
	<div id="wapper">
		<header>
			<c:import url="jspBoardHeader.jsp" />
		</header>
		<nav>
			<c:import url="jspBoardTopMenu.jsp" />
		</nav>
		<section>
			<form:form method="post" action="jspMemberWriteSave2.do"
				commandName="jspMemberVO2">
				<form:hidden path="crudgbn"/>
				<c:set var="crudgbn" value="${jspMemberVO2.crudgbn}"/>
				<table style="width: 100%; text-align: center;">
					<caption>회원등록${crudgbn}</caption>
					<tr>
						<th style="width: 15%;">사용자ID</th>
						<td style="width: *; text-align: left;">
						<c:if test="${crudgbn == 'insert'}">
						<form:input
								path="userid" style="width:100px;" />
							<button type="button" id="btn_idchk">중복확인</button> <form:errors
								path="userid" />
						</c:if>
						<c:if test="${crudgbn == 'update'}">
							<form:hidden path="userid"/>
							${jspMemberVO2.userid}	
						</c:if>
						</td>
					</tr>
					<tr>
						<th>암호</th>
						<td style="text-align: left;"><form:password path="pass"
								style="width:100px;" /> 
							<c:if test="${crudgbn == 'update'}">
								<button type="button" id="btn_pass">비밀번호변경</button>
							</c:if>
							<form:errors path="pass" />
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td style="text-align: left;"><form:input path="name"
								style="width:100px;" /> <form:errors path="name" /></td>
					</tr>
					<tr>
						<th>생일</th>
						<td style="text-align: left;"><form:input path="birthday"
								style="width:100px;" /> <form:errors path="birthday" /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td style="text-align: left;"><form:radiobutton path="gender"
								value="M" label="남자" /> <form:radiobutton path="gender"
								value="F" label="여자" /> <form:errors path="gender" /></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td style="text-align: left;"><form:input path="mobile"
								style="width:100px;" /> <form:errors path="mobile" /></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td style="text-align: left;"><form:input path="zipcode"
								style="width:50px;" />
							<button type="button" id="btn_zipcode">우편번호</button> <br /> <form:errors
								path="zipcode" /> <form:input path="addr" style="width:400px;" />
							<form:errors path="addr" /></td>
					</tr>
				</table>
				<div style="text-align: center; margin-top: 10px; float: bottom;">
					<button type="submit">저장</button>
					<button type="reset">취소</button>
				</div>
			</form:form>
		</section>
		<aside>
			<c:import url="jspBoardLeftMenu.jsp" />
		</aside>
		<footer>
			<c:import url="jspBoardFooter.jsp" />
		</footer>
	</div>

</body>
</html>