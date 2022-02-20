package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {

	@Resource(name = "deptService")
	private DeptService deptService;

	@RequestMapping("deptWrite.do")
	public String deptWrite() {
		return "dept/deptWrite";
	}

	@RequestMapping("/deptWriteSave.do")
	public String insertDept(DeptVO vo) throws Exception {
		System.out.println(vo.getDeptno());
		System.out.println(vo.getDname());
		System.out.println(vo.getLoc());
		String resutl = deptService.insertDept(vo);
		if (resutl == null) {
			System.out.println("부서저장성공");
		} else {
			System.out.println("부서저장실패");
		}
		return "";
	}

	@RequestMapping("/deptList.do")
	public String selectDeptList(DeptVO vo, ModelMap model) throws Exception {
		List<?> list = deptService.selectDeptList(vo);
		model.addAttribute("resultList", list);
		System.out.println(list);
		return "dept/deptList";
	}

	@RequestMapping("/deptDetail.do")
	public String selectDeptDetail(int deptno, ModelMap model) throws Exception {
		DeptVO vo = deptService.selectDeptDetail(deptno);
		System.out.println("DeptVO=" + vo);
		model.addAttribute("deptVO", vo);
		return "dept/deptDetail";
	}

	@RequestMapping("/deptDelete.do")
	public String deleteDept(int deptno) throws Exception {
		int result = deptService.deleteDept(deptno);
		if(result == 1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실퍠");
		}
		return "";
	}
	
	@RequestMapping("/deptModifyWrite.do")
	public String selectDeptModify(int deptno, ModelMap model) throws Exception{
		DeptVO vo = deptService.selectDeptDetail(deptno);
		model.addAttribute("result", vo);
		return "dept/deptModifyWrite";
	}
	
	@RequestMapping("/deptModifySave.do")
	public String updateDept(DeptVO vo) throws Exception{
		int result = deptService.updateDept(vo);
		if(result == 1) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실퍠");
		}
		return "";
	}
}
