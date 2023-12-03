package com.spring.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class loginBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("loginBoardController --> ");
		
		//로그인 화면 연결
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		
		return mav;
	}

}
