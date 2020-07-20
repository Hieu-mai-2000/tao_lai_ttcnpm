<?php

$connect = mysqli_connect("localhost","root","","quay_hang");
mysqli_query($connect,"SET NAMES 'utf8'");

$id = $_POST['idQH'];
$TenQH = $_POST['TenQH'];
$LinkImage = $_POST['LinkImage'];


$query = "UPDATE QuayHang SET name = '$TenQH', image = '$LinkImage' WHERE id = '$id'";

if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "fail";
}

?>