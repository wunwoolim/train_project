<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="styleSheet" type="text/css"
	href="http://localhost:9000/ktx/css/payment_history.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/t3_jsp_jquery.js"></script>
</head>
<body class="sub KO">
	<div id="wrap">
		<jsp:include page="../gnb2.jsp"></jsp:include>
		<div id="contentWrap">
			<jsp:include page="../header/header_mypage_receipt.jsp"></jsp:include>
			<div class="adtnPrdPT_modal">
				<form id="srchForm" name="srchForm" method="post">
					<div class="receipt_wrap ">
						<ul class="innerBox col4">
							<li>
								<div class="box_inputForm">
									<strong>상태</strong> <span class="radio_wrap"> <span
										class="custom_radio"> <input type="radio" id="status01"
											name="status" value="all"> <label for="status01">전체<img
												src="./images/pmy_checked.png"
												style="position: absolute; width: 15px; height: 15px; transform: translate(4px, 1px);"></label>
									</span> <span class="custom_radio"> <input type="radio"
											id="status02" name="status" value="payments"> <label
											for="status02">결제</label>
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
										class="custom_radio"> <input type="radio" id="term01"
											name="term"> <label for="term01">1개월</label>
									</span> <span class="custom_radio"> <input type="radio"
											id="term02" name="term"> <label for="term02">2개월</label>
									</span> <span class="custom_radio"> <input type="radio"
											id="term03" name="term"> <label for="term03">3개월</label>
									</span>
									</span> <input type="hidden" id="preTerm" name="preTerm"
										value="term01"> <input type="hidden" id="beforeTerm"
										name="beforeTerm" value="">
								</div>
							</li>
							<li class="label_tag">
								<div class="date_picker_wrap">
									<span class="name">조회시작일</span> <input type="hidden"
										id="agePageSttDt" name="agePageSttDt" value=""> <input
										type="hidden" id="agePageEndDt" name="agePageEndDt" value="">
									<input type="hidden" id="orignDate" name="orignDate"
										value="20230417"> <input type="hidden" id="startMonth"
										name="startMonth" value="4">
									<p class="text">
										<span class="text_date text_date1" id="today">오늘</span><input
											type="text" id="datepicker3" name="srchBltnSttDt"
											class="hasDatepicker"> <img
											class="ui-datepicker-trigger1"
											src="./images/ico_calender.png" alt="달력" title="달력"> <input
											type="date" class="calendar" id="start" name="trip-start">
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
						</ul>
					</div>
					<jsp:include page="/paycal.do"></jsp:include>
					<p class="btns col1">
						<a class="btnL btn_confirm">조회</a>
					</p>
				</form>
				<div class="search_result_wrap"></div>
			</div>
		</div>
	</div>
</body>
</html>