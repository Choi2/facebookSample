package com.cafe24.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		return "Welcome Hello Computer";
	}
	
	@RequestMapping(value="/webhook", method=RequestMethod.GET)
	@ResponseBody
	public String webhook(@RequestParam("hub.mode") String mode,
			@RequestParam("hub.challenge") String challenge,
			@RequestParam("hub.verify_token") String verify_token) {
		System.out.println(mode + " " + challenge + " " + verify_token);
		return challenge;
	}
	
	@RequestMapping(value="/webhook", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject webhook2(JSONObject data) {
		System.out.println("Test = " + data);
		return data;
	}
	
	
}
