package java1.d클래스.EX6;

public class Member {
  
   String id;
   String password;
   String name;
   int point;
   // 2. 생성자
        //1. 빈생성자
        //2. 회원가입시 사용되는 생성자
   public Member( String id, String password, String name, int point) {
	this.id = id; // this 사용하는 이유 [내부필드 와 매개변수의 이름이 동일한경우 식별용]
	this.password = password;
	this.name = name;
	this.point = point;
}
   //3. 회원수정시 사용되는 생성자
   Member( String password){
	   this.password = password;
	   this.name = name;
   }
   
   //4. 로그인[아이디,비밀번호]시 사용되는 생성자 
   Member(String id, String password){
	   this.id = id;
	   this.password = password;
   }
   
}
