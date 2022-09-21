package java1.키오스크.관리자;

public class ProductDTO {
  private int pno;
  private String pname;
  private int pprice;
  private String pcomment;
  private short pamount;
  private byte mno;
  
  //2. 생성자
    public ProductDTO() {}

    public ProductDTO(int pno, String pname, int pprice, String pcomment, short pamount, byte mno) {
	  super();
	  this.pno = pno;
	  this.pname = pname;
	  this.pprice = pprice;
	  this.pcomment = pcomment;
	  this.pamount = pamount;
	  this.mno = mno;
    }
    // 3. 메소드 [private 필수 요소]

	public int getPno() {
		return pno;
	}
	
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public int getPprice() {
		return pprice;
	}
	
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	
	public String getPcomment() {
		return pcomment;
	}
	
	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}
	
	public short getPamount() {
		return pamount;
	}
	
	public void setPamount(short pamount) {
		this.pamount = pamount;
	}
	
	public byte getMno() {
		return mno;
	}
	
	public void setMno(byte mno) {
		this.mno = mno;
	}
  
  
}
