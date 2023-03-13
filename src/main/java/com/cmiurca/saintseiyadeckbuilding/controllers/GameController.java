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
	static Game game = null;
	static String last_info = null;

	/** 
	 * Main webpage, where the user types in basic game info
	 * @param model The type of model the form is compatible with (Game class in this case)
	 * @return String The home webpage (src/main/resources/templates/home.html)
	 */
	//@GetMapping("/")
	//public String forms(Model model) {
	//	model.addAttribute("game", new Game());
	//	return "home.html";
	//}
	
	/** 
	 * The game UI page, where the user gets redirected after inputting basic game info
	 * @param game The previously instanciated game
	 * @param model The type of model the form is compatible with
	 * @return String The game webpage (src/main/resources/templates/game.html)
	 */
	@PostMapping("/game")
	public String gameSubmit(@ModelAttribute Game game, Model model) {
		model.addAttribute("game", game); //Here, the game variable will have all the correct attributes to start
		game.startGame();
		
		return "game.html";
	}

	@GetMapping(path = "/exemple")
	public String exemple(int a, String b) {
		System.out.println(a + b);

		return "nothing";
	}

	@GetMapping(path = "/api/start_game")
	public String start_game(int player_count) {
		game = new Game(player_count);
		game.initPlayers();
		System.out.println(game);
		return "nothing";
	}

	@GetMapping(path = "/api/get_info")
	public String get_info(Model model) {
		var player = game.getPlayer(game.getCurrentPlayerIndex());
		last_info = player.help(game.getPlayMat());
		model.addAttribute("last_info", last_info);

		return "info.html";
	}

}