package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {

	@RequestMapping("/deptWrite.do")
	public String deptWrite() {
		return "dept/deptWrite";
	}
	
	@RequestMapping("/deptWriteSave.do")
	public String deptWriteSave(DeptVO vo) {
		System.out.println("부서번호 : "+vo.getDeptno());
		System.out.println("부서이름 : "+vo.getDname());
		return "";
	}
}
