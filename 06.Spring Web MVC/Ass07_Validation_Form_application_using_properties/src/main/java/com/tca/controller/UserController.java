package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tca.model.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/form")
	public String showForm(Model model)
	{
		User user=new User();	
		model.addAttribute("user", user);
		
		return "UserForm";
	}
	
	@PostMapping("/register")
	public String handleForm(@Valid @ModelAttribute("user") User x,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "UserForm";
		}
		else
		{
			System.out.println("User Details :"+x);
			model.addAttribute("uName",x.getUserName());
			model.addAttribute("uEmail",x.getEmailId());
			model.addAttribute("uPhone",x.getMobileNo());
			model.addAttribute("uGender",x.getGender());
			model.addAttribute("uBirth",x.getBirthDate());
			
			return "UserInformation";
		}
		
		
	}
}
