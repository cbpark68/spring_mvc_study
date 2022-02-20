package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO {

	public String insertDAO(DeptVO vo) {
		return (String) insert("deptDAO.insertDept", vo);
	}

	public List<?> selectDeptList(DeptVO vo) {
		return list("deptDAO.selectDeptList", vo);
	}

	public DeptVO selectDetpDetail(int deptno) {
		return (DeptVO) select("deptDAO.selectDeptDetail", deptno);
	}

	public int deleteDept(int deptno) {
		return delete("deptDAO.deleteDept", deptno);
	}

	public int updateDept(DeptVO vo) {
		return update("deptDAO.updateDept", vo);
	}

}
