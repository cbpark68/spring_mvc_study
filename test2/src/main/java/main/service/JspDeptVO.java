package main.service;

public class JspDeptVO {

	private int deptno;
	private String dname;
	private String loc;
	private String crudgbn;

	public String getCrudgbn() {
		return crudgbn;
	}

	public void setCrudgbn(String crudgbn) {
		this.crudgbn = crudgbn;
	}

	public String getCurdgbn() {
		return crudgbn;
	}

	public void setCurdgbn(String crudgbn) {
		this.crudgbn = crudgbn;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "JspDeptVO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", crudgbn=" + crudgbn + "]";
	}


}