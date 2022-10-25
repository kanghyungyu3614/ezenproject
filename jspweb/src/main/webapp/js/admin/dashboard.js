
// 1. 해당 사이드바 태그 호출
let sidebar = document.querySelector('.sidebar')

// 2. 해당 사이드바 태그를 클릭했을때 이벤트
sidebar.addEventListener('click', function(){
	// 해당 사이드바 css 변경 [ left 속성을 0으로 변경 ]
	sidebar.style.left = 0;
})