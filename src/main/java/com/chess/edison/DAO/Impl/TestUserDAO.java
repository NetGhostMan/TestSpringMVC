package com.chess.edison.DAO.Impl;

import java.util.ArrayList;
import java.util.List;


import com.chess.edison.DAO.UserDAO;
import com.chess.edison.meta.User;


public class TestUserDAO implements UserDAO{

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUserId(1001);
		user1.setUserName("test1");
		User user2 = new User();
		user2.setUserId(1002);
		user2.setUserName("test2");
		users.add(user1);
		users.add(user2);
		return users;
	}

}
