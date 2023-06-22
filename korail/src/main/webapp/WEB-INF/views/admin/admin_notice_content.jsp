<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 공지사항 상세내용</title>
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
	<table class="admin_notice_content">
		<tr>
			<th>제목</th>
			<td>${noticeVo.ntitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${noticeVo.ncontent}
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${noticeVo.nhits}</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td>${noticeVo.ndate}</td>
		</tr>
		<tr>
			<td colspan="2">
			<div class="button">
				<a href="admin_notice_update.do?nid=${noticeVo.nid}" class="btn">수정하기</a>
				<a href="admin_notice_delete.do?nid=${noticeVo.nid}" class="btn">삭제하기</a>
				<a href="admin_notice_list.do" class="btn">리스트</a>
				<a href="admin_main.do" class="btn">관리자홈</a>
					</div>
			</td>
		</tr>
	</table>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>