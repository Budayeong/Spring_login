package com.spring.boardex.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.boardex.common.JdbcUtil;
import com.spring.boardex.impl.BoardDo;

public class BoardClient {
	
	public static void main(String[] args) {
//		JdbcUtil jUtil = new JdbcUtil();
//		jUtil.getConnection();
		
		ApplicationContext context = new GenericXmlApplicationContext("boardSetting.xml");
		
		BoardService bService = (BoardService) context.getBean("boardService");
		
		//1. ������ ����
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle("title3");
//		bdo.setWriter("writer3");
//		bdo.setContent("content3");
//		bService.insertBoard(bdo);
		
		//2. ��ü ������ �������� 
		ArrayList<BoardDo> bList= bService.getBoardList();
		for(BoardDo bdo: bList) {
			System.out.println("-->"+bdo.toString());
		} //���̵�sql�� ����ִ� ������ ������ŭ ������
		

//		//2. ��ü ������ �������� 
//		bList= bService.getBoardList();
//		for(BoardDo board: bList) {
//			System.out.println("-->"+board.toString());
//		} 
		

	}
}
