package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspDeptService;
import main.service.JspDeptVO;

@Service("jspDeptService")
public class JspDeptServiceImpl extends EgovAbstractServiceImpl implements JspDeptService{

	@Resource(name="jspDeptDAO")
	private JspDeptDAO jspDeptDAO;
	
	@Override
	public List<?> jspDeptList() throws Exception {
		return jspDeptDAO.jspDeptList();
	}

	@Override
	public String jspDeptInsert(JspDeptVO vo) throws Exception {
		return jspDeptDAO.jspDeptInsert(vo);
	}

	@Override
	public JspDeptVO jspDeptInfo(JspDeptVO vo) throws Exception {
		return jspDeptDAO.jspDeptInfo(vo);
	}

	@Override
	public int jspDeptUpdate(JspDeptVO pvo) {
		return jspDeptDAO.jspDeptUpdate(pvo);
	}

	@Override
	public int jspDeptDelete(JspDeptVO pvo) {
		return jspDeptDAO.jspDeptDelete(pvo);
	}

	@Override
	public int jspDeptCount(JspDeptVO pvo) {
		return jspDeptDAO.jspDeptCount(pvo);
	}

}
