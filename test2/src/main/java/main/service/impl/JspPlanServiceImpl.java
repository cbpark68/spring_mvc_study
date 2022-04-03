package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspPlanService;
import main.service.JspPlanVO;

@Service("jspPlanService")
public class JspPlanServiceImpl extends EgovAbstractServiceImpl implements JspPlanService{
	@Resource(name="jspPlanDAO")
	private JspPlanDAO jspPlanDAO;

	@Override
	public String jspPlanInsert(JspPlanVO vo) {
		return jspPlanDAO.jspPlanInsert(vo);
	}

	@Override
	public List<?> jspPlanList(JspPlanVO vo) {
		return jspPlanDAO.jspPlanList(vo);
	}

	@Override
	public JspPlanVO jspPlanSelect(JspPlanVO vo) {
		return jspPlanDAO.jspPlanSelect(vo);
	}

	@Override
	public int jspPlanUpdate(JspPlanVO vo) {
		return jspPlanDAO.jspPlanUpdate(vo);
	}

}
