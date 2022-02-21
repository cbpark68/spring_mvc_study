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
<title>codeList</title>
</head>
<style>
table {
	width: 400px;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #cccccc;
	padding: 5px;
}
</style>
<script type="text/javascript">
	function fn_delete(code) {

		if (confirm("정말 삭제하겠습니까?")) {
			location = "codeDelete.do?code=" + code;
		}
	}
	function fn_update(code){
		location = "codeModify.do?code=" + code;
	}
</script>
<body>
	<table>
		<caption>
			<div>코드리스트</div>
			<br />
			<div style="width: 100%; text-align: left;">Total : ${total} 개
			</div>
		</caption>
		<colgroup>
			<col width="10" />
			<col width="30" />
			<col width="30" />
			<col width="30" />
		</colgroup>
		<tr>
			<th>번호</th>
			<th>그룹</th>
			<th>이름</th>
			<th>구분</th>
		</tr>
		<c:set var="count" value="1" />
		<c:forEach var="list" items="${result}">
			<tr align="center">
				<td>${count }</td>
				<td>${list.gid }</td>
				<td>${list.name }</td>
				<td>
					<button type="button" onclick="fn_update('${list.code}')">수정</button>
					<button type="button" onclick="fn_delete('${list.code}')">삭제</button>
				</td>
			</tr>
			<c:set var="count" value="${count+1 }" />
		</c:forEach>
	</table>
</body>
</html>