package model.dto;

public class BoardDto {
//	   bno int auto_increment primary key,   -- 번호
//	   btitle varchar(1000),                 -- 제목
//	   bcontent longtext,                    -- 내용
//	   mno   int,                             -- 작성자(회원번호) or mno
//	   constraint bmno_fk foreign key (mno) REFERENCES member(mno)
	
	
	private int bno;
	private String btitle;
	private String bcontent;
	private int mno;
	
	public BoardDto () {}

	public BoardDto(int bno, String btitle, String bcontent, int mno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
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

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mno=" + mno + "]";
	}
	
	
}
