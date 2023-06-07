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
		<ul class="banner">
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
			<li><a href="#">마이페이지</a></li>
			<li><a href ="#">결제내역조회</a></li>
			<li><a href="#">사이트맵</a></li>
		</ul>
		<h1 class="title">관리자 - 공지사항</h1>
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
					<a href="#" class="btn">등록완료</a>
					<a href="#" class="btn">다시쓰기</a>
					<a href="admin_notice_list.do" class="btn">리스트</a>
					<a href="http://localhost:9000/ktx/notice/notice_content.do" class="btn">관리자홈</a>
					</div>
				</td>				
			</tr>
		</table>
	</form>
	</div>
</body>
</html>