package com.uniqur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniqur.entity.Subscribers;
import com.uniqur.entity.User;
import com.uniqur.helper.Message;
import com.uniqur.service.SubscribersService;
import com.uniqur.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private SubscribersService subscribersService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registrationPage(Model model, HttpSession session) {
		Message message = (Message) session.getAttribute("message");
	    if (message != null) {
	        model.addAttribute("message", message);
	        session.removeAttribute("message");
	    }
		return "register";
	}
	
	@PostMapping("/subscribers")
	public String addSubscribers(@RequestParam String email) {
		Subscribers s = new Subscribers();
		s.setEmail(email);
		subscribersService.addSubscribers(s);
		return "index";
	}
	
	@PostMapping("/doRegistration")
	public String addRegistration(@ModelAttribute User user, @RequestParam(value="agreement", defaultValue="false") boolean agreement, Model model, HttpSession session) {
		try {
			if(!agreement) {
				throw new Exception("You have not agreed the term and conditions ");
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			
			this.userService.saveUsers(user);
			
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registerd!!", "alert-success"));
			
			return "redirect:/register";
		}catch(Exception e) {
			
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something Went Wrong!!"+e.getMessage(), "alert-danger"));
			return "redirect:/register";
		
		}
	}
	
}
