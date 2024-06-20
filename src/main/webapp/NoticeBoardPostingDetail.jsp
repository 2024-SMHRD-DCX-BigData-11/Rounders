<%@page import="com.baseballtalk.model.MemberDAO"%>
<%@page import="com.baseballtalk.model.BoardDAO"%>
<%@page import="com.baseballtalk.model.NoticeBoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
	<link href="./css/PostingDetail.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	int notice_idx = Integer.parseInt(request.getParameter("notice_idx"));
	NoticeBoardDTO noticeBoard = new BoardDAO().noticeDetail(notice_idx);
	String mem_nick = new MemberDAO().getNick(noticeBoard.getMem_id());
%>
<%@ include file = "header.jsp" %>
	<div id = "board">
				<form action="#" method="post" enctype="multipart/form-data">
				<table id="list">
					<tr><td class="td">카테고리</td>
						
						<td><%= noticeBoard.getNotice_category()%></td>
					</tr>
					<tr><td class="td">제목</td>
						
						<td><%= noticeBoard.getNotice_title()%></td>
					</tr>
					<tr>
						<td class="td">작성자</td>
						<td><%= mem_nick%></td>
					</tr>
					<tr>
						<td class="td">조회수</td>
						<td><%= noticeBoard.getNotice_views()%></td>
					</tr>
					<tr>
						<td class="td">등록일</td>
						<td><%= noticeBoard.getCreated_at()%></td>
					</tr>
					</tr>
					
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2"><h4><%= noticeBoard.getNotice_content()%></h4></td>
					</tr>
					<tr>
						<td colspan="2" id="rs">
							<a href="#"><input type="button" value="뒤로가기"></a>
						</td>
					</tr>
				</table>
				</form>
			</div>
		<div>
			<%@ include file="Footer.jsp"%>
		</div>
	<script>
		document.getElementById('backButton').addEventListener('click',
				function() {
					window.history.back(); // 브라우저의 뒤로 가기 기능을 실행합니다.
				});
	</script>
</body>
</html>