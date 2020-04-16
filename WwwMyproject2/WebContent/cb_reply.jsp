<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest_reply.jsp] </title>
	<style type="text/css">
	   *{font-size:14pt; font-family: Comic Sans MS; }
	 
	   	#LOG-IN{
		 font-size:26pt; font-weight: bold; 
		 background:#FFFF00; height:550; 
		}
		
		#btnEdit{font-size:16pt;background: #cccccc; }   
	</style>
	
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script type="text/javascript">
  
	 function replyEdit(num,writer,content ){ 
		frm.num.value=num;
		frm.writer.value=writer;
		frm.content.value=content;
		frm.bt_save.value="댓글수장";
		frm.action="greplyUpdate.tis";
	 }//end
	 
	 function replyEdit2( num,writer,content,sabun){
		 //alert(num+" "+writer+" "+content+" "+sabun);
         $("#writer"+num).html("<input type=text id='writer' value=" +writer+">");
         $("#content"+num).html("<input type=text id='content' value=" +content+">");
         $("#bt"+num).html(
        		 "<input type=button id='btnEdit' onclick=\"editSave("+num+","+sabun+")\" value='수정완료'>" +
        		  "<input type=button onclick=\"location.href='gdetail.tis?Gidx="+sabun+"'\" value='취소'>"
         );

	 }//end
	 function editSave(num,sabun){
		 var wt=$("#writer").val();
		 var ct=$("#content").val();
		 alert("editSave함수 num="+num+"&writer="+wt+"&content="+ct+"&sabun="+sabun);
		 location.href="greplyUpdate.tis?num="+num+"&writer="+wt+"&content="+ct+"&sabun="+sabun;
		 
	 }//end
  </script>
  <style>
  #b{color:#66FFcc;}
  </style>
</head>
<body>

<div class="promotions" > 
<table width="700"  border='0' cellspacing="0" align="center">
 <form  name="frm" method="get" action="greplyInsert.tis" >
    <td align="center"><font color="red">
    flag: <input type="text"  name="flag"  value="true">
 	Gidx: <input type="text"  name="sabun"  value="${rsabun }">
 	num:  <input type="text"  name="num"   value=""><br>
    
    </font> </td>
 	
 	<tr>
 	  <td id="b">작성자:
 		<input type="text"  name="writer" size=30 >
 		<input type="submit" name="bt_save" value="게시판댓글저장 "  style="height:25pt;">     
 	  </td>
 	</tr>
 	
 	<tr>
 	  <td id="b">
 		메모글: <textarea  name="content" cols="60" rows=3></textarea>
 	  </td>
 	</tr>
 </form>
</table>
  
 <p>
  <table width="700"  border='0' cellspacing="0" align="center">
   <tr   bgcolor="grey"  height='30'  align="center">
 	   <td colspan=4>MVC댓글 데이타 내용 표시 <c:if test="${Rtotal>0}">reply:${Rtotal }</c:if></td>       
   </tr>
   
  <c:forEach var="rdto" items="${rLG }" >
	  <tr id="b">
	  	 <td width=70  > ${rdto.rrn} </td>
  		 <td width=150 id="writer${rdto.num }"> ${rdto.writer } </td>
  		 <td width=150 id="content${rdto.num }"> ${rdto.content } </td>
	 	 <td width=330 align="right" id="bt${rdto.num }"> 
<%-- 	 	 <a  href="greplyDelete.tis?Gidx=${rdto.sabun }&Gnum=${rdto.num}">[댓글삭제]</a> --%>
	 	 <input type="button" onClick="location.href='greplyDelete.tis?Gidx=${rdto.sabun }&Gnum=${rdto.num}'" value="댓글삭제1">
		 <input type="button" onClick="replyEdit('${rdto.num}','${rdto.writer }','${rdto.content }')" value="댓글수정1"> 
		 <input type="button" onClick="replyEdit2('${rdto.num}','${rdto.writer }','${rdto.content }','${rdto.sabun }')" value="댓글수정2">     
	 	 </td>       
	  </tr>
  </c:forEach>

</table>	
</div> 
</body>
</html>