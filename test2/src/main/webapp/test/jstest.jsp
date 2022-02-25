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
var n = prompt("숫자입력 ","0");
n = Number(n);
if(n%2 == 0 ){
	alert("짝수");
}else{
	alert("홀수");
}
 
 </script>
<body>

</body>
</html>