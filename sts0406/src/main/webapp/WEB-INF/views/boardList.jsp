<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[boardList.jsp]</title>
   <style type="text/css">
    *{font-size: 18pt; font-weight: bold; }
    a{text-decoration:none;font-size: 18pt; font-weight: bold;   color:blue ;}
    a:hover{font-size: 20pt; font-weight: bold;   text-decoration:underline; color:green ;  }
  </style>
  
	<script type="text/javascript">	
	  function clearText(){
		document.myform.keyword.value="";
		document.myform.keyword.focus();
	  }
	</script>

</head>
<body>
   <font color=blue>[boardList.jsp]</font> <br>
     
  <table width=1000 border=1  cellspacing=0>
     <tr align="right">
       <td colspan="4"> 레코드갯수: ${Gtotal}/${GGtotal} &nbsp; </td>
     </tr>
     
     <tr bgcolor=yellow height="55"> 
         <td>행번호</td>  <td>이 름</td>  <td>제 목</td> <td>이미지</td>
     </tr>
      
  	<c:forEach var="dto" items="${LG}">
  	  <tr>
  	    <td> ${dto.rn} </td>
  	    <td> ${dto.name} </td>
  	    <td> <a href="boardDetail.do?idx=${dto.hobby_idx}"> ${dto.title}</a><c:if test="${dto.rcnt>0}"> <font style="color:red;font-size:16pt"> [${dto.rcnt}] </font> </c:if> </td>
  	    
  	    <td> <img src="${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}"  width=100 height=50 border="0"> </td>
  	 </tr> 
  	</c:forEach>  
  	<!-- page -->
  	<tr align="center">
  	<td colspan="5">
  	 <c:if test="${startpage>10 }"><a href="boardList.do?pageNum=1">[First page]</a></c:if>
  	 <c:if test="${startpage>10 }"><a href="boardList.do?pageNum=${startpage-10 }${returnpage}">[이전]</a></c:if>
  	 <c:forEach var="i" begin="${ startpage}" end="${endpage}" step="1">
  	 <c:choose>
  	 <c:when test="${i==pageNUM }"><font style='color:red;font-size:26pt'>[${i }]</font></c:when>
  	 <c:otherwise><a href="boardList.do?pageNum=${i }${returnpage}">[${i }]</a></c:otherwise>
  	 </c:choose>
  	 </c:forEach>
  	 <c:if test="${endpage<pagecount }"><a href="boardList.do?pageNum=${startpage+10 }${returnpage}">[다음]</a></c:if>
  	 <c:if test="${endpage<pagecount }"><a href="boardList.do?pageNum=${pagecount }${returnpage}">[Last page]</a></c:if>
     	
  	 </td>
  </tr>
  <!-- search -->
  <tr align="center">
  	<td colspan="5">
  	  <form name="myform">
  	  	  검색 :     
  	  	 <select name="keyfield" onchange="clearText();">  
  	  	 	<option value="">-----선택하세요----- </option>
  	  	 	<option value="name" <c:if test="${skey eq 'name'}">selected</c:if>> 이름필드 </option>
  	  	 	<option value="title" <c:if test="${skey eq 'title'}">selected</c:if>> 제목필드 </option>
  	  	 	<option value=""> 내용필드 </option>
  	  	 	<option value=""> 전체출력 </option>
  	  	 </select>
  	  	 <input type="text" name="keyword" size=10 value="${sval }">
  	  	 <input type="submit" value="검색">
  	  </form>
  	</td>
  </tr>  
  </table>

 <p>
  <a href="index.jsp">[index.jsp]</a>
  <a href="board.do">[boardwrite]</a>
  <a href="boardList.do">[boardlist]</a>
  <a href="login.do">[Login]</a>
  <a href="logout.do">[LogOut]</a>
</body>
</html>




