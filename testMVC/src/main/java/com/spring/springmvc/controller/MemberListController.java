package com.spring.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class MemberListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberListController --> ");
		
		//1. ���κ��� ��ü ������ �������� 
		BoardDo bdo=new BoardDo();
		BoardDao bdao=new BoardDao();
		ArrayList<BoardDo> bList=bdao.getBoardList();
		
		for(BoardDo board: bList) {
			System.out.println("--> "+board.toString());
		}
		
		//2. �� ȣ���ϸ鼭, ������ �ѱ��
		ModelAndView mav=new ModelAndView();
		mav.addObject("bList",bList);
		mav.setViewName("memberList"); //��� ������ ������ �ѱ�� ó���� �����ϴ�. 
		
		return mav;
	}
	
	
}
