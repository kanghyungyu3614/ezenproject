package jspweb.model.dto;

public class MemberDto {
	
	// 1. 필드 private 
	// 2. 생성자 
	// 3. 
	// 4.
	
	private String id;
 	private String pw;
 	private String name;
 	private String phone;
 	
 	public MemberDto() {}

	public MemberDto(String id, String pw, String name, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
	}
 	
}
