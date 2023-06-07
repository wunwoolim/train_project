$(document).ready(function(){
	
	$(".selectricOpen").click(function() {
		//alert("1234");
		$(".selectricOpen").css("z-index","9999");
		$(".selectricItems").css("display","block");
	});
	  
	$(".selectricScroll li").click(function(){
		//
		$(".selectricScroll").removeClass("selected");
		//클래스 추가
		$(this).addClass("selected");
		
		 let selectedValue = $(this).text();
		$(".selectric label").text(selectedValue);
		
	});
	
	
});