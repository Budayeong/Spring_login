package com.spring.boardex.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	//1. �Խ��� ������ ����
	void insertBoard(BoardDo bdo);
	
	//2. ��ü �Խ��� ������ �������� 
	ArrayList<BoardDo> getBoardList();
	
	//3. �α��� ������ ���ϱ�
	boolean userCheck(BoardDo bdo);

}
