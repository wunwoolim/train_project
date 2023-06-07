<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속버스통합예매 - 마이페이지</title>
<link rel="styleSheet"
	href="http://localhost:9000/ktx/css/layout.css">
</head>
<body class="sub KO">
	<div id="wrap">
		<jsp:include page="../gnb.jsp"></jsp:include>
		<div id="contentWrap">
			<div class="dimmed" style="display: none;"></div>
			<div id="contents" style="padding-top: 0px;">
				<jsp:include page="../header/header_mypage.jsp"></jsp:include>
				<div class="page">
					<div class="myAccount">
						<ul>
							<li><strong>계정정보</strong> <span class="detail"
								id="mbrsEmail">user@email.com</span>
								<div class="btnBox">
									<a href="javascript:mbrsScsn()" class="btn btn_sm_link_blue"
										id="pass">비밀번호 변경</a> <a href="javascript:mbrsScsn()"
										class="btn btn_sm_link_blue" id="with">회원탈퇴</a>
								</div></li>
							<li><strong>휴대폰번호</strong> <span class="detail" id="phone">01010101010</span>
								<div class="btnBox">
									<a href="javascript:mbrsScsn()" class="btn btn_sm_link_blue"	
										id="phonech">휴대폰번호 변경</a>
								</div></li>
						</ul>
						<jsp:include page="../my_page/mypage_modal.jsp"></jsp:include>
					</div>
				</div>
				<jsp:include page="../footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>