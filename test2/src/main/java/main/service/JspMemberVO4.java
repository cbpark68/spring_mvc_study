package main.service;

public class JspMemberVO4 {
	private String userid;
	private String bpass;
	private String pass;
	private String apass;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBpass() {
		return bpass;
	}
	public void setBpass(String bpass) {
		this.bpass = bpass;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	@Override
	public String toString() {
		return "JspMemberVO4 [userid=" + userid + ", bpass=" + bpass + ", pass=" + pass + ", apass=" + apass + "]";
	}

}
