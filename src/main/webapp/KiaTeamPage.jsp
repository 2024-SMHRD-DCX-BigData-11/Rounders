<%@page import="com.baseballtalk.model.MatchDAO"%>
<%@page import="com.baseballtalk.model.MatchDTO"%>
<%@page import="com.baseballtalk.model.MemberDAO"%>
<%@page import="com.baseballtalk.model.BoardDAO"%>
<%@page import="com.baseballtalk.model.TeamBoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기아 팀 페이지</title>
<link href="./css/TeamPage.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	List<TeamBoardDTO> showKiaBoard = new BoardDAO().showKiaBoard();
	MatchDTO mymatch = new MatchDAO().myView(1);
	%>
	<%@ include file="header.jsp"%>
	<img alt="logo" src="./image/kiaimg.jpg" class="img">
	<div class = "con-wrap">
	<div class="wrap">
		<div class="all">
			<div class="left">
				<div id="team">
					<h1>
						기아 타이거즈 게시판 <select>
							<option value="category">카테고리</option>
							<option value="category">잡담</option>
							<option value="category">정보</option>
							<option value="category">직관모임</option>
						</select>
					</h1>
					<table class="table">
						<span style="color: red" id="hotBoard">!! 지금 핫한 게시물 !! >>></span>
						<colgroup>
							<col width="60px">
							<col width>
							<col width="50px">
							<col width="110px">
							<col width="70px">
							<col width="50px">
						</colgroup>
						<thead>
							<tr>
								<th>카테고리</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일자</th>
								<th>조회수</th>
								<th>좋아요</th>
								<th>첨부파일</th>
							</tr>
						</thead>
						<%
						for (TeamBoardDTO tb : showKiaBoard) {
						%>
						<%
						String mem_nick = new MemberDAO().getNick(tb.getMem_id());
						%>
						<tbody>
							<tr>
								<td><%=tb.getBoard_category()%></td>
								<td
									onclick="location.href='TeamBoardPostingDetail.jsp?board_idx=<%=tb.getBoard_idx()%>'"><%=tb.getBoard_title()%></td>
								<td><%=mem_nick%></td>
								<td><%=tb.getCreated_at()%></td>
								<td><%=tb.getBoard_views()%></td>
								<td><%=tb.getBoard_likes()%></td>
								<td><%=tb.getBoard_file()%></td>
							</tr>
						</tbody>
						<%
						}
						%>
					</table>
					<div class="write_wrap">
						<div class="write">
							<%MemberDTO mem_login = (MemberDTO)session.getAttribute("login_member");
							if(mem_login == null){%>
								<a href="Login.jsp"><input style="background: #ea0029"
										type="button" name="write" value="글 쓰기" id="write"></a>
							<%}else if(mem_login != null){%>
								<a href="TeamPostingWrite.jsp"><input style="background: #ea0029"
										type="button" name="write" value="글 쓰기" id="write"></a>
							
							<%}%>
							
						</div>
					</div>
					<div class="page_wrap">
						<div class="page">
							<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
							<a href="#">5</a> <a href="#">6</a> <a href="#">7</a> <a href="#">8</a>
							<a href="#">9</a> <a href="#">10</a> <a href="#" class="next"
								title="다음"><input type="button" name="next" value="다음"></a>
						</div>
					</div>
				</div>

			</div>
			<div class="right">
				<div class="rightone">
					<table id="schedule_wrap" style="border: 3px solid #ea0029">
						<tr>
							<th colspan="3" id="match_date">오늘의 경기<br> <span><%=mymatch.getMatch_date() %></span></th>
						</tr>
							<tr>
								<td><span class="team"><%=mymatch.getAway_team() %></span><br>
									<span class="pitcher"><%=mymatch.getAway_pitcher() %></span></td>
								<td><%=mymatch.getMatch_time() %></td>
								<td><span class="team"><%= mymatch.getHome_team() %></span><br>
									<span class="pitcher"><%=mymatch.getHome_pitcher() %></span></td>
							</tr>
						
					</table>
				</div>
				<!-- 버튼 -->
				<div class="rightone">
					<input style="background: #ea0029" type="button" value="응원하기"
						onclick="openPopup()">
				</div>
			</div>
		</div>

	</div>
	<!-- 팝업 창 -->
	<div class="overlay" id="overlay"></div>
	<div class="popup" id="popup">
		<h2>응원하기</h2>
		<div>팀 응원가</div>
		<div>
			<iframe width="560" height="315"
				src="https://www.youtube.com/embed/cGs5swSDvJ8?si=7xh4_WbYPHFuOThA"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
		</div>
		<a target="_blank" href="https://teamstore.tigers.co.kr/"><img
			id="logo" src="./image/kia.svg"></a> <span><< 굿즈 사러가기 </span> <span
			style="color: red">CLICK!</span>
		<button style="background: #ea0029" onclick="closePopup()">닫기</button>
	</div>

	<div>
		<%@ include file="Footer.jsp"%>
	</div>
</div>
	<script>
		function openPopup() {
			document.getElementById('overlay').style.display = 'block';
			document.getElementById('popup').style.display = 'block';
		}

		function closePopup() {
			document.getElementById('overlay').style.display = 'none';
			document.getElementById('popup').style.display = 'none';
		}
	</script>
</body>
</html>