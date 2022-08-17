/**
 * 
 */
 //확인문제1
 function multipyAll(a,b){
	let num = 1;
	for(let i=a; i<=b; i++){
		num*=i
	}
	return num;
}
 console.log(multipyAll(1,2))
 console.log(multipyAll(1,3)) 
 //확인문제2
 const max = function(array){
	let output = array[0]
	for(let i=0; i<array.length; i++){
		if(output<array[i]){
			output = array[i]
		}
	}
	return output
}
console.log(max([1,2,3,4]))
 //확인문제3
 
 //확인문제4
 
 //확인문제5    