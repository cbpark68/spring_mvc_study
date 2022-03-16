package main.web;

import java.util.Calendar;
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
import main.service.JspMemberService;
import main.service.JspMemberVO;

@Controller
public class JspController {

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@Resource(name = "jspDeptService")
	private JspDeptService jspDeptService;

	@Resource(name = "jspEmpService")
	private JspEmpService jspEmpService;
	
	@Resource(name = "jspMemberService")
	private JspMemberService jspMemberService;

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
		if (! JspUtil.CheckDate(hdate)) errors.rejectValue("hiredate", "required", "날짜형식이 맞지 않습니다.");
		if (bindingResult.hasErrors() ||
				(crudgbn.contentEquals("insert") && cnt > 0 ) ||
				(crudgbn.contentEquals("update") && cnt == 0) ||
				cnt2 == 0 ||
				! JspUtil.CheckDate(hdate)) {
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

	@RequestMapping("/jspIndex.do")
	public String jspIndex() throws Exception{
		return "jsp/jspIndex";
	}
	
	@RequestMapping("/jspMemberWrite.do")
	public String jspMemberWrite(JspMemberVO jspMemberVO,ModelMap model) throws Exception{
		System.out.println(jspMemberVO.toString());
		String crudgbn = jspMemberVO.getCrudgbn();
		if(crudgbn == null || crudgbn.contentEquals("insert")) {
			jspMemberVO.setCrudgbn("insert");
			jspMemberVO.setMember_no(""+jspMemberService.jspMemberGetNo());
			Calendar cal = Calendar.getInstance();
			String rdate = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
			jspMemberVO.setMember_date(rdate);
		}else {
			jspMemberVO = jspMemberService.jspMemberInfo(jspMemberVO);
			jspMemberVO.setCrudgbn("update");
		}
		model.addAttribute("jspMemberVO",jspMemberVO);
		return "jsp/jspMemberWrite";
	}
	
	@RequestMapping("/jspMemberWriteSave.do")
	public String jspMemberWriteSave(JspMemberVO jspMemberVO,ModelMap model, BindingResult bindingResult, Errors errors) throws Exception{
		System.out.println(jspMemberVO.toString());
		String crudgbn = jspMemberVO.getCrudgbn();
		int	cnt = jspMemberService.jspMemberNoCheck(jspMemberVO);
		if (crudgbn.contentEquals("insert")) {
			if (cnt > 0) errors.rejectValue("member_no", "duplicate", "이미 등록된 회원번호입니다.");
		}else {
			if (cnt == 0) errors.rejectValue("member_no", "required", "등록되지 않은 회원번호입니다.");
		}
		beanValidator.validate(jspMemberVO, bindingResult);
		String dateFormat = "true";
		if (! JspUtil.CheckDate(jspMemberVO.getMember_date())) {
			errors.rejectValue("member_date", "required", "날짜형식이 맞지 않습니다.");
			dateFormat = "false";
		}
		if (bindingResult.hasErrors() || dateFormat.contentEquals("false")) {
			model.addAttribute("jspMemberVO", jspMemberVO);
			return "jsp/jspMemberWrite";
		}
		if(crudgbn.contentEquals("insert")) {
			String result = jspMemberService.jspMemberInsert(jspMemberVO);
		}else {
			int cnt2 = jspMemberService.jspMemberUpdate(jspMemberVO);
		}
		return "redirect:jspIndex.do";
	}
	
	@RequestMapping("/jspMemberList.do")
	public String jspMemberList(JspMemberVO jspMemberVO, ModelMap model) throws Exception{
		List<?> list = jspMemberService.jspMemberList(jspMemberVO);
		model.addAttribute("list",list);
		return "jsp/jspMemberList";
	}
}
