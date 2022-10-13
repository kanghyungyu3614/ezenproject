package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	
	
	private static BoardDao bdao = new BoardDao();
	public static BoardDao  getInstance() { return bdao;}
	// 1. 글등록
	public boolean write( String btitle, String bcontent , int mno) {
		String sql = "insert into board(btitle, bcontent , mno) " 
				  + "values(?,?,?)";
		try {
		 ps = con.prepareStatement(sql);
		 ps.setString(1, btitle); 
		 ps.setString(2, bcontent);
		 ps.setInt(3, mno);
		 ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2. 글 출력
	public ArrayList<BoardDto> getlist() {
		
		ArrayList<BoardDto> list = new ArrayList<>();
		
		String sql = "select * from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				list.add(dto);
			}
			return list; 
		} catch (Exception e) {System.out.println(e);}return list;
	}
}
