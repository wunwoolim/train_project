<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/admin_member.css">
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
<!--contents  -->
<div class="admin_member">
		<section class="notice">
			<h1 class="title">관리자 - 회원관리</h1>			
			<table class = "amem_table">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>생일</th>
					<th>성별</th>
					<th>가입일자</th>
				</tr>
				<c:forEach var="memberVo" items="${list}">
				<tr>
					<td>${memberVo.rno}</td>
					<td>${memberVo.id }</td>
					<td>${memberVo.pass }</td>
					<td>${memberVo.name }</td>
					<td>${memberVo.email }</td>
					<td>${memberVo.pnumber }</td>
					<td>${memberVo.birth }</td>
					<td>${memberVo.gender }</td>
					<td>${memberVo.mdate }</td>
				</tr>	
				</c:forEach>
				<tr>
					<td colspan="5"><div id="ampaginationsm"></div></td>
				</tr>	
			</table>
			
			
			
		</section>
	</div>





</div>
</div>
</body>
</html>