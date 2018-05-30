package com.avaya.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avaya.shopping_backend.dao.CategoryDAO;
import com.avaya.shopping_backend.dto.Category;


//Ctrl+Shift+O to import all the packages
@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title" ,"Home");
	
		//passing list
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome" ,true);		
		return mv;
	}
	
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title" ,"About Us");
		mv.addObject("userClickAbout" ,true);
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title" ,"Contact Us");
		mv.addObject("userClickContact" ,true);
		return mv;
	}
	
// To get parameter from the query string 	
/*	@RequestMapping(value={"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting) {
		if(greeting == null){
			greeting ="Hello";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
		
	}*/
	
	//@path varaible to make query string part of path
	@RequestMapping(value={"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting")String greeting) {
		if(greeting == null){
			greeting ="Hello";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
		
	}
	
	/*Method to load all the products*/
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
		
	}
	
	
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("page");
		//Category DAO to fetch single category
		
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName() );
		//passing a list of category
		mv.addObject("categories",categoryDAO.list());
		
		//passing a single category object
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
		
	}
	
	
	
	
	
	
	
	
}
