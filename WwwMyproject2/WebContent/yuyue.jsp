<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> title </title>
<style type="text/css">
*{font-size:16pt;font-weight:hold;}
a{font-size:20pt;test-decoration:none;color:red;font-family:Comic Sans MS;}
a:hover{font-size:24pt;test-decoration:underline;color:green;font-family:Comic Sans MS;}
#bg{background:#007ea3;}
#LOG_IN{  
	    font-size:18pt; 
	    font-weight:bold;  
	    height:35px;
	    background:lightblue;  
	   }
</style>

<script type="text/javascript">
</script>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Display month &amp; year menus</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
  
  <script>
  $( function() {
    $( "input" ).checkboxradio();
  } );
  </script>

</head>
<body >
<c:choose>
<c:when test="${google==null||google=='' }">
<div align="center">
<font>회원등록을 부탁드립니다!!</font><br>
<img src="images/xuanchuan.gif"> <br>
<a href="loginAjax.jsp">Click here to login !!</a> <P>
<a href="index.jsp">You can also back to the Home page!! </a>
</div>
</c:when>
<c:otherwise>
<br>
<form name="myform" method="post"  action="yy.tis">
<table  width='700' border='1' cellspacing='2' cellpadding=5 align="center">
<tr align="center"><td colspan="2"><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d19949.837969069402!2d128.07448005315766!3d41.988230977939786!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x5e34aef69343d173%3A0x29f9d45614652dce!2z67Cx65GQ7IKw!5e0!3m2!1sko!2skr!4v1585808463995!5m2!1sko!2skr" width="700" height="100" frameborder="0" style="border:0;" allowfullscreen="true" aria-hidden="false" tabindex="0"></iframe></td></tr>
  <tr><td colspan="2" align="center">입장권예약</td></tr>
  
  <tr >
  <td rowspan="4" >
  <img src="./images/zhengmen.jpg" height="200px" weight="200px">
      날짜선탯: <input type="text" name="date" id="datepicker">
  </td>
  </tr>
  
  <tr><td>회원님:<input type="text" name="sabun" value="${google }" readonly></td></tr>
  <tr align="char">
  <td>
  <fieldset>
    (<label for="radio-1">9:30</label>
    <input type="radio" name="time" value="9:30" id="radio-1">)
    (<label for="radio-2">10:30</label>
    <input type="radio" name="time" value="10:30" id="radio-2">)
    (<label for="radio-3">11:30</label>
    <input type="radio" name="time" value="11:30" id="radio-3">) 
    (<label for="radio-4">12:30</label>
    <input type="radio" name="time" value="12:30" id="radio-4">)
    (<label for="radio-5">13:30</label>
    <input type="radio" name="time" value="13:30" id="radio-5">)
    (<label for="radio-6">14:30</label>
    <input type="radio" name="time" value="14:30" id="radio-6">)
    (<label for="radio-7">15:30</label>
    <input type="radio" name="time" value="15:30" id="radio-7">)
    (<label for="radio-8">16:30</label>
    <input type="radio" name="time" value="16:30" id="radio-8">)
  </fieldset>
  </td>
  </tr>
  
  <tr>
  <td>
    <fieldset>
    <font>Pay:</font><br>
    <label for="radio-1">협곡(￥200)</label>
    <input type="radio" name="pay" value="200" id="radio-1">
    <label for="radio-2">호수(￥180)</label>
    <input type="radio" name="pay" value="180" id="radio-2"><br>
    <label for="radio-3">폭포(￥122)</label>
    <input type="radio" name="pay" value="122" id="radio-3">
    <label for="radio-4">천지(￥150)</label>
    <input type="radio" name="pay" value="150" id="radio-4">
    
    </fieldset>
  </td>
  </tr>
  <tr>
  <td colspan="2" align="center">
  <input type="submit" value="확인" >
  <input type="reset"  value="취소">
  <input type="button" onclick="location.href='index.jsp'" value="Back" id="LOG_IN">
  </td>
  </tr>
  
  
</table>
</form>
</c:otherwise>
</c:choose>


</body>
</html>