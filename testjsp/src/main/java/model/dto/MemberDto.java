package model.dto;

public class MemberDto {
	// DB테이블 필드명 <-- 필드명 ---> java 필드 
	private int mno;			
	private String mtitle	;							
	private String mcontent	;							
	private String mwriter	;								
	private String mpassword;					
	private String mdate	;		
	private int mpoint		;
	
	// 생성자2개 , set/get , toString => 자동완성 
	public MemberDto() {}

	public MemberDto(int mno, String mtitle, String mcontent, String mwriter, String mpassword, String mdate,
			int mpoint) {
		super();
		this.mno = mno;
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mwriter = mwriter;
		this.mpassword = mpassword;
		this.mdate = mdate;
		this.mpoint = mpoint;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getMwriter() {
		return mwriter;
	}

	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mtitle=" + mtitle + ", mcontent=" + mcontent + ", mwriter=" + mwriter
				+ ", mpassword=" + mpassword + ", mdate=" + mdate + ", mpoint=" + mpoint + "]";
	}
	
	
}
