package main.service;

import java.util.List;

public interface JspMemberService2 {
	public int jspMemberIdCheck2(String userid);
	public String jspMemberInsert2(JspMemberVO2 jspMemberVO2);
	public List<?> jspPostSearch(String dong);
	public int jspMemberLogin2(JspMemberVO3 jspMemberVO3);
	public JspMemberVO2 jspMemberSelect2(JspMemberVO2 jspMemberVO2);
	public int jspMemberUpdate2(JspMemberVO2 jspMemberVO2);
	public int jspMemberUpdatePass2(JspMemberVO4 jspMemberVO4);
}
