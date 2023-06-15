$(document).ready(function(){

/****************************
아이디 찾기 
****************************/
	$(function(){
		$("#find_id_btn").click(function(){
			location.href ='../find_id/find_id1';	
		})
	})










	/*******************************************
		인증번호 관련 jquery 
	********************************************/


		
		$('#mail-Check-Btn').click(function() {
				const eamil = $('#userEmail1').val()+'@' + $('#userEmail2').val(); // 이메일 주소값 얻어오기!
				console.log('완성된 이메일 : ' + eamil); // 이메일 오는지 확인
				const checkInput = $('.mail-check-input') // 인증번호 입력하는곳 
				
				$.ajax({
					type : 'get',
					url : '<c:url value ="/user/mailCheck?email="/>'+eamil, // GET방식이라 Url 뒤에 email을 뭍힐수있다.
					success : function (data) {
						console.log("data : " +  data);
						checkInput.attr('disabled',false);
						code =data;
						alert('인증번호가 전송되었습니다.')
					}			
				}); // end ajax
			}); // end send eamil



/*******************************************
		인증번호 이메일 폼 체크 
	********************************************/



	$("#userEmail3").on("change", function(){
		if($("#userEmail3").val() == "default"){
			alert("이메일을 선택해주세요");
			$("#userEmail2").val("");
			$("#usereEmail3").focus();
		}else if($("#userEmail3").val() == "self"){
			$("#userEmail2").val("").focus();
		}else{
			$("#userEmail2").val($("#userEmail3").val());
		}		
		
	});




	/*******************************************
		이메일 폼 체크 
	********************************************/



	$("#email3").on("change", function(){
		if($("#email3").val() == "default"){
			alert("이메일을 선택해주세요");
			$("#email2").val("");
			$("#email3").focus();
		}else if($("#email3").val() == "self"){
			$("#email2").val("").focus();
		}else{
			$("#email2").val($("#email3").val());
		}		
		
	});



	/*******************************************
	아이디 중복체크
	********************************************/

		$("#btnIdCheck").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else{
			$.ajax({
				url : "id_check.do?id="+$("#id").val(),
				success : function(result){
					if(result == 1){
						$("#idcheck_msg").text("이미 사용중인 아이디 입니다. 다시 입력해주세요")
						.css("color","red").css("font-size","11px").css("display","block")
						.css("padding","8px 0px 8px 160px");
						$("#id").val("").focus();
					}else if(result == 0){
						$("#idcheck_msg").text("사용 가능한 아이디 입니다")
						.css("color","blue").css("font-size","11px").css("display","block")
						.css("padding","8px 0px 8px 160px");
						$("#pass").focus();
					}
				}
			});
		}
	});
		

		/*******************************************
		회원가입 폼 체크 - 비밀번호 & 비밀번호 확인 
	********************************************/
	$("#cpass").on("blur", function(){		
		if($("#pass").val() != "" && $("#cpass").val() != ""){
			if($("#pass").val() == $("#cpass").val()){
				$("#cmsg").text("비밀번호가 동일합니다").css("color","blue")
					.css("font-size","11px").css("display","block");
				$("#name").focus();
			}else{
				$("#cmsg").text("비밀번호가 동일하지 않습니다. 다시  입력해주세요")
				.css("color","red").css("font-size","11px").css("display","block");
				
				$("#pass").val("").focus();
				$("#cpass").val("");
			}
		}
	}); //cpass blur



	/*******************************
		회원가입 폼 체크 - 유효성체크(값의 유무만 확인)
	*******************************/
	
	$("#btnJoin").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else if($("#idcheck_msg").text() == ""){
			alert("중복체크를 진행해주세요");
			$("#btnIdCheck").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}else if($("#cpass").val() == ""){
			alert("패스워드 확인을 입력해주세요");
			$("#cpass").focus();
			return false;
		}else if($("#name").val() == ""){
			alert("성명을 입력해주세요");
			$("#name").focus();
			return false;
		
		}else if($("#email1").val() == ""){
			alert("이메일 주소를 입력해주세요");
			$("#email1").focus();
			return false;
		}else if($("#email2").val() == ""){
			alert("이메일 주소를 선택해주세요");
			$("#email3").focus();
			return false;
		}else if($("input[name='tel']:checked").length == 0){
			alert("통신사를 선택해주세요");
			return false;
		}else if($("#pnumber").val() == ""){
			alert("폰번호를 입력해주세요");
			$("#pnumber").focus();
			return false;
			}else if($("input[name='gender']:checked").length == 0){
			alert("성별을 선택해주세요");
			return false;
		}else{
			//서버전송
			alert("회원가입에 성공하셨습니다.")
			joinForm.submit();
		}
	});	//btnJoin


});
 