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

</head>
<body>
   <font color=blue>[boardList.jsp]</font> <br>
    
  <table width=1000 border=1  cellspacing=0>
     <tr align="right">
       <td colspan="4"> 레코드갯수: ${Gtotal} &nbsp; </td>
     </tr>
     
     <tr bgcolor=yellow height="55"> 
         <td>행번호</td>  <td>이 름</td>  <td>제 목</td> <td>이미지</td>
     </tr>
      
  	<c:forEach var="dto" items="${LG}">
  	  <tr>
  	    <td> ${dto.rn} </td>
  	    <td> ${dto.name} </td>
  	    <td> <a href="boardDetail.do?idx=${dto.hobby_idx}"> ${dto.title}</a><c:if test="${dto.rcnt>0}"> <font style="color:red;font-size:14pt"> [${dto.rcnt}] </font> </c:if> </td>
  	    
  	    <td> <img src="${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}"  width=100 height=50 border="0"> </td>
  	 </tr> 
  	</c:forEach>  
  	
  	<tr align="center">
  	<td colspan="4"> </td>
  </tr>
  
  <tr align="center">
  	<td colspan="4">
  	  <form name="myform">
  	  	  검색 :     
  	  	 <select name="keyfield" onchange="clearText();">  
  	  	 	<option value="">-----선택하세요----- </option>
  	  	 	<option value="name"> 이름필드 </option>
  	  	 	<option value="title"> 제목필드 </option>
  	  	 	<option value=""> 내용필드 </option>
  	  	 	<option value=""> 전체출력 </option>
  	  	 </select>
  	  	 <input type="text" name="keyword" size=10>
  	  	 <input type="submit" value="검색">
  	  </form>
  	</td>
  </tr>  
  </table>

 <p>
  <a href="index.jsp">[index.jsp]</a>
  <a href="board.do">[boardwrite]</a>
  <a href="boardList.do">[boardlist]</a>
</body>
</html>




