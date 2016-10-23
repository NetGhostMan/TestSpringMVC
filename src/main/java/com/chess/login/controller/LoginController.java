package com.chess.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chess.login.meta.User;
import com.chess.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginServiceImpl;

	@RequestMapping("login.html")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		User user = new User();
		Cookie[] cookies = request.getCookies();
		HttpSession httpSession = request.getSession();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		// 是不是第一次 默认是
		boolean isfirst = true;
		// 如果cookies里没有叫userName的内容说明是第一次登陆。
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userName")) {
					isfirst = false;
				}
			}
		}

		// 如果是第一次登陆，同时userName为空。说明没有登陆过
		if (isfirst && userName == null) {
			map.addAttribute("msg", "未登陆");
			return "errer";
		}
		// 如果不是第一次
		if (!isfirst) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userName")) {
					if (userName == null) {
						userName = "";
					}
					if (userName.equals("")) {
						if (cookie.getValue().equals("")) {
							map.addAttribute("msg", "未登陆");
							return "errer";
						} else {
							user.setUserName(cookie.getValue());
							user.setUserPassword((String) httpSession.getAttribute("userPassword"));
						}
					} else {
						user.setUserName(userName);
						user.setUserPassword(userPassword);
					}

				}
			}
		}
		// 如果第一次登陆
		else {
			if (userName.equals("")) {
				map.addAttribute("msg", "未登陆");
				return "errer";
			} else {
				user.setUserName(userName);
				user.setUserPassword(userPassword);
			}
		}

		Cookie userNameCookie = null;
		if (loginServiceImpl.isUser(user)) {

			userNameCookie = new Cookie("userName", user.getUserName());
			response.addCookie(userNameCookie);
			httpSession.setAttribute("userPassword", user.getUserPassword());

			map.addAttribute("user", user);

			return "scuess";
		} else {
			userNameCookie = new Cookie("userName", null);
			response.addCookie(userNameCookie);
			map.addAttribute("msg", "用户名密码错误");
			return "errer";
		}

	}
}
