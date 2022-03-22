package main.service;

public class JspBoardVO {
	private String crudgbn = "insert";
	private String unq;
	private String title;
	private String pass;
	private String name;
	private String content;
	private int hits = 0;
	private String rdate;
	private int reqpgno = 1;
	private int startrow = 0;
	private int pgrow = 10;
	private int lastpgno = 0;
	private int totrow = 0;
	private int gid = 0;
	private String thread = "a";
	private String mode="root";
	private int threadlen = 0;
	
	public String getCrudgbn() {
		return crudgbn;
	}
	//insert update delete만 가능
	public void setCrudgbn(String crudgbn) {
		if(!(crudgbn.contentEquals("update")||crudgbn.contentEquals("delete"))) 
			crudgbn = "insert";
		this.crudgbn = crudgbn;
	}
	//페이지가 1보다 작으면 1, reqpgno는 먼저 세팅되어야 한다.
	public int getReqpgno() {
		if(reqpgno < 1) reqpgno = 1;
		return reqpgno;
	}
	//조회시 가져올 테이블의 row번호, reqpgno는 먼저 세팅되어야 한다.
	public int getStartrow() {
		startrow = (reqpgno-1)*pgrow;
		return startrow;
	}
	//마지막 페이지 번호, pgrow는 내부에 세팅되어 있지만 totrow는 외부에서 받아야 한다.
	public int getLastpgno() {
		lastpgno = (int)Math.ceil((double)totrow/pgrow);
		return lastpgno;
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


	public void setReqpgno(int reqpgno) {
		this.reqpgno = reqpgno;
	}


	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getPgrow() {
		return pgrow;
	}

	public void setPgrow(int pgrow) {
		this.pgrow = pgrow;
	}

	public void setLastpgno(int lastpg) {
		this.lastpgno = lastpg;
	}

	
	public int getTotrow() {
		return totrow;
	}

	public void setTotrow(int totrow) {
		this.totrow = totrow;
	}

	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
	}
	
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		if(!(mode.contentEquals("branch")))
			mode = "root";
		this.mode = mode;
	}
	public int getThreadlen() {
		return threadlen;
	}
	public void setThreadlen(int threadlen) {
		this.threadlen = threadlen;
	}
	@Override
	public String toString() {
		return "JspBoardVO [crudgbn=" + crudgbn + ", unq=" + unq + ", title=" + title + ", pass=" + pass + ", name="
				+ name + ", content=" + content + ", hits=" + hits + ", rdate=" + rdate + ", reqpgno=" + reqpgno
				+ ", startrow=" + startrow + ", pgrow=" + pgrow + ", lastpgno=" + lastpgno + ", totrow=" + totrow
				+ ", gid=" + gid + ", thread=" + thread + ", mode=" + mode + "]";
	}

	
}
