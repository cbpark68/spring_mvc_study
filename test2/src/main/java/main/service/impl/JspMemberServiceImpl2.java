package main.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspMemberService2;
import main.service.JspMemberVO2;

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

}
