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

import main.service.JspBoardService;
import main.service.JspBoardVO;
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

	@Resource(name = "jspBoardService")
	private JspBoardService jspBoardService;

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
	public String jspEmpWrite(JspEmpVO jspEmpVO, ModelMap model) throws Exception {
		String crudgbn = jspEmpVO.getCrudgbn();
		int cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		if (crudgbn == null || crudgbn.contentEquals("insert") || cnt == 0) {
			jspEmpVO.setCrudgbn("insert");
			int empno = jspEmpService.jspEmpGetEmpno();
			jspEmpVO.setEmpno("" + empno);
		} else {
			jspEmpVO = jspEmpService.jspEmpInfo(jspEmpVO);
			jspEmpVO.setCrudgbn("update");
		}
		List<?> deptList = jspDeptService.jspDeptList();
		model.addAttribute("jspEmpVO", jspEmpVO);
		model.addAttribute("deptList", deptList);
		return "jsp/jspEmpWrite";
	}

	@RequestMapping("/jspEmpWriteSave.do")
	public String jspEmpWriteSave(JspEmpVO jspEmpVO, BindingResult bindingResult, ModelMap model, Errors errors)
			throws Exception {
		List<?> deptList = jspDeptService.jspDeptList();
		model.addAttribute("deptList", deptList);
		int cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		String crudgbn = jspEmpVO.getCrudgbn();
		if (crudgbn.contentEquals("insert")) {
			if (cnt > 0)
				errors.rejectValue("empno", "duplicate", "이미 등록된 사원번호입니다.");
		} else {
			if (cnt == 0)
				errors.rejectValue("empno", "required", "등록되지 않은 사원번호입니다.");
		}
		int cnt2 = jspEmpService.jspEmpDeptnoCheck(jspEmpVO);
		String hdate = jspEmpVO.getHiredate();
		beanValidator.validate(jspEmpVO, bindingResult);
		if (cnt2 == 0)
			errors.rejectValue("deptno", "required", "등록되지 않은 부서번호입니다.");
		if (!JspUtil.CheckDate(hdate))
			errors.rejectValue("hiredate", "required", "날짜형식이 맞지 않습니다.");
		if (bindingResult.hasErrors() || (crudgbn.contentEquals("insert") && cnt > 0)
				|| (crudgbn.contentEquals("update") && cnt == 0) || cnt2 == 0 || !JspUtil.CheckDate(hdate)) {
			model.addAttribute("jspEmpVO", jspEmpVO);
			return "jsp/jspEmpWrite";
		}
		if (crudgbn.contentEquals("insert")) {
			String result1 = jspEmpService.jspEmpInsert(jspEmpVO);
		} else {
			int result2 = jspEmpService.jspEmpUpdate(jspEmpVO);
		}
		return "redirect:jspEmpList.do";
	}

	@RequestMapping("/jspEmpList.do")
	public String jspEmpList(JspEmpVO pvo, ModelMap model) throws Exception {
		List<?> list = jspEmpService.jspEmpList(pvo);
		int cnt = jspEmpService.jspEmpCount();
		model.addAttribute("result", list);
		model.addAttribute("totcnt", cnt);
		return "jsp/jspEmpList";
	}

	@RequestMapping("/jspEmpDelete.do")
	public String jspEmpDelete(JspEmpVO jspEmpVO, Errors errors) throws Exception {
		int cnt = jspEmpService.jspEmpIdCheck(jspEmpVO);
		if (cnt == 0) {
			errors.rejectValue("empno", "required", "등록되지 않은 사원번호입니다.");
			return "jsp/jspEmpWrite";
		}
		cnt = jspEmpService.jspEmpDelete(jspEmpVO);
		return "redirect:jspEmpList.do";
	}

	@RequestMapping("/jspIndex.do")
	public String jspIndex() throws Exception {
		return "jsp/jspIndex";
	}

	@RequestMapping("/jspMemberWrite.do")
	public String jspMemberWrite(JspMemberVO jspMemberVO, ModelMap model) throws Exception {
		String crudgbn = jspMemberVO.getCrudgbn();
		if (crudgbn == null || crudgbn.contentEquals("insert")) {
			jspMemberVO.setCrudgbn("insert");
			jspMemberVO.setMember_no("" + jspMemberService.jspMemberGetNo());
			Calendar cal = Calendar.getInstance();
			String rdate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
			jspMemberVO.setMember_date(rdate);
		} else {
			jspMemberVO = jspMemberService.jspMemberInfo(jspMemberVO);
			jspMemberVO.setCrudgbn("update");
		}
		model.addAttribute("jspMemberVO", jspMemberVO);
		return "jsp/jspMemberWrite";
	}

	@RequestMapping("/jspMemberWriteSave.do")
	public String jspMemberWriteSave(JspMemberVO jspMemberVO, ModelMap model, BindingResult bindingResult,
			Errors errors) throws Exception {
		String crudgbn = jspMemberVO.getCrudgbn();
		int cnt = jspMemberService.jspMemberNoCheck(jspMemberVO);
		if (crudgbn.contentEquals("insert")) {
			if (cnt > 0)
				errors.rejectValue("member_no", "duplicate", "이미 등록된 회원번호입니다.");
		} else {
			if (cnt == 0)
				errors.rejectValue("member_no", "required", "등록되지 않은 회원번호입니다.");
		}
		beanValidator.validate(jspMemberVO, bindingResult);
		String dateFormat = "true";
		if (!JspUtil.CheckDate(jspMemberVO.getMember_date())) {
			errors.rejectValue("member_date", "required", "날짜형식이 맞지 않습니다.");
			dateFormat = "false";
		}
		if (bindingResult.hasErrors() || dateFormat.contentEquals("false")) {
			model.addAttribute("jspMemberVO", jspMemberVO);
			return "jsp/jspMemberWrite";
		}
		if (crudgbn.contentEquals("insert")) {
			String result = jspMemberService.jspMemberInsert(jspMemberVO);
		} else {
			int cnt2 = jspMemberService.jspMemberUpdate(jspMemberVO);
		}
		return "redirect:jspIndex.do";
	}

	@RequestMapping("/jspMemberList.do")
	public String jspMemberList(JspMemberVO jspMemberVO, ModelMap model) throws Exception {
		List<?> list = jspMemberService.jspMemberList(jspMemberVO);
		model.addAttribute("list", list);
		return "jsp/jspMemberList";
	}

	@RequestMapping("/jspFriendList.do")
	public String jspFriendList(JspMemberVO jspMemberVO, ModelMap model) throws Exception {
		List<?> list = jspMemberService.jspFriendList(jspMemberVO);
		model.addAttribute("list", list);
		return "jsp/jspFriendList";
	}

	@RequestMapping("/jspMain.do")
	public String jspMain() throws Exception {
		return "jsp/jspMain";
	}

	@RequestMapping("/jspBoard.do")
	public String jspBoard() throws Exception {
		return "jsp/jspBoard";
	}

	@RequestMapping("/jspBoardWrite.do")
	public String jspBoardWrite(JspBoardVO jspBoardVO, ModelMap model) throws Exception {
		String crudgbn = jspBoardVO.getCrudgbn();
		if (crudgbn.contentEquals("update")) {
			jspBoardService.jspBoardHits(jspBoardVO);
			jspBoardVO = jspBoardService.jspBoardSelect(jspBoardVO);
			jspBoardVO.setCrudgbn("update"); //반드시 세팅해줘야 한다.
		}
		model.addAttribute("jspBoardVO", jspBoardVO);
		return "jsp/jspBoardWrite";
	}

	@RequestMapping("/jspBoardWriteSave.do")
	public String jspBoarWriteSave(JspBoardVO jspBoardVO, ModelMap model, BindingResult bindingResult, Errors errors)
			throws Exception {
		String crudgbn = jspBoardVO.getCrudgbn();
		if (crudgbn.contentEquals("update")||crudgbn.contentEquals("delete")) {
			String newpass = jspBoardVO.getPass();
			JspBoardVO vo = jspBoardService.jspBoardSelect(jspBoardVO);
			String oldpass = vo.getPass();
			if(! oldpass.contentEquals(newpass))
				errors.rejectValue("pass", "required", "비밀번호가 일치하지 않습니다.");
		}
		beanValidator.validate(jspBoardVO, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("jspBoardVO", jspBoardVO);
			return "jsp/jspBoardWrite";
		}
		if (crudgbn.contentEquals("insert")) {
			jspBoardVO.setGid(jspBoardService.jspBoardGid());
			jspBoardService.jspBoardInsert(jspBoardVO);
		}else if (crudgbn.contentEquals("update")) {
			jspBoardService.jspBoardUpdate(jspBoardVO);
		} else {
			jspBoardService.jspBoardDelete(jspBoardVO);
		}
		return "redirect:jspBoardList.do";
	}
	
	@RequestMapping("/jspBoardList.do")
	public String jspBoardList(JspBoardVO jspBoardVO,ModelMap model) throws Exception{
		int totrow = jspBoardService.jspBoardTotCnt();
		jspBoardVO.setTotrow(totrow); //totrow를 먼저 주입해야 lastpgno를 받아온다.
		//lastPgno가 먼저 확정되어야 하므로 아래 비교는 VO의 getReqpgno에서는 할수 없다. 
		if(jspBoardVO.getReqpgno() >= jspBoardVO.getLastpgno()) {
			//요청페이지가 마지막페이지로 변경된다.
			jspBoardVO.setReqpgno(jspBoardVO.getLastpgno());
		}
		List<?> list = jspBoardService.jspBoardList(jspBoardVO);
		//요청페이지가 원래페이지일수도 있고 마지막페이지일수도 있으므로 다시 가져와야 한다.
		model.addAttribute("reqpgno",jspBoardVO.getReqpgno());
		model.addAttribute("lastpgno",jspBoardVO.getLastpgno());
		model.addAttribute("totrow",totrow);
		model.addAttribute("list",list);
		return "jsp/jspBoardList";
	}
}
