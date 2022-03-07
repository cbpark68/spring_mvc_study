package main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.DeptVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import main.service.MysqlService;

@Service("mysqlService")
public class MysqlServiceImpl extends EgovAbstractServiceImpl implements MysqlService {

	@Resource(name="mysqlDAO")
	private MysqlDAO mysqlDAO;

	@Override
	public int selectTestCnt() throws Exception {
		return mysqlDAO.selectTestCnt();
	}

	@Override
	public List<?> selectBoardList() throws Exception {
		return mysqlDAO.selectBoardList();
	}

	@Override
	public String insertDept(DeptVO vo) throws Exception {
		return mysqlDAO.insertDept(vo);
	}

	@Override
	public List<?> selectDeptList() throws Exception {
		return mysqlDAO.selectDeptList();
	}

}
