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
</head>
<body>
<div>
	<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
	<div class="title_wrap_checkTicketingT">
		<div class="title_wrap">
			<div class="util">
				<ul class="clfix">
					<li class="login"><a href="#"><span>로그인</span></a></li>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">마이페이지</a></li>
					<li><a href="#">결제내역조회</a></li>
					<li><a href="#">사이트맵</a></li>
				</ul>
			</div>
			<!-- <a href="#" class="back">back</a>
			<a href="#" class="mo_toggle">메뉴</a> -->
			<h2>예매확인/취소/변경</h2>
		</div>
	</div>
	
	<!------------------------ 메뉴바 ---------------------------->
	<div class="breadcrumb">
		<ul class="breadcrumb_list">
			<li><a href="/main.do">HOME</a></li>
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/rotinf.do">KTX예매</option>
								<option value="/mrs/mrscfm.do" selected="selected">예매확인</option>
								<option value="/oprninf/alcninqr/oprnAlcnPage.do">운행정보</option>
								<option value="/ugd/mrsgd/Mrsgd.do">이용안내</option>
								<option value="/cscn/ntcmttr/readNtcList.do">공지사항</option>
								<option value="/cscn/qna/readQnaList.do">고객센터</option>
							</select>
						</div>
						<!-- <div class="selectric">
							<p class="label">예매확인</p>
							<b class="button">▾</b>
						</div> -->
						<!-- <div class="selectricItems" tabindex="-1">
							<div class="selectricScroll">
								<ul>
									<li class="">고속버스예매</li>
									<li class="selected">예매확인</li>
									<li class="">운행정보</li>
									<li class="">고속버스 프리패스/정기권</li>
									<li class="">이용안내</li>
									<li class="">공지사항</li>
									<li class="">고객센터</li>
									<li class="">전국고속버스운송사업조합</li>
									<li class="last">터미널사업자협회</li>
								</ul>
							</div>
						</div>
						<input class="selectricInput" tabindex="0"> -->
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
						<!-- <div class="selectric">
							<p class="label">예매 확인/취소/변경</p>
							<b class="button">▾</b>
						</div>
							<div class="selectricItems" tabindex="-1">
							<div class="selectricScroll">
								<ul>
									<li class="selected">예매 확인/취소/변경</li>
									<li class="last">영수증 발행</li>
								</ul>
							</div>
						</div>
						<input class="selectricInput" tabindex="0"> -->
					</div>
				</div>
			</li>
		</ul>
	</div>
	<!------------------------ 로그인하기 ---------------------------->
	<div class="page">
		<div class="login_wrap">
			<!-- 회원로그인 -->
			<form id="lgnUsrInfForm" name="lgnUsrInfForm">
			<div class="box_login">
				<h3 class="mob_h3">회원 로그인</h3>
				<div class="inner">
					<fieldset>
						<!-- <legend>회원로그인</legend> -->
						<ul class="loginList">
							<li>
								<div class="box_inputForm">
									<strong>아이디</strong>
									<span class="box_label">
										<label for="usrId">아이디를 입력하세요</label>
										<input type="text" name="usrId" id="usrId" class="input" onkeyup="fnIcoCheck(this);">
									</span>
								</div>
							</li>
							<li>
								<div class="box_inputForm">
									<strong>비밀번호</strong>
									<span class="box_label">
										<label for="usrPwd">비밀번호를 입력하세요</label>
										<input type="password" name="usrPwd" id="usrPwd" class="input" onkeyup="fnIcoCheck(this);" data-tk-kbdtype="qwerty" onfocus="tk.onKeyboard(this);">
									</span>
								</div>
							</li>
						</ul>
							</fieldset>
							<p class="btn_squareBox"><button onclick="fnMngChkCfm(this);" type="button" class="btn_confirm ready" id="btnLogin">로그인</button></p>
							<div class="box_searchId">
								<a href="#none" onclick="lgnSearchId();"><span class="ico_searchId">아이디찾기</span></a>
								<a href="#none" onclick="lgnSearchPwd();"><span class="ico_searchPW">비밀번호찾기</span></a>
								<a href="#none" onclick="mbrsJoin();"><span class="ico_joinUs">회원가입</span></a>
							</div>
						</div>
						<input type="hidden" id="returnUrl" name="returnUrl" value="/mrs/mrscfm.do?vltlCnt=Y">
						<input type="hidden" id="popUpDvs" name="popUpDvs" value="N">
					</div>
					<input type="hidden" id="hidfrmId" name="hidfrmId" value="lgnUsrInfForm">
					<input type="hidden" id="transkeyUuid_lgnUsrInfForm" name="transkeyUuid_lgnUsrInfForm" value="a8faa6eb38350229c3950316465f5e6755b404b31270294d21fafa58b2086f59">
					<input type="hidden" id="transkey_usrPwd_lgnUsrInfForm" name="transkey_usrPwd_lgnUsrInfForm" value="">
					<input type="hidden" id="transkey_HM_usrPwd_lgnUsrInfForm" name="transkey_HM_usrPwd_lgnUsrInfForm" value="">
			</form> 
			<!-- //회원로그인 -->
				
			<!-- 비회원로그인 -->
			<form id="lgnNonUsrFrm" name="lgnNonUsrFrm">
			<div class="box_login non-member">
				<h3 class="mob_h3">비회원 예매확인</h3>
				<p class="h3_desc">예매 시 입력하신 정보를 정확히 입력해주세요.</p>
				<div class="find_tab clearfix">
					<p class="ph_find on">휴대폰번호로 찾기</p>
					<p class="card_find">카드번호로 찾기</p>
				</div>
				<div class="inner">
					<fieldset>
					<!-- <legend>회원로그인</legend> -->
					<ul class="loginList">
						<li class="phone_wrap">
							<ul class="ph_form">
								<li class="clearfix send no_member_ticketing01 " style="display: list-item;">
									<div class="box_inputForm_no_member">
										<strong>휴대폰번호</strong>
										<span class="box_label">
											<label for="nonMbrsHp">휴대폰번호를 입력하세요</label>
											<input type="text" name="nonMbrsHp" id="nonMbrsHp" class="input" maxlength="11" onkeyup="fnIcoCheck(this),fnNumCheck(this);">
										</span>
									</div>
									<button type="button" class="phone_send_btn send_btn">인증번호 발송</button>
								</li>
								<li class="resend " style="display: none;">
									<div class="box_inputForm_no_member">
										<strong class="send_txt">인증번호가 발송 완료되었습니다.</strong>
									</div>
									<button class="phone_send_btn resend_btn">인증번호 재발송</button>
								</li>
								<li class="clearfix no_member_ticketing01" style="display: list-item;">
									<div class="box_inputForm_no_member">
										<strong>수신된 인증번호</strong>
										<span class="box_label">
											<label for="nonMbrsAuthNo">인증번호를 입력하세요</label>
											<input type="text" name="nonMbrsAuthNo" id="nonMbrsAuthNo" maxlength="6" onkeyup="fnIcoCheck(this),fnNumCheck(this);" class="input">
										</span>
									</div>
									<button type="button" class="phone_send_btn ph_check">확인</button>
									<p style="padding-left: 10px; text-align: left;">
										<input type="checkbox" name="sms_yn" id="sms_yn" value="Y"> <label for="sms_yn">SMS로 인증번호 받기</label>
									</p>
								</li>
							</ul>
						</li>
						<li class="pay_wrap_ph" style="display: none;">
							<ul>
								<li class=" ">
									<div class="box_inputForm ticketing02"> 
										<strong class="ph_done">인증이 완료되었습니다.</strong>
										<input type="hidden" name="nonMbrsAuthYn" id="nonMbrsAuthYn">
									</div>
								</li>
								
								<li class="clearfix no_member_tab no_member_tab01">
									<p class="credit on">신용카드 예매 티켓</p>
									<p class="easypay">간편결제 예매 티켓</p>
								</li>
									
								<li class="credit01 mt0">
									<div class="box_inputForm"> 
										<strong>생년월일(YYMMDD)</strong>
										<span class="box_label">
											<label for="birthday1">생년월일 6자리를 입력하세요</label>
											<input type="text" name="birthday1" id="birthday1" maxlength="10" onkeyup="fnIcoCheck(this),fnNumCheck(this);" class="input">
										</span>
									</div>
								</li>
								
								<li class="credit02 mt0">
									<div class="box_inputForm"> 
										<strong>출발일(YYYYMMDD)</strong>
										<span class="box_label">
											<label for="start_date1">출발일 8자리를 입력하세요</label>
											<input type="text" name="start_date1" id="start_date1" maxlength="8" onkeyup="fnIcoCheck(this),fnNumCheck(this);" class="input">
										</span>
									</div>
								</li>
								<li class="credit01"><span class="notice02 ">※ 법인카드로 결제 한 경우 사업자번호(10자리)를 입력하세요.</span></li>
								<li class="wh100_notice credit02" style="margin-left:25px; text-align:left;"><span class="notice02 ">※ 스마일페이/티머니페이/페이코로 결제 한 경우<br> 생년월일(6자리)대신 출발일(8자리)을 입력하세요.</span></li>
							</ul>
						</li>
							
						<li class="pay_wrap_card" style="display: none;">
							<ul>
								<li class="mt0">
									<div class="box_inputForm ht47">
										<strong class="send_number">카드번호</strong>
										<span class="box_label clearfix">
											<input type="text" name="card_number01" id="card_number01" class="input02" maxlength="4" onkeydown="this.value = onlyNumPlus(this.value);" onkeyup="fnChkNext(this,'card_number02')">
											<span class="hyp">-</span>
											<input type="text" name="card_number02" id="card_number02" class="input02" maxlength="4" onkeydown="this.value = onlyNumPlus(this.value);" onkeyup="fnChkNext(this,'card_number03')">
											<span class="hyp">-</span>
											<input type="password" name="card_number03" id="card_number03" class="input02" maxlength="4" onkeydown="this.value = onlyNumPlus(this.value);" onkeyup="fnChkNext(this,'card_number04')" data-tk-kbdtype="number" onfocus="tk.onKeyboard(this);">
											<span class="hyp">-</span>
											<input type="password" name="card_number04" id="card_number04" class="input02" maxlength="4" onkeydown="this.value = onlyNumPlus(this.value);" onblur="" data-tk-kbdtype="number" onfocus="tk.onKeyboard(this);">
										</span>
									</div>
								</li>
								<li class="clearfix no_member_tab no_member_tab02">
									<p class="credit on">신용카드 예매 티켓</p>
								</li>
								<li class=" credit03 mt0">
									<div class="box_inputForm"> 
										<strong>생년월일(YYMMDD)</strong>
										<span class="box_label">
											<label for="birthday2">생년월일 6자리를 입력하세요</label>
											<input type="text" name="birthday2" id="birthday2" maxlength="10" onkeyup="fnIcoCheck(this),fnNumCheck(this);" class="input">
										</span>
									</div>
								</li>
								<li class="credit03"><span class="notice02 ">※ 법인카드로 결제 한 경우 사업자번호(10자리)를 입력하세요.</span></li>
							</ul>
						</li>		
					</ul>
				</fieldset>
				<p class="btn_squareBox no_member_ticketing01" style="display: block;"><button type="button" onclick="javascript:alert('휴대폰인증이 필요합니다.'), $('#nonMbrsHp').val(''), $('#nonMbrsHp').focus();" class="btn_confirm ready">조회</button></p>
				<p class="btn_squareBox pay_wrap_ph pay_wrap_ph_btn" style="display: none;"><button type="button" onclick="javascript:fnNonUsr_Search();" class="btn_confirm ready">조회</button></p>
				<p class="btn_squareBox pay_wrap_card pay_wrap_card_btn" style="display: none;"><button type="button" onclick="javascript:fnNonUsr_Search();" class="btn_confirm ready">조회</button></p>
				
				<input type="hidden" id="popUpDvs" name="popUpDvs" value="N">
				<input type="hidden" id="returnUrl" name="returnUrl" value="/mrs/mrscfm.do">
				<input type="hidden" id="vltlCnt" name="vltlCnt" value="Y">
				<input type="hidden" id="cal_flg1" name="cal_flg1" value="0">
				<input type="hidden" id="cal_flg2" name="cal_flg2" value="1">
			</div>
		</div>

	<input type="hidden" id="hidfrmId" name="hidfrmId" value="lgnNonUsrFrm">
	<input type="hidden" id="transkeyUuid_lgnNonUsrFrm" name="transkeyUuid_lgnNonUsrFrm" value="a8faa6eb38350229c3950316465f5e6755b404b31270294d21fafa58b2086f59">
	<input type="hidden" id="transkey_card_number03_lgnNonUsrFrm" name="transkey_card_number03_lgnNonUsrFrm" value="">
	<input type="hidden" id="transkey_HM_card_number03_lgnNonUsrFrm" name="transkey_HM_card_number03_lgnNonUsrFrm" value="">
	<input type="hidden" id="transkey_card_number04_lgnNonUsrFrm" name="transkey_card_number04_lgnNonUsrFrm" value="">
	<input type="hidden" id="transkey_HM_card_number04_lgnNonUsrFrm" name="transkey_HM_card_number04_lgnNonUsrFrm" value="">
