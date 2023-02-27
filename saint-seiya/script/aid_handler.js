var cards;
fetch("saint_seiya_cartes.json")
.then(response => response.json())
.then(json => cards = json);

var players_cards = [[]];

function id_input(event, force, i) {
	if(force || event.key == 'Enter') {
		const input = document.querySelectorAll('input')[i];

		const result = cards.find(card => card.id == input.value);
		if(result !== undefined) {
			players_cards[i].push(result);
			document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : <b>" + result.nom + "</b>";
			document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : <b>" + players_cards[i].length + "</b>";
		}

		input.value = null;
		input.focus();
	}
}

function id_pop(i) {
	if(players_cards[i].length > 1) {
		players_cards[i].pop();
		const count = players_cards[i].length;

		document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : <b>" + players_cards[i][count -1].nom + "</b>";
		document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : <b>" + count + "</b>";
	}

	else if(players_cards[i].length > 0) {
		players_cards[i].pop();

		document.getElementsByClassName('last_card')[i].innerHTML = "Dernière carte : aucune";
		document.getElementsByClassName('cards_count')[i].innerHTML = "Nombre de cartes : 0";
	}
}

function summary() {
	const result = document.getElementsByClassName('result')[0];
	result.style.display = 'block';

	const strength = document.getElementsByClassName('strength')[0];
	const cosmos = document.getElementsByClassName('cosmos')[0];
	const heal = document.getElementsByClassName('heal')[0];
	const effects = document.getElementsByClassName('effects')[0];

	var tmp_strength = 0;
	var tmp_cosmos = 0;
	var tmp_heal = 0;
	var tmp_effects = [];
	var a = [];

	players_cards[0].map(function add(card) {
		tmp_strength += Number(card.force);
		tmp_cosmos += Number(card.cosmos);
		tmp_heal += Number(card.vie);
		tmp_effects.push(String(card.effets.split("\n")));
		a.push([card.nom, card.effets.split("\n").filter(effect => !effect.includes("Mise en jeu")).map(effect => effect.replace("Défausser -", "<b>Défausser -</b>").replace("Vaincu -", "<b>Vaincu -</b>").replace("Marqué -", "<b>Marqué -</b>").replace("Détruire -", "<b>Détruire -</b>").replace("Geler -", "<b>Geler -</b>").replace("Sortie -", "<b>Sortie -</b>").replace("Fin d'épopée -", "<b>Fin d'épopée -</b>").replace("Fin de partie -", "<b>Fin de partie -</b>").replace("Blesser -", "<b>Blesser -</b>").replace("Arrivée -", "<b>Arrivée -</b>"))]);
	});
	a = a.filter(b => b[1].length > 0);

	strength.innerHTML = "Force : <b>" + tmp_strength + "</b>";
	cosmos.innerHTML = "Cosmos : <b>" + tmp_cosmos + "</b>";
	heal.innerHTML = "Soin : <b>" + tmp_heal + "</b>";

	for (var i = 0; i < a.length; i++) {
		var li = document.createElement('li');
		var h3 = document.createElement('h4');
		var p = document.createElement('p');
		p.className = "effects_desc";

		h3.innerHTML = a[i][0] + " : ";
		for (var j = 0; j < a[i][1].length; j++) {
			if(j > 0) {
				p.innerHTML += "<br>";
			}
			p.innerHTML += a[i][1][j] + "<br>";
 		}

 		li.appendChild(h3);
 		li.appendChild(p);

 		effects.appendChild(li);
	}

	window.scrollTo({
  		top: result.offsetTop,
  		left: 0,
  		behavior: "smooth",
	});
}