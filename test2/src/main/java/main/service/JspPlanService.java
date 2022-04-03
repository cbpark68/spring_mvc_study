package main.service;

import java.util.List;

public interface JspPlanService {
	String jspPlanInsert(JspPlanVO vo);
	List<?> jspPlanList(JspPlanVO vo);
	JspPlanVO jspPlanSelect(JspPlanVO vo);
	int jspPlanUpdate(JspPlanVO vo);
}
