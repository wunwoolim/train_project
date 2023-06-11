<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 공지사항 글쓰기</title>
	<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/ktx/js/min.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/ktx/css/min.css">
</head>
 	<script type='text/javascript'>
 	$(document).ready(function() {
			
 		  $('#btnAgain').click(function() {
 			  
 		  });
 		});
   </script>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
	<div class="title-wrap">
		<jsp:include page="../header.jsp"></jsp:include>
		<h2 class="title">관리자 - 공지사항</h2>
	</div>
	<form name="writeForm" action="admin_notice_write_proc.do" method="post" id="form_write">
		<table class="notice_write">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="ntitle" id="notice_title">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="80" name="ncontent" id="notice_content"></textarea>
				</td>
			</tr>					
			<tr>
				<td colspan="2">
				<div class="button">
					<a id="btnSubmit" class="btn" >등록완료</a>
					<a id="btnAgain" class="btn" >다시쓰기</a>
					<a href="http://localhost:9000/ktx/admin_notice_list.do" class="btn">리스트</a>
					<a href="admin_main.do" class="btn">관리자홈</a>
					</div>
				</td>				
			</tr>
		</table>
	</form>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>