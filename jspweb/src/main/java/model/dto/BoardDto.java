package model.dto;

public class BoardDto {
	
	private int bno;		;	
	private String btitle	;					
	private String bcontent	;		
	private String bfile 	;
	private String bdate 	;
	private int bview  		;
	private int cno  		;
	private int mno 		;	// 필요시 삭제 가능
	
	private String mid	;		// 게시물 출력용 
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	


	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int cno, int mno,
			String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.cno = cno;
		this.mno = mno;
		this.mid = mid;
	}




	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mno=" + mno + ", bfile="
				+ bfile + ", bdate=" + bdate + ", bview=" + bview + ", cno=" + cno + ", mid=" + mid + "]";
	}
	
	
	

	
	
}