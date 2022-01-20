package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute; // vo 인스턴스 받기
import org.springframework.web.bind.annotation.RequestMapping; // 주소 정하기
import org.springframework.web.bind.annotation.RequestMethod; // get post

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;


@Controller
@RequestMapping(value="/guest")
public class GuestController {

	@Autowired
	private GuestBookDao guestBookDao;
	
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model){
		System.out.println("addList()");
		List<GuestBookVo> guestBookList = guestBookDao.getGuestBookList();
		model.addAttribute("gList",guestBookList);
		
		return "addList";
	}
	
	
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(){
		
		return "deleteForm";
	}
	
	
	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestBookVo vo){
		guestBookDao.addGuestBook(vo);
			
		return "redirect:addList";
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestBookVo vo){
		guestBookDao.deleteGuestBook(vo);
		
		return "redirect:addList";
	}
	
}
