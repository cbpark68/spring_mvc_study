package main.service;

import java.util.List;

public interface JspBoardService {
	public String jspBoardInsert(JspBoardVO jspBoardVO);
	public List<?> jspBoardList(JspBoardVO jspBoardVO);
	public JspBoardVO jspBoardSelect(JspBoardVO jspBoardVO);
	public int jspBoardUpdate(JspBoardVO jspBoardVO);
	public int jspBoardDelete(JspBoardVO jspBoardVO);
	public int jspBoardTotCnt();
	public int jspBoardHits(JspBoardVO jspBoardVO);
	public int jspBoardGid();
	public String jspBoardLthread(JspBoardVO jspBoardVO);
}
