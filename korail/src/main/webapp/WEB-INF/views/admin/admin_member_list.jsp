<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:9000/ktx/css/admin_member.css">
<link rel="stylesheet" href="http://localhost:9000/ktx/css/am-pagination.css">
<script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/ktx/js/am-pagination.js"></script>
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
	           $(location).attr('href', "http://localhost:9000/mycgv_jsp/board_list.do?page="+e.page);         
	    });
		
 	});
</script> 
</head>
<body>
<div>
<jsp:include page="../gnb.jsp"></jsp:include>
<div id="contentWrap">
<!--header  -->
		<div class= "title_wrap loginT">
		<jsp:include page="../header.jsp"></jsp:include>
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
					<td colspan="9" class="paging"><div id="ampaginationsm" class="paging"></div></td>
				</tr>	
			</table>
			
			<form action ="memberList.do" class ="mem_search">
				<select name ="ch1" class ="search_put">
					<option value ="custname">이름</option>
					<option value ="id">아이디</option>
				</select>
				<input type ="text" name ="ch2" class ="search_put1">
				<input type = "submit" class ="search_put" value ="검색하기">
			</form>		
				
			
		</section>
	</div>




<jsp:include page="../footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>