<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 전체 리스트 보기 (memberList.jsp) </h2>
	<hr>
	<a href = "memberJoinBoard.do"> 회원가입 </a>
	<a href = "login.do"> 로그인 </a>
	<table border="1px solid gray" style="border-collaps:collapse;">
		<tr align="center" height="50">
			<td width="200">아이디</td>
			<td width="200">이름</td>
			<td width="200">비밀번호</td>
			<td width="200">전화번호</td>
		</tr>
		<!-- jstl을 이용하여 데이터 출력 -->
		<c:forEach items="${bList}" var="board">
			<tr align="center" height="50">
			<td width="200">${board.id}</td>
			<td width="200">${board.name}</td>
			<td width="200">${board.password}</td>
			<td width="200">${board.number}</td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>