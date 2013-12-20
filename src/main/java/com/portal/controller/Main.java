package com.portal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

import com.portal.model.domain.Users;
import com.portal.model.service.UsersService;

@Controller
@RequestMapping("/")
public class Main {
	
	@Autowired
	private UsersService userService;
	
	public static Logger logger = Logger.getLogger(Main.class);
	
	public Main() {
	
	}
	
	@RequestMapping(value="/index.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String myHandler(Model model, @RequestParam(value = "error", required = false) boolean error)
	{
		model.addAttribute("loginerror", "");
		
		if (error == true) {
			// Assign an error message
			model.addAttribute("loginerror", "You have entered an invalid username or password!");
		}
		
		model.addAttribute("page_title", "Login page");

		return "index";
    }
	
	@RequestMapping(value="/main.html", method=RequestMethod.GET)
	public String main(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception,ServletException {
		
		logger.debug("Method main, name: " + request.getMethod());
		
		 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	
		model.addAttribute("username", name);
		
		logger.debug("UserName: " + name);
		
		
		model.addAttribute("page_title", "Main page");
		model.addAttribute("panel_title", "Main page");

		return "main";
		
    }
	
	@RequestMapping(value="/leave.html", method=RequestMethod.GET)
	public String exit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "index";
    }
	
}