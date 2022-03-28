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
<script>
	$(function() {
		$("#btn_select").click(function(){
			var addr = $("#result").val();
			var addr_array = addr.split(" ");
			var zipcode = addr_array[0]
			var address = addr.replace(addr_array[0],"");
			address = $.trim(address);
			opener.document.getElementById("zipcode").value = zipcode;
			opener.document.getElementById("addr").value = address;
			self.close();
		});
		$("#btn_search").click(function() {
			var dong = document.getElementById("dong").value.trim();
			$.ajax({
				url : "jspPostSearch.do",
				data : "dong="+dong,
				type : "POST",
				datatype : "json",
				success : function(data) {
					$("#result").empty();
					$("#result").append('<option value="">-- Select --</option>');
 					$.each(data.list,function(index,item){
 						var adrs = item.postno+' '+item.addr;
						$('#result').append('<option value="'+adrs+'">'+adrs+'</option>');
					});
				},
				error : function() {
					alert("오류가 발생했습니다.")
				}
			});
		});
	});
</script>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/jspBoard.css'/>" />
<body onload="document.getElementById('dong').focus();">
주소: <input type="text" id="dong"/> 
<button type="button" id="btn_search">검색</button>
<br/><br/>
<select id="result">
</select>
<br/>
<br/>
<button type="button" id="btn_select">선택</button>
</body>
</html>