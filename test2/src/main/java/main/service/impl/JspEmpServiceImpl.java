package main.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspEmpService;
import main.service.JspEmpVO;

@Service("jspEmpService")
public class JspEmpServiceImpl extends EgovAbstractServiceImpl implements JspEmpService{

	@Resource(name="jspEmpDAO")
	private JspEmpDAO jspEmpDAO;
	
	@Override
	public String jspEmpInsert(JspEmpVO pvo) throws Exception {
		return jspEmpDAO.jspEmpInsert(pvo);
	}

	@Override
	public int jspEmpIdCheck(JspEmpVO pvo) throws Exception {
		return jspEmpDAO.jspEmpIdCheck(pvo);
	}

	@Override
	public int jspEmpDeptnoCheck(JspEmpVO pvo) throws Exception {
		return jspEmpDAO.jspEmpDeptnoCheck(pvo);
	}

}
