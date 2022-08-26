    document.addEventListener('DOMContentLoaded', ()=>{
	//1번.html을 다읽고 가져온다.
	
	//2-1번.dom으로 태그들 가져온다.
	//input박스
	const input = document.querySelector("#todo")
	//input 추가시키는 버튼
	const addButton = document.querySelector("#add-button")
	// 추가된 상위 컴포넌트
	//오늘할일들을 모두 가지고 있는 상단 컴포넌트
	const todoList = document.querySelector("#todo-list")
	
	//3번 keyCount 변수선언 
	//맨 밑에 removeTodo 함수에서 문서객체를 찾기위해 만듦 나중에 key에 할당할거다.
	let keyCount = 0; 
    
    //4번: 함수 선언 ==> 인풋에 없으면 종료시킬려고 만듬
    const addTodo = () =>{
	
	//할일의 내용이 없으면 할일을 입력해주세요. 함수종료
	//5-1번 input안의 내용물 공백제거후 ''이면 
	if(input.value.trim() === ''){
		
       alert('할 일을 입력해주세요.')
       //6번 함수 종료
       return 
		
	}
    
    
    
    //5-2번 여기서부터 인거 같음
    //2-2번 : dom으로 
    //1.div태그랑 2.인풋박스 랑 3. 스팬태그 랑 4. 버튼태그를 만든다.
    //오늘할일에 관련된 태그들을 만들거다.
    const item = document.createElement('div')
    const checkbox = document.createElement('input')
    const text = document.createElement('span')
    const button = document.createElement('button')
    
    
    // 문서객체를 식별할 키를 생성 : 오늘할일의 갯수
    //removeTodo() 함수 에서 문서객체를 쉽게 제거하기 위해 만든 변수
    const key = keyCount
    keyCount +=1
    
    // 6번 : item  객체를 조작하고 추가
    //위에서 만든 div태그에 data-key속성에 오늘 할일의 갯수 === 숫자(key)추가
    //이걸 해야 제거할때 찾을수 있음
    item.setAttribute('data-key', key)
    
    // 7번 :  div태그 하위에 checkbox ,text , button을 순서대로 자식으로 넣는다.
    item.appendChild(checkbox) //인풋태그임 체크박스를 만들거다.
    item.appendChild(text) //span임 === input에 입력한 내용이 된다.
    item.appendChild(button) //버튼태그임 === 제거하기 버튼을 만들기 위해서 만든다.
    //세팅후 todoList에 추가한다.
    todoList.appendChild(item);
    
    // 8번 : checkbox 조작
    // input박스를 checkbox타입으로 바꾼다.
    checkbox.type = 'checkbox'
    
    
    
    
    //9번 체크박스를 클릭하면 바뀐다.
    //event.target.checked가 되면  체크되면 "line-through" 아니면 빈문자열 을 item.style.textDecoration에 할당한다.
    checkbox.addEventListener( 'change', (event) =>{
	  item.style.textDecoration = event.target.checked ? "line-through" : ''
    })
    
    // 10번 : text 객체를 조작합니다. input태그의 값을 span태그의 내용에 할당한다. 
    text.textContent = input.value 
    
    // 11번 : 제거하기 button객체를 조작합니다.
    button.textContent = "제거하기"
    //제거하기 버튼을 누르면 removeTodo함수에서 data-key의 key값을 찾아서 제거한다.
    button.addEventListener('click', ()=>{
	  // 버튼을 클릭하면 removeTodo(key)를 실행
	  removeTodo(key)
    })
    
    
    // 12번 입력 양식을 비워줍니다.
    input.value = ''
    }
    //addTodo 끝
    
    // removeTodo 시작
    // 식별 키로 문서 객체를 제거합니다.
    
     //data-key의 key값을 찾아서 제거하기 위해 만듦
    const removeTodo = (key) =>{
	  
     const item = document.querySelector(`[data-key="${key}"]`)
     todoList.removeChild(item)
    } 
    
    
    // removeTodo 끝
    // 추가된 상위 컴포넌트 를 클릭하면 addTodo를 실행한다.
    addButton.addEventListener('click', addTodo)
    input.addEventListener('keyup', (event)=>{
	 const ENTER = 13
	 if(event.keyCode === ENTER){
		//키코드가 엔터 13번이면 addTodo()를 실행시킨다.
		addTodo()
	}
    }
    )
    
    
    
    
     














































})
