<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 1</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/find.css">
 	 <script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	 <script src="http://localhost:9000/ktx/js/join.js"></script>
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>
<div id="contentWrap">
<div class= "title_wrap joinT">
			<div class="util">
			
			<ul>
			<li>
			<a href="http://localhost:9000/ktx/login.do"><span>로그인</span></a>
			</li>
			<li>
			<a href="http://localhost:9000/ktx/join.do"><span>회원가입</span></a>
			<li>
			<a href="#"><span>마이페이지</span></a>
			</li>
			
			<li>
			<a href="#"><span>결제내역조회</span></a>
			</li>
			<li>
			<a href="#"><span>사이트맵</span></a>
			</li>
			 </ul>
			 </div>
			 <h2 >로그인</h2>
		 </div>	
	
<div class ="content">
	<form name = "verti" action ="#" method ="get">

	<h2 > 회원가입 시 입력한 휴대폰 번호를 입력해주세요.</h2>
	<div> 
	<label>휴대폰 번호</label>
	<input type="text" name="phonenumber" id="phonenumber" placeholder="휴대폰번호를 입력하세요">
	</div>
	<button type="button" class="verti" id="verti">인증번호 발송</button>
	</form>
</div>
</div>
</div>
</body>
</html>