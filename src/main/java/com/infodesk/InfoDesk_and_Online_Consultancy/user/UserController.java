package com.infodesk.InfoDesk_and_Online_Consultancy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    @Autowired
	private UserRepository userRepo;

    @GetMapping({"/usersList"})
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("list-users");
		mav.addObject("users", userRepo.findAll());
		return mav;
	}
    
    @GetMapping("/addUserForm")
	public ModelAndView addUserForm() {
		ModelAndView mav = new ModelAndView("add-user-form");
		User newUser = new User();
		mav.addObject("user", newUser);
		return mav;
	}

    @PostMapping("/saveUser")
	public String saveBlog(@ModelAttribute User user) {
		userRepo.save(user);
		return "redirect:/usersList";
	}
	
	@GetMapping("/showUserUpdateForm")
	public ModelAndView showUserUpdateForm(@RequestParam Long userId) {
		ModelAndView mav = new ModelAndView("add-user-form");
		User user = userRepo.findById(userId).get();
		mav.addObject("user", user);
		return mav;
	}

    @GetMapping("/deleteUser")
	public String deleteUser(@RequestParam Long userId) {
		userRepo.deleteById(userId);
		return "redirect:/usersList";
	}
}
