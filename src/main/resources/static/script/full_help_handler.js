function add_player() {
	inputs = document.getElementsByTagName('input');
	input = inputs[inputs.length - 1];

	selects = document.getElementsByTagName('select');
	select = selects[selects.length - 1];

	if(inputs.length < 5) {
		name_input = document.getElementsByClassName('name_input')[0];
		name_input.appendChild(document.createElement('input'));
		name_input.appendChild(select.cloneNode(true));
	}

	input.disabled = true;
	select.disabled = true;

	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "api/add_player?player_name=" + input.value + "&hero=" + select.value, false); // false for synchronous request
    xmlHttp.send(null);
}