package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;

@Controller
public class CodeController {

	@Resource(name="codeService")
	private CodeService codeService;
	
	@RequestMapping("/codeWrite.do")
	public String codeWrite() {
		return "code/codeWrite";
	}

	@RequestMapping("/codeWriteSave.do")
	public String codeWriteSave(CodeVO vo) throws Exception{
		String result = codeService.insertCodes(vo);
		if(result == null) {
			System.out.println("등록성공!");
		}else {
			System.out.println("등록실패!");
		}
		return "redirect:codeList.do";
	}
	
	@RequestMapping("/codeList.do")
	public String codeList(CodeVO vo, ModelMap model) throws Exception{
		int total = codeService.selectCodesCount(vo);
		List<?> list = codeService.selectCodesList(vo);
		System.out.println("list="+list);
		model.addAttribute("total",total);
		model.addAttribute("result",list);
		return "code/codeList";
	}
	
	@RequestMapping("/codeDelete.do")
	public String codeDelete(int code) throws Exception{
		int result = codeService.deleteCodes(code);
		return "redirect:codeList.do";
	}
	
	@RequestMapping("/codeModify.do")
	public String codeModify(int code, ModelMap model) throws Exception{
		CodeVO vo = codeService.selectCodesDetail(code);
		model.addAttribute("result",vo);
		return "code/codeModify";
	}
	
	@RequestMapping("/codeModifySave.do")
	public String codeModifySave(CodeVO vo) throws Exception{
		int result = codeService.updatecodes(vo);
		return "redirect:codeList.do";
	}
}
