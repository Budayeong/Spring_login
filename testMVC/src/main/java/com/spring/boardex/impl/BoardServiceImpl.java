package com.spring.boardex.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.boardex.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//boardDao ��ü �̿� 
	@Autowired
	private BoardDao bdao; // BoardDao repository �κ��� ���� �� 
	
	@Override
	public void insertBoard(BoardDo bdo) {
		bdao.insertBoard(bdo);
	}
	
	@Override
	public ArrayList<BoardDo> getBoardList() {
		return bdao.getBoardList();
	}

	@Override
	public boolean userCheck(BoardDo bdo) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
