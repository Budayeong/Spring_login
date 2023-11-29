package com.spring.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class memberJoinBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("memberJoinBoardProcController -->");
		
		/*
		 * //1. �߰��� ������ �������� (request) String writer = request.getParameter("writer");
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("content");
		 */
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		
		
		//2. ��� ����
		BoardDo bdo = new BoardDo();
		bdo.setId(id);
		bdo.setName(name);
		bdo.setPassword(password);
		bdo.setNumber(number);
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		//3. ��� �̿��Ͽ� �߰��� ������ Ȯ�� !!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.do");
		
		return mav;
	}

}
