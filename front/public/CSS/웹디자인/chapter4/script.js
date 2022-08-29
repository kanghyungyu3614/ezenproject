/* chartist.js 이용한 차트 구현*/


/* 파이차트[원형차트] 데이터 객체 선언 */
let pieData = {
	/* 항목의 이름 */ 
	labels : ["웹디자이너", "웹개발자", "서버 엔지니어", "영업직"],
	/* 항목의 값 */
	series : [ 14, 9, 8, 6]
	
 } 
let pieOptions = {
	width: "100%",
	height: '440px'
}
/* 차트 적용하기 : new Chartist.Pie('표시할식별자', 데이터객체, 옵션객체) */
/* Chartist.Pie [ 미리 만들어진 클래스 ]  */
new Chartist.Pie('.pie_chart',pieData, pieOptions)

/* 막대차트 */
let barData = {
	lables : ["2018년", "2019년", "2020년"],
	series : [ [10,16,29]]
}
let barOptions = {
	// y축
	axisY : {
		offset : 60 ,                            //1.d
		scaleMinSpace : 50,                      //2.선 간격[px]
		labelInterPolationFnc : function(value){ //3.Y축 눈금 표시
			return value + ' 명'
		}
	},
	width : "100%",
	height : "400px;"
}

new Chartist.Bar('.bar_chart',barData,barOptions)






/* 막대차트 */
let barData2 = {
	/*항목 */
	lables : [],
	/*값 */
	series : [[]]
}

let barOptions2 = {
	// y축
	axisY : {
		offset : 60 ,                            //1.d
		scaleMinSpace : 50,                      //2.선 간격[px]
		labelInterPolationFnc : function(value){ //3.Y축 눈금 표시
			return value + ' 명'
		}
	},
	width : "100%",
	height : "400px;"
}

function 차트그리기(){
	let name = document.querySelector("#name").value
	let money = document.querySelector("#money").value
	barData2.lables.push(name);
	barData2.series[0].push(money);

    new Chartist.Bar('.bar_chart2',barData2,barOptions2)   
}






