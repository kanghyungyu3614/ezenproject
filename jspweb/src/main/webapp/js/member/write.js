 function bwrite(){
	let inputs = docuement.querySelectorAll('input');
	let data = {btitle :inputs[1].value , bcontent : inputs[2].value};
	
	
	// let 객체 = { 속성명 : 데이터, 속성명 : 데이터 ~~}
    $.ajax({
	   url : "http://localhost:8080/jspweb/board/write",
	   data : data,
	   suecess: function(re){alert(re);}
	   })
}