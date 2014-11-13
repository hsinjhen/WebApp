package com.sprhib.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sprhib.model.Role;
import com.sprhib.model.User;
import com.sprhib.model.UserRole;
import com.sprhib.service.RoleService;
import com.sprhib.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/list")
	public ModelAndView listOfUsers(@ModelAttribute("message") String message) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		List<User> users = new ArrayList<User>();
		users = userService.getUsers();
		modelAndView.addObject("users", users);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUserPage(@ModelAttribute("message") String message) {
		LinkedHashMap<Integer, String> userRoles = new LinkedHashMap<Integer, String>();
		List<Role> roles = roleService.getRoles();
		for (Role role : roles) {
			userRoles.put(role.getId(), role.getRole());
		}
		ModelAndView modelAndView = new ModelAndView("add-user-form");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("userRoles", userRoles);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		String message = "";
		String username = user.getLogin();
		String password = user.getPassword();
		Integer roleParam = user.getRole();
		if (username.isEmpty() || username.equals("")) {
			message = "Username must not be empty.";
			return addUserPage(message);
		} else if (password.isEmpty() || password.equals("")) {
			message = "Password must not be empty.";
			return addUserPage(message);
		} else if (roleParam == 0 || roleParam.equals("")) {
			message = "Role must not be empty.";
			return addUserPage(message);
		} else if (!username.isEmpty() || !password.isEmpty() || roleParam != 0) {
			Integer roleId = user.getRole();
			Role role = new Role();
			role.setId(roleId);
			UserRole userRole = new UserRole();
			userRole.setUserId(user);
			userRole.setRoleId(role);
			userService.addUser(user);
			userService.setUserRole(userRole);
			message = "User Successfully Added!";
			return listOfUsers(message);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer id) {
		LinkedHashMap<Integer, String> userRoles = new LinkedHashMap<Integer, String>();
		List<Role> roles = roleService.getRoles();
		for (Role role : roles) {
			userRoles.put(role.getId(), role.getRole());
		}
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.searchById(id);
		modelAndView.addObject("user", user);
		modelAndView.addObject("userRoles", userRoles);
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editUser(@ModelAttribute User user,
			@PathVariable Integer id, RedirectAttributes redirectAttrs) {
		String message = "";
		Integer newRole = user.getRole();
		Role role = new Role();
		role.setId(newRole);
		UserRole userRole = new UserRole();
		userRole.setUserId(user);
		userRole.setRoleId(role);
		userService.updateUserRole(userRole);
		userService.updateUser(user);
		message = "User successfully edited!";
		redirectAttrs.addFlashAttribute("message", message);
		System.out.println("NEW ROLE ::::::::::::::" + newRole);
		return "redirect:/user/list";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchUser(@RequestParam("criteria") String criteria,
			@RequestParam("parameter") String parameter) {
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = new ArrayList<User>();
		User user = new User();
		String message = "";
		if (criteria.equals("username") && !criteria.isEmpty()) {
			users = userService.searchByUsername(parameter);
		} else if (criteria.equals("id") && !criteria.isEmpty()) {
			try {
				user = userService.searchById(Integer.valueOf(parameter));
				users.add(user);
			} catch (NumberFormatException e) {
				message = "Id must be Integer";
				return listOfUsers(message);
			}
		} else if (parameter.isEmpty() || parameter.equals("")) {
			message = "Input search parameters";
			return listOfUsers(message);
		}
		if (users.isEmpty() || users.size() == 0 || user == null) {
			message = "No Results";
			return listOfUsers(message);
		}
		modelAndView.setViewName("list-of-users");
		modelAndView.addObject("users", users);
		modelAndView.addObject(message, message);
		return modelAndView;
	}
}
