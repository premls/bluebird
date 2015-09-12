package com.bluebird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@RequestMapping( value = "/static/{page}")
	public String staticPages(@PathVariable("page") String page) {
		// TODO : Use thymeleaf templating
		return page;
	}
	
	@RequestMapping( value = "/api")
	public String restApi() {
		return "restApi";
	}
}
