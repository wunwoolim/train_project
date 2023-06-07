<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 상세 내용</title>
	<script src="http://localhost:9000/train_project/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/train_project/js/min.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/train_project/css/min.css">
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
		<h1 class="title">공지사항</h1>
	</div>
	<table class="notice_content">
		<tr>
			<th>제목</th>
			<td>KTX 공지사항 입니다.</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				2023년 5월 23일 기준 전체 시스템 점검 예정입니다.<br>
				참고해주세요.
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>1000</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td>2023-05-18</td>
		</tr>
		<tr>
			<td colspan="2">
			<div class="button">
				<a href="notice_list.jsp" class="btn">리스트</a>
				<a href="http://localhost:9000/project/notice/notice_content.jsp" class="btn">홈으로</a>
				</div>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>