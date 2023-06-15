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
	.hidden-span, #traintime, .return{
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
			<h2>예매 변경</h2>
		</div>
	</div>
	
	<!------------------------ 예매변경 ---------------------------->
	<!-- <div class="breadcrumb">
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
			
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/mrscfm.do" selected="selected">예매 변경</option>
								<option value="/mrs/mrsrecplist.do">영수증 발행</option>
							</select>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div> -->
	<!------------------------ 예매확인하기 ---------------------------->
	<div class="page" id="page_updateC">
		<h3 class="update">출발일 변경</h3>
		<div class="change_wrap custom_input">
			<form name="mrschangefrm" id="mrschangefrm" method="post" action="/mrs/mrschantimestep1.do">
				<div class="routeBody clfix">
					<div class="routeArea route_wrap" id="update_routeArea">
						<p id="updatedate" class="date">${ovo.depPlandTime}</p>
						<p id="updatetime" class="time">${ovo.stime}</p>
						<div class="inner" id="updateinner">
							<span class="roundBox_start">출발</span>
							<span class="roundBox departure">${ovo.sstation}</span>
							<span class="roundBox_end">도착</span>
							<span class="roundBox arrive">${ovo.dstation}</span>
						</div>
						<span class="hidden-span" id="update_depPlaceId">${ovo.depPlaceId}</span>
						<span class="hidden-span" id="update_arrPlaceId">${ovo.arrPlaceId}</span>
					</div>
					<div class="routeArea route_select">
						<div class="box_inputForm click_box inselect" id="updatetimebox">
							<strong>출발일</strong>
							<ul class="date">
								<li>
									<div class="date_picker_wrap">
										<p class="text">
										<span class="text_date text_date1" id="starttime"></span>
										<span class="text_date text_date1" id="traintime"></span>
										<input type="text" id="datepicker11" readonly="" class="hasDatepicker">
										<img class="ui-datepicker-trigger" id="calenderImg" src="http://localhost:9000/ktx/images/ico_calender.png" alt="달력" title="달력">
										</p>
										<input type="hidden" >
									</div>
								</li>
								
								<li class="return">
									<div class="date_picker_wrap">
										<span class="name">오는날</span>
										<p class="text">
										<span class="text_date text_date2"></span>
										<input type="text" id="datepicker22" readonly="" class="hasDatepicker">
										<img class="ui-datepicker-trigger" src="http://localhost:9000/ktx/images/ico_calender.png" alt="달력" title="달력">
										</p>
									</div>
								</li>
							</ul>
							<jsp:include page="../reservcalender.jsp"></jsp:include>
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