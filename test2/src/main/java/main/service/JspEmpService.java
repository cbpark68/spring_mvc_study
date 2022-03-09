package main.service;

public interface JspEmpService {

	public String jspEmpInsert(JspEmpVO pvo) throws Exception;
	public int jspEmpIdCheck(JspEmpVO pvo) throws Exception;
	public int jspEmpDeptnoCheck(JspEmpVO pvo) throws Exception;
}
