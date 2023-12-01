package com.spring.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class loginProcBoardController implements Controller{
	private BoardDao boardDao;
	
	// BoardDao�� �����ڳ� ���� �޼��带 ���� ����
    public loginProcBoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    public loginProcBoardController() {}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("loginProcBoardController -->");
		
		 // 1. �α��� ������ �������� (request)
        String id = request.getParameter("id");
        String password = request.getParameter("password");


        BoardDao boardDao = new BoardDao();
        // 2. DB�� ������ ��
        boolean userCheck = boardDao.userCheck(id, password);

        // 3. ����� ���� ������ �̵�
        if (userCheck) {
            // ����ڰ� ��ȿ�ϸ� 
            ModelAndView mav = new ModelAndView("loginConfirm"); 
            return mav;
        } else {
            // ����ڰ� ��ȿ���� ������ 
            ModelAndView mav = new ModelAndView("memberJoin"); 
            return mav;
        }
    }



}