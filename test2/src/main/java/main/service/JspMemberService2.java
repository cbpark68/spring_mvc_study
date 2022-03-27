package main.service;

import java.util.List;

public interface JspMemberService2 {
	public int jspMemberIdCheck2(String userid);
	public String jspMemberInsert2(JspMemberVO2 jspMemberVO2);
	public List<?> jspPostSearch(String dong);
}
