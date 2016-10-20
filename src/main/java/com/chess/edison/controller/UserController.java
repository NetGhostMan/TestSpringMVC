package com.chess.edison.controller;

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
	
	@RequestMapping("user")
	public String login(ModelMap map){
		User user = userDAO.getUser();
		map.addAttribute("userId",user.getUserId());
		map.addAttribute("userName",user.getUserName());
		return "user";
		
	}
}
