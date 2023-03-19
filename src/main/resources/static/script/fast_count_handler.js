var cards;
fetch("saint_seiya_cartes.json")
	.then(response => response.json())
	.then(json => cards = json);

var crt_player_cards = [[], []];
var crt_marked_cards = 0;
var crt_player_name = "";

var game_id = 0;

var players_cards = [];
var players_marked_cards = [];
var players_names = [];

function new_game() {
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "register.php", false ); // false for synchronous request
    xmlHttp.send(null);

    if(xmlHttp.responseText == "failed") {
    	alert("Something went wrong, try later.");
    } else {
    	partie = Number(xmlHttp.responseText);

    	game_id_p = document.getElementById('game_id');
    	game_id_p.innerHTML = "Identifiant de la partie : " + xmlHttp.responseText;

    	game_id = Number(xmlHttp.responseText);

    	document.querySelectorAll('button').forEach(b => b.disabled = false);
		document.querySelectorAll('input').forEach(i => i.disabled = false);

		new_game = document.getElementById('new_game');
    	new_game.disabled = true;
    }
}

function set_player_name() {
	crt_player_name_input = document.getElementById('player_name');
	crt_player_name = crt_player_name_input.value;
	crt_player_name_input.disabled = true;
}

function id_input(event, force, i) {
	if(force || event.key == 'Enter') {
		const input = document.getElementsByClassName('cards_input')[i];

		const result = cards.find(card => card.id == input.value);
		if(result !== undefined) {
			crt_player_cards[i].push(result);
			document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : <b>" + result.nom + "</b>";
			document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : <b>" + crt_player_cards[i].length + "</b>";
		}

		input.value = null;
		input.focus();
	}
}

function id_pop(i) {
	if(crt_player_cards[i].length > 1) {
		crt_player_cards[i].pop();
		const count = crt_player_cards[i].length;

		document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : <b>" + crt_player_cards[i][count -1].nom + "</b>";
		document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : <b>" + count + "</b>";
	}

	else if(crt_player_cards[i].length > 0) {
		crt_player_cards[i].pop();

		document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : aucune";
		document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : 0";
	}
}

function marked_cards_input(event, force, i) {
	if(force || event.key == 'Enter') {
		const input = document.getElementById('marked_cards_input');
		
		if(input.value >= 0) {
			crt_marked_cards = Number(input.value);
			document.getElementById('marked_cards').innerHTML = "Nombre de cartes : <b>" + input.value + "</b>";
		}

		input.value = null;
	}
}

function upload_cards() {
	var hand_cards = "";
	var marked_cards = "";

	crt_player_cards[0].forEach(card => hand_cards += card.id + ",");
	crt_player_cards[1].forEach(card => marked_cards += card.id + ",");

	const url = "upload.php?partie=" + game_id + "&nom=" + crt_player_name + "&main=" + hand_cards + "&marque=" + marked_cards + "&detruit=" + crt_marked_cards;

	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url, false ); // false for synchronous request
    xmlHttp.send(null);

	if(xmlHttp.responseText == "failed") {
    	alert("Something went wrong, try later.");
    } else {
    	document.getElementById('cards_validation').disabled = true;
    }
}

function set_game_id() {
	const input = document.getElementById('client_game_id_input');
	input.disabled = true;
	game_id = Number(input.value);
}

