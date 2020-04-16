<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link rel="stylesheet" href="css/chocolat.css" type="text/css">

<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="Vide" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---->
<script src="js/bootstrap.min.js"></script>
<!---->
<link href='http://fonts.googleapis.com/css?family=Questrial' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,800italic,800,700italic,700,600italic,600,400italic,300italic,300' rel='stylesheet' type='text/css'>
<script src="js/jquery.chocolat.js"></script>
		<!--lightboxfiles-->
		<script type="text/javascript">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
<!--script-->
<!--startsmothscrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

<script src="js/modernizr.custom.97074.js"></script>

<script type="text/javascript">
	var xhr = null;
	var ID = "";
	var PW = "";
	function first() {
		xhr = new XMLHttpRequest();
		ID = form.sabun.value;
		PW = form.pwd.value;
		//alert(ID+" "+PW);
		if (ID == "" || PW == "" || ID == null || PW == null) {
			alert("userID,PWD공백입니다");
		} else {
			var url = "loginList1.jsp?loginID="+ID+"&loginPWD=" + PW;
			xhr.onreadystatechange = two;
			xhr.open('GET', url, true);
			xhr.send(null);
		}
		
	}//first end
	function two() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var str = xhr.responseText;
				document.getElementById("result").innerHTML = str;
			}//200 end
		}//4 end
	}//two end
	
	function myload() {
		location.href="logOut.jsp";
		/* location.reload();
		form.sabun.focus(); */
	}//end
	
	function idelete(){
		
	}
	
</script>

</head>
<body >
<%
String naver=(String)session.getAttribute("google");

%>
<div class="banner-section">
		<div class="container">
			<div class="banner-heder">
				<a href="#" ><h3><font color="blue">难以忘记初次见你</font><span>长白山</span></h3></a>
			</div>
		</div>
	</div>
    <div class="header">
		<div class="container">
			<div class="header-menu">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
						  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						  </button>
						  <div class="navbar-brand logo">
								<h1><a href="yuyue.jsp">门票咨询 &nbsp;<font size="5pt">TEL : +8615104426410</font> </a></h1>
							</div>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav cl-effect-11">
							<li class="active"><a href="index.jsp" data-hover="Home" >Home </a></li>
							<li><a href="glist.tis" data-hover="Board" >Board</a></li>
							<li><a href="userdetail.jsp"  >Info</a></li>
							<li><a href="qa.jsp" data-hover="Q&A"  >Q&A</a></li>
							
							<c:choose>
							<c:when test="${naver == null||naver == ''}">
							<li>
					        <div id="result" >
						    <form name="form" >
							userID:<input type="text" name="sabun" size=6 value="">
							PWD: <input type="text" name="pwd" size=6 value="" >
							     <input type="button" onClick="first();" value="로그인">
						    </form>
					        </div>
			                </li>
							</c:when>
							<c:otherwise >
							<li>
					        <div id="result1" >
						    <form name="form1" >
							     <font color=red>${naver }회원님의 로그인성공 ★★★</font>
							     <a  href='udetail.tis?Gidx=${naver }'><font color='orange'>나의정보</font></a>
							     <input type="button" onClick="idelete();" value="out">
						    </form>
					        </div>
			                </li>
							</c:otherwise> 
							</c:choose>
			                
							 
						 </ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			<div class="clearfix"></div>
			</div>	
		</div> 
	</div>
		<!-- 4 seasons -->
	
	
</body>
</html>