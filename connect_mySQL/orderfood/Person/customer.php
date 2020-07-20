<?php


$connect = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");

$query = "SELECT * FROM Customer";

$name  = $_POST['name'];
$email  = $_POST['email'];
$password  = $_POST['password'];
$numberphone  = $_POST['numberphone'];

// $name = "khach hang";
// $email = "123@gmail.com";
// $password = "matkhau";
// $numberphone="1234567222";

$query = "INSERT INTO Customer VALUES(null,'$name','$email','$password','$numberphone')";

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}

?>