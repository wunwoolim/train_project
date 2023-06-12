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
	#d2{
		margin-bottom: 70px;
	}
</style>
</head>
<body>
<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
		<div class="title_wrap_checkTicketingT">
			<div class="title_wrap">
				<jsp:include page="../header.jsp"></jsp:include>
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
			<button type="button" id="btnsearch" class="btn2">조회</button>
			<input type="hidden" id="start" >
			<input type="hidden" id="end" >
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>