package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;
import main.service.JspBoardVO;

@Repository("jspBoardDAO")
public class JspBoardDAO extends EgovAbstractDAOMysql{

	public String jspBoardInsert(JspBoardVO jspBoardVO) {
		return (String) insert("jspBoardInsert", jspBoardVO);
	}

	public List<?> jspBoardList(JspBoardVO jspBoardVO) {
		return list("jspBoardList", jspBoardVO);
	}

	public JspBoardVO jspBoardSelect(JspBoardVO jspBoardVO) {
		return (JspBoardVO) select("jspBoardSelect", jspBoardVO);
	}

	public int jspBoardUpdate(JspBoardVO jspBoardVO) {
		return update("jspBoardUpdate",jspBoardVO);
	}

	public int jspBoardDelete(JspBoardVO jspBoardVO) {
		return delete("jspBoardDelete",jspBoardVO);
	}

	public int jspBoardTotCnt() {
		return (int) select("jspBoardTotCnt");
	}

	public int jspBoardHits(JspBoardVO jspBoardVO) {
		return (int) update("jspBoardHits", jspBoardVO);
	}

	public int jspBoardGid() {
		return (int) select("jspBoardGid");
	}

}
