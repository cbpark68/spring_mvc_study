package main.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspEmpVO;

@Repository("jspEmpDAO")
public class JspEmpDAO extends EgovAbstractDAOMysql{

	public String jspEmpInsert(JspEmpVO pvo) {
		return (String) insert("jspEmpInsert", pvo);
	}

}
