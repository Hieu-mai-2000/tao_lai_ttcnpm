<?php

require "connect.php";

$id = $_POST['idSV'];
$hoten = $_POST['hotenSV'];
$namsinh = $_POST['namsinhSV'];
$diachi = $_POST['diachiSV'];



$query = "UPDATE studentt SET hoten = '$hoten', namsinh = '$namsinh',diachi =
'$diachi' WHERE id = '$id'";

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}

?>