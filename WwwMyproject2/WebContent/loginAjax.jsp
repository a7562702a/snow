<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>[loginAjax.jsp]</title>
	<style type="text/css">
		input, b{font-size: 20pt; font-weight: bold;}
		a{text-decoration: none;font-size: 20pt; font-weight: bold;}
		a:hover{font-size:24pt;test-decoration:underline;color:green;font-family:Comic Sans MS;}
		#btnlogin{
		 font-size:26pt; font-weight: bold; 
		 background:#006699; height:120; 
		}
		
		#loading-mask{
		  display:none;
		  width:500px;
		  height:500px;
		}
		#bodyColor{background:#000066}
	</style>
	

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		
		
<script type="text/javascript"> 
 $(function( ){ 
       $('#btnlogin').click( function( ){  
			$.ajax({
			  "url"  : "login.tis" , //서블릿문서
			  "type" : "get",
			  "data" : { UID: $('#userid').val(), UPWD: $('#pwd').val( )} ,
			  "beforeSend": function( ){ 
					$('#loading-mask').show();
					$('#msgIN').empty();
					$('#loading-mask').html("<div align=center><img src='./images/loding.gif' width=500 height=250></div> ");
					$("#loading-mask").css("opacity","0.9").stop().animate({opacity:3},8000);//opacity非透明	
			  }, 
			  "success": function(data){
				setTimeout(function() {
					$('#loading-mask').fadeOut( );
					$('#msgIN').empty();
					$('#msg').html(data);
				}, 1000);
			  },
			  "error": function(err){
				     alert('로그인실패 error' + err)
				  	 $('#loading-mask').fadeOut(); 
				  }
			});
	   });
      //////////////////////////////////////////////////////////////////////////
  });
</script>
</head>
<body id="bodyColor">

<br>	
<div id="msg" align="center">

   <div id="msgIN">
	<table width="600" border="1" cellspacing="1">
	  <form name="myform" method="get">
	  <img src="./images/a4.jpg">	
		<tr>
			<td width=350> <b><font color="green">I&nbsp;&nbsp;D&nbsp;:</font> </b></td>
			<td> <input type="text" name="userid" id="userid"   placeholder="userid" value=""></td>
			
			<td rowspan=2 align="center">
			 <input type="button" id="btnlogin"  name="btnlogin" value="확인"  >
			</td>
		</tr>
		
		<tr>
			<td width=350><b><font color="#cc0066">PWD:</font> </b> </td>
			<td>
			  <input type="password"  name="pwd" id="pwd"  placeholder="password" value="">       
			</td>
		</tr>
		</form>
	</table>
	
	</div>
	<a href="Input_user.html"><font color="#FFFF99">[회원가입]</font></a>&nbsp;&nbsp;&nbsp;
	<a href="index.jsp">[Home page]</a>
	<div id="loading-mask"> </div>
</div>
	
   
   
</body>
</html>

