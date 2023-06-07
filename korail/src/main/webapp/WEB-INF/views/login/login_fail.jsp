<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/login.css">
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>
<div id="contentWrap">
<!--header  -->
		<div class= "title_wrap loginT">
			<div class="util">
			
			<ul>
			<li>
			<a href="http://localhost:9000/ktx/login.do"><span>로그인</span></a>
			</li>
			<li>
			<a href="http://localhost:9000/ktx/join.do"><span>회원가입</span></a>
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
			 <h2 class= "login_ti" >로그인</h2>
		 </div>	
<!-- contents  -->

<div class="content">
		<section class="login_fail">
			<h1 class="title">로그인 실패</h1>
			<img src="http://localhost:9000/ktx/login_fail.do">
			<h1 class="title">로그인에 실패하셨습니다.</h1>
			<a href="http://localhost:9000/ktx/login.do"><span>로그인</span>
				<button type="button" class="btn_style">로그인 페이지 이동</button>
			</a>
		</section>
	</div>




</div>
</div>
</body>
</html>