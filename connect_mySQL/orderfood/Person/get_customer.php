<?php

$connect = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");

$query = "SELECT * FROM Customer WHERE email = '".$username."' 
    and password = '".$password."'";

$data = mysqli_query($connect,$query);

$mangID_KH = array();
while ($row = mysqli_fetch_assoc($data)) {
array_push($mangID_KH,$row['id_KH']);
}
echo json_encode($mangID_KH);
}


// $mangID_KH = array();
// while ($row = mysqli_fetch_assoc($data)) {
// array_push($mangID_KH,$row['id_KH']);
// }
// echo json_encode($mangID_KH);




// class Customer{
//  	function Customer($id_KH,$name,$email,$password,$numberphone){
//  		$this->id_KH 	= $id_KH;
//  		$this->name 	= $name;
//  		$this->email 	= $email;
//  		$this->password = $password;
//  		$this->numberphone = $numberphone;

//  	}
//  }

//  $mangCustomer = array();

// while ($row = mysqli_fetch_assoc($data)) {
// array_push($mangCustomer, new Customer($row['id_KH'],$row['name'],$row['email'],$row['password'],$row['numberphone']));
// }

//  echo json_encode($mangCustomer);

?>