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
<script>
function fn_title(){
document.write("____");
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
			<div>
				<table style="width:100%;text-align:center;">
					<caption>
					<div>게시물조회</div>
					<div style="margin-left:10px;float:left;font-size:12px;font-wegith:normal;">총건수 : ${totrow}</div>
					<div style="margin-right:10px;float:right;">
						<button type="button" onclick="location='jspBoardWrite.do?crudgbn=insert'">글쓰기</button>	
					</div>
					</caption>
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
							<td style="text-align:left;">
							<c:forEach var="i" begin="1" end="${list.threadlen}">
								&nbsp;&nbsp;
								<c:if test="${i == list.threadlen}">[RE]</c:if>
							</c:forEach>
							<a href="jspBoardWrite.do?crudgbn=update&unq=${list.unq}">
							${list.title}
							</a>
							</td>	
							<td>${list.name}</td>	
							<td>${list.hits}</td>	
							<td>${list.rdate}</td>	
						</tr>	
					</c:forEach>
					</tbody>
				</table>
				<div style="text-align:center;margin-top:10px;float:bottom;">
					<button type="button" onclick="location='jspBoardList.do?reqpgno=${1}'">처음</button>	
					<button type="button" onclick="location='jspBoardList.do?reqpgno=${reqpgno-1}'">이전</button>	
					<button type="button" onclick="location='jspBoardList.do?reqpgno=${reqpgno+1}'">다음</button>	
					<button type="button" onclick="location='jspBoardList.do?reqpgno=${lastpgno}'">마지막</button>	
				</div>
				</div>
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