package com.infodesk.InfoDesk_and_Online_Consultancy.blog;


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
	
	@GetMapping({"/list", "/"})
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
	
	@PostMapping("/saveBlog")
	public String saveBlog(@ModelAttribute Blog blog) {
		blogRepo.save(blog);
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long BlogId) {
		ModelAndView mav = new ModelAndView("add-Blog-form");
		Blog Blog = blogRepo.findById(BlogId).get();
		mav.addObject("Blog", Blog);
		return mav;
	}
	
	@GetMapping("/deleteBlog")
	public String deleteBlog(@RequestParam Long blogId) {
		blogRepo.deleteById(blogId);
		return "redirect:/list";
	}
}


