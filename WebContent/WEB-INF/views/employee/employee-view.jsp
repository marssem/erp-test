<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="'/employee/employee-update" id="frm">
<input type="hidden" name="emp_no" value="${employee.emp_no}">
<table border="1">
	<tr>
		<th>직급번호</th>
		<th>${employee.emp_no}</th>
	</tr>
	<tr>
		<th>직급</th>
		<th><input type="text" name="emp_name" value="${employee.emp_name}"></th>
	</tr>
	<tr>
		<th>설명</th>
		<th><input type="text" name="emp_salary" value="${employee.emp_salary}"></th>
	</tr>
	<tr>
		<th colspan="2"><button>수정</button><button type="button" onclick="goDelete()">삭제</button></th>
	</tr>
</table>
</form>
<script>
function goDelete(){
	var formObj = document.querySelector('#frm');
	formObj.action = '/employee/employee-delete';
	formObj.submit();
}
</script>
</body>
</html>