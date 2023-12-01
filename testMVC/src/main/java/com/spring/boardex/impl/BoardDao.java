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
	
	//1.������ ���� 
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() --> ");
		
		//1.DB�� ���� 
		conn=JdbcUtil.getConnection();
		String sql="insert into board values (?,?,?,?)";
		try {
			
			//2.sql�� �ϼ� 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getId());
			pstmt.setString(2, bdo.getName());
			pstmt.setString(3, bdo.getPassword());
			pstmt.setString(4, bdo.getNumber());
			
			//3.sqló�� 
			pstmt.executeUpdate();
			
			//4.���� ���� 
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("insertBoard() ó�� �Ϸ� ");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//2.��ü ������ �������� 
	public ArrayList<BoardDo> getBoardList(){
		System.out.println("getBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//1. ��� ����
		conn=JdbcUtil.getConnection();
		String sql="select * from board";
		
		
		try {
			//2. sql�� �ϼ� 
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			//3.sql���� �� ��� �ޱ�
			while(rs.next()) {
				BoardDo bdo=new BoardDo();
				bdo.setId(rs.getString(1));
				bdo.setName(rs.getString(2));
				bdo.setPassword(rs.getString(3));
				bdo.setNumber(rs.getString(4));
				//�迭 ����Ʈ�� �о�� ������ �����ϱ� 
				bList.add(bdo);
			}
			
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getBoardList() ó�� �Ϸ�!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return bList;
	}
	
	
	//3. �α��� ������ ���ϱ�
	public boolean userCheck(String id, String password) {
	   Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       try {
           //DB ���� ����
            conn = JdbcUtil.getConnection();

			String sql="SELECT * FROM board WHERE id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, password);
	        
	        rs = pstmt.executeQuery();
	
	        return rs.next(); // ����� ������ true, ������ false ��ȯ
	        
		   } catch (SQLException e) {
	           e.printStackTrace();
	           return false;
		   } finally {
	           // ���ҽ��� �ݾƾ� �մϴ�.
	           JdbcUtil.close(rs, pstmt, conn);
	}
}
	}
