<?php

$DBhost  = "";   // Par exemple
$DBowner = "";  // ton login SQL
$DBpw    = "";  // ton password SQL
$DBName  = $DBowner;

$mysqli = new mysqli($DBhost, $DBowner, $DBpw, $DBName);

$id = $_GET['id'];

if(!$mysqli->real_query("SELECT nom, main, marque, detruit FROM `joueur` WHERE partie='$id'")) {
	echo "failed";
}
$res = $mysqli->use_result();

$result = "";

while ($row = $res->fetch_assoc()) {
   $nom = $row['nom'];
   $main = $row['main'];
   $marque = $row['marque'];
   $detruit = $row['detruit'];

   $result = $result . "$nom; $main; $marque; $detruit; /";
}

echo $result;

?>