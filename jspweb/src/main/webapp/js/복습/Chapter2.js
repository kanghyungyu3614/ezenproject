/**
 * 
 */
// console.log("가나다라");
 
 
 // 문제1 : 지폐 세기
 // 조건 : 금액을 입력받아 
 // console.log 출력에 십만원 3장 
 // 만원권 2장 , 천원권 1장 백원 
 
 let input = prompt("십만원단위의 금액을 알려주세요.");
 input = Number(input);
 let tenmanwon;
 let manwon;
 let chunwon;
 let baek;
 
 while(true){
     console.log(input);
 	 if(input<1000000&&input>0){
   	 tenmanwon = Number(input/100000);
  	 input -= Math.floor(tenmanwon)*100000;
	 if(input<100000){
	 manwon = Number(input/10000);
	 input -= Math.floor(manwon)*10000;
	 if(input<10000){
	 chunwon = Number(input/1000);
	 input -= Math.floor(chunwon)*1000;
     if(input<1000){
	 baek = Number(input/100);
	 input -= Math.floor(baek)*100;	
	 break;
        }	
	   }
	  }
	 }
	 else if(input>=1000000||input<=0){
	 input = prompt("십만원단위의 금액을 알려주세요.");
	 continue;
	 }
}

 console.log("십만원권 : ",Math.floor(tenmanwon),"장"," 만원권 : ",Math.floor(manwon),"장"," 천원권 : ",Math.floor(chunwon),"장"," 백원단위 : ",Math.floor(baek)," 나머지 :",input)
 