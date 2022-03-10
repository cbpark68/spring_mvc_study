package main.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		}else {
			jspEmpVO.setCrudgbn("update");
		}
		model.addAttribute("jspEmpVO",jspEmpVO);
		return "jsp/jspEmpWrite";
	}

	@RequestMapping("/jspEmpWriteSave.do")
	public String jspEmpWriteSave(JspEmpVO jspEmpVO, BindingResult bindingResult, ModelMap model, Errors errors)
			throws Exception {
		String result = "";
		int cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		int cnt2 = jspEmpService.jspEmpDeptnoCheck(jspEmpVO);
		int sal = jspEmpVO.getSal();
		String hdate = jspEmpVO.getHiredate();
		beanValidator.validate(jspEmpVO, bindingResult);
		if (cnt > 0) errors.rejectValue("empno", "duplicate", "이미 등록된 사원번호입니다.");
		if (cnt2 == 0) errors.rejectValue("deptno", "required", "등록되지 않은 부서번호입니다.");
		if (sal < 100) errors.rejectValue("sal", "required", "급여는 100만원 이상입니다.");
		if (! formatCheck(hdate)) errors.rejectValue("hiredate", "required", "날짜형식이 맞지 않습니다.");
		if (bindingResult.hasErrors() || cnt > 0 || cnt2 == 0 || sal < 100 || ! formatCheck(hdate)) {
			model.addAttribute("jspEmpVO", jspEmpVO);
			return "jsp/jspEmpWrite";
		}
		result = jspEmpService.jspEmpInsert(jspEmpVO);
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
