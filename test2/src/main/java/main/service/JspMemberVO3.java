package main.service;

public class JspMemberVO3 {
	private String userid;
	private String pass;
	private boolean saveChk = false;

	public JspMemberVO3() {}

	public JspMemberVO3(String userid,String pass){
		this.userid = userid;
		this.pass = pass;
	}

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
	public boolean getSaveChk() {
		return saveChk;
	}

	public void setSaveChk(boolean saveChk) {
		this.saveChk = saveChk;
	}

	@Override
	public String toString() {
		return "JspMemberVO3 [userid=" + userid + ", pass=" + pass + ", saveChk=" + saveChk + "]";
	}

	
}
