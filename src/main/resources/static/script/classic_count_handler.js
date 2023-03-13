const MIN_PLAYER_COUNT = 2;
const MAX_PLAYER_COUNT = 5;

var cards;
fetch("saint_seiya_cartes.json")
.then(response => response.json())
.then(json => cards = json);

var players_cards = [[[], []]];

var players_marked_cards = [0];

function id_input(event, force, i) {
	if(force || event.key == 'Enter') {
		const input = document.querySelectorAll('input')[i];

		const result = cards.find(card => card.id == input.value);
		if(result !== undefined) {
			players_cards[players_cards.length - 1][i].push(result);
			document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : <b>" + result.nom + "</b>";
			document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : <b>" + players_cards[players_cards.length - 1][i].length + "</b>";
		}

		input.value = null;
		input.focus();
	}
}

function id_pop(i) {
	if(players_cards[players_cards.length - 1][i].length > 1) {
		players_cards[players_cards.length - 1][i].pop();
		const count = players_cards[players_cards.length - 1][i].length;

		document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : <b>" + players_cards[players_cards.length - 1][i][count -1].nom + "</b>";
		document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : <b>" + count + "</b>";
	}

	else if(players_cards[players_cards.length - 1][i].length > 0) {
		players_cards[players_cards.length - 1][i].pop();

		document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : aucune";
		document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : 0";
	}
}

function marked_cards_input(event, force, i) {
	if(force || event.key == 'Enter') {
		const input = document.querySelectorAll('input')[i];
		
		if(input.value >= 0) {
			players_marked_cards[players_marked_cards.length - 1] = Number(input.value);
			document.getElementById('dead_cards').innerHTML = "Nombre de cartes : " + input.value;
		}

		input.value = null;
	}
}

function next_player() {
	players_cards.push([[], []]);
	players_marked_cards.push(0);

	document.querySelectorAll('.last_card').forEach(p => p.innerHTML = "Dernière carte : aucune");
	document.querySelectorAll('.cards_count').forEach(p => p.innerHTML = "Nombre de cartes : 0");
	document.getElementById('dead_cards').innerHTML = "Nombre de cartes : 0";
	document.getElementsByClassName('player_id')[0].innerHTML = "Vous êtes le joeur " + players_cards.length;

	if(players_cards.length == MIN_PLAYER_COUNT) {
		document.getElementsByClassName('final_count')[0].disabled = false;
	}

	else if(players_cards.length == MAX_PLAYER_COUNT) {
		document.getElementsByClassName('next_player')[0].disabled = true;
	}
}

function final_count() {
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
		points.push(0);

		for (var j = 0; j < player[0].length; j++) {

			const card = player[0][j];

			switch(card.id) {
			case 16:
				points[points.length - 1] += Math.floor(player[0].length / 10);
				break;
			case 42:
				points[points.length - 1] += 3;
				if(Math.max.apply(null, hero) > 0 && indexOfMax(hero) == i) {
					points[points.length - 1]++;
				}
				break;
			case 43:
				points[points.length - 1] += 3;
				if(Math.max.apply(null, chevalier_argent) > 0 && indexOfMax(chevalier_argent) == i) {
					points[points.length - 1]++;
				}
				break;
			case 69:
				if(spica[i] > 0) {
					points[points.length - 1] += 2;
				}
				break;
			case 70:
				if(leda[i] > 0) {
					points[points.length - 1] += 2;
				}
				break;
			case 71:
				points[points.length - 1] += chevalier_noir[i];
				break;
			case 90:
				points[points.length - 1] += Math.floor(player[1].length / 5);
				break;
			case 1014:
				points[points.length - 1] += robe_divine[i] * 2;
				break;
			case 2038:
				points[points.length - 1] += 2 + marina[i];
				break;
			case 2039:
				points[points.length - 1] += 2 + chevalier_bronze[i];
				break;
			case 2040:
				points[points.length - 1] += 2; 
				if(Math.max.apply(null, players_marked_cards) > 0 && indexOfMax(players_marked_cards) == i) {
					points[points.length - 1] += players_cards.length;
				}
				break;
			case 2041:
				points[points.length - 1] += 2 + chevalier_detruit[i];
				break;
			case 2042:
				points[points.length - 1] += 2; 
				if(players_marked_cards[i] >= 5) {
					points[points.length - 1] += 3;
				}
				break;
			case 2043:
				points[points.length - 1] += 2 + armure_rare[i];
				break;
			case 2044:
				points[points.length - 1] += 2 + personnage_tres_rare[i];
				break;
			default:
				if(Number(card.points) !== undefined) {
					points[points.length - 1] += Number(card.points);
				}
				break;
			}
		}

	}
	
	document.querySelectorAll('button').forEach(b => b.disabled = true);
	document.querySelectorAll('input').forEach(i => i.disabled = true);
	const result = document.getElementsByClassName('result')[0];
	result.style.display = 'block';
	var result_table = document.getElementsByClassName('result_table')[0];
	
	for (var i = 0; i < points.length; i++) {
		//sorted_points[i]

		const id = indexOfMax(points);
		const pt = points[id];
		points[id] = -1;

		var tr = document.createElement('tr');

		var td1 = document.createElement('td');
		td1.innerHTML = i + 1;
		tr.appendChild(td1);

		var td2 = document.createElement('td');
		td2.innerHTML  = id + 1;
		tr.appendChild(td2);

		var td3 = document.createElement('td');
		td3.innerHTML = pt;
		tr.appendChild(td3);

		result_table.appendChild(tr);
	}

	window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' })
}

function indexOfMax(arr) {
	if (arr.length === 0) {
		return -1;
	}

	var max = arr[0];
	var maxIndex = 0;

	for (var i = 1; i < arr.length; i++) {
		if (arr[i] > max) {
			maxIndex = i;
			max = arr[i];
		}
	}

	return maxIndex;
}