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
			<jsp:include page="../header.jsp"></jsp:include>
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
				<button type="button"  class ="btnJoin" onclick ="location.href='http://localhost:9000/ktx/join3.do'">  인증번호 발송</button>
		</li>	
	
	</ul>	
					
	</form>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	</div>




</div>
</div>

</body>
</html>