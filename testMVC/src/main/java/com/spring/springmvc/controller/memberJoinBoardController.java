package com.spring.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class memberJoinBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("memberJoinBoardController --> ");
		
		//ȸ������ ȭ�� ����
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberJoin");
		
		
		return mav;
	}

}
