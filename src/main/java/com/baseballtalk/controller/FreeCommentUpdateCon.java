package com.baseballtalk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseballtalk.model.FreeBoardDTO;
import com.baseballtalk.model.MemberDTO;
import com.baseballtalk.model.NoticeBoardDTO;
import com.baseballtalk.model.RecoredCommentDTO;
import com.baseballtalk.model.TeamBoardCommentDTO;
import com.baseballtalk.model.TeamBoardDTO;
import com.baseballtalk.model.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.baseballtalk.model.BoardDAO;
import com.baseballtalk.model.CommentDAO;
import com.baseballtalk.model.FreeBoardCommentDTO;
import com.baseballtalk.model.TeamBoardCommentDTO;

@WebServlet("/FreeCommentUpdateCon")
	
	public class FreeCommentUpdateCon extends HttpServlet {


		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
			
			String mem_id = request.getParameter("mem_id");
			String cmt_content = request.getParameter("cmt_content");
			
			System.out.println("nick : " + mem_id);
			System.out.println("rcmt_content : " + cmt_content);
			
			FreeBoardCommentDTO freeComment = new FreeBoardCommentDTO(cmt_content, mem_id);
						
			// System.out.println(member.toString());
			
			int u_cnt = new CommentDAO().updateFreeBoardComment(freeComment);//u_cnt = update_cnt
			
			
			
			if(u_cnt > 0) {
				System.out.println("자유게시판 댓글 수정 성공!!");
				String stat = (String)request.getParameter("stat");
				System.out.println(stat);
				RequestDispatcher rd1 = request.getRequestDispatcher("FreeBoard.jsp");
			}else {
				System.out.println("자유게시판 댓글 수정 실패...ㅠㅠ");
				RequestDispatcher rd2 = request.getRequestDispatcher("FreeBoard.jsp");
	
			}
			
			
		}

		
		}
					
			