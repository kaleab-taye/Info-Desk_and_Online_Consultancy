package com.infodesk.InfoDesk_and_Online_Consultancy.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AdminController {
    

    @GetMapping({"/admin-login"})
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("admin-login");
		return mav;
	}
}
