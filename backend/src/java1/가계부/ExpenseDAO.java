package java1.가계부;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExpenseDAO {
	// 1. 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static ExpenseDAO dao = new ExpenseDAO(); // 싱글톤 객체 [ 생성자를 private ]
	// 2. 생성자
	private ExpenseDAO() {
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "1234");
		} catch (Exception e) { System.out.println("DB오류:"+e);}
	}
	// 3. 메소드 
	public static ExpenseDAO getInstance() { return dao; }
	
	// 1. 내용추가 SQL 메소드 
	boolean create( ExpenseDTO dto ) {
		String sql ="insert into expense values( null , ? , ? , ? );";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getEdate() );
			ps.setInt( 2 , dto.getEmoney() );
			ps.setString( 3 , dto.getEcomment() );
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println("DB오류:"+e);} 
		return false;
	}
	
	// 2. 내용출력 SQL 메소드 
	ArrayList< ExpenseDTO > read ( ){
		ArrayList< ExpenseDTO > list = new ArrayList<>();
		String sql ="select * from expense";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // rs.next() : 다음레코드
				// 레코드[필드4개] 1개 --> 객체화[필드4개] 1개 [포장]	
				ExpenseDTO dto = new ExpenseDTO( 
						rs.getInt(1),rs.getString(2), 
						rs.getInt(3), rs.getString(4));
				// 객체 -> 리스트 담기
				list.add( dto );
			} // while end 
			return list; // 반환 
		}catch (Exception e) { System.out.println("DB오류:"+e);} 
		return list;
	}

	//3. 내용 수정 sql 메소드
	boolean update (new ExpenseDTO dto) {
		String sql = "update expense set"
				+ "edate = ?"
				+ "emoney = ?"
				+ "ecomment = ?"
				+ "where eno = ?";
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, dto.)
		return true;
	} catch ([ e) {}
	return false;
	
	} 
	
	
	//4. 내용 삭제 sql 메소드
	boolean delete (int eno) {
		String sql = "delete from expense where eno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	   return false;
	} 
	

}
