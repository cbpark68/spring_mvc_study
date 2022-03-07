package main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;
import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;

@Repository("mysqlDAO")
public class MysqlDAO extends EgovAbstractDAOMysql{

	public int selectTestCnt() {
		int cnt = (int) select("mysqlDAO.selectTestCnt");
		System.out.println("mysqlcount = "+cnt);
		return cnt;
	}

	public List<?> selectBoardList() {
		List<?> list =  list("mysqlDAO.selectBoardList");
		System.out.println("boardList = "+list);
		return list;
	}

	public String insertDept(DeptVO vo) {
		return (String) insert("mysqlDAO.insertDept",vo);
	}

	public List<?> selectDeptList() {
		return list("mysqlDAO.selectDeptList");
	}

}
