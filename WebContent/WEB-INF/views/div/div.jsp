<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.sido {
   border: solid red;
   width: 30px;
   text-align: center;
   font-size: 10px;
   float: left;
   margin-left: 2px;
}

div.selected {
   background-color: yellow;
}

div.gugun {
   border: solid blue;
   width: 30px;
   text-align: center;
   font-size: 10px;
   float: left;
   margin-left: 2px;
}

div.dong {
   border: solid green;
   width: 30px;
   text-align: center;
   font-size: 10px;
   float: left;
   margin-left: 2px;
}
</style>
</head>
<body>
   <div class="sido <c:if test="${param.sido==null}">selected </c:if>">전체</div>
   <c:forEach items="${sidoList}" var="sido">
      <div class="sido" onclick="clicksido(this)" data-value="${sido}" varStatus="idx" >
         <c:if test="${fn:contains(sido,'충청') || fn:contains(sido,'경상') || fn:contains(sido,'전라')}">
         ${fn:substring(sido,0,1)}${fn:substring(sido,2,3)}
         </c:if>
         <c:if test="${!fn:contains(sido,'충청') && !fn:contains(sido,'경상') && !fn:contains(sido,'전라')}">
         ${fn:substring(sido,0,2)}
         </c:if>
      </div>
   </c:forEach>



   <c:forEach items="${gugunList}" var="gugun" varStatus="idx">
      <div class="gugun" onclick="clickgugun(this)" data-value="${gugun}">
      ${fn:substring(gugun,0,2)}
      <c:if test="${idx.count==8}">
      <br>
      </c:if>
      </div>
   </c:forEach>

   <c:forEach items="${dongList}" var="dong">
      <div class="dong">${fn:substring(dong,0,2)}</div>
   </c:forEach>
   <script>
      function clicksido(sidoObj) {
         var sido = sidoObj.getAttribute("data-value");
         location.href = "/div?sido=" + sido;
      }
      function clickgugun(gugunObj) {
         var gugun = gugunObj.getAttribute("data-value");
         location.href = "/div?sido=${param.sido}&gugun=" + gugun;
      }
   </script>

</body>
</html>