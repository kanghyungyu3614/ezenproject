/**
 * 
 */
 getproduct();
// 1. 모든 제품 호출 메소드
function getproduct(){
	$.ajax({
		url: "/jspweb/admin/regist",
		type: "get",
		success:function (re){
			let json = JSON.parse(re);	
			console.log(json);		
			let img = "/jspweb/admin/pimg/"+json[0].pimg;
			let html = 'img src="'+img+'">'
			document.querySelector('table').innerHTML = html;
		}
	})
}