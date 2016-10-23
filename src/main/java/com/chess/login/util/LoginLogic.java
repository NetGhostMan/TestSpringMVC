package com.chess.login.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginLogic {
	public static String loginlogic(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		String userName = request.getParameter("userName");

		boolean cookieIsNull = true;
		// 检查cookies里的元素
		for (Cookie cookie : cookies) {
			// 如果cookies中有userName的cookie
			if (cookie.getName().equals("userName")) {
				// 看下userName是否为空
				if (cookie.getValue() != null) {
					// buweikong
					cookieIsNull = false;
				}
			}
		}
		// 以后登陆情况1:cookie中保存了账号密码，没有输入
		if (!cookieIsNull && userName.equals("")) {
			return "NOT_IN_SCOUND";
		}
		// 再次登陆情况2:cookie中保存了账号，但是有输入
		if (!cookieIsNull && !userName.equals("")) {
			return "IN_SCOUND";
		}
		// 再次登陆情况3:cookie中被清空，没有输入
		if (cookieIsNull && userName.equals("")) {
			return "IN_SCOUND_NO_COOKIE";
		}
		// 再次登陆情况3:cookie中被清空，有输入
		if (cookieIsNull && !userName.equals("")) {
			return "IN_SCOUND_NO_COOKIE";
		}
		// 直接刷页面情况1，无cookie
		if (cookieIsNull && userName == null) {
			return "NO_COOKIE";
		}
		// 直接刷页面情况2，有cookie
		if (cookieIsNull && userName != null) {
			return "HAS_COOKIE";
		}

		return "ERRER";
	}
}
