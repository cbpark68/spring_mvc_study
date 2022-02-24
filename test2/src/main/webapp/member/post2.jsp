<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>post2</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#btn_send").click(function() {
			var addr = $("#address").val();
			var addr_array = addr.split(" ");
			var zipcode = addr_array[0].substring(1,addr_array[0].length-1);
			var address = addr.replace(addr_array[0],"");
			address = $.trim(address);
			opener.document.frm.zipcode.value = zipcode;
			opener.document.frm.address.value = address;
			self.close();
		});
 	});
</script>
</head>
<body>
	<div style="width: 100%; text-align: center;">
		<select name="address" id="address">
			<c:forEach var="i" items="${result}">
				<option value="${i.adrs}">${i.adrs}</option>
			</c:forEach>
		</select> <br /> <br />
		<button type="button" id="btn_send">적용하기</button>
	</div>
</body>
</html>