package com.chess.login.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chess.login.dao.UserDao;
import com.chess.login.meta.User;
import com.chess.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;
	@Override
	public boolean isUser(User user) {
		String userPassword = userDao.getUserPassword(user.getUserName());
		if(userPassword == null){
			return false;
		}else if(!userPassword.equals(user.getUserPassword())){
			return false;
		}else{
			return true;
		}
	}
}
