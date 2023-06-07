<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 1</title>
</head>
<body>
<div>
<div id="contentWrap">
<div class= "head">
	
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
	
	
	 </ul>
	</div>



<div class ="content">

	<h2 > 회원가입시 입력한 정보를 입력하세요.</h2>
			<form name = "find" action ="#" method ="get">
			<ul>
			<li>
			<label>아이디</label>
			<input type="text" name="phonenumber" id="phonenumber" placeholder="아이디를 입력하세요">
			<button type="button" class="find" id="find">확인</button>
			</li>
			</ul>
			</form>
	
</div>
</div>
</div>
</body>
</html>