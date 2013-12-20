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

import com.portal.model.domain.Data;
import com.portal.model.service.DataService;

@Controller
@RequestMapping("/")
public class Main { //extends MultiActionController implements InitializingBean{
	
	@Autowired
	private DataService dataService;
	
	public static Logger logger = Logger.getLogger(Main.class);
	
	public Main() {
		// TODO Auto-generated constructor stub
	}


	
	@RequestMapping(value="/index.html", method = { RequestMethod.GET, RequestMethod.POST })
	public String myHandler(Model model, //@RequestParam(value = "user", required=false) String user,
										 //@RequestParam(value = "password", required = false) String password,
										 @RequestParam(value = "error", required = false) boolean error
										 //HttpServletRequest request, HttpServletResponse response
										 ) {

	
		//logger.debug("Method index, name: " + request.getMethod());
		//logger.debug("Method index, user: " + user);
		//logger.debug("Method index, password: " + password);
		
		if (error == true) {
			// Assign an error message
			logger.debug("##################### login error");
			model.addAttribute("loginerror", "You have entered an invalid username or password!");
		} else {
			model.addAttribute("loginerror", "");

		}
		
		
		//HttpSession session=request.getSession(true);

		model.addAttribute("page_title", "Login page");
		/***
		if (user!=null && password!=null) {
			logger.debug("before getting data");
			Data data=dataService.getLogin(user, password);
			session.setAttribute("code", Integer.toString(data.getUsers().getCode()));
			logger.debug("code "+data.getUsers().getCode());
			try {
				response.sendRedirect("main.html");
				//return "redirect:main.html";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.debug("can't redirect");
			}

		}
		***/ 
		return "index";
    }
	
	@RequestMapping(value="/main.html", method=RequestMethod.GET)
	public String main(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception,ServletException {
		
		logger.debug("Method main, name: " + request.getMethod());
		
		 
		Data user = (Data)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getLogin();
	
		model.addAttribute("username", name);
		
		
		model.addAttribute("page_title", "Main page");
		model.addAttribute("panel_title", "Main page");
		/***
		String pk_code = (String) session.getAttribute("code");
		
		if (pk_code==null) {
			response.sendRedirect("index.html");	
		}
		else {
			model.addAttribute("code", pk_code);
		}
		***/
		return "main";
		
    }
	
	@RequestMapping(value="/leave.html", method=RequestMethod.GET)
	public String exit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		logger.debug("Method leave");
		
		//HttpSession session=request.getSession(true);
		//session.invalidate();
		//response.sendRedirect("main.html");
		return "index";
    }
	
}