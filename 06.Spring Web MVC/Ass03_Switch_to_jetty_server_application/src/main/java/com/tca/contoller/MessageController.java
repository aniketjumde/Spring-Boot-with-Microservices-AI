package com.tca.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

	@GetMapping("/msg")
	public String getMessage()
	{
		return "Dispaly";
	}
}
