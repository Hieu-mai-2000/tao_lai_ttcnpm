<?php

$connect = mysqli_connect("localhost","root","","History");
$connect_ = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");


$Time = "SELECT NOW()";
$result = mysqli_query($connect,$Time);
   while ($row = mysqli_fetch_assoc($result)) 
    {
		$Time = $row['NOW()'];    
    }
$Time = substr($Time,0,-3);

$email = $_POST['email'];
$customer = "SELECT id_KH FROM Customer WHERE email ='".$email."' ";

$result = mysqli_query($connect_,$customer);
   while ($row = mysqli_fetch_assoc($result)) 
    {
		$query = "INSERT INTO History_KH VALUES(null,'".$row['id_KH']."','$Time')";        
    }

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}

?>