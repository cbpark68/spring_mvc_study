package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspMemberService2;
import main.service.JspMemberVO2;
import main.service.JspMemberVO3;
import main.service.JspMemberVO4;

@Service("jspMemberService2")
public class JspMemberServiceImpl2 extends EgovAbstractServiceImpl implements JspMemberService2{

	@Resource(name="jspMemberDAO2")
	private  JspMemberDAO2 jspMemberDAO2;

	@Override
	public int jspMemberIdCheck2(String userid) {
		return jspMemberDAO2.jspMemberIdChk2(userid);
	}

	@Override
	public String jspMemberInsert2(JspMemberVO2 jspMemberVO2) {
		return jspMemberDAO2.jspMemberInsert2(jspMemberVO2);
	}

	@Override
	public List<?> jspPostSearch(String dong) {
		return jspMemberDAO2.jspPostSearch(dong);
	}

	@Override
	public int jspMemberLogin2(JspMemberVO3 jspMemberVO3) {
		return jspMemberDAO2.jspMemberLogin2(jspMemberVO3);
	}

	@Override
	public JspMemberVO2 jspMemberSelect2(JspMemberVO2 jspMemberVO2) {
		return jspMemberDAO2.jspMemberSelect2(jspMemberVO2);
	}

	@Override
	public int jspMemberUpdate2(JspMemberVO2 jspMemberVO2) {
		return jspMemberDAO2.jspMemberUpdate2(jspMemberVO2);
	}

	@Override
	public int jspMemberUpdatePass2(JspMemberVO4 jspMemberVO4) {
		return jspMemberDAO2.jspMemberUpdatePass2(jspMemberVO4);
	}

}
