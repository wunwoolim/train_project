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
	<table class="notice_content">
		<tr>
			<th>제목</th>
			<td>KTX 공지사항 입니다.</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>2023년 5월 23일 기준 전체 시스템 점검 예정입니다.<br>
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
				<a href="http://localhost:9000/ktx/admin_notice_update.do" class="btn">수정하기</a>
				<a href="http://localhost:9000/ktx/admin_notice_delete.do" class="btn">삭제하기</a>
				<a href="http://localhost:9000/ktx/admin_notice_list.do" class="btn">리스트</a>
				<a href="#" class="btn">관리자홈</a>
					</div>
			</td>
		</tr>
	</table>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>