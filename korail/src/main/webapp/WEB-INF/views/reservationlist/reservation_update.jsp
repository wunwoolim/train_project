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
<style>
	.hidden-span {
            display: none;
        }
</style>
</head>
<body>
<div>
	<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
	<div class="title_wrap_checkTicketingT">
		<div class="title_wrap">
			<jsp:include page="../header.jsp"></jsp:include>
			<h2>예매확인/취소/변경</h2>
		</div>
	</div>
	
	<!------------------------ 예매변경 ---------------------------->
	<div class="breadcrumb">
		<ul class="breadcrumb_list">
			<li><a href="/main.do">HOME</a></li>
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/rotinf.do">고속버스예매</option>
								<option value="/mrs/mrscfm.do" selected="selected">예매확인</option>
								<option value="/oprninf/alcninqr/oprnAlcnPage.do">운행정보</option>
								<option value="/adtnprdnew/frps/frpsPrchGd.do">고속버스 프리패스/정기권</option>
								<option value="/ugd/mrsgd/Mrsgd.do">이용안내</option>
								<option value="/cscn/ntcmttr/readNtcList.do">공지사항</option>
								<option value="/cscn/qna/readQnaList.do">고객센터</option>
								<option value="/ugd/bustrop/Bustrop.do">전국고속버스운송사업조합</option>
								<option value="/ugd/trmlbizr/Trmlbizr.do">터미널사업자협회</option>
							</select>
						</div>
					</div>
				</div>
			</li>
			<!-- 예매확인 -->
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/mrscfm.do" selected="selected">예매 확인/취소/변경</option>
								<option value="/mrs/mrsrecplist.do">영수증 발행</option>
							</select>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<!------------------------ 예매확인하기 ---------------------------->
	<div class="page">
		<h3 class="update">시간/등급 변경</h3>
		<div class="change_wrap custom_input">
			<form name="mrschangefrm" id="mrschangefrm" method="post" action="/mrs/mrschantimestep1.do">
				<div class="routeBody clfix">
					<div class="routeArea route_wrap">
						<p id="updatedate" class="date">${ovo.depPlandTime}</p>
						<p id="updatetime" class="time">${ovo.stime}</p>
						<div class="inner" id="updateinner">
							<span class="roundBox departure">${ovo.sstation}</span>
							<span class="roundBox arrive">${ovo.dstation}</span>
						</div>
						<span class="hidden-span" id="update_reservnum">${ovo.reservnum}</span>
					</div>
					<div class="routeArea route_select">
						<div class="box_inputForm click_box inselect" id="updatetimebox">
							<strong>시간</strong>
							<div class="payment select-box value">
								<div class="selectricWrapper">
									<div class="selectricHideSelect">
										<select name="timeChoice" id="timeChoice" onchange="fnTimeChoice(this);" title="시간 선택" tabindex="0">
											<option value="0-1">00:00</option>
											<option value="00">01:00</option>
											<option value="01">02:00</option>
											<option value="02">03:00</option>
											<option value="03">04:00</option>
											<option value="04">05:00</option>
											<option value="05">06:00</option>
											<option value="06">07:00</option>
											<option value="07">08:00</option>
											<option value="08">09:00</option>
											<option value="9">10:00</option>
											<option value="10">11:00</option>
											<option value="11">12:00</option>
											<option value="12">13:00</option>
											<option value="13">14:00</option>
											<option value="14">15:00</option>
											<option value="15">16:00</option>
											<option value="16">17:00</option>
											<option value="17">18:00</option>
											<option value="18">19:00</option>
											<option value="19">20:00</option>
											<option value="20">21:00</option>
											<option value="21">22:00</option>
											<option value="22">23:00</option>
										</select>
									</div>
									<div class="selectric">
										<p class="label add">${ovo.stime}</p><b class="button">▾</b>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<p class="btns col1">
			<!-- <input type="text" id="update_depPlandTime">
			<input type="text" id="update_depPlaceId">
			<input type="text" id="update_arrPlaceId"> -->
			<a href="http://localhost:9000/ktx/reservation_updatetime.do" class="btnL btn_confirm" id="reserv_search">조회하기</a>
		</p>
		<div class="section">
			<ul class="desc_list">
				<li>시간 변경은 1회만 가능하며 출발시간, 등급, 매수 및 좌석선택 변경이 가능합니다.</li>
				<li>기존에 선택하셨던 출발시간으로는 변경이 불가합니다.</li>
				<li>출발날짜는 변경이 불가합니다.</li>
				<li>예매 변경을 하게 되면 기존에 예매한 사항은 취소되며, 다시 한 번 카드결제가 이루어집니다.</li>
			</ul>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>