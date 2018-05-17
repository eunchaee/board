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

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath } /bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
	<%@ include file="/include/jQuery.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		
		
		
		
		$('#signinbtn').click(function(){
			$('#frm').submit();
		})
		
	})
			
		
	
	
	



</script>
</head>
<body>
 <div class="container">

      <form id="frm" class="form-signin" action="<%=request.getContextPath() %>/loginServlet2" method="post">
        <h2 class="form-signin-heading">로그인 화면</h2>
        
        <label for="userId" class="sr-only">Email address</label>
        <input type="text" id="mem_id" name="mem_id" class="form-control" placeholder="아이디를 입력 해 주세요." required autofocus>
     
        <label for="password"  class="sr-only" >Password</label>
        <input type="password" id="mem_pass" name="mem_pass" class="form-control" placeholder="비밀번호를 입력하세요." required>
        <button id="signinbtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> 
</body>
</html>