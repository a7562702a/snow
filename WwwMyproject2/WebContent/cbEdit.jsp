<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>


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
	<script src="./js/InputJS_board.js"></script>
</head>
<body>
    <!--  guestEdit.jsp단독실행금지  -->
	<form method="post" name="myform" action="gedit.tis" enctype="multipart/form-data">
	<div><img src="./storage/${dto.file }" ><input type="file" id="file" name="file"  onchange="handleFileSelect()"></div>
	  수정사번: <input type="text" name="sabun" value="${dto.sabun}"  readonly> <br>
	  수정지역: <input type="text" name="name"  value="${dto.name}"> <br>
	  수정계절: <input type="text" name="seasons" value="${dto.seasons}"> <br>
	  수정급여: <input type="text" name="pay"  value="${dto.pay}"> <br>
	  수정내용: <input type="text" name="content" value="${dto.content}">
	  
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="submit"  value="서브밋수정"> &nbsp;
	    <input type="reset" value="수정취소">
	</form>
	
	<p>
	<a href="index.jsp">[index]</a> 
  	<a href="cbwrite.jsp">[신규등록]</a>
  	<a href="glist.tis">[전체출력]</a>
</body>
</html>






