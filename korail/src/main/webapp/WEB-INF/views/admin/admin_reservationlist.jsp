<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/reservationlist.css">
<link rel="stylesheet" href="http://localhost:9000/ktx/css/am-pagination.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/am-pagination.js"></script>
<!-- <script src="http://localhost:9000/ktx/js/reservation_jquery.js"></script> -->
<script>
	$(document).ready(function(){
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: '${maxSize}',	    		// max page size
		    totals: '${totals}',	// total pages	
		    page: '${page}',		// initial page		
		    pageSize: '${pageSize}',			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           $(location).attr('href', "http://localhost:9000/ktx/admin_reservationlist.do?page="+e.page);         
	    });
		
 	});
	
</script> 
<style>
</style>
</head>
<body>
<jsp:include page="../gnb.jsp"></jsp:include>
	<!------------------------ 타이틀 ---------------------------->
	<div id="contentWrap">
		<div class="title_wrap_checkTicketingT">
			<div class="title_wrap">
				<jsp:include page="../header.jsp"></jsp:include>
				<h2>예매 리스트</h2>
			</div>
		</div>
		<!-- ---------------------content---------------------------->		
		<div id="admin_reservationlist">
			<table>
			  <tr class="admin_table_title">
			  	<th>예매일자</th>
			    <th>출발역</th>
			    <th>도착역</th>
			    <th>출발일</th>
			    <th>출발시간</th>
			    <th>도착시간</th>
			    <!-- <th>소요시간</th> -->
			    <th>운임</th>
			    <th>예매번호</th>
			    <th>열차번호</th>
			    <th>좌석번호</th>
			    <th>아이디(회원이름)</th>
			  </tr>
			   <c:forEach var="ovo" items="${orderList}">
			      <c:if test="${ovo.cancel == 0}">
			        <tr class="admin_reserv" id="${ovo.reservnum}">
			          <td>${ovo.rdate}</td>
			          <td>${ovo.sstation}</td>
			          <td>${ovo.dstation}</td>
			          <td>${ovo.depPlandTime}</td>
			          <td>${ovo.stime}</td>
			          <td>${ovo.dtime}</td>
			          <%-- <td>${ovo.runtime}</td> --%>
			          <td>${ovo.price}</td>
			          <td class="admin_reservnum">${ovo.reservnum}</td>
			          <td>${ovo.trainnum}</td>
			          <td>${ovo.chairnum}</td>
			          <td>${ovo.id}</td>
			        </tr>
			      </c:if>
			    </c:forEach>
			    <tr>
			    	<td colspan="11"><div id="ampaginationsm"></div></td>
			    </tr>
			</table>
		  	<div>
				<input type="hidden" id="admin_input" name="admin_input">			  	
		  	</div>
		  	<button></button>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>