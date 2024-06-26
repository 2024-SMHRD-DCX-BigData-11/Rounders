package com.baseballtalk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseballtalk.model.FreeBoardDTO;
import com.baseballtalk.model.MemberDTO;
import com.baseballtalk.model.NoticeBoardDTO;
import com.baseballtalk.model.TeamBoardDTO;
import com.baseballtalk.model.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.baseballtalk.model.BoardDAO;

@WebServlet("/NoticeBoardInsertCon")
	
	public class NoticeBoardInsertCon extends HttpServlet {


		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// 파일 업로드를 위한 변수 설정
			// 1. request
			// 2. 파일을 저장할 경로(상대경로)
			String path = request.getServletContext().getRealPath("./file");
			System.out.println(path);
			// 3. 파일 허용 용량
			int maxSize = 10*1024*1024; // 10MB
			
			// 4. 인코딩 방식
			String encoding = "UTF-8";
			
			// 5. 중복제거
			DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();
			
			MultipartRequest multi;
		try {
			
			multi = new MultipartRequest(request, path, maxSize, encoding, rename);
			
			request.setCharacterEncoding("UTF-8");
			
			String notice_category = multi.getParameter("notice_category");
			String notice_title = multi.getParameter("notice_title");
			String notice_content = multi.getParameter("notice_content");
			String mem_id = multi.getParameter("mem_id");
			
			NoticeBoardDTO noticeBoard = new NoticeBoardDTO(notice_title, notice_content, mem_id, notice_category);
			
			int i_cnt = new BoardDAO().insertNoticeBoard(noticeBoard); //i_cnt = insert_cnt
			
			System.out.println(notice_category + " " + notice_title + " " + notice_content + " " + mem_id);
			
			if(i_cnt == 1) {
				System.out.println("공지사항 게시글 업데이트 성공");
				response.sendRedirect("Notice.jsp");
			}
			else {
				System.out.println("공지사항 게시글 업데이트 실패");
				response.sendRedirect("NoticePostingWrite.jsp");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
					
			