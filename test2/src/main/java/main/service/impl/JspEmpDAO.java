package main.service.impl;

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

}
