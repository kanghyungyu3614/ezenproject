/**
 * 
 */

list()
function list(){
	
	$.ajax({
		url : "http://localhost:8080/jspweb/board/list",
		sueccess : function (re){
			
 			let boardlist = JSON.parse(re)
 		
 			let html = ""
 		
	 		for(let i =0; i<boardlist.length; i++){
		     let board = boardlist[i];
		     
		     html += 
		     		'<tr>'+
						'<td>'+board.bno+'</td>'+
						'<td>'+board.btitle+'</td>'+
						'<td>'+board.mno+'</td>'+
					'</tr>';
			}
			document.querySelector('.btable').innerHTML = html
			
			
		}
	})
}