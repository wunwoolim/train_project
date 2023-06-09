<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입3</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/join3.css">
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
			 <h2 class= "login_ti" >회원가입</h2>
		 </div>	
	
<div class="page">
	<div class ="wrapper">
		<h1> 회원정보를 입력해주세요</h1>
		
		<form name ="joinForm"  action ="join_proc.do"  method ="post">
		<div class ="join_bo">
		<ul class="join_list">
		<li>
		<!-- <div class ="join_1" id="info_id"> -->
			<div>	<p>아이디</p><span id="idcheck_msg"></span> </div>
			<input type="text" id ="id"  class ="join_input1" name ="id" placeholder ="아이디입력(6~20자)"/>
			<button type="button" class ="check_btn" id="btnIdCheck" >중복체크</button> 
			<span id="idcheck_msg"></span>
	<!-- 	</div> -->	
		</li>	
		
		<li>
		<div>	<p>비밀번호</p> </div>
			<input type="text" class="join_input" name ="pass" id ="pass" 
			aceholder ="비밀번호 입력(문자,숫자,특수문자 포함 8~20자)">
		</li>
		<li>	
		<div>	<p>비밀번호 확인</p> </div>
			<input type="text" class="join_input" name ="cpass" id ="cpass" placeholder ="비밀번호 재입력">
			 <span id="cmsg"></span>
		</li>
		<li>
		<div>	<p>성명</p> </div>
			<input type="text" class="join_input" name ="name" id ="name" placeholder ="성명" >
		</li>	
		<li>	
		<div>	<p>이메일</p> </div>
			<input type="text"  class="email_input" name ="email1" id="email1"  placeholder ="이메일을 입력해주세요"> @
			<input type="text"  class="email_input"name ="email2" id="email2"  placeholder ="이메일 주소를 입력해주세요"> 
			<select id ="email3" class="btn_ch" >
				<option value="default">선택</option>
				<option value="naver.com">네이버</option>
				<option value="gmail.com">구글</option>
				<option value="daum.net">다음</option>
				<option value="korea.com">코리아</option>
				<option value="self">직접입력</option>			
			</select>
		</li>	
		<li>	
		<div>	<p>휴대폰 번호</p> </div>
			<input type="radio" name="tel" value="skt" ><span>SKT</span>
						<input type="radio" name="tel" value="lgu+"><span>LGU+</span>
						<input type="radio" name="tel" value="kt"><span>KT</span>
			<input type="text"  class="join_input2" name ="pnumber" id="pnumber"  placeholder ="휴대폰 번호 입력 - 제외 11자리 입력">			
		</li>	
		<li >
		<div>	<p>출생년도</p> </div>
			<input type="text"  class="join_input" name ="birth" id="birth"  placeholder ="출생년도 4자리를 입력해주새요">
		</li>	
		<li>
			<div>	<p>성별</p> </div>
			<label class="space"> </label>
			<span class="girl_jo">여자</span><input  type ="radio" name ="gender" id ="gender" value="m" >
			<span class="girl_jo">남자</span><input  type ="radio"  name ="gender" id ="gender"  value ="g" >
		</li>
			
		<li style ="text-align:center" >		
				<button type="button" id ="btnJoin" >  회원가입</button>
		</li>	
				</ul>
		</div>
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	</div>
</body>
</html>