package com.infodesk.InfoDesk_and_Online_Consultancy.user;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
// import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    @Autowired
	private UserRepository userRepo;

    @GetMapping({"/admin/usersList"})
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("list-users");
		mav.addObject("users", userRepo.findAll());
		return mav;
	}

	@GetMapping({"/register"})
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("signup_form");
		User register = new User();
		mav.addObject("user", register);
		return mav;
	}
	

	@GetMapping("/admin/usersList/showUserUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long userId) {
		ModelAndView mav = new ModelAndView("add-user-form");
		User user = userRepo.findById(userId).get();
		mav.addObject("user", user);
		return mav;
	}

	
	// @GetMapping("/admin/usersList/showUserUpdateForm")
	// public ModelAndView showUserUpdateForm(@RequestParam Long userId) {
	// 	ModelAndView mav = new ModelAndView("add-user-form");
	// 	User user = userRepo.findById(userId).get();
	// 	mav.addObject("user", user);
	// 	return mav;
	// }

	@GetMapping("/admin/usersList/deleteUser")
	public String deleteBlog(@RequestParam Long userId) {
		userRepo.deleteById(userId);
		return "redirect:/admin/usersList";
	}

	
    
    @GetMapping("/admin/usersList/addUserForm")
	public ModelAndView addUserForm() {
		ModelAndView mav = new ModelAndView("add-user-form");
		User newUser = new User();
		mav.addObject("user", newUser);
		return mav;
	}

    @PostMapping("/admin/usersList/addUserForm/saveUser")
	public String saveBlog(@ModelAttribute User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
		userRepo.save(user);
		return "redirect:/admin/usersList";
	}


	

    @GetMapping("/admin/deleteUser")
	public String deleteUser(@RequestParam Long userId) {
		userRepo.deleteById(userId);
		return "redirect:/admin/usersList";
	}

	@GetMapping("/reg")
	public String reg(){
		return "register_success";
	}

	@PostMapping("/newRegisteredUser")
	public String saveUsers(@ModelAttribute User userNew, Errors errors) {

		if (errors.hasErrors()){
			return "signup_form";
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(userNew.getPassword());
		userNew.setPassword(encodedPassword);
		userRepo.save(userNew);
		return "redirect:/reg";
	}

	@GetMapping("/practice")
	public String res(){
		return "signup_form";
	}
}
