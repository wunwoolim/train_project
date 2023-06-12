$(document).ready(function(){


	
	//카드사 선택 이벤트
	$(".selectricOpen").click(function() {
		//alert("1234");
		$(".selectricOpen").css("z-index","9999");
		$(".selectricItems").css("display","block");
	});
	  
	$(document).on("click", ".selectricScroll li", function(){
		//
		$(".selectricScroll").removeClass("selected");
		//클래스 추가
		$(this).addClass("selected");
		
		 let selectedValue = $(this).text();
		$("#selectric .label").text(selectedValue);
		$(".selectricInput").val(selectedValue);
		
		//alert(selectedValue);
		$(".selectricItems").css("display","none");
		
	});
	
	
	
	//카드 정보 입력 이벤트
	$(".box_inputForm span").click(function(){
		
		if($(this).text() == ''){
			$(this).find('label').css('display', 'block');
	  		$(this).find('input').css('display', 'none');
		}else{
			$(this).find('label').css('display', 'none');
	  		$(this).find('input').css('display', 'block');
		}
	});
	
	//결제하기 클릭시 서브밋
	$("#stplCfmBtn").click(function(){
	
		purchaseForm.submit();
	});
	
});