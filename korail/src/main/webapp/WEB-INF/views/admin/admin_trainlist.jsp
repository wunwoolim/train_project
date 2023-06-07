<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/reservationlist.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/reservation_jquery.js"></script>
<script src="http://localhost:9000/ktx/js/ktx_getJson.js"></script>
<style>
</style>
</head>
<body>
<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
		<div class="title_wrap_checkTicketingT">
			<div class="title_wrap">
				<div class="util">
					<ul class="clfix">
						<li class="account">sohyun990502@naver.com</li>
						<li class="logout"><a href="#"><span>로그아웃</span></a></li>
						<li><a href="#">마이페이지</a></li>
						<li><a href="#">결제내역조회</a></li>
						<li><a href="#">사이트맵</a></li>
					</ul>
				</div>
				<!-- <a href="#" class="back">back</a>
				<a href="#" class="mo_toggle">메뉴</a> -->
				<h2>KTX 시간표</h2>
			</div>
		</div>
		<div id="trainList">
			<span class="start_span">출발지</span>
			<select id="start_city"></select>
			<select id="start_train"></select>
			
			<span class="end_span">도착지</span>
			<select id="end_city"></select>
			<select id="end_train"></select>
			
			<input type="text" name="traintime"  placeholder="날짜입력 예)20200701" id="traintime">
			<button type="button" id="btnsearch">조회</button>
			<input type="hidden" id="start" >
			<input type="hidden" id="end" >
		</div>
	</div>
</body>
</html>