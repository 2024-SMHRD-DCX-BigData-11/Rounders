package com.baseballtalk.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baseballtalk.database.SqlSessionManager;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

public class MemberDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	 
	public int join(MemberDTO member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.insert("com.baseballtalk.database.MemberMapper.join", member);
		session.close();
		return cnt;
	}
	
	
	public boolean nickCheck(String input_nick) {
		SqlSession session = sqlSessionFactory.openSession(true);
		boolean result = session.selectOne("com.baseballtalk.database.MemberMapper.nickCheck", input_nick);
		session.close();
		return result;
	}
	
	public MemberDTO login(MemberDTO member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		MemberDTO login_member = session.selectOne("com.baseballtalk.database.MemberMapper.login", member);
		session.close();
		return login_member;
	}
	
	public MemberDTO kakaologin(MemberDTO member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		MemberDTO login_member = session.selectOne("com.baseballtalk.database.MemberMapper.kakaologin", member);
		session.close();
		return login_member;
	}
	
	
	public int kakaoupdate(MemberDTO update_member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("com.baseballtalk.database.MemberMapper.kakaoupdate", update_member);
		session.close();
		return cnt;
	}
	
	public int updateMember(MemberDTO update_member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("com.baseballtalk.database.MemberMapper.updateMember", update_member);
		session.close();
		return cnt;
	}
	
	public MemberDTO SerchPw(MemberDTO member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		MemberDTO serchPw = session.selectOne("com.baseballtalk.database.MemberMapper.serchPw", member);
		session.close();
		return serchPw;
	}
	
	public int memberRemove(MemberDTO remove_member) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.delete("com.baseballtalk.database.MemberMapper.removemember", remove_member);
		session.close();
		return cnt;
	}
	
	public String getNick(String id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		String nick = session.selectOne("com.baseballtalk.database.MemberMapper.getNick", id);
		session.close();
		return nick;
	}
	
	public int updatePoint(MemberDTO member){
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("com.baseballtalk.database.MemberMapper.updatePoint", member);
		session.close();
		return cnt;
	}
	
	public int getPoint(String id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int point = session.selectOne("com.baseballtalk.database.MemberMapper.getPoint", id);
		session.close();
		return point;
	}
	
	public int updateGrade(MemberDTO updatemem){
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("com.baseballtalk.database.MemberMapper.updateGrade",updatemem);
		session.close();
		return cnt;
	}
	
	public int updateMemberTeam(MemberDTO updatemem){
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("com.baseballtalk.database.MemberMapper.updateMemberTeam",updatemem);
		session.close();
		return cnt;
	}
	
	
	
}
