package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.MemberService;
import main.service.MemberVO;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	private MemberService memberService;

	@RequestMapping("/memberWrite.do")
	public String memberWrite() {
		return "member/memberWrite";
	}
	
	@RequestMapping("/memberWriteSave.do")
	@ResponseBody
	public String memberWriteSave(MemberVO vo) throws Exception{
		String msg = "";
		String result = memberService.insertMember(vo);
		if(result == null) {
			msg = "ok";
		}
		return msg;
	}
	
	@RequestMapping("/idcheck.do")
	@ResponseBody
	public String idcheck(String userid) throws Exception{
		String message = "";
		int cnt = memberService.selectMemberIdCheck(userid);
		if(cnt == 0) {
			message = "ok";
		}
		return message;
	}
	
	@RequestMapping("/post1.do")
	public String post1() {
		return "member/post1";
	}
	
	@RequestMapping("/post2.do")
	public String post2(String dong,ModelMap model) throws Exception{
		List<?> list = memberService.selectPostList(dong);
		model.addAttribute("result",list);
		return "member/post2";
	}
}
