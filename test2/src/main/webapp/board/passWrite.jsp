<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>passWrite</title>
<script src="/test2/script/jquery-1.12.4.js"></script>
<script src="/test2/script/jquery-ui.js"></script>
</head>
<script>
	$(function() {
		$("#delBtn").click(function() {
			var pass = $("#pass").val();
			pass = $.trim(pass);
			if (pass == "") {
				alert("암호를 입력하세요.");
				$("#pass").focus();
				return false;
			}
			var sendData = "unq=${unq}&pass="+pass;
			$.ajax({
				type : "POST",
				data : sendData,
				url : "boardDelete.do",
				dataType : "text",
				success : function(data) {
					if (data == "1") {
						alert("삭제완료");
						location = "boardList.do";
					} else {
						alert("삭제실패");
					}
				},
				error : function() {
					alert("오류발생");
				}
			});

		});
	});
</script>
<body>
	<table>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass" id="pass" /></td>
			<td><button type="button" name="delBtn" id="delBtn">삭제</button></td>
		</tr>
	</table>
</body>
</html>