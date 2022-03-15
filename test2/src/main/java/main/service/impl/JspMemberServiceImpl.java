package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspMemberService;
import main.service.JspMemberVO;

@Service("jspMemberService")
public class JspMemberServiceImpl extends EgovAbstractServiceImpl implements JspMemberService{
	
	@Resource(name="jspMemberDAO")
	private JspMemberDAO jspMemberDAO;

	@Override
	public int jspMemberGetNo() {
		return jspMemberDAO.jspMemberGetNo();
	}

	@Override
	public String jspMemberInsert(JspMemberVO jspMemberVO) {
		return jspMemberDAO.jspMemberInsert(jspMemberVO);
	}

	@Override
	public int jspMemberUpdate(JspMemberVO jspMemberVO) {
		return jspMemberDAO.jspMemberUpdate(jspMemberVO);
	}

	@Override
	public int jspMemberDelete(JspMemberVO jspMemberVO) {
		return jspMemberDAO.jspMemberDelete(jspMemberVO);
	}

	@Override
	public List<?> jspMemberList(JspMemberVO jspMemberVO) {
		return jspMemberDAO.jspMemberList(jspMemberVO);
	}

	@Override
	public JspMemberVO jspMemberInfo(JspMemberVO jspMemberVO) {
		return  jspMemberDAO.jspMemberInfo(jspMemberVO);
	}

}
