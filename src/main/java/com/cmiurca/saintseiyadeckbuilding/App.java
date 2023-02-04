package com.cmiurca.saintseiyadeckbuilding;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Main application class
* 
* @author LittleBigOwI
* @version 1.0
* @since 2023-02-04
*/

@SpringBootApplication
@RestController
public class App {

	
	/** 
	 * Application start point
	 * @param args command line args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	
	/** 
	 * Demo home page, returns a blank page with Hello World on it
	 * (localhost:8080/)
	 * @return String
	 */
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}

	
	/** 
	 * Demo for JSON data
	 * (localhost:8080/j/)
	 * @return List<String>
	 */
	@GetMapping("/j/")
	public List<String> helloWorldList() {
		return List.of("Hello", "World");
	}

}
