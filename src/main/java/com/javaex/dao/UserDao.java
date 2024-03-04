package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("userDao.userSelectByIdPw()");
		
		UserVo authuser = sqlSession.selectOne("user.seletbyIdPw", userVo);
		
		System.out.println(authuser);
		
		return authuser;
	}
	
	public int userInsert(UserVo userVo) {
		System.out.println("userDao.userInsert()");
		
		int count = sqlSession.insert("user.insert",userVo);
		
		return count;
	}
	
	public int userUpdate(UserVo userVo) {
		System.out.println("userDao.userUpdate()");
		
		int count = sqlSession.update("user.update", userVo);
		
		return count;
	}
	
}
