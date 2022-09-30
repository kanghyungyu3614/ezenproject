package java1.ch10예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	// 1. 필드 
	// JDBC 자주 사용 하는 클래스/인터페이스
	private Connection con; 		// DB 접속할수 있는 인터페이스
		// con = DriverManager.getConnection( "db주소" , "db계정명" , "db비밀번호" ) 
		//	-- 오류 발생[ 예외 발생 ] : 만약에 접속실패 했을때에 대한 대처 방안 [ 예외 처리 try~catch ]
	private PreparedStatement ps; 	// 접속된 DB에 SQL 연결 조작하는 인터페이스 
	private ResultSet rs;			// SQL 결과[쿼리]를 조작하는 인터페이스 
	private static Dao dao = new Dao();
	
	public static Dao getInstance() {
		return dao;
	}
	// 2. 생성자 
	public Dao() {
		// 빈생성자에 DB 접속 코드 ( 객체 생성시 자동으로 DB 접속 )
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boardtest","root","1234");
		}catch (Exception e) { System.out.println(e); }
	}
	
	// 메소드
	public void signup() throws SQLException {
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}
	public void login() throws SQLException{
		String sql = "";
		ps = con.prepareStatement(sql);
		ps.executeQuery();
	}
}
