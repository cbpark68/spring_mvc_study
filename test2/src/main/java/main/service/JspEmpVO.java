package main.service;

public class JspEmpVO {
	private String empno;
	private String ename;
	private int sal;
	private String job;
	private int deptno;
	private String hiredate;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "JspEmpVO [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", job=" + job + ", deptno=" + deptno
				+ ", hiredate=" + hiredate + "]";
	}


}
