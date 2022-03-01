package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import main.service.MysqlService;

@Controller
public class testController {
	
	@Resource(name="mysqlService")
	private MysqlService mysqlService;

	@RequestMapping("/deptWrite2.do")
	public String deptWrite2() {
		return "test/deptWrite";
	}
	
	@RequestMapping("/jstest.do")
	public String jstest() {
		return "test/jstest";
	}

	@RequestMapping("/csstest.do")
	public String csstest() {
		return "test/csstest";
	}
	
	@RequestMapping("/mysqlTest.do")
	public String mysqlTest(ModelMap model) throws Exception{
		int cnt = mysqlService.selectTestCnt();
		model.addAttribute("testcnt",cnt);
		List<?> list = mysqlService.selectBoardList();
		model.addAttribute("boardlist",list);
		return "test/mysqltest";
	}
	

}
