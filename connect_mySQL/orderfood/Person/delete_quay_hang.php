<?php

$connect = mysqli_connect("localhost","root","","quay_hang");
mysqli_query($connect,"SET NAMES 'utf8'");

$idQH = $_POST['idQH'];

$query = "DELETE FROM QuayHang WHERE id = '$idQH'";

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}

?>