<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestList.jsp] </title>
	<style type="text/css">
	  *{ font-size: 18pt; font-weight: bold; }
	  a{ font-size: 18pt; text-decoration:none; color:blue ; font-family: Comic Sans MS; }
	  a:hover{ font-size: 20pt; text-decoration:underline; color:green ; font-family: Comic Sans MS; }
	</style>

	<script type="text/javascript">	
	  function clearText(){
		document.myform.keyword.value="";
		document.myform.keyword.focus();
	  }
	</script>
</head>
<body>

 <table width=900 border=1 cellspacing=0>
 	<tr align="center"><td  colspan="6"><font color="blue">예약상황 </font></td></tr>
 	<tr align="right">
 		<td colspan="6" >
 		     총건수: ${Gtotal} &nbsp; 
 		</td>
 	</tr>
 
 	<tr bgcolor="hotpink">
 	 <td>No</td> <td>ID</td>  <td>Time</td> <td>Date</td> <td>Pay（￥）</td> 
 	</tr>
 
  <c:forEach var="bean" items="${LG}">
 	<tr>   
 		<td> ${bean.rn} </td>
 		<td> ${bean.sabun} </td>
 		<td> ${bean.time} </td>
<%--  		<td> <a href="gdetail.tis?Gidx=${bean.sabun}"> ${bean.title}<font color=red style='font-size:16pt'> <c:if test="${bean.rcnt>0}"> [${bean.rcnt}] </c:if></font> </a> </td> --%>
 		<td> ${bean.date} </td>
 		<td> ${bean.pay}  </td>
 	</tr>	 
  </c:forEach>
 
  <tr align="center">
  	<td colspan="6">
  	 <c:if test="${startpage>10 }"> <a href="yylist.tis?pageNum=${startpage-10}${returnpage}">[이전]</a></c:if>
  	 <c:forEach var="i" begin="${startpage}" end="${endpage}">
  	  <c:choose>
  	   <c:when test="${i==pageNUM }"> <font style="color:pink, font-size:24pt">[${i}]</font> </c:when>
  	   <c:otherwise><a href="yylist.tis?pageNum=${i}${returnpage}"> [${i}] </a></c:otherwise>
  	  </c:choose>
  	 </c:forEach>
  	 <c:if test="${endpage<pagecount }"> <a href="yylist.tis?pageNum=${startpage+10}${returnpage}">[다음]</a></c:if>
  	
    </td>
  </tr>
  
  <tr align="center" bgcolor=orange>
  	<td colspan="6">
  	  <form name="myform" action="yylist.tis">
  	  	  검색 :     
  	  	 <select name="keyfield" onchange="clearText();">  
  	  	 	<option value="">-----선택하세요----- </option>
  	  	 	<option value="time" <c:if test="${skey=='date'}">selected</c:if> > Time </option>
  	  	 	<option value="date" <c:if test="${skey=='wdate'}">selected</c:if> > Date </option>
  	  	 	
  	  	 </select>
  	  	 <input type="text" name="keyword" value="${sval}" size=10>
  	  	 <input type="submit" value="검색">
  	  	 
  	  </form>
  	</td>
  </tr>
  <tr align="right">
  <td colspan="6">
  <a href="index.jsp">[index]</a>
  <a href="yylist.tis">[출력]</a>
  </td>
  </tr>
 </table>
   
</body>
</html>











