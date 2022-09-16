package java1.ch5클래스.EX13_비회원게시판_DB버전;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	
	// 1. 필드 
	// JDBC 자주 사용 하는 클래스/인터페이스
	Connection con; 		// DB 접속할수 있는 인터페이스
		// con = DriverManager.getConnection( "db주소" , "db계정명" , "db비밀번호" ) 
		//	-- 오류 발생[ 예외 발생 ] : 만약에 접속실패 했을때에 대한 대처 방안 [ 예외 처리 try~catch ]
	PreparedStatement ps; 	// 접속된 DB에 SQL 연결 조작하는 인터페이스 
	ResultSet rs;			// SQL 결과를 조작하는 인터페이스 

	// 2. 생성자 
	public BoardDao() {
		// 빈생성자에 DB 접속 코드 ( 객체 생성시 자동으로 DB 접속 )
		try {
		con = DriverManager.getConnection(
				"jdbc:mysql:://localhost:3306/boardtest",
				"root",
				"1234");
		}catch (Exception e) { System.out.println("경고) DB 접속 실패 " + e ); }
	}
	
	// 3. 메소드 
		// 1. 등록 메소드
	boolean regist( BoardDto boardDto ) {
		// sql 코드 들어갈 예정 
		return false;
	}
		// 2. 모든 게시물 출력 메소드 
	BoardDto[] getBoardlist( ) {
		BoardDto[] boardlist = null;
		// sql 코드 들어갈 예정 
		return boardlist;
	}
		// 3. 개별 게시물 출력 메소드 
	BoardDto getBoard( int b_no  ) {
		BoardDto board = null;
		// sql 코드 들어갈 예정
		return board;
	}
		// 4. 수정 처리 메소드 
	boolean update( int b_no , String b_password , String b_title , String b_content ) {
		// sql 코드 들어갈 예정  
		return false;
	}
		// 5. 삭제 처리 메소드 
	boolean delete( int b_no , String b_password ) {
		// sql 코드 들어갈 예정 
		return false;
	}
	
	
}