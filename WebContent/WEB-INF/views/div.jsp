<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
div.sido{
	border : solid hotpink;
	width : 190px;
	text-align : center;
	font-size : 20px;
	float : left;
	margin-left : 10px;
}
div.gugun{
	border : solid ;
	width : 150px;
	text-align : center;
	font-size : 15px;
	float : left;
	margin-left : 10px;
}
div.selected{
	background-color:pink;
	color : white;
} 
</style>
</head>
<body>
<div class="sido selected">전체</div>
<c:forEach items="${sidoList}" var="sido" varStatus="idx">
	<div class="sido" 
	
	onclick="selectSido(this)" data-sido="${sido}">
 	<c:if test="${fn:contains(sido,'충청') || fn:contains(sido,'경상') ||
 		fn:contains(sido,'전라')}">
 		${fn:substring(sido,0,1)}${fn:substring(sido,2,3)}
 	</c:if>
 	<c:if test="${!fn:contains(sido,'충청') && !fn:contains(sido,'경상') &&
 		!fn:contains(sido,'전라')}">
 		${fn:substring(sido,0,2)}
 	</c:if>
 	</div>
		<c:if test="${idx.count==8}">
		<br>
	</c:if>
</c:forEach>
<div class="gugun">전체</div>
<c:forEach items="${gugunList}" var="gugun" varStatus="idx">
	<div class="gugun" onclick="selectGugun(this)" data-gugun="${gugun}">
		${fn:substring(gugun,0,2)}
	</div>
	<c:if test="${idx.count%8==0}">
		<br>
	</c:if>
</c:forEach>
-- --
${dongList }
-- --
</div>
<script>
	function selectSido(sidoObj){
		var sido = sidoObj.getAttribute('data-sido');
		location.href='/div?sido='+sido;
	}
	function selectGugun(gugunObj){
		
		var gugun = gugunObj.getAttribute('data-gugun');
		location.href='/div?sido='+sido+'&gugun='+gugun;
	}
</script>
</body>
</html>