package java1.ch5클래스.EX13_비회원게시판_DB버전;

public class BoardControl {
  //1.
  boolean regist(String btittle , String bcontent, String bwriter, String bpassword){
	  // 로직 OR Dao 호출 작성 예정 
	  return false;
  }
  //2.
  BoardDto[] getBoardlist(){
	  // 로직 or DAO 호출 작성 예정
      BoardDto[] boardlist = null;
	  return boardlist;
  }
  //3. 
  BoardDto getBoard( int b_no) {
	  // 로직 or DAO 호출 작성 예정
	  BoardDto board = null;
	  return board;
  }
  //4. 
  boolean update(int b_no, String b_password, String new_title, String new_content) {
	  // 로직 or DAO 호출 작성 예정
	  return false;
  }
  //5. 
  boolean delete( int b_no , String b_password) {
	  // 로직 or DAO 호출 작성 예정 
	  return false;
  }

}
  