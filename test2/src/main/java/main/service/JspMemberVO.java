package main.service;

public class JspMemberVO {
	private String member_no;
	private String member_id;
	private String member_name;
	private String member_grade;
	private String member_hobby;
	private String member_date;
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_grade() {
		return member_grade;
	}
	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}
	public String getMember_hobby() {
		return member_hobby;
	}
	public void setMember_hobby(String member_hobby) {
		this.member_hobby = member_hobby;
	}
	public String getMember_date() {
		return member_date;
	}
	public void setMember_date(String member_date) {
		this.member_date = member_date;
	}
	@Override
	public String toString() {
		return "JspMemberVO [member_no=" + member_no + ", member_id=" + member_id + ", member_name=" + member_name
				+ ", member_grade=" + member_grade + ", member_hobby=" + member_hobby + ", member_date=" + member_date
				+ "]";
	}

	
	
}
