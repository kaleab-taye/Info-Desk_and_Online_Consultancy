package com.infodesk.InfoDesk_and_Online_Consultancy;

import com.infodesk.InfoDesk_and_Online_Consultancy.blog.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class indexController {

    @Autowired
	private BlogRepository blogsRepo;
   
    @GetMapping({"/"})
	public ModelAndView getAllBlogs() {
		ModelAndView mav = new ModelAndView("index");
        mav.addObject("blogs", blogsRepo.findAll());
		return mav;
	}

	// @GetMapping({"/login"})
	// public ModelAndView login() {
	// 	ModelAndView mav = new ModelAndView("login");
    //     mav.addObject("blogs", blogsRepo.findAll());
	// 	return mav;
	// }
	// @GetMapping({"/login-page"})
	// public ModelAndView login() {
	// 	ModelAndView mav = new ModelAndView("login");
    //     mav.addObject("blogs", blogsRepo.findAll());
	// 	return mav;
	// }
    
}


