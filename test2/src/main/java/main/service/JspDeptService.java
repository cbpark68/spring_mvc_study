package main.service;

import java.util.List;

public interface JspDeptService {
	public List<?> jspDeptList() throws Exception;
	public String jspDeptInsert(JspDeptVO vo) throws Exception;
	public JspDeptVO jspDeptInfo(JspDeptVO vo) throws Exception;
	public int jspDeptUpdate(JspDeptVO pvo);
	public int jspDeptDelete(JspDeptVO pvo);
	public int jspDeptCount(JspDeptVO pvo);
}
