$(document).ready(function(){
	trInitAjax(1);
	
	function trInitAjax(trnumber) {
		//alert(trnumber);
	  $.ajax({
	    url: "train_reservation_satschc_json.do?trnumber="+trnumber,
	    success: function (result) {
	      //alert(result);
	      let jdata = JSON.parse(result);
	      let seatList = jdata.seatList;
	
	      //alert(seatList[0].seat);
	
	      // 좌석 만들기
	      let width = 4;
	      let height = 10;
	      let count = 0;
	      let seat = "";
	
	      for (let i = 0; i < height; i++) {
	        seat += "<div>";
	        
	        for (let j = 0; j < width; j++) {
	          count++;
	          seat += "<div class='box'>";
	          seat += "<span class='seatBox'>";
	          
	          let isOccupied = false;
	          
	          for (let seatObj of seatList) {
	          
	            if (seatObj.seat == count) {
	              seat += "<img src='http://localhost:9000/ktx/images/seat_c.gif' style='opacity: 0.5;'>";
	              isOccupied = true;
	              break;
	            }
	          }
	          
	          if (!isOccupied) {
	          	let seatNumber = count.toString().padStart(2, '0');
	            seat += "<img src='http://localhost:9000/ktx/images/seat_p.gif' id='chairImg_${count}' style='opacity: 0.5;'>";
	          }
	          
	          seat +=  count.toString().padStart(2, '0');
	          seat += "</span></div>";
	        }
	        seat += "</div>";
	      }
	
	      $(".seatList").empty();
	      $(".seatList").append(seat);
	    } //success
	  }); //ajax
	} //initAjax
	
	
	
	
	
	
	
	//좌석 선택 이벤트
	
	$(".seatList").on("click", "[id^='chairImg_']", function() {
		  let seatNum = $("#chldCnt").text() + "호 " +  $(this).parent().text() + "좌석";
		  
		  $("#seatNum").text(seatNum);
		  $("#seatNum1").val(seatNum);
		  $("#seatNum2").val(seatNum);
		  //alert(seatNum);
		  $(".box img").css("opacity", "0.5");
		  $(this).css("opacity", "1.0");
		  $("#passengersNum").text($("#adltCnt").text());
		  let ticketQty = $("#adltCnt").text();
		  $("#ticketQty1").val(ticketQty);
		  $("#ticketQty2").val(ticketQty);
	});
	
	
	//모달창의  비로그인 클릭시 이벤트
	$("#btn_nonmember").click(function(){
		lgnUsrInfForm.submit();
	});
	
	//모달창의  로그인 클릭시 이벤트
	$("#btn_confirm").click(function(){
		loginForm.submit();
	});
	
	
	
	//모달창의 로그인 비로그인 클릭시 이벤트 - 예매 변경
	$("#btn_nonmember_update").click(function(){
		updateseatForm.submit();
	});
	
	$("#btn_confirm_update").click(function(){
		updateseatForm.submit();
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
		$("#Kind_add").click(function() {
			var trnumber = parseInt($("#chldCnt").text()) + 1;// 현재 카운트 값을 가져와 1 증가
			//alert(trnumber);
			  if(trnumber >9){
			  	trnumber = 9;
			  }
			  
			  $("#chldCnt").text(trnumber); // 증가된 값을 화면에 표시
			  trInitAjax(trnumber);
			});

		$("#Kind_minus").click(function() {
			  var trnumber = parseInt($("#chldCnt").text()) - 1; // 현재 카운트 값을 가져와 1 감소
			  if (trnumber < 1) {
			    trnumber = 1; // 음수 값이 되지 않도록 조정
			  }
			  $("#chldCnt").text(trnumber); // 감소된 값을 화면에 표시
			  trInitAjax(trnumber);
			});
			
	  
		//비회원 예매 버튼 이벤트
		$("#btn_nonmember").click(function(){
			//window.location.href = "http://localhost:9000/ktx/train_reservation_stplcfmpym.do";
		});
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	    
}); //ready