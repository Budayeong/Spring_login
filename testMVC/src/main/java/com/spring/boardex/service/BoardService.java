package com.spring.boardex.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	//1. 게시판 데이터 저장
	void insertBoard(BoardDo bdo);
	
	//2. 전체 게시판 데이터 가져오기 
	ArrayList<BoardDo> getBoardList();
	
	//3. 로그인 데이터 비교하기
	boolean userCheck(BoardDo bdo);

}
