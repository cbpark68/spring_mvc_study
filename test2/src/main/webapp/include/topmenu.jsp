<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userid = (String)session.getAttribute("SessionUserId");
%>
	<table>
		<tr>
			<th width="25%">홈</th>
			<th width="25%"><a href="boardList.do">게시판</a></th>
 			<% if(userid == null){ %>
			<th width="25%"><a href="memberWrite.do">회원가입</a></th>
			<th width="25%"><a href="loginWrite.do">로그인</a></th>
 			<% } else { %>
			<th width="25%"><a href="memberWrite.do">회원수정</a></th>
			<th width="25%"><a href="logout.do">로그아웃</a></th>
			<% } %>
		</tr>
	</table>

</body>
</html>