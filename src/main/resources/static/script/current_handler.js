function add_card() {
	const input = document.getElementsByTagName('input')[0];
	get("/api/add_card?card_id=" + input.value);
	window.location.reload();
}

function remove_card() {
	const input = document.getElementsByTagName('input')[1];
	get("/api/remove_card?card_id=" + input.value);
	window.location.reload();
}

function kill_card() {
	const input = document.getElementsByTagName('input')[2];
	get("/api/kill_card?card_id=" + input.value);
	window.location.reload();
}

function mark_card() {
	const input = document.getElementsByTagName('input')[3];
	get("/api/mark_card?card_id=" + input.value);
	window.location.reload();
}

function heal_card() {
	const input = document.getElementsByTagName('input')[4];
	get("/api/heal_card?card_id=" + input.value);
	window.location.reload();
}

function get(url) {
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", url, false); // false for synchronous request
    xmlHttp.send(null);
}