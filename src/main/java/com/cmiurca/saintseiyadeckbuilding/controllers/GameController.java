package com.cmiurca.saintseiyadeckbuilding.controllers;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Hero;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmiurca.saintseiyadeckbuilding.saintseiya.Game;

import java.util.ArrayList;

/**
 * GameController class
 * 
 * @author LittleBigOwI
 * @version 1.0
 * @since 2023-02-04
 */
@Controller
public class GameController {
	static Game game = new Game();

	@GetMapping(path = "/api/current")
	public String current(Model model) {
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		model.addAttribute("player_name", current_player.getName());
		var hand = current_player.getHand();
		var hand_string = new ArrayList<String>();
		hand.forEach(card -> hand_string.add(card.name));
		model.addAttribute("hand", hand_string);
		model.addAttribute("info", current_player.help(game.getPlayMat()));

		System.out.println(game);

		return "current.html";
	}

	@GetMapping(path = "/api/add_player")
	public String add_player(String player_name, Hero hero) {
		game.addPlayer(new Player(player_name, hero));

		return "nothing";
	}

	@GetMapping(path = "/api/next_player")
	public String next_player(Model model) {
		game.nextPlayer();
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		model.addAttribute("player_name", current_player.getName());
		var hand = current_player.getHand();
		var hand_string = new ArrayList<String>();
		hand.forEach(card -> hand_string.add(card.name));
		model.addAttribute("hand", hand_string);
		model.addAttribute("info", current_player.help(game.getPlayMat()));

		return "current.html";
	}

	@GetMapping(path = "/api/add_card")
	public String add_card(int card_id, Model model) {
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		current_player.addCardToHand(card_id);

		return "current.html";
	}

	@GetMapping(path = "/api/remove_card")
	public String remove_card(int card_id, Model model) {
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		current_player.moveCardFromHandToDiscard(card_id);

		return "current.html";
	}

	@GetMapping(path = "/api/kill_card")
	public String kill_card(int card_id, Model model) {
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		current_player.moveCardFromHandToDestroyedCards(card_id);

		return "current.html";
	}

	@GetMapping(path = "/api/mark_card")
	public String mark_card(int card_id, Model model) {
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		current_player.moveCardFromHandToInjuredCharacters(card_id);

		return "current.html";
	}

	@GetMapping(path = "/api/heal_card")
	public String heal_card(int card_id, Model model) {
		var current_player = game.getPlayer(game.getCurrentPlayerIndex());
		current_player.moveCardFromInjuredCharactersToDiscard(card_id);

		return "current.html";
	}
}