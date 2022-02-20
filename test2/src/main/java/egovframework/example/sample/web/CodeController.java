package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@RequestMapping("/codeWrite.do")
	public String codeWrite() {
		return "code/codeWrite";
	}
}
