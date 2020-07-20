<?php


require "connect.php";

$query = "SELECT * FROM studentt";

// $hoten = $_POST['hotenSV'];
// $namsinh = $_POST['namsinhSV'];
// $diachi = $_POST['diachiSV'];

$hoten = "mai nguyen minh hieu";
$namsinh = "123";
$diachi = "kdjfk";

$query = "INSERT INTO studentt VALUES(null, '$hoten','$namsinh','$diachi')";

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}


?>