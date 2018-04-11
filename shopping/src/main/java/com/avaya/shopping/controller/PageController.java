package com.avaya.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//Ctrl+Shift+O to import all the packages
@Controller
public class PageController {
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting" ,"Welcome to spring mvc");
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
	
	
}
