<%@page import="com.baseballtalk.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 게시글 작성</title>
	<link href="./css/PostingWrite.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file = "header.jsp" %>
 <!-- 로그인 세션 값 가져오기 -->
 <% MemberDTO login_member = (MemberDTO)session.getAttribute("login_member");%>
 <%String mem_id = login_member.getMem_id();%>
  <%String nick = login_member.getMem_nick();%>
	<div id = "board">
				<form action="FreeBoardInsertCon?mem_id=<%= mem_id %>&board_idx=0" method="post" enctype="multipart/form-data">
				<table id="list">
					<tr>
						<td>제목</td>
						
						<td><input type="text" name="board_title"> </td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><%=nick%></td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2">
							<input name="board_file" type="file" style="float: right;">
							<textarea name="board_content" rows="10" style="resize: none;"></textarea>			
						</td>
					</tr>
					<tr>
						<td colspan="2" id="rs">
							<input type="reset" value="초기화">
							<input type="submit" value="작성하기">
						</td>
					</tr>
				</table>
				</form>
			</div>
		<div>
			<%@ include file="Footer.jsp"%>
		</div>	
</body>
</html>