function result() {
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "result.php?id=" + game_id, false ); // false for synchronous request
    xmlHttp.send(null);

	if(xmlHttp.responseText == "failed") {
    	alert("Something went wrong, try later.");
    } else {
    	const data = xmlHttp.responseText;
    	const players = data.split('/');

    	for (var i = 0; i < players.length - 1; i++) {
    		player_data = players[i].split(';');

    		var hand = [];
    		var marked = [];

    		player_data[1].split(',').forEach(id => hand.push(cards.find(card => card.id === Number(id))));
    		player_data[2].split(',').forEach(id => marked.push(cards.find(card => card.id === Number(id))));
    		hand.pop();
    		marked.pop();

    		players_cards.push([hand, marked, player_data[0]]);
    		players_marked_cards.push(Number(player_data[3]));
    	}

		var points = [];

		var hero = [];
		var chevalier_argent = [];
		var spica = [];
		var leda = [];
		var chevalier_noir = [];
		var robe_divine = [];
		var marina = [];
		var chevalier_bronze = [];
		var armure_rare = [];
		var personnage_tres_rare = [];

		var chevalier_detruit = [];

		for (var i = 0; i < players_cards.length; i++) {
			console.log(players_cards[i][0]);
			hero.push(players_cards[i][0].filter(card => card.classe.includes("Héros")).length);
			chevalier_argent.push(players_cards[i][0].filter(card => card.classe.includes("Chevalier d'Argent")).length);
			spica.push(players_cards[i][0].filter(card => card.nom.includes("Spica")).length);
			leda.push(players_cards[i][0].filter(card => card.nom.includes("Léda")).length);
			chevalier_noir.push(new Set(players_cards[i][0].filter(card => card.classe.includes("Chevalier Noir"))).size);
			robe_divine.push(players_cards[i][0].filter(card => card.nom.includes("Robe Divine")).length);
			marina.push(players_cards[i][0].filter(card => card.classe.includes("Marina")).length);
			chevalier_bronze.push(new Set(players_cards[i][0].filter(card => card.classe.includes("Chevalier de Bronze"))).size);
			armure_rare.push(players_cards[i][0].filter(card => card.classe.includes("Armure") && card.rang.includes("Rare")).length);
			personnage_tres_rare.push(players_cards[i][0].filter(card => card.rang.includes("Très Rare") && card.classe == "").length);

			chevalier_detruit.push(players_cards[i][1].filter(card => card.classe.includes("Chevalier")).length);
		}

		for (var i = 0; i < players_cards.length; i++) {
			
			const player = players_cards[i];
			var point = 0;

			for (var j = 0; j < player[0].length; j++) {

				const card = player[0][j];

				switch(card.id) {
				case 16:
					point += Math.floor(player[0].length / 10);
					break;
				case 42:
					point += 3;
					if(Math.max.apply(null, hero) > 0 && indexOfMax(hero) == i) {
						point++;
					}
					break;
				case 43:
					point += 3;
					if(Math.max.apply(null, chevalier_argent) > 0 && indexOfMax(chevalier_argent) == i) {
						point++;
					}
					break;
				case 69:
					if(spica[i] > 0) {
						point += 2;
					}
					break;
				case 70:
					if(leda[i] > 0) {
						point += 2;
					}
					break;
				case 71:
					point += chevalier_noir[i];
					break;
				case 90:
					point += Math.floor(player[1].length / 5);
					break;
				case 1014:
					point += robe_divine[i] * 2;
					break;
				case 2038:
					point += 2 + marina[i];
					break;
				case 2039:
					point += 2 + chevalier_bronze[i];
					break;
				case 2040:
					point += 2; 
					if(Math.max.apply(null, players_marked_cards) > 0 && indexOfMax(players_marked_cards) == i) {
						point += players_cards.length;
					}
					break;
				case 2041:
					point += 2 + chevalier_detruit[i];
					break;
				case 2042:
					point += 2; 
					if(players_marked_cards[i] >= 5) {
						point += 3;
					}
					break;
				case 2043:
					point += 2 + armure_rare[i];
					break;
				case 2044:
					point += 2 + personnage_tres_rare[i];
					break;
				default:
					if(Number(card.points) !== undefined) {
						point += Number(card.points);
					}
					break;
				}
			}
			points.push([point, player[2]]);
		}

	document.querySelectorAll('button').forEach(b => b.disabled = true);
	document.querySelectorAll('input').forEach(i => i.disabled = true);

	const result = document.getElementsByClassName('result')[0];
	result.style.display = 'block';
	var result_table = document.getElementsByClassName('result_table')[0];
	
	for (var i = 0; i < points.length; i++) {
		//sorted_points[i]

		const id = indexOfMax(points);
		const pt = points[id][0];
		points[id][0] = -1;

		var tr = document.createElement('tr');

		var td1 = document.createElement('td');
		td1.innerHTML = points[id][1];
		tr.appendChild(td1);

		var td2 = document.createElement('td');
		td2.innerHTML  = pt;
		tr.appendChild(td2);

		result_table.appendChild(tr);
	}

	window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });
	}
}

function indexOfMax(arr) {
	if (arr.length === 0) {
		return -1;
	}

	var max = arr[0][0];
	var maxIndex = 0;

	for (var i = 1; i < arr.length; i++) {
		if (arr[i][0] > max) {
			maxIndex = i;
			max = arr[i][0];
		}
	}

	return maxIndex;
}