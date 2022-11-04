/**
 * 
 */
 
getcart()
function getcart(){
	$.ajax({
		url : "/jspweb/product/cart",
		type : "get",
		success : re =>{
			let cartlist = JSON.parse(re);
			console.log(cartlist);
			
			let html = '<tr><th width="5%"> </th><th width="10%"> 이미지 </th><th width="40%"> 상품정보 </th><th width="15%"> 수량 </th> <th width="15%">가격</th> <th width="10%"> 비고 </th> </tr>';
			
			cartlist.forEach(c=>{
				html += '<tr>'
				'<td><input type="checkbox"></td>'
				'<td><img alt="" src="/jspweb/admin/pimg/'+c.img+'"></td>'
				'<td>'+c.pname+'<br> - '+c.pcolor+' / '+c.psize+' </td>'
				'<td>'+c.amount+'</td>'
				'<td>'+c.amount * (c.pprice - (c.pprice* c.pdiscount))+'</td>'
				'<td><button>삭제</button></td>'
			'</tr>';
			})
			document.querySelector('.cart_t').innerHTML = html
		}
	})
}