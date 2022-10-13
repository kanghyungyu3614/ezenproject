package model.dao;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	// 0. 싱글톤 객체 선언 [ 공유 메모리 ] 
	private static MemberDao mdao = new MemberDao();
	public static MemberDao getInstance() { return mdao;}
	
	//1. 회원가입 메소드 
	public boolean signup( MemberDto dto ) {
		String sql ="insert into"
				+ " member( mid ,mpassword,"
				+ "mname,mphone,"
				+ "memail,maddress)"
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
	} // 회원가입 end 
	
	// 2. 로그인 메소드 
	public int login( String id , String password) {
		String sql = "select * from member where mid = ?";	// 아이디 검증 
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , id );
			rs = ps.executeQuery();
			if( rs.next() ) {
				sql = "select * from member where "
						+ " mid = ? and mpassword = ?";
				ps =con.prepareStatement(sql);
				ps.setString( 1 , rs.getString( 2 ) );	// 첫번째 select 찾은 데이터를 첫번째 ? 대입 
				ps.setString( 2 , password );
				rs = ps.executeQuery();
				if( rs.next() ) { return 1; } // 로그인 성공 뜻
				return 2; // 패스워드가 틀렸다는 뜻  
			}
		}catch (Exception e) { System.out.println(e); return 3; } // 데이터베이스 오류 뜻 
		return 0;	// 아이디 없다는 뜻 
	}
	
	// 3. 아이디찾기 
	public String findid( String mname , String memail) {
		String sql = "select * from member "
				+ "where mname=? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mname );
			ps.setString( 2 , memail );
			rs = ps.executeQuery();
			// 만일 동일한 정보가 있으면 찾은 레코드의 아이디 반환
			if( rs.next() ) return rs.getString(2); 
		}catch (Exception e) {System.out.println(e);}
		return null;	// 동일한 정보가 없으면 null 
	}
	
	// 4.비밀번호찾기 [ 임시 비밀번호 발급 여부 판단  ]  
	public boolean findpassword( String mid , String memail) {
		String sql = "select * from member "
				+ "where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );
			ps.setString( 2 , memail );
			rs = ps.executeQuery();
			if( rs.next() ) return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	// 5. 임시 비밀번호 업데이트 
	public boolean passwordchange( String mid , String randstr ) {
		String sql ="update member set mpassword = ? "
				+ " where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , randstr  );
			ps.setString( 2 , mid );
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println(e); }
		return false;
	}
	
	// 6. 회원정보 호출 
	public MemberDto getinfo( String mid ) {
		MemberDto dto = null;
		String sql ="select * from member where mid = ?";
		try {
			ps =  con.prepareStatement(sql);
			ps.setString( 1 , mid );
			rs = ps.executeQuery();
			if( rs.next() ) {
				// 1. 풀생성자 
				dto = new MemberDto(
						rs.getInt( 1 ) , rs.getString( 2 ) , null ,
						rs.getString( 4 ), rs.getString( 5 ) ,
						rs.getString( 6 ), rs.getString( 7 ), 
						rs.getString( 8 ) , rs.getInt( 9 ) 
						);
				// 2. 반환
				return dto;
			}
		}catch (Exception e) { System.out.println( e );}
		return dto;
	}
	
	// 7. 모든 회원 호출 
	public ArrayList<MemberDto> getinfolist(){
		ArrayList<MemberDto> list = new ArrayList<>();	// 1.리스트 선언 
		String sql ="select * from member";	// 2. SQL 작성 
		try {
			ps = con.prepareStatement(sql);	// 3. SQL 연결 
			rs = ps.executeQuery();			// 4. SQL 실행 
			while( rs.next() ) {			// 5. SQL 결과 레코드 반복 호출
				MemberDto dto = new MemberDto(	// 6. 레코드 --> DTO 객체 생성 
						rs.getInt( 1 ) , rs.getString( 2 ) , null ,
						rs.getString( 4 ), rs.getString( 5 ) ,
						rs.getString( 6 ), rs.getString( 7 ), 
						rs.getString( 8 ) , rs.getInt( 9 ) 
						);
				list.add(dto);					// 7. DTO -> 리스트 담기
			}
			return list;						// 8. 리스트 반환
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	// 8. 회원탈퇴
	public boolean delete( String mid , String mpassword) {
		String sql = "delete from member"
				+ " where mid = ? and mpassword = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mid );	
			ps.setString( 2 , mpassword );
			int count = ps.executeUpdate();  // 삭제 레코드 수 반환
			if( count == 1 ) { return true; } 
			// 삭제된 레코드가 1개 이면 성공 
		}catch (Exception e) {System.out.println(e);} 
		return false;
	}
	// 9. 아이디 중복체크 
	public boolean idcheck( String mid ) {
		String sql ="select * from member where mid = ?";
		try {
			ps=con.prepareStatement(sql);	ps.setString( 1 , mid );
			rs = ps.executeQuery(); if( rs.next() ) return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	// 10. 이메일 중복체크
	public boolean emailcheck( String memail ) {
		String sql ="select * from member where memail = ?";
		try {
			ps = con.prepareStatement(sql); ps.setString( 1 , memail );
			rs = ps.executeQuery(); if( rs.next() ) return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	// 11. 회원정보 수정 
	public boolean update(String mid , String mname ) {
		String sql = "update member set mname = ? where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , mname );	ps.setString( 2 , mid );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	// 12. 회원아이디 ----> 회원번호
	public int getBno(String mid) {
		String sql = "select mno from member where mid =?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			// if문 (1개) vs while (여러개)
			if( rs.next()) {
				return rs.getInt(1);
			}else { return 0;}
		} catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}