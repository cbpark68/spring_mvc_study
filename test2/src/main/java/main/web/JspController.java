package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import main.service.JspDeptService;
import main.service.JspDeptVO;
import main.service.JspEmpService;
import main.service.JspEmpVO;

@Controller
public class JspController {

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;


	@Resource(name="jspDeptService")
	private JspDeptService jspDeptService;
	
	@Resource(name="jspEmpService")
	private JspEmpService jspEmpService;
	
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

	@RequestMapping("/jspEmpWrite.do")
	public String jspEmpWrite(JspEmpVO pvo,ModelMap model) throws Exception{
		JspEmpVO rvo = new JspEmpVO();
		model.addAttribute("empinfo",rvo);
		return "jsp/jspEmpWrite";
	}
	
	@RequestMapping("/jspEmpWriteSave.do")
	public String jspEmpWriteSave(JspEmpVO jspEmpVO,BindingResult bindingResult,ModelMap model) throws Exception{
		beanValidator.validate(jspEmpVO, bindingResult);
	    if(bindingResult.hasErrors()) {
	        model.addAttribute("jspEmpVO", jspEmpVO);
	        return "jsp/jspEmpWrite";
	    }

		String result = "";
		result = jspEmpService.jspEmpInsert(jspEmpVO);
		return "redirect:jspEmpList.do";
	}
	
}
