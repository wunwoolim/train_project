$(document).ready(function(){
	
	// 좌석 만들기 
	let width = 4;
	let height  = 10;
	let count = 0;
	
	let seat = "";
	
	for(let i = 0; i<height; i++){
				seat += "<div>";
		for(let j = 0; j<width; j++){
				count++;
				seat +="<div class='box'>";
			 	seat +="<span class='seatBox'>";
				seat +="<img src='http://localhost:9000/ktx/images/seat_p.gif'>";
				seat +=  count 
				seat +="</span></div>";
		
				
		}
				seat +="</div>";
	}
	
	$(".seatList").append(seat);
	
	
	//좌석 선택 이벤트
	
	$(".box").click(function(){
		//alert($("#chldCnt").text() + "호차 " + $(this).text()+"좌석");
		let seatNum = $("#chldCnt").text() + "호 " + $(this).text()+"좌석";
		$("#seatNum").val(seatNum);
		$("#passengersNum").text($("#adltCnt").text());
		let ticketQty = $("#adltCnt").text();
		$("#ticketQty").val(ticketQty);
		
	});
	
	//모달창의 로그인 비로그인 클릭시 이벤트
	$("#btn_nonmember").click(function(){
		seatForm.submit();
	});
	
	$("#btn_confirm").click(function(){
		seatForm.submit();
	});
	
	
	
	
	
	
	
	
	

	
	//선택 완료 시 로그인 모달창
	$(".btn_selectSeat").click(function() {
		  $(".modal").css("display", "block");
	  });
	  
	  $(".modalclose").click(function() {
		  $(".modal").css("display", "none");
	  });
	  
	  $(window).click(function(event) {
	      if (event.target == $("#myModal")[0]) {
	        $("#myModal").fadeOut();
	      }
	    });
	  
	  
	  //새로고침
	  $(".ico_refresh").click(function(){
			 location.reload();
		});
		
	  //수정 -1
	  $("#back1").click(function(){
			history.go(-1);
		});
	  
	  
	  //수정 -2
	  $("#back2").click(function(){
			history.go(-2);
		});
	  
	  //일반 인원 증감 이벤트
	  $(".adult_add").click(function() {
		  var count = parseInt($("#adltCnt").text()) + 1; // 현재 카운트 값을 가져와 1 증가
		  $("#adltCnt").text(count); // 증가된 값을 화면에 표시
		});

		$(".adult_minus").click(function() {
		  var count = parseInt($("#adltCnt").text()) - 1; // 현재 카운트 값을 가져와 1 감소
		  if (count < 1) {
		    count = 1; // 음수 값이 되지 않도록 조정
		  }
		  $("#adltCnt").text(count); // 감소된 값을 화면에 표시
		});
	  
		
		//기차 호실 증감 이벤트
		$(".Kind_add").click(function() {
			  var count = parseInt($("#chldCnt").text()) + 1; // 현재 카운트 값을 가져와 1 증가
			  if(count >10){
			  	count = 10;
			  }
			  
			  $("#chldCnt").text(count); // 증가된 값을 화면에 표시
			});

		$(".Kind_minus").click(function() {
			  var count = parseInt($("#chldCnt").text()) - 1; // 현재 카운트 값을 가져와 1 감소
			  if (count < 1) {
			    count = 1; // 음수 값이 되지 않도록 조정
			  }
			  $("#chldCnt").text(count); // 감소된 값을 화면에 표시
			});
			
	  
		//비회원 예매 버튼 이벤트
		$("#btn_nonmember").click(function(){
			//window.location.href = "http://localhost:9000/ktx/train_reservation_stplcfmpym.do";
		});
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	    
});