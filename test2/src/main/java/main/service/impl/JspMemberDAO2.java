package main.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspMemberVO2;

@Repository("jspMemberDAO2")
public class JspMemberDAO2 extends EgovAbstractDAOMysql{

	public int jspMemberIdChk2(String userid) {
		return (int) select("jspMemberIdChk2",userid);
	}

}
