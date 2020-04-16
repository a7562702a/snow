<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/InputJS_user.js"></script>
<title> [openSbSave1.jsp]</title></head>
<body>
 <c:choose>
 <c:when test="${total>0 }">
 <script type="text/javascript">
	 	alert(${data} + " 사번은 이미 사용중입니다.");
	 	opener.iform.sabun.value="";
	 	self.close();
  </script>
 </c:when>
 <c:otherwise>
	 <script type="text/javascript">
	    alert(${data}+"사용가능입니다")
	 	flagS_t();
	 	self.close();
	 </script>
 </c:otherwise>
 </c:choose>
	 
 

 
</body>
</html>


















