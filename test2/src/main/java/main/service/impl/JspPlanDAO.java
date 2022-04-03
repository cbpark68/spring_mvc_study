package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspPlanVO;

@Repository("jspPlanDAO")
public class JspPlanDAO extends EgovAbstractDAOMysql{

	public String jspPlanInsert(JspPlanVO vo) {
		return (String)insert("jspPlanInsert", vo);
	}

	public List<?> jspPlanList(JspPlanVO vo) {
		return list("jspPlanList",vo);
	}

	public JspPlanVO jspPlanSelect(JspPlanVO vo) {
		return (JspPlanVO) select("jspPlanSelect",vo);
	}

	public int jspPlanUpdate(JspPlanVO vo) {
		return update("jspPlanUpdate",vo);
	}


}
