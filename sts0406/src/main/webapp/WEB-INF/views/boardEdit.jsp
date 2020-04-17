<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guestEdit.jsp] </title>
	<style type="text/css">
	  *{ font-size: 20pt; font-weight: bold; }
	  a{ font-size: 24pt; text-decoration:none; color:blue ; font-family: Comic Sans MS; }
	  a:hover{ font-size: 26pt; text-decoration:underline; color:green ; font-family: Comic Sans MS; }
	</style>
</head>
<body>
<p>
<div align="center">
    <img src="${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}" height=200 width=300>  <p>
    
	   <!--  guestEdit.jsp단독실행금지  -->
	
	<form method="post" name="myform" action="boardEdit.do" enctype="multipart/form-data">
	  수정파일:<input type="file" name="upload_f" ><br>
	 Hobby_idx: <input type="text" name="hobby_idx" value="${dto.hobby_idx }" readonly ><br>
	  수정이름: <input type="text" name="name" value="${dto.name }"  > <br>
	  수정성별: <input type="text" name="gender"  value="${dto.gender }"> <br>
	  수정제목: <input type="text" name="title" value="${dto.title }"> <br>
	  수정내용: <input type="text" name="content"   value="${dto.content }"> <br>
	  수정취미: <input type="text" name="hobby"   value="${dto.hobby }"> <br>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="submit"  value="서브밋수정"> &nbsp;
	    <input type="reset" value="수정취소">
	 
	</form>
	
	<p>
	<a href="index.jsp">[index]</a> 
  	<a href="board.do">[신규등록]</a>
  	<a href="boardList.do">[전체출력]</a>
  	</div>
</body>
</html>






