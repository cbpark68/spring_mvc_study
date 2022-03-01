<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Random" %>
<%!public int multi(int a, int b) {
		int result = a * b;
		return result;
	}

	public int plus(int a, int b) {
		int result = a + b;
		return result;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsptest</title>
</head>
<style>
body {
	font-size: 9pt;
}

table {
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	width: 30px;
	text-align: center;
}
</style>
<body>
	<%
		out.println("JSP 시작");
	%><br />
	<%="게시판만들기<br/>"%>
	<%="MYSQL연동하기"%><br />
	<%
		String title = "java";
	int year = 2020;
	out.println(title + "<br/>");
	out.println(year + "<br/>");
	%>
	<%=title%>
	<br />
	<%=year%>
	<br />
	<%
		for (int i = 0; i < 10; i++) {
		out.println(i + " ");
	}
	%>
	<br />
	<%
		for (int i = 0; i < 10; i++) {
	%>
	<a href="test.jsp?page="><%=i%></a>
	<%
}
%>
	<br />
	<table>
		<tr>
			<%
				for (int i = 0; i < 10; i++) {
				out.print("<td>" + i + "</td>");
			}
			%>
		</tr>
	</table>
	<table>
		<tr>
			<%
				for (int i = 0; i < 10; i++) {
			%>
			<td><%=i%></td>
			<%
				}
			%>
		</tr>
	</table>
	<br />
	<table>
		<tr>

			<%
				int count = 0;
			for (int i = 1; i <= 31; i++) {
				count++;
				out.print("<td>" + i + "</td>");
				if (count == 7) {
					out.print("</tr><tr>");
					count = 0;
				}
			}
			while (count < 7) {
				count++;
				out.print("<td></td>");
			}
			%>
		</tr>
	</table>
	<br />
	<select name="year">
		<%
			String str = "";
		for (int y = 1940; y < 2022; y++) {
			if (y == 2000) {
				str = "selected";
			} else {
				str = "";
			}
		%>
		<option value="<%=y%>" <%=str%>><%=y%>년
		</option>
		<%
			}
		%>
	</select>
	<br />
	<%=multi(10, 5)%><br />
	<%=plus(10, 5)%><br />
	<%
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
	%>
	<%=y %> 년 <%=m %> 월 <%=d %> 일<br/>
	<%
	Random r = new Random();
	out.print(r.nextInt(10)+"<br/>");
	Random r1 = new Random();
	for(int i=0;i<10;i++){
		int nm=r1.nextInt(10);
		out.print(i+" : "+nm+"<br/>");
		if(nm==7)break;
	}
	%>
	<%
	String address = "12345 경기도 광명시 하안동    ";
	address = address.trim();	
	String[] array = address.split(" ");
	String zipcode = array[0];
	String address2 = address.replace(zipcode,"")	;
	address2 = address2.trim();
	int result = address.indexOf("대구");
	%>
	길이 : <%=address.length() %><br/>
	우편번호 : <%=zipcode %><br/>
	주소 : <%=address2 %><br/>
	<%
	if(result<0){
		out.print("존재하지 않음.");
	}else{
		out.print("존재함.");
	}
	%>
	<br/>
	<a href="jsptest2.do?eng=90&kor=80&mth=70">성적전송</a>
	<br/>	
	<%
	for(int pg=1;pg<=5;pg++){
	%>
	<a href="jsptest2.do?pg=<%=pg%>"><%=pg%></a>
	<%
	}
	%>
	<br/>	
	<a href="jsptest2.do?id=park&pass=1234&nm=박철범">회원전송</a>
	<br/>
	<form name="frm" method="post" action="jsptest2.do">
	이름 : <input type="text" name="nm"/><br/>
	비번 : <input type="password" name="pass"/><br/>		
	<button type="submit">회원전송</button>	
	</form>
</body>
</html>