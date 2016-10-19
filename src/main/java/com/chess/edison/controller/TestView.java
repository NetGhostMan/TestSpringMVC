package com.chess.edison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestView {

	@RequestMapping("login")
	public String login(@RequestParam String userName, @RequestParam String password, ModelMap map){
		map.addAttribute("userName", userName);
		map.addAttribute("password", password);
		
		return "user";
		
	}
}
