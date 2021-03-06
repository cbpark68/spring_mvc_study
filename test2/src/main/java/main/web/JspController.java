package main.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import main.service.JspBoardService;
import main.service.JspBoardVO;
import main.service.JspDeptService;
import main.service.JspDeptVO;
import main.service.JspEmpService;
import main.service.JspEmpVO;
import main.service.JspMemberService;
import main.service.JspMemberService2;
import main.service.JspMemberVO;
import main.service.JspMemberVO2;
import main.service.JspMemberVO3;
import main.service.JspMemberVO4;
import main.service.JspPlanService;
import main.service.JspPlanVO;
import main.service.impl.JspPlanDAO;

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

	@Resource(name = "jspMemberService2")
	private JspMemberService2 jspMemberService2;

	@Resource(name = "jspPlanService")
	private JspPlanService jspPlanService;


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
				errors.rejectValue("empno", "duplicate", "?????? ????????? ?????????????????????.");
		} else {
			if (cnt == 0)
				errors.rejectValue("empno", "required", "???????????? ?????? ?????????????????????.");
		}
		int cnt2 = jspEmpService.jspEmpDeptnoCheck(jspEmpVO);
		String hdate = jspEmpVO.getHiredate();
		beanValidator.validate(jspEmpVO, bindingResult);
		if (cnt2 == 0)
			errors.rejectValue("deptno", "required", "???????????? ?????? ?????????????????????.");
		if (!JspUtil.CheckDate(hdate))
			errors.rejectValue("hiredate", "required", "??????????????? ?????? ????????????.");
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
			errors.rejectValue("empno", "required", "???????????? ?????? ?????????????????????.");
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
				errors.rejectValue("member_no", "duplicate", "?????? ????????? ?????????????????????.");
		} else {
			if (cnt == 0)
				errors.rejectValue("member_no", "required", "???????????? ?????? ?????????????????????.");
		}
		beanValidator.validate(jspMemberVO, bindingResult);
		String dateFormat = "true";
		if (!JspUtil.CheckDate(jspMemberVO.getMember_date())) {
			errors.rejectValue("member_date", "required", "??????????????? ?????? ????????????.");
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
		if (jspBoardVO.getCrudgbn().contentEquals("update")) {
			jspBoardService.jspBoardHits(jspBoardVO);
			jspBoardVO = jspBoardService.jspBoardSelect(jspBoardVO);
			jspBoardVO.setCrudgbn("update"); // ????????? ??????????????? ??????.
		}
		if (jspBoardVO.getMode().contentEquals("branch")) {
			JspBoardVO vo = jspBoardService.jspBoardSelect(jspBoardVO);
			jspBoardVO.setGid(vo.getGid());
			jspBoardVO.setThread(vo.getThread());
			jspBoardVO.setTitle("Re:" + vo.getTitle());
			jspBoardVO.setContent("Re:" + vo.getContent());
		}
		System.out.println(jspBoardVO.toString());
		model.addAttribute("jspBoardVO", jspBoardVO);
		return "jsp/jspBoardWrite";
	}

	@RequestMapping("/jspBoardWriteSave.do")
	public String jspBoarWriteSave(JspBoardVO jspBoardVO, ModelMap model, BindingResult bindingResult, Errors errors)
			throws Exception {
		String crudgbn = jspBoardVO.getCrudgbn();
		String mode = jspBoardVO.getMode();
		if (crudgbn.contentEquals("update") || crudgbn.contentEquals("delete")) {
			String newpass = jspBoardVO.getPass();
			JspBoardVO vo = jspBoardService.jspBoardSelect(jspBoardVO);
			String oldpass = vo.getPass();
			if (!oldpass.contentEquals(newpass))
				errors.rejectValue("pass", "required", "??????????????? ???????????? ????????????.");
		}
		beanValidator.validate(jspBoardVO, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("jspBoardVO", jspBoardVO);
			return "jsp/jspBoardWrite";
		}
		int gid = jspBoardVO.getGid();
		String thread = jspBoardVO.getThread();
		if (crudgbn.contentEquals("insert")) {
			if (mode.contentEquals("root")) {
				gid = jspBoardService.jspBoardGid();
				thread = "a";
			} else if (mode.contentEquals("branch")) {
				String lthread = jspBoardService.jspBoardLthread(jspBoardVO);
				if (lthread == null) {
					thread = thread + "a";
				} else {
					char cthread = lthread.charAt(0);
					cthread++;
					thread = thread + cthread;
				}
			}
			jspBoardVO.setGid(gid);
			jspBoardVO.setThread(thread);
			jspBoardService.jspBoardInsert(jspBoardVO);
		} else if (crudgbn.contentEquals("update")) {
			jspBoardService.jspBoardUpdate(jspBoardVO);
		} else if (crudgbn.contentEquals("delete")) {
			String lthread = jspBoardService.jspBoardLthread(jspBoardVO);
			if (lthread == null) {
				jspBoardService.jspBoardDelete(jspBoardVO);
			} else {
				jspBoardVO.setTitle("???????????? ?????????");
				jspBoardVO.setContent("???????????? ?????????");
				jspBoardService.jspBoardUpdate(jspBoardVO);
			}
		}
		return "redirect:jspBoardList.do";
	}

	@RequestMapping("/jspBoardList.do")
	public String jspBoardList(JspBoardVO jspBoardVO, ModelMap model) throws Exception {
		int totrow = jspBoardService.jspBoardTotCnt();
		jspBoardVO.setTotrow(totrow); // totrow??? ?????? ???????????? lastpgno??? ????????????.
		// lastPgno??? ?????? ??????????????? ????????? ?????? ????????? VO??? getReqpgno????????? ?????? ??????.
		if (jspBoardVO.getReqpgno() >= jspBoardVO.getLastpgno()) {
			// ?????????????????? ????????????????????? ????????????.
			jspBoardVO.setReqpgno(jspBoardVO.getLastpgno());
		}
		List<?> list = jspBoardService.jspBoardList(jspBoardVO);
		// ?????????????????? ???????????????????????? ?????? ??????????????????????????? ???????????? ?????? ???????????? ??????.
		model.addAttribute("reqpgno", jspBoardVO.getReqpgno());
		model.addAttribute("lastpgno", jspBoardVO.getLastpgno());
		model.addAttribute("totrow", totrow);
		model.addAttribute("list", list);
		return "jsp/jspBoardList";
	}

	@RequestMapping("/jspMemberWrite2.do")
	public String jspMemberWrite2(JspMemberVO2 jspMemberVO2, ModelMap model) throws Exception {
		if (jspMemberVO2.getCrudgbn().contentEquals("update")) {
			jspMemberVO2 = jspMemberService2.jspMemberSelect2(jspMemberVO2);
			jspMemberVO2.setCrudgbn("update");
		}
		model.addAttribute("jspMemberVO2", jspMemberVO2);
		return "jsp/jspMemberWrite2";
	}

	@RequestMapping("/jspMemberWriteSave2.do")
	public String jspMemberWriteSave2(JspMemberVO2 jspMemberVO2, ModelMap model, BindingResult bindingResult,
			Errors errors) throws Exception {
		String errgbn = "no";
		String crudgbn = jspMemberVO2.getCrudgbn();
		String userid = jspMemberVO2.getUserid();
		String pass = jspMemberVO2.getPass();
		if (crudgbn.contentEquals("insert")) {
			int cnt = jspMemberService2.jspMemberIdCheck2(userid);
			if (cnt > 0) {
				errors.rejectValue("userid", "duplicate", "?????? ????????? ?????????ID?????????.");
				errgbn = "yes";
			}
		}
		if (crudgbn.contentEquals("update")) {
			JspMemberVO3 vo = new JspMemberVO3(userid, pass);
			int cnt = jspMemberService2.jspMemberLogin2(vo);
			if (cnt == 0) {
				errors.rejectValue("pass", "required", "????????????????????? ???????????? ????????????.");
				errgbn = "yes";
			}
		}
		beanValidator.validate(jspMemberVO2, bindingResult);
		if (bindingResult.hasErrors() || errgbn.contentEquals("yes")) {
			model.addAttribute("jspMemberVO2", jspMemberVO2);
			return "jsp/jspMemberWrite2";
		}
		if (crudgbn.contentEquals("insert")) {
			jspMemberService2.jspMemberInsert2(jspMemberVO2);
		} else {
			jspMemberService2.jspMemberUpdate2(jspMemberVO2);
		}
		return "redirect:jspBoard.do";
	}

	@RequestMapping("/jspMemberIdChk.do")
	public ModelAndView jspMemberIdChk(JspMemberVO2 jspMemberVO2) throws Exception {
		int cnt = jspMemberService2.jspMemberIdCheck2(jspMemberVO2.getUserid());
		if (cnt == 0) {
			jspMemberVO2.setIdchk("????????? ??? ?????? ??????????????????.");
		} else {
			jspMemberVO2.setIdchk("????????? ??? ?????? ??????????????????.\n?????????????????? ???????????????.");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("jsonView", map);
	}

	@RequestMapping("/jspPost.do")
	public String jspPost(JspMemberVO2 jspMemberVO2, ModelMap model) throws Exception {
		return "jsp/jspPost";
	}

	@RequestMapping("/jspPostSearch.do")
	public ModelAndView jspPostSearch(String dong) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<?> list = jspMemberService2.jspPostSearch(dong);
		map.put("list", list);
		return new ModelAndView("jsonView", map);
	}

	@RequestMapping("/jspMemberLogin2.do")
	public String jspMemberLogin2(JspMemberVO3 jspMemberVO3, ModelMap model) throws Exception {
		model.addAttribute("jspMemberVO3", jspMemberVO3);
		return "jsp/jspMemberLogin2";
	}

	@RequestMapping("/jspMemberLoginProc2.do")
	public String jspMemberLoginProc2(JspMemberVO3 jspMemberVO3, ModelMap model, BindingResult bindingResult,
			Errors errors, HttpServletRequest request) throws Exception {
		int cnt = jspMemberService2.jspMemberLogin2(jspMemberVO3);
		if (cnt == 0)
			errors.rejectValue("userid", "required", "???????????? ??? ????????????.");
		beanValidator.validate(jspMemberVO3, bindingResult);
		if (bindingResult.hasErrors() || cnt == 0) {
			model.addAttribute("jspMemberVO3", jspMemberVO3);
			return "jsp/jspMemberLogin2";
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("ssuserid", jspMemberVO3.getUserid());
		session.setMaxInactiveInterval(3600);
		
		return "redirect:jspBoard.do";
	}

	@RequestMapping("/jspMemberLogout2.do")
	public String jspMemberLogout2(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:jspBoard.do";
	}

	@RequestMapping("/jspMemberPass2.do")
	public String jspMemberPass2(JspMemberVO4 jspMemberVO4, ModelMap model) throws Exception {
		model.addAttribute("jspMemberVO4", jspMemberVO4);
		return "jsp/jspMemberPass2";
	}

	@RequestMapping("/jspMemberPassProc2.do")
	public String jspMemberPassProc2(JspMemberVO4 jspMemberVO4, ModelMap model, BindingResult result, Errors errors)
			throws Exception {
		String errgbn = "no";
		String userid = jspMemberVO4.getUserid();
		String bpass = jspMemberVO4.getBpass();
		String pass = jspMemberVO4.getPass();
		String apass = jspMemberVO4.getApass();
		JspMemberVO2 vo = new JspMemberVO2();
		if (!(bpass == null || bpass.contentEquals(""))) {
			vo.setUserid(userid);
			vo = jspMemberService2.jspMemberSelect2(vo);
			String opass = vo.getPass();
			if (!bpass.contentEquals(opass)) {
				errors.rejectValue("bpass", "required", "?????? ??????????????? ???????????? ????????????.");
				errgbn = "yes";
			}
		}
		if (pass.contentEquals(bpass)) {
			errors.rejectValue("pass", "required", "?????? ??????????????? ???????????????.");
			errgbn = "yes";
		}
		if (!pass.contentEquals(apass)) {
			errors.rejectValue("apass", "required", "??? ??????????????? ???????????? ????????????.");
			errgbn = "yes";
		}
		beanValidator.validate(jspMemberVO4, result);
		if (result.hasErrors() || errgbn.contentEquals("yes")) {
			model.addAttribute("jspMemberVO4", jspMemberVO4);
			return "jsp/jspMemberPass2";
		}
		int cnt = jspMemberService2.jspMemberUpdatePass2(jspMemberVO4);
		if (cnt == 1) {
			model.addAttribute("msg", "??????????????? ??????????????????.");
			model.addAttribute("rslt", "success");
		} else {
			model.addAttribute("msg", "??????????????? ???????????? ???????????????.");
			model.addAttribute("rslt", "fail");
		}
		return "jsp/jspMemberPass2";
	}

	@RequestMapping("/jspPlanList.do")
	public String jspPlanList(String year, String month, String userid,ModelMap model) throws Exception {
		int y, m, sysy;
		String ym;
		Calendar cal = Calendar.getInstance();
		sysy = cal.get(Calendar.YEAR);
		if (year == null || month == null) {
			y = cal.get(Calendar.YEAR);
			m = cal.get(Calendar.MONTH);
		} else {
			y = Integer.parseInt(year);
			m = Integer.parseInt(month) - 1;
		}
		ym = y+"-"+String.format("%02d", (m+1));
		cal.set(y, m, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DATE);
		model.addAttribute("y", y);
		model.addAttribute("m", m);
		if (m == 0) {
			model.addAttribute("by", y - 1);
			model.addAttribute("bm", 12);
		} else {
			model.addAttribute("by", y);
			model.addAttribute("bm", m);
		}
		if (m == 11) {
			model.addAttribute("ny", y + 1);
			model.addAttribute("nm", 1);
		} else {
			model.addAttribute("ny", y);
			model.addAttribute("nm", m + 2);
		}
		model.addAttribute("dayOfWeek", dayOfWeek);
		model.addAttribute("lastday", lastday);
		model.addAttribute("sysy", sysy);
		if(userid != null) {
			JspPlanVO vo = new JspPlanVO();
			vo.setUserid(userid);
			vo.setYm(ym);
			List<?> userlist = jspPlanService.jspPlanList(vo);
			model.addAttribute("userlist", userlist);
		}
		return "jsp/jspPlanList";
	}

	@RequestMapping("/jspPlanWrite.do")
	public String jspPlanWrite(JspPlanVO jspPlanVO, ModelMap model) throws Exception {
		if (jspPlanVO.getCrudgbn().contentEquals("update")) {
			jspPlanVO = jspPlanService.jspPlanSelect(jspPlanVO);
			jspPlanVO.setCrudgbn("update");
		}
		model.addAttribute("jspPlanVO",jspPlanVO);
		return "jsp/jspPlanWrite";
	}

	@RequestMapping("/jspPlanWriteSave.do")
	public String jspPlanWriteSave(JspPlanVO jspPlanVO,ModelMap model,BindingResult result, Errors errors) throws Exception{
		String crudgbn = jspPlanVO.getCrudgbn();
		String errgbn = "no";
		beanValidator.validate(jspPlanVO, result);
		if (result.hasErrors() || errgbn.contentEquals("yes")) {
			model.addAttribute("jspPlanVO", jspPlanVO);
			return "jsp/jspPlanWrite";
		}
		if(crudgbn.contentEquals("insert")) {
			jspPlanService.jspPlanInsert(jspPlanVO);
		}else {
			jspPlanService.jspPlanUpdate(jspPlanVO);
		}
		model.addAttribute("msg", "????????? ??????????????????.");
		model.addAttribute("rslt","success");
		return "jsp/jspPlanWrite";
	}
	
	@RequestMapping("/jspPlanDelete.do")
	public String jspPlanDelete(JspPlanVO jspPlanVO,ModelMap model) throws Exception{
		jspPlanService.jspPlanDelete(jspPlanVO);
		return "";
	}
}
