<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/gnb.css">
<!-- <script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script> -->

<script>
$(document).ready(function() {
  let infoMenuVisible = false;

  $(".info").click(function() {
    if (!infoMenuVisible) {
      $(".info_menu").css("display", "block");
      infoMenuVisible = true;
    } else {
      $(".info_menu").css("display", "none");
      infoMenuVisible = false;
    }
  });
  
    let adminMenuVisible = false;
    
    $(".admin").click(function() {
        if (!adminMenuVisible) {
          $(".admin_menu").css("display", "block");
          adminMenuVisible = true;
        } else {
          $(".admin_menu").css("display", "none");
          adminMenuVisible = false;
        }     
    });
    
    let depthMenuVisible = false;
    
    $(".depth4").click(function() {
        if (!depthMenuVisible) {
          $(".depth4-1").css("display", "block");
          depthMenuVisible = true;
        } else {
          $(".depth4-1").css("display", "none");
          depthMenuVisible = false;
        }     
    });
});
</script>
<style>
	.admin, .info {
		cursor:pointer;
	}
	.gnb_pc table img {
		width:60px;
		vertical-align: middle;
	}
	.gnb_pc table {
		margin-left: 15px;
		border-collapse: collapse;
		position: absolute;
    	top: 200%;
	}
	.gnb_pc table td{
		border: 1px solid #ddd;
	}
	
	
</style>
</head>
<body>
	<div id="gnb" class="gnb_pc">
		<h1 class="logo" style="margin-bottom: 0px; height:105px;" >
		
			<a href="http://localhost:9000/ktx/main_train.do">
			<img class="gnb_logo" src="http://localhost:9000/ktx/images/free-icon-train.png">KTX 통합 예매</a>
		</h1>
		<div id="menu">
			<ul class="depth1" style="padding-left:30px; ">
				<li><a href="http://localhost:9000/ktx/train_reservation_rotinf.do">예매</a></li>
				<li><a href="http://localhost:9000/ktx/reservation_main.do" class="">예매확인</a></li>
				<li><a class="info">운행정보</a>
					<ul class="info_menu" style="display:none;">
						<li><a href="http://localhost:9000/ktx/train_timetable.do">시간표 조회</a></li>
						<li><a href="http://localhost:9000/ktx/train_route_info.do">기차역 정보</a></li>
					</ul>
				</li>
				<li><a class="admin">이용안내</a>
					<ul class="admin_menu" style="display:none;">
						<li><a href="http://localhost:9000/ktx/info_payment.do">결제 안내</a></li>
						<li><a href="http://localhost:9000/ktx/info_refund.do">환불 안내</a></li>
						<li><a href="http://localhost:9000/ktx/info_reservation.do">예매 안내</a></li>
					</ul>
				</li>
				<li><a class="depth4">회원정보관리</a>
					<ul class="depth4-1"  style="display: none;">
						<li><a href="http://localhost:9000/ktx/mypage.do">나의정보수정</a></li>
						<li><a href="http://localhost:9000/ktx/s_reservation.do">우대예약 등록</a></li>
						<li><a href="http://localhost:9000/ktx/mypage.do">간편구매 정보 등록</a></li>
						<li><a href="http://localhost:9000/ktx/mypage.do" onclick="bye(event)">회원탈퇴</a></li>
					</ul>
				</li>
				<li><a href="http://localhost:9000/ktx/notice_list.do?category=all&cvalue=all&page=1">공지사항</a></li>
			</ul>
		</div>
	</div>
</body>
</html>