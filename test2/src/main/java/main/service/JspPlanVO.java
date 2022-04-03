package main.service;

import java.util.Calendar;
import java.util.Date;

public class JspPlanVO {
	String crudgbn = "insert";
	private int unq;
	private String userid;
	private String pdate;
	private String title;
	private String content;
	private String ym;

	public String getCrudgbn() {
		return crudgbn;
	}
	//insert update delete만 가능
	public void setCrudgbn(String crudgbn) {
		if(!(crudgbn.contentEquals("update"))) 
			crudgbn = "insert";
		this.crudgbn = crudgbn;
	}

	public int getUnq() {
		return unq;
	}

	public void setUnq(int unq) {
		this.unq = unq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPdate() {
		if(this.pdate == null) {
			Calendar cal = Calendar.getInstance();
			this.pdate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
		}
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getYm() {
		return ym;
	}
	public void setYm(String ym) {
		this.ym = ym;
	}
	@Override
	public String toString() {
		return "JspPlanVO [crudgbn=" + crudgbn + ", unq=" + unq + ", userid=" + userid + ", pdate=" + pdate + ", title="
				+ title + ", content=" + content + ", ym=" + ym + "]";
	}
	
}
