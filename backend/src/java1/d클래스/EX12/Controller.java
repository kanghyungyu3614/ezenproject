package java1.d클래스.EX12;

public class Controller {
	static Board[] boardlist = new Board[100];
	// 1. 게시물 등록 함수 
	static boolean con_regist( String title , String content , String writer , String password ) {
		// 1. 객체 생성 
		Board board = new Board(title, content, writer, password, 0);
		// 2. 배열에 빈공간에 배치
		for( int index = 0 ; index<boardlist.length ; index++) {
			if( boardlist[index] == null ) {
				boardlist[index] = board; 
				return true; // 게시물 등록 성공 의미 // 게시물 등록시 함수 탈출 
			}
		}
		// 3. 
		return false; // 게시물 등록 실패 의미 // 배열에 자리 가 없다.
	} // m end 
	
	// 2. 게시물 삭제 함수 
	static boolean con_delete( int bnum , String password ) {
		if( boardlist[bnum].password .equals(password) ) {
			for( int i = bnum ; i<boardlist.length ; i++ ) {
				boardlist[ i ] = boardlist[ i + 1 ];	// 한칸씩 당기기
				if( boardlist[ i + 1 ] == null ) { break; }
			} // for end 
			return true;
		}else { return false; }
	} // m end 
	
	// 3. 게시물 수정 함수 
	static boolean con_update( int bnum , String password , 
			String title , String content ) {
		
		if( boardlist[bnum].password .equals(password) ) {
			boardlist[bnum].title = title;
			boardlist[bnum].content = content;
			return true;
		}else { return false; }
	} // m end 
	
} // c end 