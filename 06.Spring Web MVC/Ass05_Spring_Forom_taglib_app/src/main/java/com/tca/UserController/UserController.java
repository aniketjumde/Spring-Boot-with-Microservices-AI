package com.tca.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tca.model.User;

@Controller
public class UserController {

	@GetMapping("/form")
	public String showForm(Model model)
	{
		User u=new User();
		u.setUserName("admin");
		u.setEmailId("admin20@gmail.com");
		u.setMobileNo(9988331122L);
		u.setGender("Male");
		model.addAttribute("user", u);	
		
		return "UserForm";
	}
	
	@PostMapping("/register")
	public String handlerForm(@ModelAttribute("user")User x,Model model)
	{
		System.out.println("User Details :"+x);
		model.addAttribute("uName",x.getUserName());
		model.addAttribute("uEmail",x.getEmailId());
		model.addAttribute("uPhone",x.getMobileNo());
		model.addAttribute("uGender",x.getGender());
		
		return "UserInformation";
	}
}
