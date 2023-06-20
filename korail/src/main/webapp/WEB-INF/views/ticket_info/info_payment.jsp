<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결제 방법</title>
	<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/ktx/js/min.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/ktx/css/min.css">
</head>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
	<div class="title-wrap info">
		<jsp:include page="../header.jsp"></jsp:include>
		<h2 class="title_station">결제 안내</h2>
	</div>
	<h2 class="title-payment">홈페이지를 통한 예매 시 카드결제 또는 계좌이체의 결제수단을 이용하실 수 있습니다.</h2>
	<h3 class="title-payment">카드결제</h3>
	<p class="payment-content">카드 사용시 카드사 제한은 없으며 일시불 결제만 가능합니다.</p>
	<h3 class="title">계좌이체</h3>
	<div class="payment">
		<ul>
			<li>예매가 완료된 후 예매확인/취소/변경 메뉴를 통해 예매 성공 여부를 확인하시기 바랍니다.</li>
			<li>계좌이체 예매 후 승차권 기차역 발권 시에는 예매 당시 입력하신 휴대폰번호(회원의 경우 가입 시 입력한 휴대폰번호)와 생년월일이 필요합니다.</li>
		</ul>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>