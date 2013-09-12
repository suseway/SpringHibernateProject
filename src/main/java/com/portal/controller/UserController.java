package com.portal.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.portal.model.dao.RolesDao;
import com.portal.model.dao.UsersDao;
import com.portal.model.domain.Roles;
import com.portal.model.domain.Users;
import com.portal.model.domain.UsersService;

@Controller
@RequestMapping("/")
public class UserController {//extends MultiActionController implements InitializingBean{
	
	@Autowired
	private UsersService usersService;
	
	public static Logger logger = Logger.getLogger(Main.class);
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub		
	}
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value="/userslist.html", method=RequestMethod.GET)  
	public String userslist(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception,ServletException {
	
		HttpSession session=request.getSession(true);
		String pk_code = (String) session.getAttribute("code");
		if(pk_code==null) {
			response.sendRedirect("index.html");	
		}

		model.addAttribute("page_title", "List of users");
		model.addAttribute("panel_title", "List of users");
		
		List userslist = usersService.getAllUsers();
		model.addAttribute("users_list", userslist);
		
		return "userslist";
		
    }
	
	@RequestMapping(value="/users.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView users(HttpServletRequest request,HttpServletResponse response) throws Exception,ServletException {
		/*
		HttpSession session=request.getSession(true);
		String pk_code = (String) session.getAttribute("code");
		if(pk_code==null){
			response.sendRedirect("index.html");	
		}
		Map map=new HashMap();
		Users user=new Users();
		user.setName("");
		user.setPhone(0);
		user.setCode(0);
		user.setBirth(new Date());
		map.put("userv", user);
	
		map.put("list_roles", this.rolesDao.getAllRoles());
		map.put("panel_title", "Add user");
		
		if(request.getParameter("add")!=null)
		{
			Users usu=new Users();
			usu.setName(request.getParameter("name"));
			usu.setCode(Integer.parseInt(request.getParameter("code")));
			usu.setPhone(Integer.parseInt(request.getParameter("phone")));
			
			
			//  converting string to date from form   
			
			SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
			fecha.setLenient(true);
			System.out.println("birth while adding : " + request.getParameter("birth"));
			Date birth = fecha.parse(request.getParameter("birth"));
    		
			usu.setBirth(birth);
			
			Roles roles=this.rolesDao.getRoles(Integer.parseInt(request.getParameter("rol")));
			usu.setRoles(roles);
			
 			this.usersDao.saveUsers(usu); // for save 
 			//redirection to userslist.html
 			response.sendRedirect("userslist.html");
		}
		if(request.getParameter("uid")!=null){
			int code=Integer.parseInt(request.getParameter("uid"));
			user=this.usersDao.getUsers(code);
			map.put("userv", user);
			map.put("panel_title", "Edit user");
		}
		if(request.getParameter("cancel")!=null){
			response.sendRedirect("userslist.html");
		}
		if(request.getParameter("save")!=null)
		{
			int code=Integer.parseInt(request.getParameter("code"));
			user=this.usersDao.getUsers(code);
			user.setName(request.getParameter("name"));
			user.setPhone(Integer.parseInt(request.getParameter("phone")));
			
			//  converting string to date from form   
			

			SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
			fecha.setLenient(true);
			Date birth = fecha.parse(request.getParameter("birth"));
			user.setBirth(birth);

			Roles roles=this.rolesDao.getRoles(Integer.parseInt(request.getParameter("rol")));
			user.setRoles(roles);
			
			this.usersDao.updateUsers(user);
			response.sendRedirect("userslist.html");
		}
		
		return new ModelAndView("users", map);
		*/
		return null;
    }
}