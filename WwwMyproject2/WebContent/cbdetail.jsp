<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ include file="top.jsp" %>     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link rel="stylesheet" href="css/chocolat.css" type="text/css">

<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="Vide" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---->
<script src="js/bootstrap.min.js"></script>
<!---->
<link href='http://fonts.googleapis.com/css?family=Questrial' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800italic,800,700italic,700,600italic,600,400italic,300italic,300' rel='stylesheet' type='text/css'>
<script src="js/jquery.chocolat.js"></script>
		<!--lightboxfiles-->
		<script type="text/javascript">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
<!--script-->
<!--startsmothscrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

<script src="js/modernizr.custom.97074.js"></script>
<style>
 #a{color:orange;}
 #b{color:white;}
</style>
</head>
<body>
<div class="promotions">
 <table width='700' border='1' cellspacing='0' cellpadding=5 align="center">
  <tr align="center">
    <td colspan="2" id="a"> [${dto.sabun}님] 상세데이터 출력 </td>
  </tr>
  
  <tr>
  	<td rowspan="5"  align="center" width=300> 
  	  <img src="./storage/${dto.file }" height=200 width=300> 
  	</td>
  	<td id="b"> 지역 : ${dto.name}  </td>
  </tr>
  
  <tr id="b"> <td> 계절 :  ${dto.seasons} </td>  </tr>
  <tr id="b"> <td> 날짜 :  ${dto.wdate} </td>  </tr>
  <tr id="b"> <td> 급여(￥) :  ${dto.pay} </td>  </tr>
  <tr id="b"> <td> 소개:  ${dto.content} </td>  </tr>
  
  <tr align="center">
  	<td colspan="2">  
  		<a href="cbwriter.jsp">[등록]</a>
  		<a href="glist.tis">[전체출력]</a>
  		<a href="gdelete.tis?idx=${dto.sabun}">[삭제]</a>
  		<a href="gpreedit.tis?idx=${dto.sabun}">[수정]</a>
  	</td>
  </tr>
</table> 
 </div>
 	<p>	
 	<jsp:include page="cb_reply.jsp" />
 		
<%--  	<jsp:param value="${dto.sabun}" name="Gidx"/> --%>

</body>
</html>