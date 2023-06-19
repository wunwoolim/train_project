<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="title_wrap mypage_title">
		<jsp:include page="../header.jsp"></jsp:include>
		<h2>마이페이지</h2>
		<div class="inner">
			<ul class="myPage_list ">
				<li class="history">
					<div class="row">
						<a href="http://localhost:9000/ktx/reservation_main.do	"
							class="txt_myMenu"> <span>나의 예매내역</span> <strong
							id="mrsCfmPT">${sessionScope.countNum}개</strong></a>
					</div>
					<div class="btnBox">
						<a href="http://localhost:9000/ktx/reservation_main.do	"
							class="btn btn_sm_link ">예매확인/변경/취소</a>
					</div>
				</li>
				<li class="additional">
					<div class="row">
						<a class="txt_myMenu adtnPrdPT" style="cursor:pointer;">
							<span>영수증 출력</span>
							<strong>&nbsp;</strong>
						</a>
					</div>
					<div class="btnBox">
						<a class="btn btn_sm_link_white adtnPrdPT" style="cursor:pointer;">영수증 출력
						</a>
					</div>
				</li>
				<li class="mileage">
					<div class="row">
						<a href="http://localhost:9000/ktx/mypage_receipt.do" class="txt_myMenu">
							<span>프리미엄 마일리지<span class="ico_mileage">왕관</span>
							</span>
							<strong>&nbsp;</strong>
						</a>
					</div>
					<div class="btnBox">
						<a href="http://localhost:9000/ktx/mypage_receipt.do"
							class="btn btn_sm_link_white">프리미엄 마일리지 조회</a>
					</div>
				</li>
				<li class="payment">
					<div class="row">
						<a href="http://localhost:9000/ktx/pmyhis.do" class="txt_myMenu">
							<span>결제내역</span><strong>&nbsp;</strong>
						</a>
					</div>
					<div class="btnBox">
						<a href="http://localhost:9000/ktx/pmyhis.do"
							class="btn btn_sm_link_white">결제내역 조회</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>