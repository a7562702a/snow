<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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

</head>
<body >
<div class="banner-section">
		<div class="container">
			<div class="banner-heder">
				<h3><font color="blue">难以忘记初次见你</font><span>长白山</span></h3>
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
								<h1><a href="yuyue.jsp?Gidx=${google }">Booking Ticket &nbsp;<font size="3pt">TEL : +8615104426410</font> </a></h1>
							</div>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						  <ul class="nav navbar-nav cl-effect-11">
							<li class="active"><a href="index.jsp" data-hover="Home" >Home </a></li>
							<li><a href="glist.tis" data-hover="Board" >Board</a></li>
							
							<li><a href="qa.jsp" data-hover="Q&A"  >Q&A</a></li>
<!-- 							<li><a href="loginAjax.jsp" data-hover="Login"  >Login</a></li> -->
<!-- 							</li> -->

                            <c:choose>
							<c:when test="${google == null||google == ''}">
							<li><a href="#"  data-toggle="modal" data-target="#myModal1" data-hover="Member">Member</a></li>
<!-- 							<li><a href="#" data-hover="Member"  >Member</a></li> -->
							<li><a href="loginAjax.jsp" data-hover="Login"  >Login</a></li>
							<li><a href="Input_user.html" data-hover="Join"  >Join </a>
							</c:when>
							<c:otherwise >
							<li>
							<a href="udetail.tis?Gidx=${google}"  data-toggle="modal" data-target="#myModal1" data-hover="Member">Member</a>
							</li>
							<li><a href='yylist.tis?Gidx=${google }'><font color='orange'>예약상황</font></a></li>&nbsp;&nbsp;
							<li><form action="loginout.tis" >
							     <font color=#cc33cc size="5pt">★${google }님 ★</font>&nbsp;&nbsp;
							     <input type="submit"  value="Goodbye">
							     </form>
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
	
	<div class="promotions">
				<div class="container">
					<h2 class="tittle">最好的长白山</h2>
					<a href="glist.tis"><span>see more</span></a>
					<div class="promotion-grids">
						<div class="col-md-6 promation-grid">
							<a href="glist.tis"><img src="images/cbchun.jpg" class="img-responsive" alt=""/></a>
							<div class="prom-text">
								<h4>春</h4>
								<div class="prom-bottom">
									<div class="prom-left">
										<h5> 大峡谷 </h5>
									</div>
									<div class="prom-right">
									<h5>  ￥100  </h5>
									</div>
									<div class="clearfix"></div>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ut efficitur ante. Donec dapibus dictum scelerisque. Maecenas semper erat et justo porta auctor nec lobortis elit.</p>
							</div>
						</div>
						
						<div class="col-md-6 promation-grid">
							<a href="glist.tis"><img src="images/cbxia.jpg" height="700px" class="img-responsive" alt=""/></a>
							<div class="prom-text">
								<h4>夏</h4>
								<div class="prom-bottom">
									<div class="prom-left">
										<h5> 绿潭 </h5>
									</div>
									<div class="prom-right">
									<h5>  ￥80 </h5>
									</div>
									<div class="clearfix"></div>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ut efficitur ante. Donec dapibus dictum scelerisque. Maecenas semper erat et justo porta auctor nec lobortis elit.</p>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="promotion-grids">
						
						<div class="col-md-6 promation-grid">
							<a href="glist.tis"><img src="images/cbqiu1.jpg" class="img-responsive" alt=""/></a>
							<div class="prom-text">
								<h4>秋</h4>
								<div class="prom-bottom">
									<div class="prom-left">
										<h5>  大峡谷 </h5>
									</div>
									<div class="prom-right">
									<h5>  ￥90  </h5>
									</div>
									<div class="clearfix"></div>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ut efficitur ante. Donec dapibus dictum scelerisque. Maecenas semper erat et justo porta auctor nec lobortis elit.</p>
							</div>
						</div>
						<div class="col-md-6 promation-grid">
							<a href="glist.tis"><img src="images/cbdong.jpg" class="img-responsive" alt=""/></a>
							<div class="prom-text">
								<h4>冬</h4>
								<div class="prom-bottom">
									<div class="prom-left">
										<h5> 冬季天池 </h5>
									</div>
									<div class="prom-right">
									<h5>  ￥200  </h5>
									</div>
									<div class="clearfix"></div>
								</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ut efficitur ante. Donec dapibus dictum scelerisque. Maecenas semper erat et justo porta auctor nec lobortis elit.</p>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		
			
		<!--footer-->
			<div class="copy-section">
				<div class="container">
					<div class="footer-top">
						<p>Copyright &copy; 2020.Company BJ All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
					</div>
				</div>
			</div>
			
		<!-- detail -->	
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body">
							<div class="news-gr">
							<img src="images/deer.jpg" class="img-responsive"/>
							<h3 class="tittle1">
							<input type="button" onclick='location.href="loginAjax.jsp"' value="Login First">
							</h3>
								
							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>