package com.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","Spring NG Example");
		return "index";
	}
	
	@RequestMapping("/categoryHome")
	String CategoryHome(ModelMap modal) {
		modal.addAttribute("title","Spring NG Example");
		return "category";
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}

}
