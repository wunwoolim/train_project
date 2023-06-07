<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/gnb.css">
<script src="http://localhost:9000/ktx/js/t3_jsp_jquery.js"></script>
</head>
<body>
	<div id="gnb" class="gnb_pc">
		<h1 class="logo" style="margin-bottom: 0px; height:105px;" >
		
			<a href="#"><img class="gnb_logo" src="http://localhost:9000/ktx/images/free-icon-train.png">승차권 통합 예매</a>
		</h1>
		<div id="menu">
			<ul class="depth1" style="padding-left:30px;">
				<li><a href="http://localhost:9000/ktx/train_reservation_rotinf.do">예매</a></li>
				<li><a href="http://localhost:9000/ktx/reservation_main.do" class="">예매확인</a></li>
				<li><a href="" class="">운행정보</a>
					<ul>
						<li><a href="http://localhost:9000/ktx/train_timetable.do">시간표 조회</a></li>
						<li><a href="http://localhost:9000/ktx/train_route_info.do">기차역 정보</a></li>
					</ul>
				</li>
				<li><a href="" class="">이용안내</a>
				<ul>
						<li><a href="http://localhost:9000/ktx/payment_info.do">결제 안내</a></li>
						<li><a href="http://localhost:9000/ktx/refund_info.do">환불 안내</a></li>
						<li><a href="http://localhost:9000/ktx/reservation_info.do">예매 안내</a></li>
					</ul>
				</li>
				<li><a href="http://localhost:9000/ktx/notice_list.do">공지사항</a></li>
			</ul>
		</div>
	</div>
</body>
</html>