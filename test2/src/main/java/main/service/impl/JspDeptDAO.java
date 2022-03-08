package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspDeptVO;

@Repository("jspDeptDAO")
public class JspDeptDAO extends EgovAbstractDAOMysql{

	public List<?> jspDeptList() {
		return list("jspDeptList");
	}

	public String jspDeptInsert(JspDeptVO vo) {
		return (String) insert("jspDeptInsert",vo);
	}

	public JspDeptVO jspDeptInfo(JspDeptVO vo) {
		return (JspDeptVO) select("jspDeptInfo",vo);
	}

	public int jspDeptUpdate(JspDeptVO pvo) {
		return update("jspDeptUpdate", pvo);
	}

	public int jspDeptDelete(JspDeptVO pvo) {
		return delete("jspDeptDelete", pvo);
	}

	public int jspDeptCount(JspDeptVO pvo) {
		return (int) select("jspDeptCount", pvo);
	}

}
