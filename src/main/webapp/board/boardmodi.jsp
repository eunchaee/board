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
		$('#modify').click(function(){
			 
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

            <form action="${pageContext.request.contextPath }/modifyBoard "method="post" id="frm">
           <input type="hidden" id="board_seq" name="board_seq" value="${vo.board_seq}"> 
           <input type="hidden" id="board_seq"  value="${vo.title}"> 
           <input type="hidden" id="board_seq"  value="${vo.content}"> 
           <input type="hidden" id="reg_id"  value="${vo.reg_id}"> 
           
          		<div class="table-responsive">
	            	<!-- Table -->
					<div class="div" >
						<table width="100%" id="table">
							<tr>
								<td><input type="text" name="title" placeholder="수정할 제목을 입력해주세요"
								 value="${vo.title }"></td>
							</tr>
							<tr>
								<td><textarea name="content" placeholder="수정할 내용을 입력해주세요" ></textarea></td>
								<td><input type="hidden" name="title" 
								 value="${vo.content }"></td>
							</tr>
						</table>
			          <div class="right"  align="right">
			          	<button type="button" id="modify">수정하기</button>
			          </div>
					</div>
	          </div>
          </form>
        </div>
      </div>
    </div>
</body>
</html>
