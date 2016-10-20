package com.chess.edison.DAO.Impl;

import org.springframework.stereotype.Repository;

import com.chess.edison.DAO.UserDAO;
import com.chess.edison.meta.User;

@Repository
public class TestUserDAO implements UserDAO{

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserId(1001);
		user.setUserName("test1");
		return user;
	}

}
