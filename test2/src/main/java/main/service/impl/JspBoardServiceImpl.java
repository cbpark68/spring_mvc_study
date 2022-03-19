package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.JspBoardService;
import main.service.JspBoardVO;

@Service("jspBoardService")
public class JspBoardServiceImpl extends EgovAbstractServiceImpl implements JspBoardService{

	@Resource(name="jspBoardDAO")
	private JspBoardDAO jspBoardDAO;

	@Override
	public String jspBoardInsert(JspBoardVO jspBoardVO) {
		return jspBoardDAO.jspBoardInsert(jspBoardVO);
	}

	@Override
	public List<?> jspBoardList(JspBoardVO jspBoardVO) {
		return jspBoardDAO.jspBoardList(jspBoardVO);
	}

	@Override
	public JspBoardVO jspBoardSelect(JspBoardVO jspBoardVO) {
		return jspBoardDAO.jspBoardSelect(jspBoardVO);
	}

	@Override
	public int jspBoardUpdate(JspBoardVO jspBoardVO) {
		return jspBoardDAO.jspBoardUpdate(jspBoardVO);
	}

	@Override
	public int jspBoardDelete(JspBoardVO jspBoardVO) {
		return jspBoardDAO.jspBoardDelete(jspBoardVO);
	}

	@Override
	public int jspBoardTotCnt() {
		return jspBoardDAO.jspBoardTotCnt();
	}

	@Override
	public int jspBoardHits(JspBoardVO jspBoardVO) {
		return jspBoardDAO.jspBoardHits(jspBoardVO);
	}

}
