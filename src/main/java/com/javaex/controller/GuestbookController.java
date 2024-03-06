package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;


@Controller
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	//리스트
	@RequestMapping(value="/guest/addList", method= {RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		List<GuestVo> guestList=guestbookService.exeList();

		System.out.println(guestList);
		
		model.addAttribute("gList", guestList);
		
		
		return "addList";
	}
	
	
	@RequestMapping(value="/guest/write", method= {RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.write()");
		
		System.out.println(guestVo.toString());
		 
		
		//서비스의 메소드 사용
		guestbookService.exeWrite(guestVo);

		
		return "redirect:/guest/addList";
	}
	
	//삭제
	@RequestMapping(value="/guest/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("GuestbookController.delete()");

		guestbookService.exeDelete(guestVo);

		
		return "redirect:/guest/addList";
	}
	
	//삭제폼
	@RequestMapping(value="/guest/deleteform", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam(value="no") int no, Model model) {
		System.out.println("GuestbookController.deleteForm()");
		
		model.addAttribute("no", no);
		return "deleteForm";
	}
}
