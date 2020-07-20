<?php

$connect = mysqli_connect("localhost","root","","History");
$connect_ = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");


//////// tu email lay id_KH /////////////////

// $email = $_POST['email'];
// $customer = "SELECT id_KH FROM Customer WHERE email ='".$email."' ";

// $result = mysqli_query($connect_,$customer);
//    while ($row = mysqli_fetch_assoc($result)) 
//     {
// 		$id_KH = $row['id_KH'];    
//     }
//////// tu email lay id_KH /////////////////

$query = "SELECT * FROM History_KH WHERE 1";

$data = mysqli_query($connect,$query);


class Time{
 	function Time($Time){
 		$this->Time 	= $Time;
 	}
 }

 $mangTime = array();

 while ($row = mysqli_fetch_assoc($data)) { 
 array_push($mangTime, new Time($row["Time"]));
}


 echo json_encode($mangTime);


?>