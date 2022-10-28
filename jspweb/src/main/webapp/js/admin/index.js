getpactive1();
function getpactive1(){
	$.ajax({
		url:"/jspweb/admin/regist",
		data:{"type" : 1, "option" : "pactive1"},
		success: function (re){
			let json = JSON.parse(re);
			console.log("json");
			console.log(json);
			let html = '';
			json.forEach(p => {//"/jspweb/admin/pimg/${p.pimg}" style="width:100%"
			console.log(p);
				html +=  '<div class="item"> <!-- 1개의 제품[아이템] -->'+
								'<a href="#">'+
									`<img src="/jspweb/admin/pimg/${p.pimg}" style="width:100%"> <!--  대표 이미지 -->`+
								'</a>'+
								''+
								'<div class="item_info"> <!-- 제품 정보 -->'+
								'<div class="item_title"> 	<!-- 제품명 -->'+
									p.pname+
								'</div> <!-- 제품명 -->'+
								''+
								'<div class="item_size"> [FREE] </div>'+
								''+
								`<div class="item_price">${p.pprice}</div> <!-- 원가 -->`+
								'<div>   <!-- 할인된 가격, 할인율 -->'+
									`<span class="item_sals">${p.pprice -(p.pprice * p.pdiscount)}</span>`+
									'<span class="item_discount">90%</span>'+
								'</div>'+
								'<div>리뷰수 412</div> <!-- 리뷰 --> '+
								'</div>'+
								'<div>	<!-- 배지 구역 -->'+
									'<span class="badge rounded-pill text-bg-warning"> 주문폭주 </span>'+
									'<span class="badge rounded-pill text-bg-danger"></span>'+
									'<span> 1+1 </span>		'+
								'</div>'+
							'</div>';
			})
			document.querySelector('.itemlist').innerHTML += html;
		}
	})	
}