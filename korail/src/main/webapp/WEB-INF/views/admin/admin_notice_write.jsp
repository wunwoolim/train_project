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
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
	<div class="title-wrap">
		<jsp:include page="../header.jsp"></jsp:include>
		<h2 class="title">관리자 - 공지사항</h2>
	</div>
	<form name="form-write" action="#" method="get">
		<table class="notice_write">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="notice-title">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="80" name="notice-content"></textarea>
				</td>
			</tr>					
			<tr>
				<td colspan="2">
				<div class="button">
					<button type="button" class="btn" id="finish">등록완료</button>
					<button type="reset" class="btn" id="again">다시쓰기</button>
					<a href="http://localhost:9000/ktx/admin_notice_list.do" class="btn">리스트</a>
					<a href="#" class="btn">관리자홈</a>
					</div>
				</td>				
			</tr>
		</table>
	</form>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>