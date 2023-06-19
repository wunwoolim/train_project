<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" type="text/css"
	href="http://localhost:9000/ktx/css/calender.css">
</head>
<body>
	<div class='rap'>
		<div class="header">
			<div class="cbtn prevDay"></div>
			<h2 class='dateTitle'></h2>
			<div class="cbtn nextDay"></div>
		</div>
		<div class="grid dateHead">
			<div style="color: #e54c2e;">일</div>
			<div>월</div>
			<div>화</div>
			<div>수</div>
			<div>목</div>
			<div>금</div>
			<div style="color: #3078bf;">토</div>
		</div>
		<div class="grid dateBoard"></div>
	</div>
	<div class='rap_s' style="display: none; width:0; height:0;">
	</div>
</body>
</html>