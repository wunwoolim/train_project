<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입2</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/join2.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/mailAuth.js"></script>
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>
<!--header  -->

<div id="contentWrap">
<div class= "title_wrap loginT">
			<jsp:include page="../header.jsp"></jsp:include>
			 <h2 class="login_ti">회원가입</h2>
</div>	
	




<div class ="content">
	<div class = "verti_form">
	
	<form name = "verti" action ="joinpage.do" method ="get">
	<div class= "v_noti">
	<p class="join2_p"> 본인 인증을 위한 이메일을 입력해 주세요.</p>
	</div>
                	 
						<div class="login_id">
                		 <div class="input-group">
							<input type="text" class="form-control" name="userEmail1" id="userEmail1" placeholder="이메일"  > @
							<input type="text"  class="email_input"name ="userEmail2" id="userEmail2"  placeholder ="이메일 주소를 입력해주세요" > 
							<select  id ="userEmail3" name="userEmail3">
						<option value="default">선택</option>
						<option value="naver.com">네이버</option>
						<option value="gmail.com">구글</option>
						<option value="daum.net">다음</option>
						<option value="korea.com">코리아</option>
						<option value="self">직접입력</option>		
							</select>
						</div>  
                	
	<ul class= "loginBoth">
		<li>		
				<button type="button"  id="mail-Check-Btn"  class ="btnJoin" >  인증번호 발송 </button>
		</li>	
	
	</ul>	
						</div>	
			<div class="mail-check-box">
					
					인증번호를 입력해주세요
				<input class="form-control mail-check-input" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
					<span id="mail-check-warn"></span>
					<button type="button"  id="authcheckBtn"  class ="btnJoin" >  인증번호 확인 </button>
				</div>
				
									
	</form>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	</div>




</div>
</div>

</body>
</html>