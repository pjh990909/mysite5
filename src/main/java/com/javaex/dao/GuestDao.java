package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MemberVo;

@Repository
public class GuestDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberVo> guestSelect(){
		System.out.println("GuestDao.guestSelet()");
		
		List<MemberVo> memberList = sqlSession.selectList("guest.select");
		
		System.out.println(memberList);
		
		return memberList;
	}
	
	//등록
		public int guestInsert(MemberVo memberVo) {
			
			int count = sqlSession.insert("guest.insert", memberVo);
			
			return count;
		}
		//삭제
		public int guestDelete(MemberVo memberVo) {
			
			int count = sqlSession.delete("guest.delete",memberVo);
			return count;
		}
}
