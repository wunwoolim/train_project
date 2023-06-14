<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 리스트</title>
    <script src="http://localhost:9000/ktx/js/jquery-3.6.4.min.js"></script>
	<script src="http://localhost:9000/ktx/js/min.js"></script>
	<script src="http://localhost:9000/ktx/js/am-pagination.js"></script>
	<link rel="stylesheet" href="http://localhost:9000/ktx/css/min.css">
	<link rel="stylesheet" href="http://localhost:9000/ktx/css/am-pagination.css">
	<style>
		#ampaginationsm {
			width: 100%;
		}
	</style>
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
	           $(location).attr('href', "http://localhost:9000/ktx/notice_list.do?page="+e.page);         
	    });
		
 	});
</script>
</head>
<body>
<div class="body">
<jsp:include page="../gnb.jsp"></jsp:include>
</div>
	<div id="contentWrap">
	<div class="title-wrap">
		<jsp:include page="../header.jsp"></jsp:include>
		<h2 class="title">공지사항</h2>
	</div>
	<h2 class="title-notice">KTX 홈페이지의 새로운 소식을 확인하세요.</h2>
	<div class="search">
		<form class="search-form" action="notice_list_search.do" name="notice_search" method="post" >
			<select name="category" id="category" class="notice_search">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="title_content">제목+내용</option>
				<option value="all">전체조건</option>
			</select>
			<input type="text" name="cvalue" id="cvalue" maxlength=100 autocomplete="off" placeholder="검색어를 입력하세요" required>
			<input type="hidden" name="page" value="1">
			<button type="button" id="notice_search">검색</button> 
			<button type="reset">다시입력</button> 
		</form>
	</div>
	<table class="notice_search">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>등록일자</th>
		</tr>
		<c:forEach var="noticeVo" items="${list}">
		<tr>
			<td>${noticeVo.rno}</td>
			<td><a href="notice_content.do?nid=${noticeVo.nid}">${noticeVo.ntitle}</a></td>
			<td>${noticeVo.nhits}</td>
			<td>${noticeVo.ndate}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" class="paging"><div id="ampaginationsm" class="paging"></div></td>
		</tr>
	</table>
	<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>