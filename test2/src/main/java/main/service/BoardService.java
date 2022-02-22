package main.service;

import java.util.List;

public interface BoardService {
	public String insertBoard(BoardVO vo) throws Exception;
	public List<?> selectBoard(BoardVO vo) throws Exception;
	public int selectBoardTotal(BoardVO vo) throws Exception;
	public BoardVO selectBoardDetail(int unq) throws Exception;
	public int updateBoardHits(int unq) throws Exception;
}
