package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("userService.exeLogin()");
		
		UserVo authUser = userDao.userSelectByIdPw(userVo);
		
		return authUser;
	}
	
	//회원가입
	public int exejoin(UserVo userVo) {
		System.out.println("userService.exejoin()");
		
		int count = userDao.userInsert(userVo);
		
		return count;
	}
	
	//회원정보수정
	public int exeModify(UserVo userVo) {
		System.out.println("userService.exeModify()");
		
		int count = userDao.userUpdate(userVo);
		
		return count;
	}
	
}
