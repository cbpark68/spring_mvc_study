package main.service;

import java.util.List;

public interface MysqlService {
	public int selectTestCnt() throws Exception;
	public List<?> selectBoardList() throws Exception;
}
