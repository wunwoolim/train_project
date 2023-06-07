<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 공지사항 리스트</title>
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
	<table class="notice_list">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
		<tr>
			<td>1</td>
			<td><a href="admin_notice_content.do">KTX 공지사항 입니다.</a></td>
			<td>1000</td>
			<td>2023-05-18</td>
		</tr>
		<tr>
			<td colspan="4">
			<div class="button">
				<a href="admin_notice_write.do" class="btn">등록하기</a>
			</div>
			</td>
		</tr>
	</table>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>