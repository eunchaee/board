<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>게시판</title>
    <link href="/jsp/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="/jsp/css/dashboard.css" rel="stylesheet">
	<%@ include file="/include/commonCss.jsp" %>
<%@ include file="/include/jQuery.jsp" %>
</head>
<script>

	$(function(){
		$('#deleteBoard').click(function(){
			$('#form').attr("action","${pageContext.request.contextPath }/deleteBoard");
			$('#form').attr("method","get");
			$('#form').submit();
			
			
		});
	
		$('#modifyBoard').click(function(){
			$('#form').attr("action","${pageContext.request.contextPath }/modifyBoard");
			$('#form').attr("method","get");
			$('#form').submit();
		});
	});
	
</script>
<body>

  <%@ include file="/layout/header.jsp" %>
   <input type="hidden" id="board_seq" name="board_seq" value="${board_seq}">
  
	<div class="row">
		<%@ include file="/layout/left.jsp"%>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="table-responsive">
				<h2>글 상세정보</h2>
				<div class="container-fluid">
					<div class="row">

						<div class="col-sm-3 col-md-2 sidebar">
							<ul class="nav nav-sidebar">
								<li class="active"><a href="#">Main <span
										class="sr-only">(current)</span></a></li>
								<li class="active"><a href="#">게시판</a></li>
							</ul>
						</div>
						<div
							class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


							<form id="form" class="form-horizontal" role="form" method="post">
								<input type="hidden" name="board_seq" value="${vo.board_seq }">
								<div class="form-group">
									<label for="boardSeq" class="col-sm-2 control-label">
										</label>
									
								</div>
<br><br>
								<div class="form-group">
									<label for="title" class="col-sm-3 control-label" >제목 :
										</label>
									<div class="col-sm-3">
										<label class="control-label" >${vo.title }</label>
									</div>
									<input type="hidden" name="title" value="${vo.title }">
								</div>
<br><br>
								<div class="form-group">
									<label for="content" class="col-sm-3 control-label">내용 :
										</label>
									<div class="col-sm-3">
										<label class="control-label" >${vo.content}</label>
										<input type="hidden" name="content" value="${vo.content }">
									</div>
								</div>
								<br><br>
								<div class="form-group">
									<label for="regId" class="col-sm-3 control-label">작성자 :
										</label>
									<div class="col-sm-3">
										<label class="control-label" >${vo.reg_id}</label>
										<input type="hidden" name="reg_id" value="${vo.reg_id }">
									</div>
								</div>
							<br><br><br>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button id="modifyBoard" type="button" class="btn btn-default">게시글
											수정</button>
										<button id="deleteBoard" type="button" class="btn btn-default">게시글
											삭제</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>