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
	
	public class FreeCommentInsertCon extends HttpServlet {


		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
			
			String mem_id = request.getParameter("mem_id");
			String cmt_content = request.getParameter("cmt_content");
			
			System.out.println("nick : " + mem_id);
			System.out.println("rcmt_content : " + cmt_content);
			
			FreeBoardCommentDTO freeComment = new FreeBoardCommentDTO(cmt_content, mem_id);
						
			// System.out.println(member.toString());
			
			int i_cnt = new CommentDAO().insertFreeBoardComment(freeComment);//i_cnt = insert_cnt
			
			
			
			if(i_cnt > 0) {
				System.out.println("자유게시판 댓글 작성 성공!!");
				response.sendRedirect("FreeBoard.jsp");
			}else {
				System.out.println("자유게시판 댓글 작성 실패...ㅠㅠ");
				response.sendRedirect("FreeBoard.jsp");
	
			}
			
			
		}

		
		}
					
			