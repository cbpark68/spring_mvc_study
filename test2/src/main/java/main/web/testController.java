package main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
	
	@RequestMapping("/deptWrite2.do")
	public String deptWrite2() {
		return "test/deptWrite";
	}
	
	@RequestMapping("/jstest.do")
	public String jstest() {
		return "test/jstest";
	}

}
