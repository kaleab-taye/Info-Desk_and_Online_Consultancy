package com.infodesk.InfoDesk_and_Online_Consultancy.blog;

// import com.infodesk.InfoDesk_and_Online_Consultancy.user.UserDetailsServiceImpl;


// import com.infodesk.InfoDesk_and_Online_Consultancy.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class BlogController {
    



	
	@Autowired
	private BlogRepository blogRepo;
	
	@GetMapping({"/list"})
	public ModelAndView getAllBlogs() {
		ModelAndView mav = new ModelAndView("list-blogs");
		mav.addObject("blogs", blogRepo.findAll());
		return mav;
	}
	
	@GetMapping("/addBlogForm")
	public ModelAndView addBlogForm() {
		ModelAndView mav = new ModelAndView("add-blog-form");
		Blog newBlog = new Blog();
		mav.addObject("blog", newBlog);
		return mav;
	}

	@GetMapping({"/admin/blogs-list"})
	public ModelAndView getAdminBlogs() {
		ModelAndView mav = new ModelAndView("admin-blogs");
		mav.addObject("blogs", blogRepo.findAll());
		return mav;
	}

	

	// @GetMapping("/myblogs")
	// public ModelAndView myblogs() {
	// 	ModelAndView mav = new ModelAndView("myblogs");
	// 	Blog newBlog = blogRepo.findAllById(currentUser).get();
	// 	mav.addObject("blog", newBlog);
	// 	return mav;
	// }
	
	@PostMapping("/saveBlog")
	public String saveBlog(@ModelAttribute Blog blog) {
		blogRepo.save(blog);
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long blogId) {
		ModelAndView mav = new ModelAndView("add-blog-form");
		Blog blog = blogRepo.findById(blogId).get();
		mav.addObject("blog", blog);
		return mav;
	}

	// @GetMapping({"/listMyBlogs"})
	// public ModelAndView getMyBlogs(@RequestParam String blogger) {
	// 	ModelAndView mav = new ModelAndView("list-blogs");
	// 	Blog blog = blogRepo.findAllByBlogger(blogger).get();
	// 	mav.addObject("blog", blog);
	// 	return mav;
	// }
	
	@GetMapping("/deleteBlog")
	public String deleteBlog(@RequestParam Long blogId) {
		blogRepo.deleteById(blogId);
		return "redirect:/list";
	}
}


