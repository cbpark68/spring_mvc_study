package main.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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

	@Resource(name = "jspDeptService")
	private JspDeptService jspDeptService;

	@Resource(name = "jspEmpService")
	private JspEmpService jspEmpService;

	@RequestMapping("/jspDeptList.do")
	public String jspDeptList(ModelMap model) throws Exception {
		List<?> list = jspDeptService.jspDeptList();
		model.addAttribute("deptList", list);
		return "jsp/jspDeptList";
	}

	@RequestMapping("/jspDeptWrite.do")
	public String jspDeptWrite(JspDeptVO pvo, ModelMap model) throws Exception {
		JspDeptVO rvo = new JspDeptVO();
		if (pvo.getDeptno() != 0) {
			rvo = jspDeptService.jspDeptInfo(pvo);
		}
		model.addAttribute("deptinfo", rvo);
		return "jsp/jspDeptWrite";
	}

	@RequestMapping("/jspDeptWriteSave.do")
	public String jspDeptWriteSave(JspDeptVO pvo, ModelMap model) throws Exception {
		String gbn = pvo.getCurdgbn();
		String result = "";
		if (gbn.contentEquals("insert")) {
			result = jspDeptService.jspDeptInsert(pvo);
		} else {
			result = "" + jspDeptService.jspDeptUpdate(pvo);
		}
		return "redirect:jspDeptList.do";
	}

	@RequestMapping("/jspDeptDelete.do")
	public String jspDeptDelete(JspDeptVO pvo) throws Exception {
		int result = jspDeptService.jspDeptDelete(pvo);
		return "redirect:jspDeptList.do";
	}

	@RequestMapping("/jspEmpWrite.do")
	public String jspEmpWrite(JspEmpVO jspEmpVO,ModelMap model) throws Exception {
		String crudgbn = jspEmpVO.getCrudgbn();
		int cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		if(crudgbn == null || crudgbn.contentEquals("insert") || cnt == 0) {
			jspEmpVO.setCrudgbn("insert");
			int empno = jspEmpService.jspEmpGetEmpno();
			jspEmpVO.setEmpno(""+empno);
		}else {
			jspEmpVO = jspEmpService.jspEmpInfo(jspEmpVO);
			jspEmpVO.setCrudgbn("update");
		}
		List<?> deptList = jspDeptService.jspDeptList();
		model.addAttribute("jspEmpVO",jspEmpVO);
		model.addAttribute("deptList",deptList);
		return "jsp/jspEmpWrite";
	}

	@RequestMapping("/jspEmpWriteSave.do")
	public String jspEmpWriteSave(JspEmpVO jspEmpVO, BindingResult bindingResult, ModelMap model, Errors errors)
			throws Exception {
		List<?> deptList = jspDeptService.jspDeptList();
		model.addAttribute("deptList",deptList);
		int	cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		String crudgbn = jspEmpVO.getCrudgbn();
		if (crudgbn.contentEquals("insert")) {
			if (cnt > 0) errors.rejectValue("empno", "duplicate", "이미 등록된 사원번호입니다.");
		}else {
			if (cnt == 0) errors.rejectValue("empno", "required", "등록되지 않은 사원번호입니다.");
		}
		int cnt2 = jspEmpService.jspEmpDeptnoCheck(jspEmpVO);
		String hdate = jspEmpVO.getHiredate();
		beanValidator.validate(jspEmpVO, bindingResult);
		if (cnt2 == 0) errors.rejectValue("deptno", "required", "등록되지 않은 부서번호입니다.");
		if (! formatCheck(hdate)) errors.rejectValue("hiredate", "required", "날짜형식이 맞지 않습니다.");
		if (bindingResult.hasErrors() ||
				(crudgbn.contentEquals("insert") && cnt > 0 ) ||
				(crudgbn.contentEquals("update") && cnt == 0) ||
				cnt2 == 0 ||
				! formatCheck(hdate)) {
			model.addAttribute("jspEmpVO", jspEmpVO);
			return "jsp/jspEmpWrite";
		}
		if(crudgbn.contentEquals("insert")) {
			String result1 = jspEmpService.jspEmpInsert(jspEmpVO);
		}else {
			int result2 = jspEmpService.jspEmpUpdate(jspEmpVO);
		}
		return "redirect:jspEmpList.do";
	}

	@RequestMapping("/jspEmpList.do")
	public String jspEmpList(JspEmpVO pvo,ModelMap model) throws Exception{
		List<?> list = jspEmpService.jspEmpList(pvo);
		int cnt = jspEmpService.jspEmpCount();
		model.addAttribute("result",list);
		model.addAttribute("totcnt",cnt);
		return "jsp/jspEmpList";
	}

	@RequestMapping("/jspEmpDelete.do")
	public String jspEmpDelete(JspEmpVO jspEmpVO, Errors errors) throws Exception{
		int	cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		if (cnt == 0) {
			errors.rejectValue("empno", "required", "등록되지 않은 사원번호입니다.");
			return "jsp/jspEmpWrite";
		}
		cnt = jspEmpService.jspEmpDelete(jspEmpVO);
		return "redirect:jspEmpList.do";
	}
	public static boolean formatCheck(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch(ParseException e) {
			return false;
		}
	}
}
