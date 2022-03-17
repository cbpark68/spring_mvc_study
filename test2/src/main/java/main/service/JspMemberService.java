package main.service;

import java.util.List;

public interface JspMemberService {
	public int jspMemberGetNo();
	public String jspMemberInsert(JspMemberVO jspMemberVO);
	public int jspMemberUpdate(JspMemberVO jspMemberVO);
	public int jspMemberDelete(JspMemberVO jspMemberVO);
	public List<?> jspMemberList(JspMemberVO jspMemberVO);
	public JspMemberVO jspMemberInfo(JspMemberVO jspMemberVO);
	public int jspMemberNoCheck(JspMemberVO jspMemberVO);
	public List<?> jspFriendList(JspMemberVO jspMemberVO);
}
