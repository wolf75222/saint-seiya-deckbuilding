function start_game(event, force) {
	if(force || event.key == 'Enter') {
		input = document.getElementById('player_count');

		var xmlHttp = new XMLHttpRequest();
    	xmlHttp.open("GET", "api/start_game?player_count=" + input.value, false); // false for synchronous request
    	xmlHttp.send(null);
	}
}

function get_info() {
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "api/get_info", false); // false for synchronous request
    xmlHttp.send(null);

    draft = document.getElementById('draft');
    draft.innerHTML = xmlHttp.responseText;
}