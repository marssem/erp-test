<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script >
var a; //undefined
a = null; //null
a = 1.1 //number
a = 'str' // string
a = true // boolean
a = function(){ //function
	console.log('난 이제 함수');
}
a = new Number(1) //object
var n1 = '1';
var n2 = 1;
if(n1===n2){// 값과 데이터 타입을 비교
	alert(n1+n2);
}
//구조체
//var map = new Map();
//map.set("sido","서울");
//alert(map.get("sido"));
/* var map = {
		sido : '서울',
		gugun : '강서구',
		'dong' : '가양동'
}
alert(map.sido + ','+map.gugun+','+ map.dong); */
//배열
/* var arr = ["1","2","3"]; */

var person = '{"name":"이름", "age" : 1, "address":"주소", "hobby":"취미"}';
/*
 *  키 : 이름, 나이, 주소, 취미
 *  값 :
 */
 person = JSON.parse(person);
 alert(person.name+','+person.age+','+person.address+','+person.hobby);
 
 var sum ='1'+1;
 
if(sum===11){
	 
 }else if{
	 
 }else{
	 
 }
 for(var i=0;i<10;i++){
	 
 }
 var i=1;
 while(i<10){
	 i++;
 }
 do{
	 i++
 }while(i<10);
 var strs = ["1","2","3"];
 for(var str of strs){
	 console.log('of : '+str);
 }//배열을 담음
 for(var key in strs){
	 console.log(key+'in : '+strs[key]);
 }//인덱스를 담음.
</script>
</body>
</html>