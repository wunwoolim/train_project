<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/reservationlist.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/reservation_jquery.js"></script>

<style>
</style>
</head>
<body>
<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
		<div class="title_wrap_checkTicketingT">
			<div class="title_wrap">
				<div class="util">
					<ul class="clfix">
						<li class="account">sohyun990502@naver.com</li>
						<li class="logout"><a href="#"><span>로그아웃</span></a></li>
						<li><a href="#">마이페이지</a></li>
						<li><a href="#">결제내역조회</a></li>
						<li><a href="#">사이트맵</a></li>
					</ul>
				</div>
				<!-- <a href="#" class="back">back</a>
				<a href="#" class="mo_toggle">메뉴</a> -->
				<h2>KTX 시간표</h2>
			</div>
		</div>
		<!-- ---------------------content---------------------------->
		<div id="admin_reservationlist">
			<table>
			  <tr>
			    <th>출발역</th>
			    <th>도착역</th>
			    <th>출발일</th>
			    <th>출발시간</th>
			    <th>소요시간</th>
			    <th>운임</th>
			    <th>예매번호</th>
			    <th>열차번호</th>
			    <th>좌석번호</th>
			    <th>아이디(회원이름)</th>
			  </tr>
			  <c:forEach var="ovo" items="${orderList}">
				<c:if test="${ovo.cancel == 1}">
			  <tr>
			    <td>${ovo.sstation}</td>
			    <td>${ovo.dstation}</td>
			    <td>${ovo.depPlandTime}</td>
			    <td>${ovo.stime}</td>
			    <td>${ovo.runtime}</td>
			    <td>${ovo.price}</td>
			    <td>${ovo.reservnum}</td>
			    <td>${ovo.trainnum}</td>
			    <td>${ovo.charnum}</td>
			    <td>${ovo.mid}</td>
			  </tr>
			  </c:if>
			  </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>