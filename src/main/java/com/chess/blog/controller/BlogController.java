package com.chess.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chess.blog.Service.SubmitService;

@Controller
public class BlogController {

	@Autowired
	SubmitService submitServiceImpl;
	
	@RequestMapping("sumit.html")
	public void doSubmit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			ModelMap map) {
		String blogTitle = httpServletRequest.getParameter("blogTitle");
		String blogContent = httpServletRequest.getParameter("blogContent");
		if(blogTitle.length() <= 20 && blogContent.length() <= 100){
			submitServiceImpl.addBlog(blogTitle,blogContent);
			httpServletResponse.setStatus(200);
		}else{
			httpServletResponse.setStatus(400);
		}
	}
}
