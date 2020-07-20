<?php

$username = filter_input(INPUT_POST,"username");
$password = filter_input(INPUT_POST,"password");

$mysqli = new mysqli("localhost","root","","Person");

$result = mysqli_query($mysqli,"SELECT * FROM Customer WHERE email = '".$username."' 
    and password = '".$password."'");

if($data = mysqli_fetch_array($result)){
    echo "1";
}

 ?>