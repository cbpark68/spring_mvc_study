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
<title>jspPlanList</title>
</head>
<script>
	function fn_planwrite(crud,pdte) {
		var wi = 400;
		var he = 400;
		var cw = window.screen.width / 2 - wi/2;
		var ch = window.screen.height / 2 - he;
		if(pdte == null){
			let today = new Date();   
			let year = today.getFullYear();
			let month = today.getMonth() + 1;
			let date = today.getDate();
			pdte = year+"-"+month+"-"+date;
		}
		window.open("jspPlanWrite.do?crudgbn="+crud+"&userid=${ssuserid}&pdate="+pdte,"planWrite",
				"width="+wi+",height="+he+",left=" + cw + ",top=" + ch);
	}
</script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body>
	<div id="wapper">
		<header>
			<c:import url="jspBoardHeader.jsp" />
		</header>
		<nav>
			<c:import url="jspBoardTopMenu.jsp" />
		</nav>
		<section>
			<article class="cal">
				<form name="frm" method="post" action="jspPlanList.do">
					<div style="float: left; padding: 5px;">
						<select name="year">
							<c:set var="sely" value="" />
							<c:set var="selm" value="" />
							<c:forEach var="i" begin="${sysy - 10}" end="${sysy +  5}"
								step="1">
								<c:if test="${y == i}">
									<c:set var="sely" value="selected" />
								</c:if>
								<c:if test="${y != i}">
									<c:set var="sely" value="" />
								</c:if>
								<option value="${i}" ${sely}>${i}년</option>
							</c:forEach>
						</select> <select name="month">
							<c:forEach var="i" begin="1" end="12" step="1">
								<c:if test="${m+1 == i}">
									<c:set var="selm" value="selected" />
								</c:if>
								<c:if test="${m+1 != i}">
									<c:set var="selm" value="" />
								</c:if>
								<option value="${i}" ${selm}>${i}월</option>
							</c:forEach>
						</select>
						<button type="submit">조회</button>
					</div>
					<c:if test="${! empty ssuserid}">
					<div style="float: right; padding: 5px;">
						<button type="button" onclick="fn_planwrite('insert');">일정등록</button>
					</div>
					</c:if>
				</form>
				<table>
					<caption>
						<button type="button"
							onclick="location='jspPlanList.do?year=${by}&month=${bm}&userid=${ssuserid}'">이전</button>
						${y}년${m+1}월
						<button type="button"
							onclick="location='jspPlanList.do?year=${ny}&month=${nm}&userid=${ssuserid}'">다음</button>
					</caption>
					<tr>
						<th>일</th>
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>
					</tr>
					<tr>
						<c:set var="cnt" value="0" />
						<c:set var="cnt2" value="0" />
						<c:forEach var="i" begin="1" end="${dayOfWeek-1}" step="1">
							<td></td>
							<c:set var="cnt" value="${cnt+1}" />
							<c:set var="cnt2" value="${cnt2+1}" />
						</c:forEach>
						<c:forEach var="d" begin="1" end="${lastday}" step="1">
							<c:set var="cnt" value="${cnt+1}" />
							<c:set var="cnt2" value="${cnt2+1}" />
							<c:set var="color" value="#ffffff" />
							<c:if test="${cnt2 == 7}">
								<c:set var="color" value="blue" />
							</c:if>
							<c:if test="${cnt2 == 1}">
								<c:set var="color" value="red" />
							</c:if>
							<td style="color:${color};height:60px;vertical-align:top;">
								<c:if test="${m+1 < 10}">
									<c:set var="cm" value="0${m+1}"/>
								</c:if>
								<c:if test="${m+1 >= 10}">
									<c:set var="cm" value="${m+1}"/>
								</c:if>
								<c:if test="${d < 10}">
									<c:set var="cd" value="0${d}"/>
								</c:if>
								<c:if test="${d >= 10}">
									<c:set var="cd" value="${d}"/>
								</c:if>
								<c:set var="ymd" value="${y}-${cm}-${cd}"/>
								${d}
  								<c:forEach var="i" items="${userlist}">
									<c:if test="${i.pdate == ymd}">
										<br/>
										<button type="button" onclick="fn_planwrite('update','+${ymd}+');">일정</button>
									</c:if>
								</c:forEach>
							</td>
							<c:if test="${cnt % 7  == 0}">
								<c:set var="cnt2" value="0" />
								</tr>
								<tr>
							</c:if>
						</c:forEach>
						<c:if test="${cnt2 > 0 }">
							<c:forEach var="j" begin="1" end="${7 - cnt2}" step="1">
								<td></td>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</article>
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