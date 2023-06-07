<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입2</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/join2.css">
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>
<!--header  -->

<div id="contentWrap">
<div class= "title_wrap loginT">
			<div class="util">
			
			<ul>
			<li>
			<a href="http://localhost:9000/train_project/login.do"><span>로그인</span></a>
			</li>
			<li>
			<a href="http://localhost:9000/train_project/join.do"><span>회원가입</span></a>
			</li>
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
			 <h2 class="login_ti">회원가입</h2>
		 </div>	
	




<div class ="content">
	<div class = "verti_form">
	
	<form name = "verti" action ="#" method ="get">
	<div class= "v_noti">
	<h2 > 본인 인증을 위한 이메일을 입력해 주세요.</h2>
	</div>
		<h4>이메일</h4>
	<ul class= "loginBoth">
						<li> 
						<div class="login_id">
                		<input type="text" name="usrId" class ="input"id="id" placeholder="이메일을  입력하세요">
						</div>
						</li>
		<li>		
				<button type="button"  class ="btnJoin">  인증번호 발송</button>
		</li>	
	
	</ul>	
					
	</form>
	</div>
	</div>




</div>
</div>

</body>
</html>