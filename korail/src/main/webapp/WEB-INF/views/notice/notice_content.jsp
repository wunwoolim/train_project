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
				<a href="http://localhost:9000/ktx/notice_list.do?category=all&cvalue=all&page=1" class="btn">리스트</a>
				<a href="http://localhost:9000/ktx/notice_content.do?nid=${nprev}" class="btn" id="click_before"><</a>
				<a href="http://localhost:9000/ktx/notice_content.do?nid=${nnext}" class="btn" id="click_after">></a>
				<input type="hidden" id="before_hidden" value="${nprev}">
				<input type="hidden" id="next_hidden" value="${nnext}">
			</div>
			</td>
		</tr>
	</table>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>