<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속버스통합예매 - 사이트맵</title>
<link rel="styleSheet" href="http://localhost:9000/ktx/css/layout.css">
<link rel="styleSheet" href="http://localhost:9000/ktx/css/sitemap.css">
</head>
<body class="sub KO">
	<div id="wrap">
		<jsp:include page="../gnb.jsp"></jsp:include>
		<div id="contentWrap">
			<div id="contents" style="padding-top: 0px;">
				<jsp:include page="../header/header_sitemap.jsp"></jsp:include>
				<div class="page">
					<div class="noti_wrap taL">
						<p class="noti" style="padding-bottom: 25px;">고속버스 홈페이지의 정보를 쉽고 빠르게 확인하실 수 있습니다.</p>
					</div>
					<div class="siteMap_wrap">
						<div class="box_siteMap tab01">
							<h3>승차권</h3>
							<div class="box_list">
								<h4>예매</h4>
								<ul>
									<li><a href="/mrs/rotinf.do">고속버스 예매</a></li>
									<li><a href="/mrs/mrscfm.do">예매확인/취소/변경</a></li>
									<li><a href="/mrs/mrsrecplist.do">영수증 발행</a></li>
								</ul>
								<h4>운행정보</h4>
								<ul>
									<li><a href="/oprninf/arscgd/oprnArscGd.do">도착시간 안내</a></li>
									<li><a href="/oprninf/alcninqr/oprnAlcnPage.do">시간표 조회</a></li>
								</ul>
								<h4>고속버스 프리패스/정기권</h4>
								<ul class="last">
									<li><a href="/adtnprdnew/frps/frpsPrchGd.do">프리패스 여행권</a></li>
									<li><a href="/adtnprdnew/pass/passPrchGd.do">정기권</a></li>
									<li><a href="/adtnprdnew/prchpt/prdPrchPt.do">상품 구매내역</a></li>
								</ul>
							</div>
						</div>
						<div class="box_siteMap tab02">
							<h3>회원</h3>
							<div class="box_list">
								<h4>마이페이지</h4>
								<ul>
									<li><a href="/mbrs/mbrspage/myPageMain.do">나의 정보</a></li>
									<li><a href="/mbrs/mbrspage/mbrsPwdMod.do">비밀번호 변경</a></li>
									<li><a href="/mbrs/mbrspage/mbrsHpMod.do">휴대폰번호 변경</a></li>
									<li><a href="/mbrs/trprinqr/pymPtInqr.do">결제내역조회</a></li>
									<li><a href="/mbrs/mlginqr/mlgPtInqr.do">프리미엄 마일리지 조회</a></li>
								</ul>
								<h4>약관 및 처리방침</h4>
								<ul class="last">
									<li><a href="/etc/svcstpl/SvcStpl.do">서비스 이용약관</a></li>
									<li><a href="/etc/indlstpl/IndlStpl.do">개인정보 처리방침</a></li>
									<li><a href="/etc/busstpl/BusStpl.do">고속버스 운송약관</a></li>
									<li><a href="/etc/cmsstpl/CmsStpl.do">전자금융거래 이용약관</a></li>
								</ul>
							</div>
						</div>
						<div class="box_siteMap tab03">
							<h3>기타</h3>
							<div class="box_list">
								<h4>이용안내</h4>
								<ul>
									<li><a href="/ugd/mrsgd/Mrsgd.do">예매 안내</a></li>
									<li><a href="/ugd/mrsgd/MrdgdPrch.do">결제수단 안내</a></li>
									<li><a href="/ugd/rygd/Rygd.do">승차권 환불안내</a></li>
									<li><a href="/ugd/mlggd/Mlggd.do">프리미엄 마일리지 이용안내</a></li>
									<li><a href="/ugd/trtrgd/Trtrgd.do">휴게소 환승안내</a></li>
									<li><a href="/ugd/trmlgd/Trmlgd.do">터미널 안내</a></li>
									<li><a href="/ugd/cacmgd/Cacmgd.do">운송사 안내</a></li>
									<li><a href="/ugd/cacmgd/CacmgdSale.do">시외노선 할인제도 안내</a></li>
								</ul>
								<h4>고객센터</h4>
								<ul>
									<li><a href="/cscn/ntcmttr/readNtcList.do">공지사항</a></li>
									<li><a href="/cscn/qna/readQnaList.do">자주찾는 질문</a></li>
									<li><a href="/cscn/lossClnc/readLossClncList.do">유실물센터 안내</a></li>
								</ul>
								<h4>기타</h4>
								<ul class="last">
									<li><a href="/ugd/bustrop/Bustrop.do">전국고속버스운송사업조합</a></li>
									<li><a href="/ugd/trmlbizr/Trmlbizr.do">터미널사업자협회</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>