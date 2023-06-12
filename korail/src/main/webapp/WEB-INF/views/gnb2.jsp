<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gnb</title>
<link rel="styleSheet" type="text/css"
	href="http://localhost:9000/ktx/css/layout.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/t3_jsp_jquery.js"></script>
</head>
<body>
	<div id="gnb" class="gnb_pc">
		<h1 class="logo"
			style="margin-bottom: 0px; height: 133px; margin-top: 16px; padding-top: 28px;">
			<a href="http://localhost:9000/ktx/main_train.do">
			<img class="gnb_logo" src="http://localhost:9000/ktx/images/free-icon-train.png">승차권 통합 예매</a>
		</h1>
		<div id="menu">
			<ul class="depth1" style="padding-left: 30px;">
				<li><a
					href="http://localhost:9000/ktx/train_reservation_rotinf.do">예매</a></li>
				<li><a href="http://localhost:9000/ktx/reservation_main.do"
					class="">예매확인</a></li>

				<li><a class="depth2">운행정보</a>
					<ul class="depth2-1" style="padding-left: 2px; display: none;"">
						<li><a href="http://localhost:9000/ktx/train_timetable.do">시간표
								조회</a></li>
						<li><a href="http://localhost:9000/ktx/train_route_info.do">기차역
								정보</a></li>
					</ul></li>
				<li><a class="depth3">이용안내</a>
					<ul class="depth3-1" style="padding-left: 2px; display: none;"">
						<li><a href="http://localhost:9000/ktx/payment_info.do">결제
								안내</a></li>
						<li><a href="http://localhost:9000/ktx/refund_info.do">환불
								안내</a></li>
						<li><a href="http://localhost:9000/ktx/reservation_info.do">예매안내</a></li>
					</ul></li>
				<li><a href="http://localhost:9000/ktx/notice_list.do">공지사항</a></li>

				<li><a class="depth4">회원정보관리</a>
					<ul class="depth4-1" style="padding-left: 2px; display: none;"">
						<li><a href="mypage.do">나의정보수정</a></li>
						<li><a href="#">안심로그인등록</a></li>
						<li><a href="s_reservation.do">우대예약 등록</a></li>
						<li><a href="#">간편구매 정보 등록</a></li>
						<!-- 다자녀, 임신부, 기초생활수급자 -->
						<li><a href="mypage.do" onclick="bye(event)">회원탈퇴</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>