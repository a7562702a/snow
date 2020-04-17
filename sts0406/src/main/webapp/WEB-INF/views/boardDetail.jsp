<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [boardDetail.jsp] </title>
	<style type="text/css">
	  *{ font-size: 16pt; font-weight: bold; }
	  a{ font-size: 16pt; text-decoration:none; color:blue ; font-family: Comic Sans MS; }
	  a:hover{ font-size: 18pt; text-decoration:underline; color:green ; font-family: Comic Sans MS; }
	</style>

	<script type="text/javascript">
	</script>
</head>
<body>
 	
<table width='700' border='1' cellspacing='0' cellpadding=5 align="center">
 
 
  <tr align="center">
    <td colspan="2"> [${dto.name }] 상세데이터 출력 </td>
  </tr>
  
  <tr>
  	<td rowspan="5"  align="center" width=300> 
  	  <a href="download.do?idx=${dto.img_file_name }"><img src="${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}"  width=300 height=300 border="0"></a>
  	</td>
  	<td> Hobby_idx : ${dto.hobby_idx }  </td>
  </tr>
  
  <tr> <td> Gender : ${dto.gender } </td>  </tr>
  <tr> <td> title : ${dto.title } </td>  </tr>
  <tr> <td> Content : ${dto.content }</td>  </tr>
  <tr> <td> Hobby : ${dto.hobby } </td>  </tr>
  
  <tr align="center">
  	<td colspan="2">  
  		<a href="board.do">[등록]</a>
  		<a href="boardList.do">[전체출력]</a>
  		<a href="boardDelete.do?idx=${dto.hobby_idx }">[삭제]</a>
  		<a href="boardPreEdit.do?idx=${dto.hobby_idx }">[수정]</a>
  		
  	</td>
  </tr>
</table> 
 <c:import url="/boardreply_list.do"></c:import>
</body>
</html>












