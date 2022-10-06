package testjsp.model.dto;

public class testDto {
	private int testno;			
	private String testid;							
	private String testpassword;					
	private String testname;								
	private String testtitle;							
	private String testcontent;						
	private String testwriter;			
	private String testdate;		
	private int testpoint;
	
	public testDto(){}

	public testDto(int testno, String testid, String testpassword, String testname, String testtitle,
			String testcontent, String testwriter, String testdate, int testpoint) {
		super();
		this.testno = testno;
		this.testid = testid;
		this.testpassword = testpassword;
		this.testname = testname;
		this.testtitle = testtitle;
		this.testcontent = testcontent;
		this.testwriter = testwriter;
		this.testdate = testdate;
		this.testpoint = testpoint;
	}

	public int getTestno() {
		return testno;
	}

	public void setTestno(int testno) {
		this.testno = testno;
	}

	public String getTestid() {
		return testid;
	}

	public void setTestid(String testid) {
		this.testid = testid;
	}

	public String getTestpassword() {
		return testpassword;
	}

	public void setTestpassword(String testpassword) {
		this.testpassword = testpassword;
	}

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public String getTesttitle() {
		return testtitle;
	}

	public void setTesttitle(String testtitle) {
		this.testtitle = testtitle;
	}

	public String getTestcontent() {
		return testcontent;
	}

	public void setTestcontent(String testcontent) {
		this.testcontent = testcontent;
	}

	public String getTestwriter() {
		return testwriter;
	}

	public void setTestwriter(String testwriter) {
		this.testwriter = testwriter;
	}

	public String getTestdate() {
		return testdate;
	}

	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}

	public int getTestpoint() {
		return testpoint;
	}

	public void setTestpoint(int testpoint) {
		this.testpoint = testpoint;
	}

	@Override
	public String toString() {
		return "testDto [testno=" + testno + ", testid=" + testid + ", testpassword=" + testpassword + ", testname="
				+ testname + ", testtitle=" + testtitle + ", testcontent=" + testcontent + ", testwriter=" + testwriter
				+ ", testdate=" + testdate + ", testpoint=" + testpoint + "]";
	}
	
}
