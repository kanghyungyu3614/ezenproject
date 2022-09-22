package java1.가계부;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountBookControl {
     //1. 필드
	 private Connection con;
	 private PreparedStatement ps;
	 private ResultSet rs;
	 private static AccountBookControl dao = new AccountBookControl();
	 //2. 생성자
	 private AccountBookControl(){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");			
		} catch (Exception e) { System.out.println("DB오류 : "+e);}
	}
	
	 //3. 메소드 
	 public static AccountBookControl getInstance () { return dao;}
	 
	 // 1.내용추가 SQL 메소드
	 boolean create(AccessBookDto dto) {
		 String sql = "insert into expense(null, ?,?,?)";
		 try {
			 ps = con.prepareStatement(sql);
			 ps.setString(1, dto.getEdate());
			 ps.setInt(2, dto.getEmoney());
			 ps.setString(3, dto.getEcomment());
			 ps.executeUpdate(); return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	 }
}