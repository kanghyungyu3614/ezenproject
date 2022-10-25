function regist(){
	/* 첨부파일이 포함되어 있을경우 */
	let form = document.querySelector('form')
	let formdata = new FormData( form )
	$.ajax({
		url : "/jspweb/admin/regist" , 
		success: function( re ){ 
			console.log( re )
		 }
	})
}