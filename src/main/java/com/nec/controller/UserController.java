package com.nec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nec.entity.User;
import com.nec.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("users",userservice.getAll());
		return "index";
	}
	
	@GetMapping("/add_user")
	public String addUserForm(Model model) {
		User u =new User();
		model.addAttribute("user", u);
		return "add_user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userservice.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/updateUserForm/{id}")
	public String showFormUpdate(@PathVariable Long id, Model model) {
	    Optional<User> user = userservice.getUserByid(id);
	    model.addAttribute("updateUser", user);
	    return "updateUserForm"; // must match updateUser.html
	}

	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("updateUser") User user) {
	    userservice.saveUser(user);
	    return "redirect:/";
	}


	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		userservice.deleteByid(id);
		return "redirect:/";
	}
	
	
	
	
	
}