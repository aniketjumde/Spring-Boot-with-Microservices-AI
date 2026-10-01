package com.tca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

	@GetMapping(value="/msg")
	public String getMessage()
	{
		
		return "Hello";  //  		prefix + logical-name + suffix
						// 			/WEB-INF/ Hello.jsp
		
		//return "display";
	}
}
