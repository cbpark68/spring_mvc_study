package main.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.impl.EgovAbstractDAOMysql;

@Repository("mysqlDAO")
public class MysqlDAO extends EgovAbstractDAOMysql{

	public int selectTestCnt() {
		int cnt = (int) select("mysqlDAO.selectTestCnt");
		System.out.println("mysqlcount = "+cnt);
		return cnt;
	}

}
