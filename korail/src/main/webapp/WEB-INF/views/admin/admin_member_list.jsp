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
	           $(location).attr('href', "http://localhost:9000/ktx/admin_member.do?page="+e.page);         
	    });
		
		$("#member_search").click(function(){
			if ( $("#category").val() == "custname"){
					if($("#cvalue").val() == ""){
						alert("이름을 입력해주세요");
						$("#cvalue").focus(); 
						return false;
					}
			}else if($("#category").val() =="id"){
					if($("#cvalue").val() == ""  ){
						alert("아이디를 입력해주세요");
						 $("#cvalue").focus(); 
						 return false;
					}
			}
			sform1.submit();		

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
			 <h2 class= "login_ti" >관리자 - 회원관리</h2>
		 </div>	
<!--contents  -->
<div class="admin_member">
		<section class="notice">
			<h1 class="title_am"></h1>			
			<table class = "amem_table">
			<thead>
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
			</thead>
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
					<td colspan="9" class="paging"><div id="ampaginationsm" class="paging" style="border:none" style ="border-top:1px solid black"></div></td>
				</tr>	
			</table>
			
			<form action ="admin_member_search.do" class ="mem_search" name ="sform1" method ="POST">
				<select name ="category" class ="search_put" id="category">
					<option value ="total">전체</option>
					<option value ="custname">이름</option>
					<option value ="id">아이디</option>
				</select>
				<input type ="text" name ="cvalue" class ="search_put1" id="cvalue">
				<input type ="hidden" name ="page" value=1>
				<button type = "button" class ="search_put"  id ="member_search">검색하기</button>
			</form>		
				
			
		</section>
	</div>




<jsp:include page="../footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>