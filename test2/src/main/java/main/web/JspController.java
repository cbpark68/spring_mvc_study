package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import main.service.JspDeptService;
import main.service.JspDeptVO;

@Controller
public class JspController {

	@Resource(name="jspDeptService")
	private JspDeptService jspDeptService;
	
	@RequestMapping("/jspDeptList.do")
	public String jspDeptList(ModelMap model) throws Exception{
		List<?> list = jspDeptService.jspDeptList();
		model.addAttribute("deptList",list);
		return "jsp/jspDeptList";
	}
	
	@RequestMapping("/jspDeptWrite.do")
	public String jspDeptWrite(JspDeptVO pvo,ModelMap model) throws Exception{
		JspDeptVO rvo = new JspDeptVO();
		if(pvo.getDeptno() != 0) {
			rvo = jspDeptService.jspDeptInfo(pvo);
		}
		model.addAttribute("deptinfo",rvo);
		return "jsp/jspDeptWrite";
	}
	
	@RequestMapping("/jspDeptWriteSave.do")
	public String jspDeptWriteSave(JspDeptVO pvo,ModelMap model) throws Exception{
		String gbn = pvo.getCurdgbn();
		String result = "";
		if(gbn.contentEquals("insert")) {
			result = jspDeptService.jspDeptInsert(pvo);
		}else {
			result = ""+jspDeptService.jspDeptUpdate(pvo);
		}
		return "redirect:jspDeptList.do";
	}
	
	@RequestMapping("/jspDeptDelete.do")
	public String jspDeptDelete(JspDeptVO pvo) throws Exception{
		int result = jspDeptService.jspDeptDelete(pvo);
		return "redirect:jspDeptList.do";
	}
}
