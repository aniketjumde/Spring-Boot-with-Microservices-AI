package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

	@GetMapping("/msg")
	public String show(@RequestParam("user") String user,Model model)
	{
		
		model.addAttribute("userName", user);
		
		return "Dispaly";
	}
}
