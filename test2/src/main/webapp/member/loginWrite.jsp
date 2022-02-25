<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginWrite</title>
</head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#btn_submit").click(function() {
			var userid = $("#userid").val();
			var pass = $("#pass").val();
			userid = $.trim(userid);
			pass = $.trim(pass);
			if (userid == "") {
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return false;
			}
			if (pass == "") {
				alert("비밀번호를 입력하세요.");
				$("#pass").focus();
				return false;
			}

			$.ajax({
				type : "POST",
				data : "userid="+userid+"&pass="+pass,
				url : "loginWriteSub.do",
				dataType : "text",
				success : function(data) {
					if (data == "ok") {
						alert(userid+"님 로그인 되었습니다.");
						location = "boardList.do";
					} else {
						alert("로그인 실패");
					}
				},
				error : function() {
					alert("오류발생");
				}
			});
		});
	});
</script>
<style>
body {
	font-size: 9pt;
	font-color: #333333;
	font-family: 맑은고딕;
}

a {
	text-decoration: none;
}

table {
	width: 600px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	padding: 3px;
	line-height: 2.0;
}

caption {
	font-size: 15pt;
	font-weight: bold;
	margin-top: 10px;
	padding-bottom: 5px;
}

.div_button {
	width: 600px;
	text-align: center;
	margin-top: 5px;
}
</style>
<body>
	<form id="frm" name="frm">
		<table>
			<caption>로그인</caption>
			<tr>
				<th><label for="userid">아이디</label></th>
				<td><input type="text" name="userid" id="userid"
					placeholder="아이디입력">
			</tr>
			<tr>
				<th><label for="pass">비밀번호</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
		</table>
		<div class="div_button">
			<button type="button" id="btn_submit">로그인</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>