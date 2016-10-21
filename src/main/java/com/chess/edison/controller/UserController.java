package com.chess.edison.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chess.edison.DAO.UserDAO;
import com.chess.edison.meta.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	private void addmap(ModelMap map) {
		List<User> userList = userDAO.getUsers();
		map.addAttribute("userList", userList);
	}
	
	@RequestMapping("user.html")
	public String loginHtml(ModelMap map){
		addmap(map);
		return "user";
	}
	@RequestMapping("user.json")
	public String loginJson(ModelMap map){
		addmap(map);
		return "userJson";
	}
	@RequestMapping(value="user",produces="text/html")
	public String loginHtml1(ModelMap map){
		addmap(map);
		return "user";
	}
	@RequestMapping(value="userjson",produces="application/json")
	public String loginJson1(ModelMap map){
		addmap(map);
		return "userJson";
	}
	
}
