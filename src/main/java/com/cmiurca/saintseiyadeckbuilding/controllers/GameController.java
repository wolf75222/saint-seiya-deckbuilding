package com.cmiurca.saintseiyadeckbuilding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Game;

/**
 * GameController class
 * 
 * @author LittleBigOwI
 * @version 1.0
 * @since 2023-02-04
 */

@Controller
public class GameController {

	/** 
	 * Main webpage, where the user types in basic game info
	 * @param model The type of model the form is compatible with (Game class in this case)
	 * @return String The home webpage (src/main/resources/templates/home.html)
	 */
	@GetMapping("/")
	public String forms(Model model) {
		model.addAttribute("game", new Game());
		return "home.html";
	}
	
	/** 
	 * The game UI page, where the user gets redirected after inputting basic game info
	 * @param game The previously instanciated game
	 * @param model The type of model the form is compatible with
	 * @return String The game webpage (src/main/resources/templates/game.html)
	 */
	@PostMapping("/game")
	public String gameSubmit(@ModelAttribute Game game, Model model) {
		model.addAttribute("game", game); //Here, the game variable will have all the correct attributes to start
		game.start();
		
		return "game.html";
	}

}