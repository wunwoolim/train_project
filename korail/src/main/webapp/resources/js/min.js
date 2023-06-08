$(document).ready(function() {
	initAjax("kyeongbu" , '1', '서울역', 'c');
		
		$(".underline").on("click", function() {
			let route = $(this).attr("id");
			let route_name = $("#route_name").val();
			let rno = '1';
			let station = '';
			
				if(route != route_name) {
					$(".underline").css("border", "none");
					$("#" + route).css("border-bottom", "3px solid rgb(83, 49, 156)");
					$("#route_name").val(route);
			
					if(route == 'kangleung') {
						rno = '2';
					}
					
					if(route == 'kyeongbu') {
						station = "서울역";
					} else if(route == 'honam') {
						station = "용산역";
					} else if(route == 'kyeongjeon') {
						station = "서울역";
					} else if(route == 'jeonla') {
						station = "용산역";
					} else if(route == 'kangleung') {
						station = "청량리역";
					} else if(route == 'joongang') {
						station = "청량리역";
					} else if(route == 'joongbu') {
						station = "부발역";
					}
					
				} 
		initAjax(route, rno, station, 'c');
		
		});	//onClick
					
		
		
		
		
		function initAjax(category, rno, station, type) {
			$.ajax({
				url : "train_route_info_json.do?category="+category+"&rno="+rno+"&station="+station+"&type="+type,
				success:function(result) {
				//alert(result);
				let jdata = JSON.parse(result);
				let obj = jdata.jlist;
				
				const arr = [jdata.station_list[0].station, jdata.station_list[1].station, jdata.station_list[2].station];
							
					let output = "<div class='station'><div class='station-section two-column'><div class='col-left'>";	
						output += "<img src='http://localhost:9000/ktx/images/" + obj.clink1 + "' class= 'train_category'>";
						output += "<img src='http://localhost:9000/ktx/images/" + obj.clink2 + "' class= 'category_map'>";
						output += "</div><div class='col-right'><div class='container-top'>";
						output += "<h2 class='title'>" + obj.station + "</h2>";
						output += "<div class='container-mover'><button id='before'><</button><button id='next'>></button></div>";
						output += "<img src='http://localhost:9000/ktx/images/" + obj.plink + "' class= 'station_map'></div>";
						output += "<div class='container-bottom'><table><tr><td>위치</td>";
						output += "<td>" + obj.location + "</td></tr><tr><td>연락처</td>";
						output += "<td>" + obj.sphone + "</td></tr></table>";
						output += "<div class='button'><a href='#info' class='btn'>기차역 상세</a></div></div></div></div></div>";
						output += "<div class='station-basic-info'><div class='info-top'><h3 id='info'>기본 정보</h3>";
						output += "<div class='station-info'>" + obj.info + "</div></div>";
						output += "<div class='info-bottom'><h3>서울역 연혁</h3>";
						output += "<ol>";
						for(hobj of obj.jhistory) {
							output += "<li class='info-bottom'>" + hobj.history + "</li>";
						}
						output += "</ol>";
						
						output += "</div>";
					
					output += "</div><div class='station-map-info'><h3>위치/교통</h3><div id='map' style='width:1100px;height:700px;'></div><script>";
					
					output += "var container = document.getElementById('map');";	
					output += "var options = { center: new kakao.maps.LatLng(" + obj.mlink + " ),level: 3 };";
					output += "var map = new kakao.maps.Map(container, options);";
					output += "var markerPosition  = new kakao.maps.LatLng(" + obj.mlink + ");";
					output += "var marker = new kakao.maps.Marker({ position: markerPosition });";
					output += "marker.setMap(map);";
				
					output += "</script></div></div></div>";
					
					$(".station-map-info").remove();
					$(".station").remove();
					$(".station-basic-info").remove();
					$(".route").after(output);				
					
					let count = 0;
					
					$("#before").on("click", function() {
						
						if(count == 0 || count == 1) {
							count++;
						} else if (count == 2) {
							count = 0;
						}
						$(".title").text(arr[count]);
						var sname = arr[count];
						//initAjax(arr[count]);
						initAjax(route, rno, sname, 's');
					});		
						
					
					$("#next").on("click", function() {
						if(count == 1 || count == 2) {
							count--;
						} else if (count == 0) {
							count = 2;
						}
						$(".title").text(arr[count]);
					});	
			
				}	//success
				
			});	//ajax
			
		}//initAjax
	

	});	//ready