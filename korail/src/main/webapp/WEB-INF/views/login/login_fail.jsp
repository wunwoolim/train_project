<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/login.css">
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
			<h2>로그인 실패</h2>
		</div>
	</div>
<!-- contents  -->

<div class="content">
		<section class="login_fail">
			<div class ="fail_image">
			<img src="http://localhost:9000/ktx/images/login_fail.png" >
			</div>
			<div class= "fail_alert">
			<h1 class="failtitle">로그인에 실패하셨습니다.</h1>
			<a href="http://localhost:9000/ktx/login.do"><span></span>
				<button type="button" class="btn_fail" >로그인 페이지 이동</button>
			</a>
			</div>
		</section>
	</div>




</div>
</div>
</body>
</html>