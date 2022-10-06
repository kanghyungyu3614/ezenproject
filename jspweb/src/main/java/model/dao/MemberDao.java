package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	// 0. 싱글톤 객체 선언 [ 공유 메모리 ] 
	private static MemberDao mdao = new MemberDao();
	public static MemberDao getInstance() { return mdao; }
	
	// 기능 메소드 구현 
	//1. 회원가입 메소드 
	public boolean signup( MemberDto dto ) {
		String sql ="insert into"
				+ " member( mid ,mpassword,mname,mphone,memail,maddress)"
				+ " values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMid() );
			ps.setString( 2 , dto.getMpassword() );
			ps.setString( 3 , dto.getMname() );
			ps.setString( 4 , dto.getMphone() );
			ps.setString( 5 , dto.getMemail() );
			ps.setString( 6 , dto.getMaddress() );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false; 	
	}//회원가입
	
	public boolean login(String id, String password) {
		String sql= "select * from member "
				+ "where mid=? and mpassword=?";
		
		try {
			 ps = con.prepareStatement(sql);
			 ps.setString(1, id);
			 ps.setString(2, password);
			 rs = ps.executeQuery();
			 if(rs.next()) {
				 return true;
			 }
			 
			 
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	
}
