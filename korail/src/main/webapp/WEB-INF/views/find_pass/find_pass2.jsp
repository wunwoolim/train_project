<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 1</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/find.css">
 	 <script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	 <script src="http://localhost:9000/ktx/js/find.js"></script>
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>

<div id="contentWrap">
<!--header  -->
		<div class= "title_wrap loginT">
			<jsp:include page="../header.jsp"></jsp:include>
			 <h2 class= "login_ti" >비밀번호 찾기</h2>
		 </div>	
	<!--body  -->
	
	<div class ="content">
		<div class ="verti_form">
		<div class= "v_noti">
		</div>
			
			<div class="login_inner">
				</div>
<!-- content -->
	<div class ="content">
	<div class = "verti_form">
	
	<div class= "v_noti">
	<p class="join2_p"> 회원님의 비밀번호는 다음과 같습니다.</p>
	
	</div>
      <div class="input-group">
						<label>비밀번호</label>
						<input type="text" name="userEmail1" id="email1" readonly value="${mvo.pass}"> 
      
      
      </div>            	 
             <div class="box_searchId">
					<a href="http://localhost:9000/ktx/login.do" onclick="lgnSearchPwd();" style="margin-left:50px"><span class="ico_searchPW">로그인하기</span></a>
             </div>
             
                	
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	</div>
	</div>
	</div>
</div>
</div>
</body>
</html>