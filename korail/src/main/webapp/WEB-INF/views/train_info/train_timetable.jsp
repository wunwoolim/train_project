<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>기차 시간표</title>
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
		<h1 class="title">기차 시간표</h1>
	</div>
	<div class="train-timetable">
		<table>
			<tr>
				<th>번호</th>
				<th>열차번호</th>
				<th>출발시간</th>
				<th>출발지</th>
				<th>목적지</th>
				<th>도착 예정 시간</th>
			</tr>
			<tr>
				<td>1</td>
				<td>123123123</td>
				<td>08:00</td>
				<td>서울역</td>
				<td>부산역</td>
				<td>14:20</td>
			</tr>
			<tr>
				<td>2</td>
				<td>123456789</td>
				<td>08:30</td>
				<td>서울역</td>
				<td>광주역</td>
				<td>14:40</td>
			</tr>
			<tr>
				<td colspan="6">< 1 2 3 4 5 6 7 8 9 10></td>
			</tr>
		</table>
		</div>
</div>
</body>
</html>