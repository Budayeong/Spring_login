package com.spring.boardex.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.boardex.common.JdbcUtil;
import com.spring.boardex.impl.BoardDo;

public class BoardClient {
	
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("boardSetting.xml");
		
		BoardService bService = (BoardService) context.getBean("boardService");
	
		//전체 데이터 가져오기 
		ArrayList<BoardDo> bList= bService.getBoardList();
		for(BoardDo bdo: bList) {
			System.out.println("-->"+bdo.toString());
		} //하이디sql에 들어있는 데이터 개수만큼 가져옴


	}
}
