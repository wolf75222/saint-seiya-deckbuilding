<?php

$DBhost  = "";   // Par exemple
$DBowner = "";  // ton login SQL
$DBpw    = "";  // ton password SQL
$DBName  = $DBowner;

$mysqli = new mysqli($DBhost, $DBowner, $DBpw, $DBName);

if(!$mysqli->query("INSERT INTO `parties`  values ('')")) {
	echo "failed";
}

$mysqli->real_query("SELECT Id FROM `parties` ");
$res = $mysqli->use_result();

while ($row = $res->fetch_assoc()) {
   $last_id = $row['Id'];
}

echo $last_id;
?>