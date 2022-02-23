package main.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.BoardService;
import main.service.BoardVO;

@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/boardWrite.do")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@RequestMapping("/boardWriteSave.do")
	@ResponseBody
	public String boardWriteSave(BoardVO vo) throws Exception {
		String result = boardService.insertBoard(vo);
		String msg = "";
		if(result == null) msg = "ok";
		else msg = "fail";
		return msg;
	}
	
	@RequestMapping("/boardList.do")
	public String boardList(BoardVO vo,ModelMap model) throws Exception{
		int unit = 5;
		int total = boardService.selectBoardTotal(vo);
		int tpage = (int)Math.ceil((double)total/unit);
		int viewPage = vo.getViewPage();
		if(viewPage > tpage || viewPage < 0) {
			viewPage = 1;
		}
		int startRow = (viewPage-1)*unit+1;
		int endRow = startRow +(unit-1);
		int startSeq = total - (viewPage - 1)*unit;
		vo.setStartRow(startRow);
		vo.setEndRow(endRow);
		List<?> list = boardService.selectBoard(vo);
		model.addAttribute("rowNumber",startSeq);
		model.addAttribute("total",total);
		model.addAttribute("tpage",tpage);
		model.addAttribute("result",list);
		return "board/boardList";
	}
	
	@RequestMapping("/boardDetail.do")
	public String boardDetail(BoardVO vo, ModelMap model) throws Exception{
		boardService.updateBoardHits(vo.getUnq());
		BoardVO rtnVo = boardService.selectBoardDetail(vo.getUnq());
		String content = rtnVo.getContent();
		rtnVo.setContent(content.replace("\n", "<br>"));
		model.addAttribute("result",rtnVo);
		return "board/boardDetail";
	}
	
	@RequestMapping("/boardModify.do")
	public String boardModify(BoardVO vo, ModelMap model) throws Exception{
		BoardVO rtnVo = boardService.selectBoardDetail(vo.getUnq());
		model.addAttribute("result",rtnVo);
		return "board/boardModify";
	}
	
	@RequestMapping("/boardModifySave.do")
	@ResponseBody
	public String boardModifySave(BoardVO vo, ModelMap model) throws Exception{
		int result = 0;
		int chk = boardService.selectBoardPass(vo);
		if(chk == 1) {
			result = boardService.updateBoard(vo);
		}else {
			result = -1;
		}
		return result+"";
	}
	
	@RequestMapping("/passWrite.do")
	public String passWrite(int unq,ModelMap model) {
			model.addAttribute("unq",unq);
		return "board/passWrite";
	}
	
	@RequestMapping("/boardDelete.do")
	@ResponseBody
	public String boardDelete(BoardVO vo) throws Exception{
		int result = 0;
		int chk = boardService.selectBoardPass(vo);
		if(chk == 1) {
			result = boardService.deleteBoard(vo);
		}else if(chk == 0) {
			result = -1;
		}
		return result+"";
	}
}
