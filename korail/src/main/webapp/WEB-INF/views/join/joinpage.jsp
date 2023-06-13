<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<!-- content -->
	<div class="content">
		<section class="join">
			<h1 class="title">회원가입</h1>
			<form name="joinForm" action="join_proc.do" method="post" class="joinput">
				<ul>
					<li>
						<label>아이디</label>
						<input type="text" id ="id"  name ="id" placeholder="*8자 이상 영문으로 입력해주세요" class="input1" id="id" >
						<button type="button" class="btn_style2" id="btnIdCheck">중복체크</button>
						<span id="idcheck_msg"></span>
					</li>
					<li>
						<label>비밀번호</label>
						<input type="password" name="pass" class="input1" id="pass" placeholder ="비밀번호 입력(문자,숫자,특수문자 포함 8~20자)">
					</li>
					<li>
						<label>비밀번호 확인</label>
						<input type="password" name="cpass" class="input1" id="cpass" placeholder="비밀번호를 재입력해주세요">
                        <span id="cmsg"></span>						     
					</li>
					<li>
						<label>성명</label>
						<input type="text" name="name" class="input1" id="name" placeholder ="성명을 입력해주세요" >
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="email1" id="email1" placeholder ="이메일을 입력해주세요"> @
						<input type="text" name="email2" id="email2" placeholder ="이메일 주소를 입력해주세요">
						<select id="email3" id="email3">
							<option value="default">선택</option>
							<option value="naver.com">네이버</option>
							<option value="gmail.com">구글</option>
							<option value="daum.net">다음</option>
							<option value="korea.com">코리아</option>
							<option value="self">직접입력</option>
						</select>
					</li>
					<li>
						<label>휴대폰</label>
						<input type="radio" name="tel" value="skt"><span>SKT</span>
						<input type="radio" name="tel" value="lgu+"><span>LGU+</span>
						<input type="radio" name="tel" value="kt"><span>KT</span>
						<select name="phonenumber1" id="phonenumber1">
							<option value="default">선택</option>
							<option value="011">011</option>
							<option value="010">010</option>
							<option value="017">017</option>
						</select>
						- <input type="text" name="phonenumber2" id="phone2">
						- <input type="text" name="phonenumber3" id="phone3">				
					</li>
					<li>
						<label>출생연도</label>
						<input type="text" name="birth" class="input1" id="birth" placeholder ="출생연도 6자리 입력해주세요" maxlength="6">
					</li>
					<li>
						<label>성별</label>
						<input type="radio" name="gender" value="m"><span>남자</span> 
						<input type="radio" name="gender" value="g"><span>여자</span>
					</li>
					<li>
						<button type="button" class="btn_style" id="btnJoin">가입하기</button>
						<button type="reset" class="btn_style">다시입력</button>
					</li>			
				</ul>
			</form>
		</section>
	</div>	 
				 
				 
				 
	
	
	</div>
	</div>
	</body>
</html>