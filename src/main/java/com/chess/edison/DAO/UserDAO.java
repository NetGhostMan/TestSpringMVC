package com.chess.edison.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chess.edison.meta.User;

public interface UserDAO {
	@Select("SELECT * FROM userList")
	public List<User> getUsers();
}
