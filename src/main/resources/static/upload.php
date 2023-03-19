<?php

$DBhost  = "";   // Par exemple
$DBowner = "";  // ton login SQL
$DBpw    = "";  // ton password SQL
$DBName  = $DBowner;

$mysqli = new mysqli($DBhost, $DBowner, $DBpw, $DBName);

$p = $_GET['partie'];
$n = $_GET['nom'];
$m = $_GET['main'];
$ma = $_GET['marque'];
$d = $_GET['detruit'];

if(!$mysqli->query("INSERT INTO `joueur` values ('$p', '$n', '$m', '$ma', '$d')")) {
	echo "failed";
}

echo "succed";
?>