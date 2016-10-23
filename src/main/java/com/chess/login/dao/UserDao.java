package com.chess.login.dao;

import org.apache.ibatis.annotations.Select;

public interface UserDao {

	@Select("select userPassword from User where userName = #{userName}")
	public String getUserPassword(String userName);
}
