<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/reservationlist.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/login.js"></script>
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
					</div>
				</div>
			</li>
			<!-- 예매확인 -->
			<li>
				<div class="select-box">
					<div class="selectricWrapper selectric-select">
						<div class="selectricHideSelect">
							<select name="" id="" class="select" tabindex="0">
								<option value="/mrs/mrscfm.do" selected="selected">로그인</option>
								<option value="/mrs/mrsrecplist.do">영수증 발행</option>
							</select>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<!------------------------ 로그인하기 ---------------------------->
	<div class="page">
		<div class="login_wrap">
			<!-- 회원로그인 -->
			<form name ="loginForm" action="login_proc.do" method="post">
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
										<!-- <label for="id">아이디를 입력하세요</label> -->
										<input type="text" name="id" id="id" class="input">
									</span>
								</div>
							</li>
							<li>
								<div class="box_inputForm">
									<strong>비밀번호</strong>
									<span class="box_label">
										<!-- <label for="pass">비밀번호를 입력하세요</label> -->
										<input type="password" name="pass" id="pass" class="input" >
									</span>
								</div>
							</li>
						</ul>
							</fieldset>
							<p class="btn_squareBox"><button onclick="fnMngChkCfm(this);" type="button" class="btn_confirm ready" id="btn_login">로그인</button></p>
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

			</div>
			<ul class="desc_list">
				<li>과거 예매 내역은 출발일 날짜기준 당일까지, 예매취소 내역은 과거3개월까지 조회 가능합니다.</li>
			</ul>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</div>		
</body>
</html>