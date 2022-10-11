package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	// 0. 싱글톤 객체 선언 [ 공유 메모리 ] 
	private static MemberDao mdao = new MemberDao();
	public static MemberDao getInstance() { return mdao; }
	
	// 기능 메소드 구현 
	//1. 글등록 메소드 
	public boolean signup( MemberDto dto ) {
		String sql ="insert into"
				+ " member( mtitle ,mcontent,mwriter,mpassword)"
				+ " values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getMtitle() );
			ps.setString( 2 , dto.getMcontent() );
			ps.setString( 3 , dto.getMwriter() );
			ps.setString( 4 , dto.getMpassword());
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false; 	
	}//글등록
	
	//2. 글 출력 메소드
	public boolean print(MemberDto dto) {
		String sql = "select * from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				ps =con.prepareStatement(sql);
				return true;
		}catch (Exception e) { System.out.println(e); } // 데이터베이스 오류 뜻 
		return false; 
	}
	
}