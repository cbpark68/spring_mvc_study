package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspEmpVO;

@Repository("jspEmpDAO")
public class JspEmpDAO extends EgovAbstractDAOMysql{

	public String jspEmpInsert(JspEmpVO pvo) {
		return (String) insert("jspEmpInsert", pvo);
	}

	public int jspEmpIdCheck(JspEmpVO pvo) {
		return (int) select("jspEmpIdCheck", pvo);
	}

	public int jspEmpDeptnoCheck(JspEmpVO pvo) {
		return (int) select("jspEmpDeptnoCheck", pvo);
	}

	public List<?> jspEmpList(JspEmpVO pvo) {
		return list("jspEmpList", pvo);
	}

	public int jspEmpCount() {
		return (int) select("jspEmpCount");
	}

	public int jspEmpGetEmpno() {
		return (int) select("jspEmpGetEmpno");
	}

	public JspEmpVO jspEmpInfo(JspEmpVO jspEmpVO) {
		return (JspEmpVO) select("jspEmpInfo",jspEmpVO);
	}

	public int jspEmpUpdate(JspEmpVO jspEmpVO) {
		return update("jspEmpUpdate", jspEmpVO);
	}

}
