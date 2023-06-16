<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 1</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/join2.css">
 	 <script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	 <script src="http://localhost:9000/ktx/js/join.js"></script>
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>

<div id="contentWrap">
<!--header  -->
		<div class= "title_wrap loginT">
			<jsp:include page="../header.jsp"></jsp:include>
			 <h2 class= "login_ti" >아이디 찾기</h2>
		 </div>	
	<!--body  -->
	
	<div class ="content">
		<div class ="verti_form">
		<div class= "v_noti">
		<p > 본인 인증을 위한 이메일을 입력해 주세요.</p>
		</div>
			
			<div class="login_inner">
				</div>
<!-- content -->
	<div class="content">
		<section class="login">
				<div class="form-group email-form">
					<!--  <label for="email">이메일</label> -->
					 <div class="input-group">
					<input type="text" class="form-control" name="userEmail1" id="userEmail1" placeholder="이메일" >
					<select class="form-control" name="userEmail2" id="userEmail2" >
					<option>@naver.com</option>
					<option>@daum.net</option>
					<option>@gmail.com</option>
					<option>@hanmail.com</option>
					 <option>@yahoo.co.kr</option>
					</select>
				</div>   
			<div class="input-group-addon">
				<button type="button" class="btn btn-primary" id="mail-Check-Btn">본인인증</button>
			</div>
				<div class="mail-check-box">
			<input class="form-control mail-check-input" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
			</div>
				<span id="mail-check-warn"></span>
			</div>
		</section>
		</div>
	</div>
	</div>
</div>
</div>
</body>
</html>