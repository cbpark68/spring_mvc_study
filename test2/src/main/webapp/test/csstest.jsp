<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>csstest</title>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/css/egovframework/sample2.css'/>" /> --%>
</head>
<style>
/* body{
	font-size:20px;
	color:#555555;
	font-family:돋움;
	font-style:italic;
	font-weight:bold;
}
td{
	font-size:12px;
	color:blue;
	line-height:0.8;
}
.java{
color:pink;
font-size:30px;
}
.script{
color:blue;
font-size:50px;
}
#aa{
color:ff00ff;
}
*/
/* body {
	font-size: 12px;
	color: #666666;
	font-weight: normal;
	font-style: normal;
	line-height: 1.6;
}

.div1 {
	background-color: pink;
	width: 100px;
	height: 30px;
	padding: 10px;
	margin: 10px 20px 30px 40px;
	background-image: url("<c:url value='/images/egovframework/example/th_bg.gif'/>");
	border-top: 5px dotted blue;
	border-bottom: 5px solid red;
}

.div2 {
	background-color: gray;
	width: 100px;
	height: 50px;
	padding-left: 10px;
	margin-top: 30px;
}*/
/* div.test{
	position:sticky;
	top:30px;
	left:30px;
	width:300px;
	border:3px solid blue;
}
 */
/* 
body {
	font-size: 12px;
	color: #282828;
	font-style: italic;
	font-weight: none;
	line-height: 1.6;
}

caption {
	font-size: 14px;
	font-weight: bold;
	padding-bottom: 10px;
}

.table1 {
	width: 100%;
	border: 1px solid blue;
	border-collapse: collapse;
}

.td1 {
	border: 1px solid blue;
	padding: 5px;
}
 */
body {
	font-size: 14px;
}

header {
	height: 50px;
	background-color: #ffcc33;
	text-align: center;
	vertical-align: middle;
	line-height:50px;
}

nav {
	height: 30px;
	background-color: #ffccff;
	text-align: center;
	line-height:30px;
}
section{
	height: 400px;
	background-color: #33cc33;
	text-align: center;
	line-height:30px;

}
footer{
	height: 30px;
	background-color: #00cccc;
	text-align: center;
	line-height:30px;

}
</style>
<body>
	<!-- <font size="6" color="red"><b>과목1</b></font><br/>
<h1>과목2</h1>
<span style="font-size:9px;">과목100</span><br/>
<span style="font-size:9pt;">과목100</span><br/>
<span style="font-size:1em;">과목100</span><br/>
<hr/>
<span style="font-syze:30px;font-weight:bold;font-style:italic;font-family:궁서체;">과목100</span><br/>
<span style="font-syze:30px;">과목100</span><br/>
<font size="5" color="#ff00ff" face="궁서"><b><i>과학100</i></b></font>
 -->
	<!-- 학습 과목<br/>
- java<br/>
- html<br/> 
<table>
<tr>
<td>대한민국<br/></td>
</tr>
</table>
<p style="text-decoration:underline;">aaaaa</p>
<span class="java">myname is java</span><br/>
<span class="script">myname is java</span><br/>
<span id="aa">myname is java</span>
 -->
	<!-- 
	CSS시작
	<div class="div1">test1</div>
	<div class="div2">test2</div>
	<table border="2">
		<tr>
			<td bgcolor="yellow">test3</td>
		</tr>
	</table>
 -->
	<!--  <p>상대적위치</p>
 <p>상대적위치</p>
<div class="test">
html css java oracle mysql
</div> 
1<br/>2<br/>3<br/> 
 <p>상대적위치</p>
 <p>상대적위치</p>
 <p>상대적위치</p>
 -->
	<%-- 	<table border="1" width="600p" cellpadding="5" cellspacing="1"
		bgcolor="#cccccc">
		<caption>게시판1</caption>
		<colgroup>
			<col width="20%" />
			<col width="50%" />
			<col width="30%" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td>1</td>
				<td>오늘의 날씨는요..</td>
				<td>20-01</td>
			</tr>
		</tbody>
	</table>
	<p />
	<p />
	<table class="table1">
		<caption>게시판2</caption>
		<colgroup>
			<col width="20%" />
			<col width="50%" />
			<col width="30%" />
		</colgroup>
		<thead>
			<tr>
				<th class="td1">번호</th>
				<th class="td1">제목</th>
				<th class="td1">날짜</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="td1">1</td>
				<td class="td1">오늘의 날씨는요..</td>
				<td class="td1">20-01</td>
			</tr>
		</tbody>
	</table>
	<p />
	<p />
 --%>
	<header> 헤더영역 </header>
	<nav>Nav영역</nav>
	<section>섹션영역</section>
	<footer> 푸터영역 </footer>
</body>
</html>