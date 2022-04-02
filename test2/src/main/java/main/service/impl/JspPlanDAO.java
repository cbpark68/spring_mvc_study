package main.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspPlanVO;

@Repository("jspPlanDAO")
public class JspPlanDAO extends EgovAbstractDAOMysql{

	public String jspPlanInsert(JspPlanVO vo) {
		return (String)insert("jspPlanInsert", vo);
	}


}
