package com.kei890.validationtutorial.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kei890.validationtutorial.dto.MemberDto;

@Controller
public class MemberController {
	

    @RequestMapping("/")
    public String moveTestJsp(Model model) {
    	//빈 객체 넘겨줘야함. 
    	model.addAttribute("memberDto", new MemberDto());
    	return "insert";
    }
    
    @RequestMapping("/insert")
    public String memberInsert(@Valid @ModelAttribute MemberDto memberDto,
    		BindingResult result) {
     
    	System.out.println("---- MemberController::memberInsert() ----");
    	
    	System.out.println(memberDto.toString());
    	
    	System.out.println("오류가 있나요? : " + result.hasErrors());
    	
    	if(result.hasErrors()) {
    		//form에 에러가 있으면
    		return "insert";
    	}
    	//에러가 없으면
    	return "";
    	
    }
    

}
