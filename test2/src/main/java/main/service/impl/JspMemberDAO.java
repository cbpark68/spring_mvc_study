package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspMemberVO;

@Repository("jspMemberDAO")
public class JspMemberDAO extends EgovAbstractDAOMysql{

	public int jspMemberGetNo() {
		return (int) select("jspMemberGetNo");
	}

	public JspMemberVO jspMemberInfo(JspMemberVO jspMemberVO) {
		return (JspMemberVO) select("jspMemberInfo",jspMemberVO);
	}

	public List<?> jspMemberList(JspMemberVO jspMemberVO) {
		return list("jspMemberList", jspMemberVO);
	}

	public int jspMemberDelete(JspMemberVO jspMemberVO) {
		return delete("jspMemberDelete",jspMemberVO);
	}

	public int jspMemberUpdate(JspMemberVO jspMemberVO) {
		return update("jspMemberUpdate",jspMemberVO);
	}

	public String jspMemberInsert(JspMemberVO jspMemberVO) {
		return (String) insert("jspMemberInsert",jspMemberVO);
	}

	public int jspMemberNoCheck(JspMemberVO jspMemberVO) {
		return (int) select("jspMemberNoCheck",jspMemberVO);
	}

	public List<?> jspFriendList(JspMemberVO jspMemberVO) {
		return list("jspFriendList", jspMemberVO);
	}

}
