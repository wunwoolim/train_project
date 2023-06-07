<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 리스트</title>
	<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/ktx/js/min.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/ktx/css/min.css">
</head>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
	<div class="title-wrap">
		<ul class="banner">
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
			<li><a href="#">마이페이지</a></li>
			<li><a href ="#">결제내역조회</a></li>
			<li><a href="#">사이트맵</a></li>
		</ul>
		<h1 class="title">공지사항</h1>
	</div>
	<h2 class="title-notice">KTX 홈페이지의 새로운 소식을 확인하세요.</h2>
	<div class="search">
		<form class="search-form" method="get" action="https://search.jsp">
			<select>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="search-notification" maxlength=100 autocomplete="off" placeholder="검색어를 입력하세요" required>
			<button type="submit">검색</button> 
			<button type="reset">다시입력</button> 
		</form>
	</div>
	<table class="notice-search">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일자</th>
		</tr>
		<tr>
			<td>1</td>
			<td>개인정보 처리방침 약관 개정 안내</td>
			<td>2021/07/19</td>
		</tr>
		<tr>
			<td colspan="3">< 1 2 3 4 5 6 7 8 9 10></td>
			
		</tr>
	</table>
	</div>
</body>
</html>