package main.service;

import java.util.List;

import egovframework.example.sample.service.DeptVO;

public interface MysqlService {
	public int selectTestCnt() throws Exception;
	public List<?> selectBoardList() throws Exception;
	public String insertDept(DeptVO vo) throws Exception;
	public List<?> selectDeptList() throws Exception;
}
