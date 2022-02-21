<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardWrite</title>
<script src="/test2/script/jquery-1.12.4.js"></script>
<script src="/test2/script/jquery-ui.js"></script>
</head>
<style>
body{
	font-size:9pt;
}
button{
	font-size:9pt;
}
table{
	width:600px;
	border-collapse:collapse;
}
th,td{
	border:1px solid #cccccc;
	padding:3px;
}
.input1{
	width:98%;
}
.textarea{
	width:98%;
	height:70px; 
}
</style>
<script>
 $(function(){
	$("#title").val("제목입력");
	$("#pass").val("비번입력");
	$("#name").val("작성자입력");
});

 function fn_submit(){
	if($.trim($("#title").val())==""){
		alert("제목을 입력해 주세요.");
		$("#title").focus();
		return false;
	}
 	$("#title").val($.trim($("#title").val()));
	if($.trim($("#pass").val())==""){
		alert("비번을 입력해 주세요.");
		$("#pass").focus();
		return false;
	}
 	$("#pass").val($.trim($("#pass").val()));
 	
 	var formData = $("#frm").serialize();

 	$.ajax({
 		type:"POST",
 		data:formData,
 		url:"boardWriteSave.do",
 		dataType:"text",
 		success:function(data){
 			if(data == "ok"){
 				alert("저장완료");
 				location = "boardList.do";
 			}else{
 				alert("저장실패");
 			}
 		},
 		error:function(){
			alert("오류발생");
 		}
 	});
/* 	if(document.frm.title.value == "")	{
		alert("제목을 입력해 주세요.");
		document.frm.title.setfocus();
		return false;
	}
	if(document.frm.pass.value == ""){
		alert("비밀번호를 입력해 주세요.");
		document.frm.pass.setFocus();
		return false;
	}
 */
 }
</script>
<body>
	<form name="frm" id="frm">
		<table>
			<caption>게시판등록</caption>
			<tr>
				<th width="20%"><label for="title">제목</label></th>
				<td width="80%"><input type="text" name="title" id="title" class="input1"></td>
			</tr>
			<tr>
				<th><label for="pass">암호</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" class="textarea"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" onclick="fn_submit();return false;">저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>