package model.dao;

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
}
