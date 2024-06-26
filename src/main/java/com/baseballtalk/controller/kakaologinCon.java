package com.baseballtalk.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baseballtalk.model.MemberDAO;
import com.baseballtalk.model.MemberDTO;

@WebServlet("/kakaologinCon")
public class kakaologinCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String nick = request.getParameter("nick");
		
		//System.out.println(email + " " + nick);
		
		MemberDTO member = new MemberDTO("k-"+email, null,null,"k-"+nick,null,null);
		MemberDTO kakao_member = new MemberDAO().kakaologin(member);
		//System.out.println(member.toString());
		if(kakao_member != null) {
			if(!member.getMem_nick().equals(kakao_member.getMem_nick())) {
				int cnt = new MemberDAO().kakaoupdate(member);
				if(cnt == 1) {
					kakao_member = new MemberDAO().kakaologin(member);
					System.out.println("업데이트 성공!");
				}else {
					System.out.println("데이터 업데이트 실패");
				}
			}
			//System.out.println(kakao_member);
			HttpSession session = request.getSession();
			session.setAttribute("login_member",kakao_member);
			System.out.println("로그인 성공!");
		}else{
			int cnt = new MemberDAO().join(member);
			if(cnt == 1) {
				System.out.println("카카오 가입 성공");
				HttpSession session = request.getSession();
				kakao_member = new MemberDAO().kakaologin(member);
				session.setAttribute("login_member",kakao_member);
			}else {
				System.out.println("카카오 가입 실패");
			}
		}
	}
}

