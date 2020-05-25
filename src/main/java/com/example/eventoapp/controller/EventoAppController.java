package com.example.eventoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventoAppController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
