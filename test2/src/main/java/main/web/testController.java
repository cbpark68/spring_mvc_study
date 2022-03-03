package main.web;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import main.service.MysqlService;

@Controller
public class testController {

	@Resource(name = "mysqlService")
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
	public String mysqlTest(ModelMap model) throws Exception {
		int cnt = mysqlService.selectTestCnt();
		model.addAttribute("testcnt", cnt);
		List<?> list = mysqlService.selectBoardList();
		model.addAttribute("boardlist", list);
		return "test/mysqltest";
	}

	@RequestMapping("/jsptest1.do")
	public String jsptest1() throws Exception {
		return "test/jsptest1";
	}

	@RequestMapping("/jsptest2.do")
	public String jsptst2(String id, String pass, String nm, String pg, String eng, String kor, String mth,
			ModelMap model) throws Exception {
		int pageNo = 0;
		int startNo = 0;
		int lastNo = 0;
		if (pg != null) {
			pageNo = Integer.parseInt(pg);
			startNo = (pageNo - 1) * 10 + 1;
			lastNo = startNo + 9;
		}
		model.addAttribute("kor", kor);
		model.addAttribute("eng", eng);
		model.addAttribute("mth", mth);
		model.addAttribute("pg", pg);
		model.addAttribute("startNo", startNo);
		model.addAttribute("lastNo", lastNo);
		model.addAttribute("id", id);
		model.addAttribute("pass", pass);
		model.addAttribute("name", nm);
		return "test/jsptest2";
	}

	@RequestMapping("/jsptest3.do")
	public String jsptest3(String username, String year, String phone, String addr, String content, String subject,
			String gender, ModelMap model) throws Exception {
		model.addAttribute("username", username);
		model.addAttribute("year", year);
		model.addAttribute("gender", gender);
		model.addAttribute("phone", phone);
		model.addAttribute("addr", addr);
		model.addAttribute("subject", subject);
		model.addAttribute("content", content);
		System.out.println("고객정보 " + username + year + phone + addr + subject);
		return "test/jsptest2";
	}

	@RequestMapping("/jspcal1.do")
	public String jspcal1(String year, String month, ModelMap model) throws Exception {
		int y, m, sysy;
		Calendar cal = Calendar.getInstance();
		sysy = cal.get(Calendar.YEAR);
		if (year == null || month == null) {
			y = cal.get(Calendar.YEAR);
			m = cal.get(Calendar.MONTH);
		} else {
			y = Integer.parseInt(year);
			m = Integer.parseInt(month) - 1;
		}
		cal.set(y, m, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DATE);
		model.addAttribute("y", y);
		model.addAttribute("m", m);
		if (m == 0) {
			model.addAttribute("by", y - 1);
			model.addAttribute("bm", 12);
		}else {
			model.addAttribute("by", y);
			model.addAttribute("bm", m);
		}
		if(m == 11) {
			model.addAttribute("ny", y + 1);
			model.addAttribute("nm", 1);
		}else {
			model.addAttribute("ny", y);
			model.addAttribute("nm", m+2);
		}
		model.addAttribute("dayOfWeek", dayOfWeek);
		model.addAttribute("lastday", lastday);
		model.addAttribute("sysy", sysy);
		return "test/jspcal1";
	}
}
