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

<div id="contentWrap">
<!--header  -->
		<div class= "title_wrap loginT">
			<jsp:include page="../header.jsp"></jsp:include>
			 <h2 class= "login_ti" >로그인</h2>
		 </div>	
	<!--body  -->
	
	<div class ="page">
		<div class ="login_wrap">
		
			<h1 class ="title" >회원  로그인 </h1>
			<p class ="login_int">
			<span style="color:lightblue">코레일 통합 예매 홈페이지</span>는 코레일 모바일앱의 회원아이디와 비밀번호로 이용이가능합니다.			
			</p>
			<div class="login_inner">
			<form name ="loginForm"  action="login_proc.do" method="post">
				<div class= "loginBox">
				<ul class= "loginBoth">
						<li> 
						<div class="login_id">
						<h4>아이디</h4>
                		<input type="text" name="id" class ="input"id="id" placeholder="아이디를 입력하세요">
						</div>
						</li>	
						<li> 						
						<div class="login_pass">
						<h4>비밀번호</h4>
                		<input type="text" name="pass" class ="input"id="pass" placeholder="비밀번호를 입력하세요">
						</div>
						</li>
						
				
				</ul>
				</div>
				<div class="btn_logbox1">
					<p class ="btn_login">
						<button type="button" class ="btn_style2" id="btn_login"> 로그인 </button>
						<button type="button" class ="btn_style2" id="btn_reset"> 다시쓰기 </button>
				</div>
					</p>
				<div class="box_find">
					<a href ="http://localhost:9000/train_project/find_id1.do"><span class ="find1"> 아이디 찾기</span></a>
					<a href ="#"> <span>비밀번호 찾기</span></a>
				</div>
				
				
				
			
			</form>
				</div>
			</div>
		</div>
	
	<!--footer  -->
	<jsp:include page="../footer.jsp"></jsp:include>

	</div>
</div>

</body>
</html>