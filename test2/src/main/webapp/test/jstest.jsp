<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	/* 	document.write("시작합니다.<br/>");
	 document.write("자바스크립트<br/>");
	 document.write("오라클<br/>");
	 alert("월컴");
	 confirm("맞나요? 맞으면 확인, 아니면 취소를 누르세요");
	 prompt("암호를 입력하세요","");
	 */
	/* var speed = 50; 
	 document.write("속도는 "+speed);
	 document.write("<br/>");
	 document.write("속도증가 "+ (speed+50));
	 document.write("<br/><br/>");
	 var subject = "oracle";
	 document.write(subject);
	 */
	/* var kor = 90;
	 var eng = 80;
	 var hap = kor + eng;
	 var avg = hap / 2 ;
	 document.write("합계 "+hap+"<br/>");
	 document.write("평균 "+avg+"<br/>");
	 document.write("나머지 "+(7%2)+"<br/>");
	 var number = 1;
	 number++;
	 ++number;
	 document.write(number+"<br/>");
	 number = number + 1;
	 number += 1;
	 document.write(number+"<br/>");
	 */
	/* var name = prompt("학생명 ","홍길동");
	 var phone = prompt(name+"님, 폰번호를 입력해주세요","010-");
	 document.write(name+"의 폰번호는 "+phone+"입니다.<br/>");
	 */
	/* var eng = prompt("영어점수 : ","0");
	 var kor = prompt("국어점수 : ","0");
	 var hap = Number(eng) + Number(kor);
	 document.write("총합은 "+hap);
	 */
	/* 	var score = prompt("점수를 입력하세요. ", "0");
	 if (score > 100 || score < 0) {
	 alert("점수 오류");
	 } else {
	 if (score < 60) {
	 alert("불합격");
	 } else {
	 alert("합격");
	 }
	 }
	 */
	/* var n = prompt("숫자입력 ","0");
	 n = Number(n);
	 if(n%2 == 0 ){
	 alert("짝수");
	 }else{
	 alert("홀수");
	 }
	 */
	 function fn_action(){
		 
		if(document.frm.userid.value == ""){
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(document.frm.pass.value == ""){
			alert("비번을 입력하세요.");
			return false;
		}
		var len = document.frm.userid.value.length;
		if(len < 4 || len > 12){
			alert("아이디의 길이를 조정하세요.");
			return false;
		}
		var len_gender = document.frm.gender.length;
		var gubun = 0;
		for(var i=0;i<len_gender;i++){
			if(document.frm.gender[i].checked == true){
				gubun = 1;	
			}
		}
		if(gubun == 0){
			alert("성별을 선택해주세요.");
			return false;
		}
		var gubun = 0;
		var len_subject = document.frm.subject.length;
		for(var i=0;i<len_subject;i++){
			if(document.frm.subject[i].checked == true){
				gubun = 1;
			}
		}
		if(gubun == 0){
			alert("과목을 선택해주세요.");
			return false;
		}
		if(document.frm.year.value == "" ||
			document.frm.month.value == "" ||
			document.frm.day.value == ""){
			alert("생년월일을 입력하세요.");
			return false;
		}
		document.frm.submit(); 
	 }
</script>
<style>
body {
	font-size: 12px;
}

table {
	width: 500px;
	border-collapse: collapse;
}

th, td {
	obrder: 1px solid #dfdfdf;
	padding: 5px;
}
</style>
<body>
	<form name="frm" method="post" action="save.do">
		<table border="0">
			<colgroup>
				<col width="30%" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userid" value=""
					style="width: 100px;" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass" value=""
					style="width: 100px;" /></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="M" />남자 <input
					type="radio" name="gender" value="F" />여자</td>
			</tr>
			<tr>
				<th>과목</th>
				<td><input type="checkbox" name="subject" value="java" />JAVA
					<input type="checkbox" name="subject" value="oracle" />ORACLE <input
					type="checkbox" name="subject" value="mysql" />MYSQL</td>
			</tr>
			<tr>
				<th>생년월일</th>	
				<td>
					<select name="year">
						<option value="">년도선택</option>
						<script>
						for(var y=1940;y<2030;y++){
							document.write("<option value='"+y+"'>"+y+"년</option>");
						}
						</script>
					</select>	
					<select name="month">
						<option value="">월선택</option>
						<script>
						for(var m=1;m<13;m++){
							document.write("<option value='"+m+"'>"+m+"월</option>");
						}
						</script>
					</select>	
					<select name="day">
						<option value="">일선택</option>
						<script>
						for(var d=1;d<32;d++){
							document.write("<option value='"+d+"'>"+d+"일</option>");
						}	
						</script>
					</select>	
				</td>
			</tr>
			<tr>
				<th colspan="2">
				<input type="button" value="저장" onclick="fn_action();" />
				<input type="reset" value="취소" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>