package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.boardex.common.JdbcUtil;

@Repository("boardDao")
public class BoardDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	//1.데이터 저장 
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() --> ");
		
		//1.DB에 연결 
		conn=JdbcUtil.getConnection();
		String sql="insert into board values (?,?,?,?)";
		try {
			
			//2.sql문 완성 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getId());
			pstmt.setString(2, bdo.getName());
			pstmt.setString(3, bdo.getPassword());
			pstmt.setString(4, bdo.getNumber());
			
			//3.sql처리 
			pstmt.executeUpdate();
			
			//4.연결 해제 
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("insertBoard() 처리 완료 ");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//2.전체 데이터 가져오기 
	public ArrayList<BoardDo> getBoardList(){
		System.out.println("getBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//1. 디비 연결
		conn=JdbcUtil.getConnection();
		String sql="select * from board";
		
		
		try {
			//2. sql문 완성 
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			//3.sql실행 및 결과 받기
			while(rs.next()) {
				BoardDo bdo=new BoardDo();
				bdo.setId(rs.getString(1));
				bdo.setName(rs.getString(2));
				bdo.setPassword(rs.getString(3));
				bdo.setNumber(rs.getString(4));
				//배열 리스트에 읽어온 데이터 저장하기 
				bList.add(bdo);
			}
			
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getBoardList() 처리 완료!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return bList;
	}
	
	
	//3. 로그인 데이터 비교하기
	public boolean userCheck(String id, String password) {
	   Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       try {
           //DB 연결 설정
            conn = JdbcUtil.getConnection();

			String sql="SELECT * FROM board WHERE id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, password);
	        
	        rs = pstmt.executeQuery();
	
	        return rs.next(); // 결과가 있으면 true, 없으면 false 반환
	        
		   } catch (SQLException e) {
	           e.printStackTrace();
	           return false;
		   } finally {
	           // 리소스를 닫아야 합니다.
	           JdbcUtil.close(rs, pstmt, conn);
	}
}
	}
