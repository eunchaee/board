<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/jsp/js/jquery-3.3.1.min.js"></script>
<link href="/jsp/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/jsp/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/jsp/css/dashboard.css" rel="stylesheet">
<link href="blog.css" rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

$(function(){
		$('#write').click(function(){
			 
		$('#frm').submit();
		})
	
	
		
	});

</script>
<style>
	.div{ 
		padding:20px;
	}
	input{
		width:100%;
	}
	td{
		padding:2px;
	}
	textarea{
		width:100%;
		height:400px;
	}
</style>
</head>

<body>
<%@ include file="/layout/header.jsp"%>
		<div class="container-fluid">
      <div class="row">
        <%@ include file='/layout/left.jsp' %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"></h1>

            <form action="${pageContext.request.contextPath }/boardInsert "method="post" id="frm">
          		<div class="table-responsive">
	            	<!-- Table -->
					<div class="div" >
						<table width="100%" id="table">
							<tr>
								<td><input type="text" name="title" placeholder="제목을 입력해주세요"></td>
							</tr>
							<tr>
								<td><textarea name="content" placeholder="내용을 입력해주세요"></textarea></td>
							</tr>
							<tr>
								<td><input type="file" name=""></td>
							</tr>
							<tr>
								<td><input type="text" name="reg_id" placeholder="작성자를 입력해주세요"></td>
							</tr>
							<tr>
								<td><input type="text" name="category_seq" placeholder="카테고리를 입력해주세요"></td>
							</tr>
						</table>
			          <div class="right"  align="right">
			          	<button type="button" id="write">글쓰기</button>
			          </div>
					</div>
	          </div>
          </form>
        </div>
      </div>
    </div>
</body>
</html>
