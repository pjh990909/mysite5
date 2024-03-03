package com.javaex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping ("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//로그인폼
	@RequestMapping(value="/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		
		
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request,HttpSession session,@ModelAttribute UserVo userVo) {
		System.out.println("UserController.login()");
		
		System.out.println(userVo);
		
		UserVo authuser = userService.exeLogin(userVo);
		
		if(authuser != null) {
			session = request.getSession();
			session.setAttribute("authuser", authuser);
			return "redirect:/main";
		}else {
			
			return "redirect:/user/loginForm";
		}
		
		
	}
	
	//회원가입폼
	@RequestMapping(value="/joinForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value="/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		
		userService.exejoin(userVo);
		
		System.out.println(userVo);
		
		return "user/joinOk";
	}
	
}
