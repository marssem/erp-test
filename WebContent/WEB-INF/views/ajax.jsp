<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
//ajax
function getAjax(){
var xhr = new XMLHttpRequest();
alert(xhr.readyState);//휴대폰 전원을 킴
xhr.open('GET','/ajax'); //get방식.
alert(xhr.readyState); //번호를 누름
xhr.onreadystatechange = function(){
	if(xhr.readyState==4){
		alert(xhr.responseText);
		var sidos = JSON.parse(xhr.responseText);
		var html = '';
		for(var i=0;i<sido.length;i++){
			html += '<div class="sido">';
			html += sidos[i].substring(0,2);
			html += '</div>';
		}
	}
}
xhr.send();
}
</script>
<button onclick="getAjax()">클릭미</button>
</body>
</html>