<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


<script type="text/javascript">	
	  function clearText(){
		document.myform.keyword.value="";
		document.myform.keyword.focus();
	  }
	  function Towriter(){
		 location.href="cbwriter.jsp";
	  }
	</script>
	<style type="text/css">
	.btn{
	  background:lightblue;
	  height:20pt;
	  font-size:10pt;
	}
	</style>
</head>
<body>

<table width=900 border=1 cellspacing=0>
 	<tr align="right">
 		<td colspan="6">
 		    레코드갯수: ${Gtotal} &nbsp; 
 		   <a href="index.jsp">[index]</a>
 		   <a href="glist.tis">[출력]</a>
 		   <a href="guestWrite.jsp">[등록]</a> &nbsp;&nbsp;
 		</td>
 	</tr>
 
 	<tr bgcolor="hotpink">
 	 <td>행번호</td> <td>사 번</td> <td>이 름</td> <td>제 목</td> <td>날 짜</td> <td>조회수</td>
 	</tr>
  <%
  //servlet ListController.java 문서 접근안하고 모델1 GuestSQL.java접급
  //ArrayList<GuestDTO> list = sql.guestselect();
  //request.getAttribute("LG",LG);
  %>
  <c:forEach var="bean" items="${LG}">
 	<tr>   
 		<td> ${bean.rn} </td>
 		<td> ${bean.sabun} </td>
 		<td> ${bean.name} </td>
 		<td> <a href="gdetail.tis?Gidx=${bean.sabun}"> ${bean.title}<font color=red style='font-size:16pt'> <c:if test="${bean.rcnt>0}"> [${bean.rcnt}] </c:if></font> </a> </td>
 		<td> ${bean.wdate} </td>
 		<td> ${bean.hit}  </td>
 	</tr>	 
  </c:forEach>
 
  <tr align="center">
  	<td colspan="6">
  	 <c:if test="${startpage>10 }"> <a href="glist.tis?pageNum=${startpage-10}${returnpage}">[이전]</a></c:if>
  	 <c:forEach var="i" begin="${startpage}" end="${endpage}">
  	  <c:choose>
  	   <c:when test="${i==pageNUM }"> <font style="color:pink, font-size:24pt">[${i}]</font> </c:when>
  	   <c:otherwise><a href="glist.tis?pageNum=${i}${returnpage}"> [${i}] </a></c:otherwise>
  	  </c:choose>
  	 </c:forEach>
  	 <c:if test="${endpage<pagecount }"> <a href="glist.tis?pageNum=${startpage+10}${returnpage}">[다음]</a></c:if>
  	
    </td>
  </tr>
  
  <tr align="center" bgcolor=hotpink>
  	<td colspan="6">
  	  <form name="myform" action="glist.tis">
  	  	  검색 :     
  	  	 <select name="keyfield" onchange="clearText();">  
  	  	 	<option value="">-----선택하세요----- </option>
  	  	 	<option value="name" <c:if test="${skey=='name'}">selected</c:if> > 이름 </option>
  	  	 	<option value="title" <c:if test="${skey=='title'}">selected</c:if> > 제목 </option>
  	  	 	<option value="">내용</option>
  	  	 	<option value="">전체출력</option>
  	  	 </select>
  	  	 <input type="text" name="keyword" value="${sval}" size=10>
  	  	 <input type="submit" value="검색">
  	  </form>
  	</td>
  </tr>
 </table>

</body>
</html>