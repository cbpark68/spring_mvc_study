package main.service;

public class JspMemberVO2 {
	private String userid;
	private String pass;
	private String name;
	private String birthday;
	private String gender;
	private String mobile;
	private String zipcode;
	private String addr;
	private String rdate;
	private String idchk;
	private String crudgbn = "insert";

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getIdchk() {
		return idchk;
	}
	public void setIdchk(String idchk) {
		this.idchk = idchk;
	}
	public String getCrudgbn() {
		return crudgbn;
	}
	//insert update delete만 가능
	public void setCrudgbn(String crudgbn) {
		if(!(crudgbn.contentEquals("update"))) 
			crudgbn = "insert";
		this.crudgbn = crudgbn;
	}
	@Override
	public String toString() {
		return "JspMemberVO2 [userid=" + userid + ", pass=" + pass + ", name=" + name + ", birthday=" + birthday
				+ ", gender=" + gender + ", mobile=" + mobile + ", zipcode=" + zipcode + ", addr=" + addr + ", rdate="
				+ rdate + ", idchk=" + idchk + ", crudgbn=" + crudgbn + "]";
	}
	
	
}
