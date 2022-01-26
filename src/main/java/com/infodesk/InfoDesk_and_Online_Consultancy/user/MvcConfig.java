package com.infodesk.InfoDesk_and_Online_Consultancy.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;





// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;



@Configuration
@Controller
public class MvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/").setViewName("index");
        registry.addViewController("/list").setViewName("list-blogs");
        registry.addViewController("/admin").setViewName("admin-page");
        // registry.addViewController("/shipper_home").setViewName("shipper_home");
    }
 

    @Autowired
	private UserRepository userRepo;

	// @PostMapping("/newRegisteredUser")
	// public String checkPersonInfo(@Valid User user, BindingResult bindingResult) {

	// 	if (bindingResult.hasErrors()) {
	// 		return "signup_form";
	// 	}

	// 	return "redirect:/newRegisteredUserL";
	// }


	@GetMapping("/register_success")
	public ModelAndView registerSuccess() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
    
}
