package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/resource")
public class MainController {
	
	@PostMapping
	public User get() {
		return new User("hello","alex");
	}
	
	@GetMapping
	public User gets() {
		return new User("hello","alex");
	}
}
