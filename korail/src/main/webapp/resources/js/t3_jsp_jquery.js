$(document).ready(function() {
	
	

	/***************************************************************************
	 * 
	 *	Mypage
	 * 
	 **************************************************************************/
			/**
			 * 마이페이지 '회원탈퇴' 클릭
			 */
		
			$("#with").click(function() {
				if ($(".with_modal").css("display") === "none") {
					$(".with_modal").toggle().css("display", "block");
					$(".with_modal_contents").toggle().css("display", "block");
				}
			});
			
			/**
			 * 마이페이지 '비밀번호 변경' 클릭
			 */
			
			$("#pass").click(function() {
				if ($(".with_modal").css("display") === "none") {
					$(".with_modal").toggle().css("display", "block");
					$(".pass_modal_cotents").toggle().css("display", "block");
				}
			});
			
			/**
			 * 마이페이지 '휴대폰번호 변경' 클릭
			 */
		
			$("#phonech").click(function() {
				if ($(".with_modal").css("display") === "none") {
					$(".with_modal").toggle().css("display", "block");
					$(".phonenum_modal_cotents").toggle().css("display", "block");
				}
			});
		
			/**
			 * 마이페이지 회원탈퇴 취소, 영역 외 클릭
			 */
		
			$(".remodal-cancel").click(function() {
				$(".with_modal").toggle().css("display", "none");
				$(".with_modal_contents").toggle().css("display", "none");
				$(".pass_modal_cotents").toggle().css("display", "none");
				$(".phonenum_modal_cotents").toggle().css("display", "none");
			});

			
			/**
			 * 마이페이지 회원탈퇴 완료
			 */
			
			$("#with-confirm").click(function() {
				if ($("input[name='usrPw']").val() === "") {
					withForm.submit();
					$(".with_modal").toggle().css("display", "none");
					alert("회원탈퇴 완료");
					// 로그아웃 처리
				}
			});
			
			/**
			 * 마이페이지 비밀번호 변경 완료
			 */
			
			$("#pass-confimr").click(function() {
				if ($("input[name='usrPw3']").val() === "") {
					passForm.submit();
					$(".with_modal").toggle().css("display", "none");
					alert("비밀번호 변경 완료");
					// 로그아웃 처리
				}
			});
			
			/**
			 * 마이페이지 비밀번호 확인
			 */
			
			$("#usrPw3").on("blur", function(){		
				if($("#usrPw3").val() != "" && $("#usrPw3").val() != ""){
					if($("#usrPw2").val() == $("#usrPw3").val()){
						$("#cmsg").text("비밀번호가 동일합니다").css("color","blue")
						.css("font-size","11px").css("display","block");
						$("#usrPw2").focus();
					}else{
						$("#cmsg").text("비밀번호가 동일하지 않습니다. 다시  입력해주세요")
						.css("color","red").css("font-size","11px").css("display","block");
						
						$("#usrPw2").val("").focus();
					}
				}
			});
			
			/**
			 * 마이페이지 휴대폰번호 변경 완료
			 */
			
			$("#phone-confirm").click(function() {
				if ($("input[name='usrPw5']").val() === "") {
					phonenumForm.submit();
					$(".with_modal").toggle().css("display", "none");
					alert("비밀번호 변경 완료");
					// 로그아웃 처리
				}
			});
			
	/***************************************************************************
	 * 
     *	gnb
	 * 
	***************************************************************************/
	/**
	 * gnb 클릭 이벤트
	 */
	$(".depth").click(function() {
		if ($(".depth2").css("display") === "none") {
			$(".depth2").toggle().css("display", "block");
		} else {
			$(".depth2").toggle().css("display", "none");
		}
	});
	
	
	/***************************************************************************
	 * 
     *	payment_history_view
	 * 
	***************************************************************************/

	
	/**
	 * 결제내역 조회 달력 클릭 이벤트 
	 */
	
	//조회 시작일
	$(".ui-datepicker-trigger1").click(function() {
		  window.$rap = $(".rap");
		  if ($rap.css("display") === "none" || $rap.css("transform") !== "translate(357px, -32px)") {
		    $rap.toggle().css("transform", "translate(357px, -32px)");
		    $(".rap_s").css("display", "block");
		  } else if ($rap.css("display") === "block" && $rap.css("transform") === "translate(357px, -32px)") {
		    $rap.toggle();
		    $(".rap_s").css("display", "none");
		  }
		});
	
	$(".ui-datepicker-trigger2").click(function() {
		$rap = $(".rap");
		if ($rap.css("display") === "none" || $rap.css("transform") !== "translate(590px, -32px)") {
			$rap.toggle().css("transform", "translate(590px, -32px)");
		    $(".rap_s").css("display", "none");
		} else if ($rap.css("display") === "block" && $rap.css("transform") === "translate(590px, -32px)") {
			$rap.toggle();
		}
	});

	/**
	 * 결제내역 조회 달력 상세 조회
	 */

	const makeCalendar = (date) => {
		  window.currentYear = new Date(date).getFullYear();
		  window.currentMonth = new Date(date).getMonth() + 1;

		  const firstDay = new Date(date.setDate(1)).getDay();
		  const lastDay = new Date(currentYear, currentMonth, 0).getDate();

		  const limitDay = firstDay + lastDay;
		  const nextDay = Math.ceil(limitDay / 7) * 7;

		  let htmlDummy = '';

		  for (let i = 0; i < firstDay; i++) {
		    htmlDummy += `<div class="noColor"></div>`;
		  }

		  for (let i = 1; i <= lastDay; i++) {    
		    htmlDummy += `<div class="cdate" data-date=${i}>${i}</div>`;
		  }

		  for (let i = limitDay; i < nextDay; i++) {
		    htmlDummy += `<div class="noColor"></div>`;
		  }

		  document.querySelector(`.dateBoard`).innerHTML = htmlDummy;
		  document.querySelector(`.dateTitle`).innerText = `${currentYear}년 ${currentMonth}월`;
		  
		// 날짜 선택 이벤트
		
		
		let dayOfWeekString = '';
	    switch (new Date().getDay()) {
	      case 0:
	        dayOfWeekString = '일';
	        break;
	      case 1:
	        dayOfWeekString = '월';
	        break;
	      case 2:
	        dayOfWeekString = '화';
	        break;
	      case 3:
	        dayOfWeekString = '수';
	        break;
	      case 4:
	        dayOfWeekString = '목';
	        break;
	      case 5:
	        dayOfWeekString = '금';
	        break;
	      case 6:
	        dayOfWeekString = '토';
	        break;
	    }
		let ldm = '';
		switch (new Date(new Date().getFullYear(), (new Date().getMonth() + 1), 0).getDay()) {
		  case 0:
		    ldm = '일';
		    break;
		  case 1:
		    ldm = '월';
		    break;
		  case 2:
		    ldm = '화';
		    break;
		  case 3:
		    ldm = '수';
		    break;
		  case 4:
		    ldm = '목';
		    break;
		  case 5:
		    ldm = '금';
		    break;
		  case 6:
		    ldm = '토';
		    break;
		}

		var currentDate = new Date().getFullYear() + ". " + (new Date().getMonth() + 1) + ". " + new Date().getDate() + ". " + dayOfWeekString;
		document.getElementsByClassName('text_date text_date1')[0].textContent = currentDate;
		
		var monthLastDate = new Date().getFullYear() + ". " + (new Date().getMonth() + 1) + ". " + new Date(new Date().getFullYear(), (new Date().getMonth() + 1), 0).getDate() + ". " + ldm;
		document.getElementsByClassName('text_date text_date2')[0].textContent = monthLastDate; 
		
		const dateElements = document.querySelectorAll('.cdate');
		dateElements.forEach(dateElement => {
		  dateElement.addEventListener('click', () => {
		    let selectedDate = dateElement.dataset.date;
		    
		    let selectedDateObj = new Date(currentYear, currentMonth - 1, selectedDate);
		    let dayOfWeek = selectedDateObj.getDay();
		
		    let dayOfWeekString = '';
		    switch (dayOfWeek) {
		      case 0:
		        dayOfWeekString = '일';
		        break;
		      case 1:
		        dayOfWeekString = '월';		
		        break;
		      case 2:
		        dayOfWeekString = '화';
		        break;
		      case 3:
		        dayOfWeekString = '수';
		        break;
		      case 4:
		        dayOfWeekString = '목';
		        break;
		      case 5:
		        dayOfWeekString = '금';
		        break;
		      case 6:
		        dayOfWeekString = '토';
		        break;
		    }
		    $rap.css("display", "none");
		    
		    if ($('.rap_s').css("display") === "block") {
		      document.getElementsByClassName('text_date text_date1')[0].textContent
		       = currentYear + '. ' + currentMonth + '. ' + selectedDate + '. ' + dayOfWeekString;
		    } else if ($('.rap_s').css("display") === "none") {
		      document.getElementsByClassName('text_date text_date2')[0].textContent
		       = currentYear + '. ' + currentMonth + '. ' + selectedDate + '. ' + dayOfWeekString;
		    }
		  });
		});
		}
		
		const date = new Date();

		makeCalendar(date);

		// 이전달 이동
		document.querySelector(`.prevDay`).onclick = () => {
		makeCalendar(new Date(date.setMonth(date.getMonth() - 1)));
		}

		// 다음달 이동
		document.querySelector(`.nextDay`).onclick = () => {
		makeCalendar(new Date(date.setMonth(date.getMonth() + 1)));
		}

		
		//기간 선택시 날짜 변경
		
			$('input[name=term]').click(function() {
			
			const daynum = (new Date().getDay());
			let dayOfWeekString = '';
						switch (daynum) {
			  case 0:
			    dayOfWeekString = '일';
			    break;
			  case 1:
			    dayOfWeekString = '월';
			    break;
			  case 2:
			    dayOfWeekString = '화';
			    break;
			  case 3:
			    dayOfWeekString = '수';
			    break;
			  case 4:
			    dayOfWeekString = '목';
			    break;
			  case 5:
			    dayOfWeekString = '금';
			    break;
			  case 6:
			    dayOfWeekString = '토';
			    break;
			}

			// 기간 버튼 클릭시 조회시작일 변경	    
			const term01 = $('#term01').is(':checked');
			const term02 = $('#term02').is(':checked');
			const term03 = $('#term03').is(':checked');
			
			const currentDate = new Date(); // 현재 날짜
			let selectedMonth = currentDate.getMonth() + 1 - (term01 ? 1 : term02 ? 2 : term03 ? 3 : 0);
			let selectedYear = selectedMonth <= 0 ? currentDate.getFullYear() - 1 : currentDate.getFullYear();
			
			if (selectedMonth <= 0) {
			  selectedMonth = 13 - (term01 ? 1 : term02 ? 2 : term03 ? 3 : 0);
			  selectedYear--;
			}
			
			const maxDaysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
			const selectedDay = Math.min(currentDate.getDate(), maxDaysInMonth);
			
			const dateString = selectedYear + '. ' + selectedMonth + '. ' + selectedDay + '. ' + dayOfWeekString;
			document.getElementsByClassName('text_date text_date1')[0].textContent = dateString;
			
		});
		
			
	/***************************************************************************
	 * 
     *	payment_history_view 조회버튼 이벤트
	 * 
	***************************************************************************/
	
	
	//조회 시작일과 조회 종료일 오류
	 
	$(".btnL.btn_confirm").click(function() {
		var day1 = document.getElementsByClassName('text_date text_date1')[0].textContent;
		var day2 = document.getElementsByClassName('text_date text_date2')[0].textContent;
	  
		var parts1 = day1.split(". ");
		var parts2 = day2.split(". ");
	  
		var date1 = parts1[0] + "-" + parseInt(parts1[1]) + "-" + parts1[2];
		var date2 = parts2[0] + "-" + parseInt(parts2[1]) + "-" + parts2[2];
	  
		if (date1 < date2) {
		  alert("good");
		  alert(date1);
		  alert(date2);
		} else {
		  alert("wrong");
		  alert(date1);
		  alert(date2);
		}
	});
	
});