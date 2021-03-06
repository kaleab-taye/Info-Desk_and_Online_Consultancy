package com.infodesk.InfoDesk_and_Online_Consultancy.blog;

// import com.infodesk.InfoDesk_and_Online_Consultancy.user.UserDetailsServiceImpl;


// import com.infodesk.InfoDesk_and_Online_Consultancy.user.User;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
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

	@GetMapping("/adminView")
	public String getAdminPage() {
		return "admin-page";
	
	}
	
	
	@GetMapping("/addBlogForm")
	public ModelAndView addBlogForm() {
		ModelAndView mav = new ModelAndView("add-blog-form");
		Blog newBlog = new Blog();
		mav.addObject("blog", newBlog);
		return mav;
	}

	@GetMapping("/adminView/addBlogForm")
	public ModelAndView adminAddBlogForm() {
		ModelAndView mav = new ModelAndView("admin-add-blog-form");
		Blog newBlog = new Blog();
		mav.addObject("blog", newBlog);
		return mav;
	}

	@GetMapping({"/adminView/blogs-list"})
	public ModelAndView getAdminBlogs() {
		ModelAndView mav = new ModelAndView("admin-blogs");
		mav.addObject("blogs", blogRepo.findAll());
		return mav;
	}


	
	@PostMapping("/saveBlog")
	public String saveBlog(@ModelAttribute Blog blog) {
		blogRepo.save(blog);
		return "redirect:/list";
	}

	@PostMapping("/adminView/saveBlog")
	public String adminsaveBlog(@ModelAttribute Blog blog) {
		blogRepo.save(blog);
		return "redirect:/adminView/blogs-list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long blogId) {
		ModelAndView mav = new ModelAndView("add-blog-form");
		Blog blog = blogRepo.findById(blogId).get();
		mav.addObject("blog", blog);
		return mav;
	}

	

	// Authentication auth = SecurityContextHolder.getContext().getAuthentication();


	@GetMapping("/adminView/showUpdateForm")
	public ModelAndView adminShowUpdateForm(@RequestParam Long blogId) {
		ModelAndView mav = new ModelAndView("admin-add-blog-form");
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
	@GetMapping("/adminView/deleteBlog")
	public String adminDeleteBlog(@RequestParam Long blogId) {
		blogRepo.deleteById(blogId);
		return "redirect:/adminView/blogs-list";
	}
}


