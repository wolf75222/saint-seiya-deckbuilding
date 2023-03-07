function exemple() {
	const input_a = document.getElementById('a');
	const input_b = document.getElementById('b');

	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "/exemple?a=" + input_a.value + "&b=" + input_b.value, false); // false for synchronous request
    xmlHttp.send(null);

    console.log(xmlHttp.responseText);
}