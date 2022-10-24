package model.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dto.BoardDto;

public class BoardDao extends Dao {
	
	private static BoardDao bdao = new BoardDao();
	public static BoardDao getInstance() { return bdao; }
	
	// 1. 글등록 
	public boolean write( String btitle , String bcontent , int mno , String bfile ) {
		
		String sql ="insert into board( btitle , bcontent , mno , bfile) "
				+ "values( ? , ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , btitle );	ps.setString( 2 , bcontent );
			ps.setInt( 3 , mno);		ps.setString( 4 , bfile );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println( e );}
		return false;
	}
	// 2. 글출력
	public ArrayList< BoardDto > getlist( int startrow , int listsize , String key , String keyword ) {
		ArrayList< BoardDto > list = new ArrayList<>();
		String sql = "";
		if( !key.equals("") && !keyword.equals("") ) { // 검색이 있을경우 
			sql = "select b.* , m.mid "
					+ "from member m , board b "
					+ "where m.mno = b.mno and "+key+" like '%"+keyword+"%' "
					+ "order by b.bdate desc "
					+ "limit "+startrow+" , "+listsize;
		}else { // 검색이 없을경우
			sql = "select b.* , m.mid from member m , board b "
					+ "where m.mno = b.mno "
					+ "order by b.bdate desc limit "+startrow+" , "+listsize;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// if[한개] -> dto vs while[여러개] -> list
			while( rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9)
						);
				list.add(dto); // 리스트에 담기
			}
			return list;
		}
		catch (Exception e) {System.out.println(e);} return list;
	}
	
	// 3. 글 조회
	public BoardDto getboard( int bno) {
		String sql ="select b.* , m.mid from member m , board b where m.mno = b.mno and bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9)
						);
				return dto;
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 4. 글 삭제 
	public boolean delete( int bno ) {
		String sql = "delete from board "
				+ " where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate(); 
			if( count == 1 ) return true;
		}catch (Exception e) {
			System.out.println( e );
		} return false;
		
	}
	// 5. 첨부파일만 삭제[업데이트]
	public boolean bfiledelete( int bno ) {
		String sql = "update board set bfile = null where bno = "+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println(e);	} return false;
		
	}
	
	// 6. 게시물 수정 
	public boolean bupdate( int bno , String btitle , 
			String content , String bfile ) {
		
		String sql = "update board set btitle = ? , "
				+ " bcontent=? , bfile = ? "
				+ " where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , btitle );
			ps.setString( 2 , content );
			ps.setString( 3 , bfile );
			ps.setInt( 4 , bno );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	// 7. 조회수 증가 
	public void bviewupdate( int bno ) {
		String sql = "update board "
				+ " set bview = bview+1 "
				+ " where bno = "+ bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch (Exception e) {System.out.println(e);}
	}
	
	// 8. 전체 게시물 수 
	public int gettotalsize( String key , String keyword ) {
		String sql = "";
		if( !key.equals("") && !keyword.equals("") ) { // 검색이 있을경우
			 sql = "select count(*) from member m , board b where m.mno = b.mno and "+key+" like '%"+keyword+"%'";
		}else { // 검색이 없을경우 
			 sql = "select count(*) from member m , board b where m.mno = b.mno";
		}
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			if( rs.next() ) return rs.getInt(1);
		}catch (Exception e) {System.out.println(e);} return 0;
	}
	///////////////////////////////////////////////// 댓글 /////////////////////////////////////
	// 9. 댓글 작성 
	public boolean rwrite( String rcontent , int mno , int bno ) {
		String sql = "insert into reply( rcontent , mno , bno ) values( ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , rcontent ); ps.setInt( 2 , mno ); ps.setInt( 3 , bno );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	// 9-2. 대댓글 작성 
	public boolean rrwrite( String rcontent , int mno , int bno , int rindex ) {
		String sql = "insert into reply( rcontent , mno , bno , rindex ) values( ? , ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , rcontent ); 	ps.setInt( 2 , mno ); 
			ps.setInt( 3 , bno );			ps.setInt( 4 , rindex );
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	// 10. 댓글 호출
	public JSONArray getrlist( int bno ) {
		JSONArray array = new JSONArray();
		String sql = "select r.rcontent , r.rdate , m.mid , r.rno"
				+ " from reply r , member m "
				+ " where r.mno = m.mno and r.bno = "+bno+" and r.rindex = 0 "
				+ " order by r.rdate desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				JSONObject object = new JSONObject();
				object.put( "rcontent", rs.getString(1) );
				object.put( "rdate", rs.getString(2) );
				object.put( "mid", rs.getString(3) );
				object.put( "rno", rs.getInt(4) );
				array.add(object);
			}
		}catch (Exception e) {} return array;
	}
	// 10-2. 대댓글 호출
	public JSONArray getrrlist( int bno , int rindex ) {
		JSONArray array = new JSONArray();
		String sql = "select r.rcontent , r.rdate , m.mid , r.rno"
				+ " from reply r , member m "
				+ " where r.mno = m.mno and r.bno = "+bno+" and r.rindex = "+rindex
				+ " order by r.rdate desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				JSONObject object = new JSONObject();
				object.put( "rcontent", rs.getString(1) );
				object.put( "rdate", rs.getString(2) );
				object.put( "mid", rs.getString(3) );
				object.put( "rno", rs.getInt(4) );
				array.add(object);
			}
		}catch (Exception e) {} return array;
	}
	
	// 11. 아파트실거래가 테이블 호출
		public JSONArray getapi() {
			JSONArray array = new JSONArray();
			String sql = "SELECT * FROM 아파트매매실거래가 where 시군구 like '%경기도 안산%'";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					JSONObject object = new JSONObject();
					object.put("시군구", rs.getString( 1 ) );
					object.put("번지본번부번", rs.getInt( 2 ) +"/"+ rs.getString( 3 ) +"/"+ rs.getString( 4 ) );
					object.put("단지명",  rs.getString( 5 ) );
					object.put("전용면적",  rs.getString( 6 ) );
					object.put("계약년월",  rs.getString( 7 ) );
					object.put("계약일",  rs.getString( 8 ) );
					object.put("계약금액",  rs.getString( 9 ) );
					object.put("층",  rs.getString( 10 ) );
					object.put("건축년도",  rs.getString( 11 ) );
					object.put("도로명",  rs.getString( 12 ) );
					object.put("해제사유발생일",  rs.getString( 13 ) );
					object.put("거래유형",  rs.getString( 14 ) );
					object.put("중개사소재지",  rs.getString( 15 ) );
					array.add(object);
				}
			}catch (Exception e) { System.out.println(); } return array;
			
		}
		
		
	}
