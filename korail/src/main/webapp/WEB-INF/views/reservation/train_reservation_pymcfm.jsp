<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/train_reservation_pymcfm.css">
</head>
<body>
<div>
	<jsp:include page="../gnb.jsp"></jsp:include>
	<div id ="contentWrap">
	<div class="title_wrap in_process ticketingT">
		<div class="util">
			<ul class="clfix">
				
				<li class="login"><a href="/mbrs/lgn/loginMain.do"><span>로그인</span></a></li>
				<li><a href="/mbrs/mbrsjoin/mbrsJoin.do">회원가입</a></li>
				<li><a href="/mbrs/mbrspage/myPageMain.do">마이페이지</a></li>
				<li><a href="/mbrs/trprinqr/pymPtInqr.do">결제내역조회</a></li>
				<li><a href="/etc/sitemap/SiteMap.do">사이트맵</a></li>
			</ul>
			<!-- 170209 다국어선택 select수정 -->
			<!-- <div class="select-box">
				<div class="selectricWrapper"><div class="selectricHideSelect"><select name="lng_cd_navi" id="lng_cd_navi" title="다국어사이트 선택" tabindex="0">
					<option value="KO" selected="selected">한국어</option>
					<option value="EN">English</option>
					<option value="CN">中文</option>
					<option value="JP">日本語</option>
				</select></div><div class="selectric"><p class="label">한국어</p><b class="button">▾</b></div><div class="selectricItems" tabindex="-1"><div class="selectricScroll"><ul><li class="selected">한국어</li><li class="">English</li><li class="">中文</li><li class="last">日本語</li></ul></div></div><input class="selectricInput" tabindex="0"></div>
			</div> -->
			<!-- //170209 다국어선택 select수정 -->
		</div>
	
	<!-- <a href="#" class="back">back</a>
	<a href="#" class="mo_toggle">메뉴</a>
	 -->
	 <h2>고속버스예매</h2>
				
				<ol class="process">
					<li >예매정보입력</li>
					<li>결제정보입력</li>
					<li class="active" id="last">예매완료</li>
					
				</ol>
	</div>




			<div class="page ticket_finish depth3">
				<div class="noti_wrap N">
					<p class="noti" id="noticeMsgNm"><span class="accent">티켓</span> 예매가 <span>완료되었습니다.</span></p>
					<p class="desc" id="noticeDtlMsgNm">고속버스 모바일앱의 <strong>예매확인</strong> <span>메뉴에서 승차권 확인이 가능합니다.</span></p>
				</div>

				<div class="box_detail_info">
					<div class="routeHead">
						<p class="date">2023.05.31(수) 16:00 출발</p>
						<p class="ticket_number">
							예매번호<span class="num">20230515479724</span>
						</p>
					</div>
					<div class="routeBody">
						<div class="routeArea route_wrap">
							<div class="inner">
								<span class="roundBox departure">동서울</span>
								<span class="roundBox arrive">부산</span>
							</div>
							<div class="detail_info">
								<span>4시간 15분 소요</span>
							</div>
						</div>
						<div class="routeArea route_wrap mob_route">
							<div class="tbl_type2">
								<table class="tbl_info">
									<caption>
										<strong>버스 정보</strong>
										<p>고속사, 등급, 출발</p>
									</caption>
									<colgroup>
										<col style="width:68px;">
										<col style="width:*;">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row">고속사</th>
											<td>(주)한일고속<span class="hanil ico_bus">(주)한일고속</span></td>
										</tr>
										<tr>
											<th scope="row">등급</th>
											<td>우등</td>
										</tr>
										<tr>
											<th scope="row">승차홈</th>
											<td>M</td>
										</tr>
										<tr>
											<th scope="row">매수</th>
											<td>일반 1명</td>
										</tr>
										<tr>
											<th scope="row">좌석</th>
											<td>19</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				

				<div class="box_detail_info bgGray">
					
						<div class="routeArea route_wrap mob_route">
							<div class="tbl_type3">
								<table>
									<caption>
										<strong>결제정보</strong>
										<p>결제일시, 결제수단에 대한 정보 제공</p>
									</caption>
									<colgroup>
										<col style="width:80px;">
										<col style="width:*;">
									</colgroup>
									<tbody>
										<tr>
											<th scope="row">결제일시</th>
											<td>2023.05.15 (월) 19:59</td>
										</tr>
										<tr>
											<th scope="row">결제수단</th>
											<td>
												신용카드
												
												
												
												
												
												
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="routeArea route_wrap mob_route">
							<div class="tbl_type3">
								<table class="taR">
									<caption>
										<strong>결제금액 정보</strong>
										<p>예매금액, 사전할인, 결제금액, 적립예정마일리지에 대한 정보 제공</p>
									</caption>
									<colgroup>
										<col style="width:50%;">
										<col style="width:*;">
									</colgroup>
									<tbody>
										
										



											<tr>
												<th scope="row">결제금액</th>
												<td><strong><span id="tissuAmtView">38,000</span></strong><span id="tissuAmtUntView">원</span></td>
											</tr>
				
									</tbody>
								</table>
							</div>
						</div>
					
				</div>
				
				
					
					
					
						<div class="section">
							<ul class="desc_list">
								<li>학생 정기권 이용 고객님은 차량 탑승 시 학생 신분증(학생증, 청소년증, 대학생증등)을 필히 지참하시기 바랍니다.</li> <!-- 191118 추가 -->
								<li>예매하신 승차권의 터미널 발권 시에는 <strong class="txt_puple">반드시 예매에 사용하신 신용카드를 지참</strong>하셔야 하며, 해당 터미널 매표현장에 제시하신 후 예매된 사항이 있다고 말씀하시면 예매하신 승차권을 발권해 드립니다.</li> <!-- 191118 수정 -->
								<li>모바일티켓 발권 혹은 홈티켓으로 발권 하시면 터미널에서 따로 발권하지 않으셔도 승차 가능합니다.</li>
								<li>E-Pass 단말기가 부착된 고속버스에서 단말기에 예매 시 사용한 카드(교통카드 기능이 있는 신용카드만 해당)를 태그하시면 영수증과 승차권을 한번에 발권하실 수 있습니다.</li>
								<li>모바일티켓으로 회원 예매하신 내역은 <strong class="txt_puple">고속버스 티머니 앱</strong>에서도 조회하실 수 있습니다.</li> <!-- 191118 수정 -->
								<li>모바일티켓 발권시 별도의 승차권 발급없이 바로 탑승 하실수 있습니다.</li>
								<li>홈티켓 발행시 PC화면을 휴대폰으로 사진 촬영한 승차권은 효력이 없습니다.</li>
								<li>예매사항을 확인하시려면 상단의 <strong class="txt_puple">예매확인/취소/변경</strong> 메뉴를 클릭하세요.</li> <!-- 191118 수정 -->
								<li>마일리지 승차권은 예매취소는 가능하나 시간변경은 불가합니다.</li>						
								<!-- 191120 수정 -->
								<li>마일리지 승차권 취소 시, 마일리지 수수료 정책에 따라 처리됩니다.
									<ul class="dash_list">
										<li>출발 시간 이전 취소 시 100% 마일리지 환급</li>
										<li>출발 시간 이후 취소 시 100% 마일리지 차감</li>
									</ul>
								</li>
								<!-- //191120 수정 -->
								<!-- 191118 추가 -->
								<li>고속버스 정기권을 이용한 승차권 예매, 취소 안내
									<ul class="dash_list">
										<li>정기권으로 예매한 승차권은 버스 출발 시간 전까지 취소 후 다시 승차권 예매가 가능합니다.</li> <!-- 191118 수정 -->
										<li><strong class="accent2">정기권으로 예매한 승차권을 취소하지 않고 출발 시간이 지났을 경우 해당일의 동일 방향(편도) 재이용이 불가합니다.</strong></li>
										<li>정기권을 이용한 승차권 예매 및 발권은 차량 좌석이 있는 경우에만 사용이 가능합니다.</li>
									</ul>
								</li>
								<!-- //191118 추가 -->
							</ul>
						</div>
					
				

					
					
						<p class="btns col1" id="mrsInqrTissu"> <!-- 홈티켓발행 버튼이 사용될때에 클래스명이 col1 에서 col2로 변경되어야 함  -->
							<a href="/mrs/mrscfm.do" class="btnL btn_cancel">예매 확인</a>
						</p>
					
					
				
			</div>
		</div>
</div>			
</body>
</html>