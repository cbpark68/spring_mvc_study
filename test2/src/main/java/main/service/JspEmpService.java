package main.service;

import java.util.List;

public interface JspEmpService {

	public String jspEmpInsert(JspEmpVO pvo) throws Exception;
	public int jspEmpIdCheck(JspEmpVO pvo) throws Exception;
	public int jspEmpDeptnoCheck(JspEmpVO pvo) throws Exception;
	public List<?> jspEmpList(JspEmpVO pvo) throws Exception;
	public int jspEmpCount() throws Exception;
	public int jspEmpGetEmpno() throws Exception;
	public JspEmpVO jspEmpInfo(JspEmpVO jspEmpVO);
	public int jspEmpUpdate(JspEmpVO jspEmpVO);
}
