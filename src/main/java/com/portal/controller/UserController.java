package com.portal.controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.portal.model.dao.RolesDao;
import com.portal.model.dao.UsersDao;
import com.portal.model.domain.Roles;
import com.portal.model.domain.Users;
import com.portal.model.service.RolesService;
import com.portal.model.service.UsersService;

import org.springframework.web.bind.annotation.InitBinder;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private RolesService rolesService;

	public static Logger logger = Logger.getLogger(UserController.class);
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub		
	}
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * @InitBinder goes into your Controller class
	 * to change the date format which is comming from your form.
	 */
	@InitBinder
	public void InitBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping(value="/list.html", method=RequestMethod.GET)  
	public String showUsersList(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("page_title", "List of users");
		model.addAttribute("panel_title", "List of users");
		
		List userslist = usersService.getAllUsers();
		model.addAttribute("users_list", userslist);
		
		return "user/list";
    }
	
	
	
	@RequestMapping(value="/edit.html", method = RequestMethod.GET)
	public String showUserForm(Model model, HttpServletRequest request, HttpServletResponse response,
									 @RequestParam(value="uid", required=false) String request_user_id)
											 throws Exception, ServletException {

		Users user=new Users();
		user.setName("");
		user.setPhone(0);
		user.setCode(0);
		user.setBirth(new Date());
		model.addAttribute("userv",  user);
		model.addAttribute("list_roles",  rolesService.getAllRoles());
		
		model.addAttribute("page_title", "Add user");
		model.addAttribute("panel_title",  "Add user");
		
		
		if (request_user_id != null) {
			
			int code=Integer.parseInt(request_user_id);
			
			user = usersService.getUsers(code);
			 
			model.addAttribute("userv", user);
			
			model.addAttribute("page_title", "Edit user");
			model.addAttribute("panel_title", "Edit user");
			
		}
		

		return "user/edit";
	
		
    }
	
	
	
	@RequestMapping(value="/save.html", method = RequestMethod.POST)
    public String editUserForm(Model model,
    						  @RequestParam(value="add", required=false) String form_add,
    						  @RequestParam(value="save", required=false) String form_save,
    						  @RequestParam(value="cancel", required=false) String form_cancel,
    						  HttpServletRequest request, HttpServletResponse response,  
    						  @ModelAttribute(value="UserData") Users fuser,
    						  BindingResult result
    						  ) throws ParseException, IOException {
		
		if (result.hasErrors()) {
			
			logger.error("Something happened during getting form attributes... Error: " + result.getAllErrors());
			
		} else {
	
			if (form_cancel == null)
			{
				Users user=new Users();
				user.setName(fuser.getName());
				user.setCode(fuser.getCode());
				user.setPhone(fuser.getPhone());
				user.setBirth(fuser.getBirth());
				user.setLogin(fuser.getLogin());
				user.setPassword(fuser.getPassword());
			
				Roles roles=rolesService.getRoles(Integer.parseInt(request.getParameter("role")));
				user.setRoles(roles);
	    	
				if (form_add != null) {
				
					usersService.saveUsers(user); // for save
					
				} else if (form_save != null) {
				
					usersService.updateUsers(user); // for update
			
				}
				
			}
			

			
	    }
		
		return "redirect:/user/list.html";
		
	}
	
	@RequestMapping(value="/delete.html", method = RequestMethod.GET)
	public String deleteUser(Model model, HttpServletRequest request, HttpServletResponse response,
									 @RequestParam(value="uid", required=false) String request_user_id)
											 throws Exception, ServletException
	{
		
		
		Users user=new Users();
		
		if (request_user_id != null) {
			
			int code=Integer.parseInt(request_user_id);
			
			user = usersService.getUsers(code);

			usersService.deleteUsers(user);
			
		}
	
		return "redirect:/user/list.html";
	}
	
	
}