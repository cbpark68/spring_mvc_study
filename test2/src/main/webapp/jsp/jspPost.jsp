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
<title>POST</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/jquery-ui.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
<script src="<c:url value='/' />/script/jquery-3.6.0.js"></script>
<script src="<c:url value='/' />/script/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body>
주소: <input type="text" id="dong"/> <button type="button" id="btn_search">검색</button>
<p id="result"></p>
<script>
	$(function() {
		$("#btn_search").click(function() {
			var dong = document.getElementById("dong").value;
			$.ajax({
				url : "jspPostSearch.do",
				data : "dong="+dong,
				type : "POST",
				datatype : "json",
				success : function(data) {
					//let str = JSON.stringify(data); // <> parse()
					//alert(str); 
 					$.each(data.list,function(index,item){
						$("#result").append(item.postno+" ");
						$("#result").append(item.addr+"<br/>");
					});
				},
				error : function() {
					alert("오류가 발생했습니다.")
				}
			});
		});
	});
</script>
</body>
</html>