<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/header.css">
</head>
<body>
	<div class="util">
	<c:choose>
		<c:when test="${ sessionScope.svo == null}">
				<ul class="clfix_login">
					<li class="login"><a href="http://localhost:9000/ktx/login.do"><span>로그인</span></a></li>
					<li><a href="http://localhost:9000/ktx/join.do">회원가입</a></li>
					<li><a href="http://localhost:9000/ktx/pmyhis.do">결제내역조회</a></li>
					<li><a href="http://localhost:9000/ktx/sitemap.do">사이트맵</a></li>
					
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
					<c:if test="${sessionScope.svo.name != null }">
					<li class="account">${sessionScope.svo.name}님! 반갑습니다~</li>
					</c:if>
					<li class="logout"><a href="http://localhost:9000/ktx/logout.do"><span>로그아웃</span></a></li>
					<li><a href="http://localhost:9000/ktx/mypage.do">마이페이지</a></li>
					<li><a href="http://localhost:9000/ktx/pmyhis.do">결제내역조회</a></li>
					<li><a href="http://localhost:9000/ktx/sitemap.do">사이트맵</a></li>
					<c:if test="${sessionScope.svo.id == 'admin'}">
					<li><a href="http://localhost:9000/ktx/admin_main.do" style="color:#cfa346; font-weight:bold;">admin</a></li>
					</c:if>
				</ul>
			</c:otherwise>
	</c:choose>
	</div>
</body>
</html>