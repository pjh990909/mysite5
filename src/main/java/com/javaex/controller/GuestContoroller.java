package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.MemberVo;

@Controller
@RequestMapping("/guest")
public class GuestContoroller {
	@Autowired
	private GuestService guestService;

	// 리스트,등록폼
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addlist(Model model) {
		System.out.println("guestController.addList()");

		List<MemberVo> memberList = guestService.exeList();

		model.addAttribute("mList", memberList);

		return "guestbook/addList";
	}

	// 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute MemberVo memberVo) {

		System.out.println("GuestbookController.write");

		guestService.exeWrite(memberVo);

		return "redirect:/guest/addList";

	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute MemberVo memberVo) {

		System.out.println("guestController.delete()");

		System.out.println(memberVo);

		guestService.exeDelete(memberVo);

		return "redirect:/guest/addList";

	}

	// 삭제폼
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@RequestParam(value = "no") int no, Model model) {

		System.out.println("guestController.deleteform()");

		model.addAttribute("no", no);

		return "guestbook/deleteForm";
	}
}
