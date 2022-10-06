package model.dto;

public class MemberDto {
	// DB테이블 필드명 <-- 필드명 ---> java 필드 
	private int mno;			
	private String mid	;							
	private String mpassword;					
	private String mname	;								
	private String mphone	;							
	private String memail	;						
	private String maddress	;			
	private String mdate	;		
	private int mpoint		;
	
	// 생성자2개 , set/get , toString => 자동완성 
	public MemberDto() {}

	public MemberDto(int mno, String mid, String mpassword, String mname, String mphone, String memail, String maddress,
			String mdate, int mpoint) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddress = maddress;
		this.mdate = mdate;
		this.mpoint = mpoint;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
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
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone="
				+ mphone + ", memail=" + memail + ", maddress=" + maddress + ", mdate=" + mdate + ", mpoint=" + mpoint
				+ "]";
	}
	
	
}
