package model.dto;

public class BoardDto {
	private int boardno;
	private String boarduserid;
	private String boarduserpassword;
	private String boardusername;
	private String boardtitle;
	private String boardcontent;
	private String boardwriter;
	private String boarddate;
	private int boardpoint;
	
	public BoardDto() {}
	public BoardDto(int boardno, String boarduserid, String boarduserpassword, String boardusername, String boardtitle,
			String boardcontent, String boardwriter, String boarddate, int boardpoint) {
		super();
		this.boardno = boardno;
		this.boarduserid = boarduserid;
		this.boarduserpassword = boarduserpassword;
		this.boardusername = boardusername;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.boardwriter = boardwriter;
		this.boarddate = boarddate;
		this.boardpoint = boardpoint;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getBoarduserid() {
		return boarduserid;
	}
	public void setBoarduserid(String boarduserid) {
		this.boarduserid = boarduserid;
	}
	public String getBoarduserpassword() {
		return boarduserpassword;
	}
	public void setBoarduserpassword(String boarduserpassword) {
		this.boarduserpassword = boarduserpassword;
	}
	public String getBoardusername() {
		return boardusername;
	}
	public void setBoardusername(String boardusername) {
		this.boardusername = boardusername;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public String getBoardwriter() {
		return boardwriter;
	}
	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}
	public String getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	public int getBoardpoint() {
		return boardpoint;
	}
	public void setBoardpoint(int boardpoint) {
		this.boardpoint = boardpoint;
	}
	@Override
	public String toString() {
		return "BoardDto [boardno=" + boardno + ", boarduserid=" + boarduserid + ", boarduserpassword="
				+ boarduserpassword + ", boardusername=" + boardusername + ", boardtitle=" + boardtitle
				+ ", boardcontent=" + boardcontent + ", boardwriter=" + boardwriter + ", boarddate=" + boarddate
				+ ", boardpoint=" + boardpoint + "]";
	}
	
}
