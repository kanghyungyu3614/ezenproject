print();
 
function print(){
	$.ajax({
		url : "http://localhost:8080/testjsp/member/signup.jsp", 
		success : function( result ){
			alert(result);
		}
	})
	
}