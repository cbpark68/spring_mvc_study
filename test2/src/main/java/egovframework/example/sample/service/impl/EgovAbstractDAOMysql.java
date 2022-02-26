package egovframework.example.sample.service.impl;

import javax.annotation.Resource;

import com.ibatis.sqlmap.client.SqlMapClient;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

public class EgovAbstractDAOMysql extends EgovAbstractDAO {
    @Override
    @Resource(name = "sqlMapClient-mysql")
    public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
        super.setSuperSqlMapClient(sqlMapClient);
    }
}
