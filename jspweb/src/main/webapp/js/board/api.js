//////////////////////////////////////// [ 전역변수 ]///////////////////////////////////////////////
let datalist = null // 약국 리스트  선언만 [ 전역변수 - 여러 함수에서 같이 쓸려고 ]
//////////////////////////////////////// [ 함수 호출 ]///////////////////////////////////////////////
getdata()
////////////////////////////////////// 공공데이터 api 호출 ///////////////////////////////////////
// 1. 공공데이터 호출 함수 
function getdata(){
	$.ajax({
		url : "/jspweb/board/api" , 
		success: function( re ){
			let json = JSON.parse(re);		// json : 전체 객체 
			datalist = json.data ;			// json.data : 약국 리스트 
			dataprint( ) // 검색이 없을때 모든 약국 호출  [ search : undefined ]
		}
	})
}
// 2. 검색 버튼을 눌렀을때 함수
function addrsearch(){ 
	let addr = document.querySelector('.addrinput').value
	dataprint( addr ) // 검색이 있을경우 검색어 전달  [ search : addr ]
}
// 3. html에 약국리스트 출력 함수 
function dataprint( search ){ // search : 검색어	
	if( search !== undefined ){ // 검색이 있을경우
		let searchlist = [] // [검색된]약국리스트 선언 
		for( let i = 0 ; i<datalist.length ; i++ ){
			let addr = datalist[i].주소
			if( addr.indexOf(search) !== -1 ){ // 입력한 검색어가 포함되어 있으면
				searchlist.push( datalist[i] )	// 리스트 추가 
			}
		} // for end 
		datalist = searchlist // 약국리스트를 [ 검색된 ]약국리스트로 대입(교체)
		if( search == '' ){ getdata(); } // 만약에 검색 키워드에 입력값이 없으면 초기화
	} // 검색 if end 
	
	
	let html = '<tr> <th> 약국명 </th> <th> 전화번호 </th> <th> 주소 </th> </tr>';
	for( let i = 0 ; i<datalist.length ; i++){	// 약국 하나씩 호출 
		let data = datalist[i]	// i번째 약국 임시 변수 
		html += '<tr onclick="mapview('+i+')">'+	// 해당 행 클릭시 map 메소드 실행 [ 클릭한 인덱스 매개변수 전달 ]
					'<td>'+data.약국명+'</td><td>'+data.대표전화+'</td><td>'+data.주소+'</td>'+
				'<tr>';
	} // for end 
	document.querySelector('table').innerHTML = html
}
//////////////////////////////////* 카카오 지도 API */////////////////////////////////////////
function mapview( i ){
	// 2. 지도 옵션 
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨 [ 1[확대] ~ 14[축소] ]
	    };
	// 3. 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	// 4. 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	// 5. 주소로 좌표를 검색합니다[ 클릭한 i번째 약국의 주소 ]
	geocoder.addressSearch( datalist[i].주소 , function(result, status) {
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
			// 좌표 : 주소로 검색된 좌표 생성 객체 
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			// 마커 :  결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,			// 해당 마커를 표시할 map 객체 대입 
	            position: coords	// 마커 좌표 대입
	        });
	        // 마커 클릭이벤트 : 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
			    detailview(i) // 약국 상세 div 출력 
			});
	        // 인포윈도우 : 마커의 설명[말풍선]달기
	        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+datalist[i].약국명+'</div>'
	        });
	        infowindow.open(map, marker);
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        	map.setCenter(coords)
	     }
    })
}
function detailview( i ){
	let html = '<div>'+datalist[i].약국명+'</div>'+
				'<div>'+datalist[i].주소+'</div>'+
				'<div>'+datalist[i].대표전화+'</div>'+
				'<div><button>평점주기</button></div>'+
				'<div><button>문의하기</button></div>';
	document.querySelector('.detailbox').innerHTML = html;
}
///////////////////////////////////////////////////////////////////////

getdata2()
function getdata2(){

	$.ajax({
		url : "/jspweb/board/api2",
		success : function( re ){ 
			let json = JSON.parse( re )
			console.log(json )
			// 해당 테이블에 부동산 정보 출력 
			
// 거래유형 //건축년도 //계약금액(만원)//계약년월//계약일//단지명//도로명//번지본번부번//시군구//전용면적//중개사소재지//층//해제사유발생일 //13
			
			
			
			
			// 여기다 작성
				let html = '<tr>'
				+'<th> 거래유형 </th> '
				+'<th> 건축년도 </th>'
				+'<th> 계약금액(만원) </th>'
				+'<th> 계약년월 </th>'
				+'<th> 계약일 </th>'
				+'<th> 단지명 </th>'
				+'<th> 도로명 </th>'
				+'<th> 번지본번부번 </th>'
				+'<th> 시군구 </th>'
				+'<th> 전용면적 </th>'
				+'<th> 중개사소재지 </th>'
				+'<th> 층 </th>'
				+'<th> 해제사유발생일 </th>'
				+'</tr>';
				
				for( let i = 0 ; i<json.length ; i++){	// 약국 하나씩 호출 
					html += '<tr>'+	// 해당 행 클릭시 map 메소드 실행 [ 클릭한 인덱스 매개변수 전달 ]
								'<td>'+json[i].거래유형+'</td>'+
								'<td>'+json[i].건축년도+'</td>'+
								'<td>'+json[i].계약금액+'</td>'+
								'<td>'+json[i].계약년월+'</td>'+
								'<td>'+json[i].계약일+'</td>'+
								'<td>'+json[i].단지명+'</td>'+
								'<td>'+json[i].도로명+'</td>'+
								'<td>'+json[i].번지본번부번+'</td>'+
								'<td>'+json[i].시군구+'</td>'+
								'<td>'+json[i].전용면적+'</td>'+
								'<td>'+json[i].중개사소재지+'</td>'+
								'<td>'+json[i].층+'</td>'+
								'<td>'+json[i].해제사유발생일+'</td>'+
							'<tr>';
				} // for end 
				console.log(json[1]);
				document.querySelector('.csvtable').innerHTML = html
			
			
			
			
			
		 }
	})

}











////////////////////////////////////////////////////////////////////////////

