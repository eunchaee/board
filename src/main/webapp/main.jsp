<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <title>Dashboard Template for Bootstrap</title>

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/dashboard.css" rel="stylesheet">
	<%@ include file="/include/commonCss.jsp" %>
	<%@ include file="/include/jQuery.jsp" %>
<script>
	$(function(){
		$('#boardList tr').click(function(){
			var board_seq=$('th:first',this).text();
			$('#board_seq').val(board_seq);
			$('#frm').submit();
		});
		$('#boardReg').click(function(){
			document.location="${pageContext.request.contextPath }/board/boardReg.jsp"
		});
		$('')
		
	})


</script>
	
	
  </head>

  <body>
    <%@ include file="/layout/header.jsp" %>
    <form id="frm" method="get" action="${pageContext.request.contextPath }/getBoard">
	<input type="hidden" id="board_seq" name="board_seq">
	<input type="hidden" id="board_seq" name="category_seq">
    
    </form>
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp"%> 
        
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">	
          <h2 class="sub-header">게시판  리스트</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>순서</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>날짜</th>
                </tr>
              </thead>
              <tbody id="boardList">
                <c:forEach items="${list }" var="vo" >
                <tr>
                  <th>${vo.board_seq }</th>
                  <th>${vo.title}</th>
                  <th>${vo.reg_id }</th>
                  <th><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd"/> </th>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <button id="boardReg" type="submit"type="button" class="btn btn-default">게시글 등록</button>
        </div>
        </div>
      </div>

  </body>
</html>
