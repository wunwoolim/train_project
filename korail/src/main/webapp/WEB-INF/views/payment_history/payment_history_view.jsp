<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속버스통합예매 - 결제내역 조회</title>

<link rel="styleSheet" type="text/css"
	href="http://localhost:9000/ktx/css/payment_history.css">
<!-- 	<href="http://localhost:9000/mycgv_jsp/css/am-pagination.css"> -->
<script src="http://localhost:9000/ktx/js/am-pagination.js"></script>
</head>
<body class="sub KO">
	<div id="wrap">
		<jsp:include page="../gnb2.jsp"></jsp:include>
		<div id="contents" style="padding-top: 0px;">
			<div id="contentWrap">
				<div class="dimmed"></div>
				<div id="contents" style="padding-top: 0px;">
					<jsp:include page="/header_payment.do"></jsp:include>
					<div class="page">
						<div class="tab_wrap tab_type1">
							<ul class="tabs violet mypage_tabs col3">
								<li class="active"><a href="#" id="pymTabs">승차권<img
										alt="" src="../images/ico_tab_s_on4.png"></a></li>
							</ul>
							<div class="tab_conts" style="display: block;">
								<form id="srchForm" name="srchForm" method="post">
									<div class="receipt_wrap ">
										<ul class="innerBox col4">
											<li>
												<div class="box_inputForm">
													<strong>상태</strong> <span class="radio_wrap"> <span
														class="custom_radio"> <input type="radio"
															id="status01" name="status" value="all"> <label
															for="status01" >전체<img src="./images/pmy_checked.png" style="position: absolute; width: 15px; height: 15px; transform: translate(4px, 1px);"></label>
													</span> <span class="custom_radio"> <input type="radio"
															id="status02" name="status" value="payments"> <label
															for="status02" >결제</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="status03" name="status" value="cancel"> <label
															for="status03">취소</label>
													</span> <input type="hidden" id="staCd" name="staCd" value="0">
													</span>
												</div>
											</li>
											<li>
												<div class="box_inputForm">
													<strong>기간</strong> <span class="radio_wrap"> <span
														class="custom_radio"> <input type="radio"
															id="term01" name="term"> <label
															for="term01">1개월</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="term02" name="term"> <label for="term02">2개월</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="term03" name="term"> <label for="term03">3개월</label>
													</span>
													</span> <input type="hidden" id="preTerm" name="preTerm"
														value="term01"> <input type="hidden"
														id="beforeTerm" name="beforeTerm" value="">
												</div>
											</li>
											<li class="label_tag">
												<div class="date_picker_wrap">
													<span class="name">조회시작일</span> <input type="hidden"
														id="agePageSttDt" name="agePageSttDt" value=""> <input
														type="hidden" id="agePageEndDt" name="agePageEndDt"
														value=""> <input type="hidden" id="orignDate"
														name="orignDate" value="20230417"> <input
														type="hidden" id="startMonth" name="startMonth" value="4">
													<p class="text">
														<span class="text_date text_date1" id="today">오늘</span><input
															type="text" id="datepicker3" name="srchBltnSttDt"
															 class="hasDatepicker"> <img
															class="ui-datepicker-trigger1"
															src="./images/ico_calender.png" alt="달력" title="달력">
														<input type="date" class="calendar" id="start"	
															name="trip-start">
													<form name="modalForm" method="get">
														<div id="modal1" style="display: none;">
															<div class="modal-content">
																<div class="datepicker-header">
																	<a class="ui-datepicker-prev ui-corner-all"
																		data-handler="prev" data-event="click" title="이전달"><span
																		class="ui-icon ui-icon-circle-triangle-w">이전달</span></a> <a
																		class="ui-datepicker-next ui-corner-all"
																		data-handler="next" data-event="click" title="다음달"><span
																		class="ui-icon ui-icon-circle-triangle-e">다음달</span></a> <span
																		class="ui-datepicker-year">2023</span>. <span
																		class="ui-datepicker-month">5</span>
																</div>
															</div>
														</div>
													</form>
												</div>
											</li>
											<li class="label_tag">
												<div class="date_picker_wrap">
													<span class="name">조회종료일</span> <input type="hidden"
														id="orignDate1" name="orignDate1" value="20230517">
													<p class="text">
														<span class="text_date text_date2">2023. 5. 17. 수</span><input
															type="text" id="datepicker4" name="srchBltnEndDt"
															 class="hasDatepicker" value="2023. 5. 17. 수"><img
															class="ui-datepicker-trigger2"
															src="./images/ico_calender.png" alt="달력" title="달력">
													<form name="modalForm" method="get">
														<div id="modal2" style="display: none;">
															<div class="modal-content" >
																<div class="datepicker-header">
																	<a class="ui-datepicker-prev ui-corner-all"
																		data-handler="prev" data-event="click" title="이전달"><span
																		class="ui-icon ui-icon-circle-triangle-w">이전달</span></a> <a
																		class="ui-datepicker-next ui-corner-all"
																		data-handler="next" data-event="click" title="다음달"><span
																		class="ui-icon ui-icon-circle-triangle-e">다음달</span></a> <span
																		class="ui-datepicker-year">2023</span>. <span
																		class="ui-datepicker-month">5</span>
																</div>
															</div>
														</div>
													</form>
												</div>
											</li>
										</ul>
									</div>
									<input type="hidden" id="pageNo" name="pageNo" value="1">
									<jsp:include page="/paycal.do"></jsp:include>
									<p class="btns col1">
										<a class="btnL btn_confirm">조회</a>
									</p>
								</form>
								<div class="search_result_wrap">
									<div class="mob_search_result">
										<section class="sec_search_result">
											<section class="sec_head">
												<span class="txt_puple">편도</span> <span class="mid_box">
													결제일시 <span>2023.05.01<br>20:27
												</span><br> <span> 일반 1<br></span>
												</span> <span class="txt_priceBox"> <span class="txt_div">카드</span>
													<span class="txt_price">17,300원</span>
												</span>
											</section>
											<section class="sec_body bg_payment_cancel">
												<div class="tbl_routeBox">
													<span class="roundBox">동서울</span> <span class="roundBox">동해</span>
												</div>
												<span class="tbl_ico ico_departure"> 2023.05.04 07:20
													<span class="txt_date">고속</span>
												</span>
											</section>
										</section>
									</div>
								</div>
								<p class="paging_wrap">
									<span class="paging"> <strong>1</strong>
									</span>
								</p>
								<ul class="desc_list">
									<li>결제 내역은 현재일 날짜기준 과거 3개월까지 조회 가능합니다.</li>
									<li>영수증발행을 선택하시면 영수증 출력을 위한 화면으로 이동합니다.</li>
								</ul>
							</div>
							<div class="tab_conts" style="display: none;">
								<form id="adtnSrchForm" name="adtnSrchForm" method="post">
									<div class="receipt_wrap">
										<ul class="innerBox col4">
											<li>
												<div class="box_inputForm">
													<strong>상태</strong> <span class="radio_wrap"> <span
														class="custom_radio"> <input type="radio"
															id="status04" name="status"
															onclick="javascript:staCdCheck(this.id);"> <label
															for="status04">전체</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="status05" name="status"
															onclick="javascript:staCdCheck(this.id);"> <label
															for="status05">결제</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="status06" name="status"
															onclick="javascript:staCdCheck(this.id);"> <label
															for="status06">취소</label>
													</span> <input type="hidden" id="adtnStaCd" name="adtnStaCd"
														value="">
													</span>
												</div>
											</li>
											<li>
												<div class="box_inputForm">
													<strong>기간</strong> <span class="radio_wrap"> <span
														class="custom_radio"> <input type="radio"
															id="term04" name="term1" checked="checked"> <label
															for="term04">1개월</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="term05" name="term1"> <label for="term05">2개월</label>
													</span> <span class="custom_radio"> <input type="radio"
															id="term06" name="term1"> <label for="term06">3개월</label>
													</span>
													</span> <input type="hidden" id="preAdtnTerm" name="preAdtnTerm"
														value="term04"> <input type="hidden"
														id="befAdtnTerm" name="befAdtnTerm" value="">
												</div>
											</li>
											<li class="label_tag">
												<div class="date_picker_wrap">
													<span class="name">조회시작일</span> <input type="hidden"
														id="adtnAgePageSttDt" name="adtnAgePageSttDt" value="">
													<input type="hidden" id="adtnAgePageEndDt"
														name="adtnAgePageEndDt" value=""> <input
														type="hidden" id="adtnOrignDate" name="adtnOrignDate"
														value="20230417"> <input type="hidden"
														id="adtnStartMonth" name="adtnStartMonth" value="4">
													<p class="text">
														<span class="text_date text_date1">2023. 4. 17. 월</span><input
															type="date" id="datepicker5" name="srchBltnSttDt1"
															 class="hasDatepicker" value="2023. 4. 17. 월"><img
															class="ui-datepicker-trigger1"
															src="/images/ico_calender.png" alt="달력" title="달력">
													</p>
												</div>
											</li>
											<li class="label_tag">
												<div class="date_picker_wrap">
													<span class="name">조회종료일</span> <input type="hidden"
														id="adtnOrignDate1" name="adtnOrignDate1" value="20230517">
													<p class="text">
														<span class="text_date text_date2">2023. 5. 17. 수</span><input
															type="text" id="datepicker6" name="srchBltnEndDt1"
															 class="hasDatepicker" value="2023. 5. 17. 수"><img
															class="ui-datepicker-trigger2"
															src="/images/ico_calender.png" alt="달력" title="달력">
													</p>
												</div>
											</li>
										</ul>
									</div>
									<input type="hidden" id="adtnPageNo" name="adtnPageNo"
										value="1">
									<p class="btns col1">
										<a href="#" class="btnL btn_confirm"
											onclick="javascript:adtnSrchFormClick();">조회</a>
									</p>
								</form>
								<div class="search_result_wrap">
									<table class="tbl_search_result">
										<caption class="cpd">
											<strong>조회결과 상세정보</strong>
											<p>결제일시, 구분, 노선, 권종, 횟수, 결제금액, 영수증발행</p>
										</caption>
										<colgroup>
											<col style="width: 17.7%;">
											<col style="width: 10.4%;">
											<col style="width: 26.9%;">
											<col style="width: 10.4%;">
											<col style="width: 9.3%;">
											<col style="width: 13.5%;">
											<col style="width: 11.4%;">
										</colgroup>
										<thead>
											<tr>
												<th scope="col">결제일시</th>
												<th scope="col">구분</th>
												<th scope="col">노선</th>
												<th scope="col">권종</th>
												<th scope="col">횟수</th>
												<th scope="col">결제금액</th>
												<th scope="col">영수증발행</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="7" class="noData">결제하신 내역이 없습니다.</td>
												<!-- noData pc -->
											</tr>
										</tbody>
									</table>
									<div class="mob_search_result">
										<section class="sec_search_result noData">
											<!-- noData mobile -->
											결제하신 내역이 없습니다.
										</section>
									</div>
								</div>
								<p class="paging_wrap"></p>
								<ul class="desc_list">
									<li>결제 내역은 현재일 날짜기준 과거 3개월까지 조회 가능합니다.</li>
									<li>영수증발행을 선택하시면 영수증 출력을 위한 화면으로 이동합니다.</li>
								</ul>
							</div>
							<div class="tab_conts" style="display: none;">
								<div class="search_result_wrap">
									<table class="tbl_search_result">
										<caption>
											<strong>조회결과 상세정보</strong>
											<p>결제일시, 구분, 노선, 권종, 횟수, 결제금액, 영수증발행</p>
										</caption>
										<colgroup>
											<col style="width: 17.7%;">
											<col style="width: 10.4%;">
											<col style="width: 26.9%;">
											<col style="width: 10.4%;">
											<col style="width: 9.3%;">
											<col style="width: 13.5%;">
											<col style="width: 11.4%;">
										</colgroup>
										<thead>
											<tr>
												<th scope="col">결제일시</th>
												<th scope="col">구분</th>
												<th scope="col">노선</th>
												<th scope="col">권종</th>
												<th scope="col">횟수</th>
												<th scope="col">결제금액</th>
												<th scope="col">영수증발행</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="7" class="noData">결제하신 내역이 없습니다.</td>
											</tr>
										</tbody>
									</table>
									<div class="mob_search_result">
										<section class="sec_search_result noData">결제하신 내역이
											없습니다.</section>
									</div>
								</div>
								<p class="paging_wrap"></p>
								<ul class="desc_list">
									<li>결제 내역은 현재일 날짜기준 과거 3개월까지 조회 가능합니다.</li>
									<li>영수증발행을 선택하시면 영수증 출력을 위한 화면으로 이동합니다.</li>
								</ul>
							</div>
						</div>
					</div>
					<jsp:include page="../footer.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
</html>