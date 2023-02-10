package com.cmiurca.saintseiyadeckbuilding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* Main application class
* 
* @author LittleBigOwI
* @version 1.1
* @since 2023-02-04
*/
@SpringBootApplication
public class App {

	/** 
	 * Web start point, also the main application start point
	 * @param args command line args (irrelevant)
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}