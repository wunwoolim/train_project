<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 상세 내용</title>
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
		<h2 class="title_station">공지사항</h2>
	</div>
	<table class="notice_content">
		<tr>
			<th>제목</th>
			<td>${noticeVo.ntitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				${noticeVo.ncontent}
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${noticeVo.nhits}</td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td>${noticeVo.ndate}</td>
		</tr>
		<tr>
			<td colspan="2">
			<div class="button">
				<a href="http://localhost:9000/ktx/notice_list.do" class="btn">리스트</a>
				<a href="#" class="btn">홈으로</a>
				<a href="#" class="btn" id="click_before"><</a>
				<a href="#" class="btn" id="click_after">></a>
			</div>
			</td>
		</tr>
	</table>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>