package com.spring.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class loginProcBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("loginProcBoardController -->");
		System.out.println("로그인 로직 ");
		
		
		
		//3. 뷰어 이용하여 추가된 데이터 확인 !!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.do");
		
		return mav;
	}

}
