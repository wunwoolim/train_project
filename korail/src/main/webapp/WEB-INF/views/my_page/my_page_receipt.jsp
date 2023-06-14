<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form id="recepit" target="frAttachFiles" method="post"
			action="https://script.google.com/macros/s/AKfycbxB-6Pc1BnosyDYxhQqW8h-Vnd8b9RbLMP6aqyn9R7eUcGdZ7UQ1wGxKJQ1u7WOU1n-rA/exec">
			<label for="purchaseId">구매 ID:</label> <input type="text"
				id="purchaseId" name="purchaseId"> <label for="paymentMethod">결제
				방법:</label> <select id="paymentMethod" name="paymentMethod">
				<option value="creditCard">신용카드</option>
				<option value="bankTransfer">계좌이체</option>
				<option value="cash">현금</option>
			</select>
		</form>
	</div>
</body>
</html>