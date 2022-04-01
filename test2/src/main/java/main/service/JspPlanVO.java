package main.service;

import java.util.Calendar;
import java.util.Date;

public class JspPlanVO {
	private int unq;
	private String userid;
	private String pdate;
	private String title;
	private String content;

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

	@Override
	public String toString() {
		return "jspPlanVO [unq=" + unq + ", userid=" + userid + ", pdate=" + pdate + ", title=" + title + ", content="
				+ content + "]";
	}

	
}
