<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<a href="http://localhost:9000/t3/reservation/reservation.jsp"
							class="txt_myMenu"> <span>나의 예매내역</span> <strong
							id="mrsCfmPT">0건</strong></a>
					</div>
					<div class="btnBox">
						<a href="http://localhost:9000/t3/reservation/reservation.jsp"
							class="btn btn_sm_link ">예매확인</a> <a
							href="http://localhost:9000/t3/reservation/reservation.jsp"
							class="btn btn_sm_link ">/변경</a> <a
							href="http://localhost:9000/t3/reservation/reservation.jsp"
							class="btn btn_sm_link_white">/취소</a>
					</div>
				</li>
				<li class="additional">
					<div class="row">
						<a href="javascript:adtnPrdPT();" class="txt_myMenu"> <span>프리패스/정기권</span><strong
							id="adtnPrdPT">0개</strong></a>
					</div>
					<div class="btnBox">
						<a href="javascript:adtnPrdPT();" class="btn btn_sm_link_white">구매내역
							확인</a>
					</div>
				</li>
				<li class="mileage">
					<div class="row">
						<a href="javascript:mlgInqrPT();" class="txt_myMenu"> <span>프리미엄
								마일리지<span class="ico_mileage">왕관</span>
						</span> <strong>&nbsp;</strong></a>
					</div>
					<div class="btnBox">
						<a href="javascript:mlgInqrPT();" class="btn btn_sm_link_white">프리미엄
							마일리지 조회</a>
					</div>
				</li>
				<li class="payment">
					<div class="row">
						<a
							href="http://localhost:9000/ktx/pmyhis.do"
							class="txt_myMenu"> <span>결제내역</span><strong>&nbsp;</strong></a>
					</div>
					<div class="btnBox">
						<a
							href="http://localhost:9000/ktx/pmyhis.do"
							class="btn btn_sm_link_white">결제내역 조회</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>