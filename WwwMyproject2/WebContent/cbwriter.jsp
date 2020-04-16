<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입 력</title>

<link rel="stylesheet" type="text/css" href="../css/InputCSS.css">
</head>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./js/InputJS_board.js"></script>

<body >


	<div class="all" align="center">
		<div class="title" ><br>글쓰기</div>
		<div class="cf"><br> <font color=red> </font></div>
		<form name="iform" method="post" enctype="multipart/form-data" action="ginsert.tis" >
			<table class="table1">
			
					<tr>
					<th >登入号码</th>
					<td colspan= "2">
						<input type="text" size="10" name="sabun" value="" onkeyup="checklen(this,4)" placeholder="숫자4자리" >
						<input type="button" onclick="checkSb()" value="중복확인"> 
						<label id="sabunlabel"></label>
					</td>
				</tr>
				<tr>
					<th> 项目</th>
					<td colspan= "3"><input type="text" name="name"  value="" ></td>
				</tr>
				<tr>
				 <th> 图片</th>
				 <td colspan= "2"><input type="file" id="file" name="file" onchange="handleFileSelect()"></td>
				 <td rowspan="2">
					
				 </td>
			    </tr>
			    
			    <tr>
			    <th>金额</th>
			    <td colspan="2"><input type="text" name="pay" value="">
			    </td>
			    </tr>
				
				<tr>
					<th>季节</th>
					<td colspan= "3" >
						<input type="text" size="40" name="seasons" placeholder="제목입력하세요" maxlength="30" >
					</td>
				</tr>
				<tr>
					<th>内容介绍</th>
					<td colspan= "6">
						<textarea name="content" id="content" onkeyup="checklen(this,30)" rows="5" cols="40" ></textarea>
					</td>
				</tr>
				
			</table>
			<div id="preview" >사진미리보기</div>
			<p>
			<input type="button" value="등록" onclick="userWriterCheck()">&nbsp;&nbsp;
			<input type="reset" value="초기화">&nbsp;&nbsp;
			
			<input type="button" value="목록" onclick="location.href='glist.tis'">
		</form>
	</div>
</body>
</html>