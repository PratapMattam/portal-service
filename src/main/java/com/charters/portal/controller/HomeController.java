package com.charters.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value ="/")
	public static String home() {
		return "Welcome to reward calculation app";
	}
}

