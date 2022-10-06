package testjsp.model.dao;

import testjsp.model.dto.testDto;

public class testDao extends Dao{
	// 0. 싱글톤 객체 선언 [ 공유 메모리 ] 
	private static testDao testdao = new testDao();
	public static testDao getInstance() { return testdao; }
	
	// 기능 메소드 구현 
	//1. 회원가입 메소드 
	public boolean signup( testDto dto ) {
		String sql ="insert into"
				+ " member( testid ,testpassword,testname,testtitle,testcontent,testwriter)"
				+ " values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getTestid() );
			ps.setString( 2 , dto.getTestpassword() );
			ps.setString( 3 , dto.getTestname() );
			ps.setString( 4 , dto.getTesttitle() );
			ps.setString( 5 , dto.getTestcontent() );
			ps.setString( 6 , dto.getTestwriter() );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false; 	
	}
}
