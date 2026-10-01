package com.tca.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

	@GetMapping("/msg")
	public String getMessage(@RequestParam("un") String user, Model model )   // The Value is Passed throw the URL http://localhost:8085/msg?un=Aniket
	{																			
		
		model.addAttribute("username",user);
		
		return "Display";
	}
}
