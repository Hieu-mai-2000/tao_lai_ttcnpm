<?php


$connect = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");

$query = "SELECT * FROM customer";

// $hoten = $_POST['hotenSV'];
// $namsinh = $_POST['namsinhSV'];
// $diachi = $_POST['diachiSV'];

$hoten = "khach hang";
$email = "123@gmail.com";
$password = "matkhau";
$numberphone="1234567222"

$query = "INSERT INTO customer VALUES(null, '$hoten','$email','$password','$numberphone')";

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}


?>