</form>

	<script>
				/* 1-1, 1-2  */
					$(".send_btn").on("click",function(){
//	 					$(".send").hide();
//	 					$(".resend").show();
						if ($("#nonMbrsHp").val().length < 10){
							alert("휴대폰번호를 확인해주세요.");
							return;
						}
						
						$("#loading").show();
						$("#nonMbrsAuthYn").val("N");
						
						var sms_yn = $("#sms_yn").prop("checked");
						
						$.ajax({	
					        url      : "/mbrs/lgn/askAuthNoNonUser.ajax",
					        type     : "post",
					        data     : {
					        	hp_no : $("#nonMbrsHp").val(),
					        	sms_yn : (sms_yn) ? 'Y' : 'N',
					        },
					        dataType : "json",
					        async    : true,
					        success  : function(lgnNonUsrMap){
					        	$("#loading").hide();
					        	
					        	if (lgnNonUsrMap.resultStatus == "Y"){
						        	
						        	alert("인증번호가 전송되었습니다.");
						        	$("#nonMbrsAuthNo").val('');
						        	$("#nonMbrsAuthNo").focus();
						        	$(".send_btn").text('인증번호 재발송');
						        	
					        	} else {
					        		alert("인증번호 전송에 실패하였습니다. \n\n잠시 후 다시 이용하여 주시기 바랍니다.");
					        	}
					        },
					        error : function (e){
					        	$("#loading").hide();
					            alert("잠시 후 다시 이용하여 주시기 바랍니다.");
					            return;
					        }
						});
						
					});
				
					/*  1, 2  */
					$(".ph_check").on("click",function(){
						
						if ($("#nonMbrsHp").val().length < 10){
							alert("휴대폰번호를 확인해주세요.");
							return;
						}
						if ($("#nonMbrsAuthNo").val().length < 6){
							alert("인증번호를 확인해주세요.");
							return;
						}
						
						$("#loading").show();
						$("#nonMbrsAuthYn").val("N");
						
						$.ajax({	
					        url      : "/mbrs/lgn/insertAuthNonUserInfo.ajax",
					        type     : "post",
					        data     : {
					        	hp_no : $("#nonMbrsHp").val(),
					        	aou_no : $("#nonMbrsAuthNo").val(),
					        	in_type : '1'
					        },
					        dataType : "json",
					        async    : true,
					        success  : function(lgnNonUsrMap){
					        	$("#loading").hide();
					        	
					        	if (lgnNonUsrMap.resultStatus == "Y"){
						        	alert("인증되었습니다.");
						        	
									$(".no_member_ticketing01").hide();
									$(".pay_wrap_ph").show();
									$(".resend").hide();
									$("#nonMbrsAuthYn").val("Y");
					        	} else {
					        		alert("인증에 실패하였습니다. \n\n인증번호를 확인하여 주시기 바랍니다.");
					        	}
					        },
					        error : function (e){
					        	$("#loading").hide();
					            alert("잠시 후 다시 이용하여 주시기 바랍니다.");
					            return;
					        }
						});
						
					});
					/*  2-2 */
					$(".no_member_tab01 p").on("click", function(){
						$(".no_member_tab01 p").removeClass("on");
						$(this).addClass("on");
						if($(".no_member_tab01 p.easypay").hasClass("on")){
							$(".credit01").hide();
							$(".credit02").show();
							$("#cal_flg2").val('2');
						}else{
							$(".credit01").show();
							$(".credit02").hide();
							$("#cal_flg2").val('1');
						}
					});
					
					$(".find_tab p").on("click", function(){
						$(".find_tab p").removeClass("on");
						$(this).addClass("on");
						if($(".card_find").hasClass("on")){
							$(".no_member_ticketing01").hide();
							$(".pay_wrap_card").show();
							$(".pay_wrap_ph").hide();
							$(".resend").hide();
							$("#cal_flg1").val('2');
						}else{
							$(".no_member_ticketing01").show();
							$(".pay_wrap_card").hide();
							$(".pay_wrap_ph").hide();
							$("#cal_flg1").val('0');
						}
					});
					/* 3-2 */
					$(".no_member_tab02 p").on("click", function(){
						$(".no_member_tab02 p").removeClass("on");
						$(this).addClass("on");
						if($(".no_member_tab02 p.easypay").hasClass("on")){
							$(".credit03").hide();
							$(".credit04").show();
							$("#cal_flg2").val('2');
						}else{
							$(".credit03").show();
							$(".credit04").hide();
							$("#cal_flg2").val('1');
						}
					});
					function fnChkNext(obj,nextFld){
						if($(obj).val().length == 4){
							$("#"+nextFld).val('');
							$("#"+nextFld).focus();
						}
					}
					function fnNonUsr_Search(){
						var cal_flg1 = Number($("#cal_flg1").val());
						var cal_flg2 = Number($("#cal_flg2").val());
						var card_number = $("#card_number01").val() +""+ $("#card_number02").val() +""+ $("#card_number03").val() +""+ $("#card_number04").val();
						if(cal_flg1 == 0 && $("#nonMbrsAuthYn").val() != "Y"){
							alert("비회원 인증이 필요합니다.");
							return;
						}
						if (cal_flg1 == 0 && $("#nonMbrsHp").val() == ''){
							alert('휴대폰번호를 확인해주세요.');
							return;
						}
						if (cal_flg1 == 0 && cal_flg2 == 1 && $("#birthday1").val().length != 6 && $("#birthday1").val().length != 10){
							alert('생년월일을 확인해주세요.');
							$("#birthday1").focus();
							return;
						}
						if (cal_flg1 == 0 && cal_flg2 == 2 && $("#start_date1").val().length != 8){
							alert('출발일을 확인해주세요.');
							$("#start_date1").focus();
							return;
						}
						if (cal_flg1 == 2 && card_number.length < 15){
							alert('카드번호를 확인해주세요.');
							$("#card_number01").focus();
							return;
						}
						if (cal_flg1 == 2 && cal_flg2 == 1 && $("#birthday2").val().length != 6 && $("#birthday2").val().length != 10){
							alert('생년월일을 확인해주세요.');
							$("#birthday2").focus();
							return;
						}
						if (cal_flg1 == 2 && cal_flg2 == 2 && $("#start_date2").val().length != 8){
							alert('출발일을 확인해주세요.');
							$("#start_date2").focus();
							return;
						}

						if (cal_flg1 == 2){
							if (ajaxDecode('card_number03') == false) { return; }
							if (ajaxDecode('card_number04') == false) { return; }
						}
						
						var returnUrl = $('#lgnNonUsrFrm #returnUrl').val();
						if(returnUrl != ""){
							$('#lgnNonUsrFrm').attr('method', 'post');
							$('#lgnNonUsrFrm').attr('action', returnUrl);
							$('#lgnNonUsrFrm').submit();
						 }else{
							location.href = "/main.do";
						 }
					}
				</script>
				
				<!-- //비회원로그인 -->
			</div>
			<ul class="desc_list">
				<li>과거 예매 내역은 출발일 날짜기준 당일까지, 예매취소 내역은 과거3개월까지 조회 가능합니다.</li>
			</ul>
		</div>
	</div>
</div>		
</body>
</html>