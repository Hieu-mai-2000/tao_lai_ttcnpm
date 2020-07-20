<?php

$connect = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");

$query = "SELECT * FROM customer";

$data = mysqli_query($connect,$query);


class infor{
 	function infor($email, $password){
 		$this->email = $email;
 		$this->password = $password;
 	
 	}
 }

 $mangSV = array();

 while ($row = mysqli_fetch_assoc($data)) {


array_push($mangSV, new infor($row["email"],$row['password']));

 
}


 echo json_encode($mangSV);

?>