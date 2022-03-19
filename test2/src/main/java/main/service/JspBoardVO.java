package main.service;

public class JspBoardVO {
	private String crudgbn;
	private String unq;
	private String title;
	private String pass;
	private String name;
	private String content;
	private int hits;
	private String rdate;
	
	public String getCrudgbn() {
		return crudgbn;
	}
	public void setCrudgbn(String crudgbn) {
		this.crudgbn = crudgbn;
	}
	public String getUnq() {
		return unq;
	}
	public void setUnq(String unq) {
		this.unq = unq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "JspBoardVO [crudgbn=" + crudgbn + ", unq=" + unq + ", title=" + title + ", pass=" + pass + ", name="
				+ name + ", content=" + content + ", hits=" + hits + ", rdate=" + rdate + "]";
	}
	
	
	
}
