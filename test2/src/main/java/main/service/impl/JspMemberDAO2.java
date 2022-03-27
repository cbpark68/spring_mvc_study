package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspMemberVO2;

@Repository("jspMemberDAO2")
public class JspMemberDAO2 extends EgovAbstractDAOMysql{

	public int jspMemberIdChk2(String userid) {
		return (int) select("jspMemberIdChk2",userid);
	}

	public String jspMemberInsert2(JspMemberVO2 jspMemberVO2) {
		return (String) insert("jspMemberInsert2", jspMemberVO2);
	}

	public List<?> jspPostSearch(String dong) {
		return list("jspPostSearch",dong);
	}

}
