<?php

require "connect.php";

$idsv = $_POST['idSV'];

$query = "DELETE FROM studentt WHERE id = '$idsv'";

if(mysqli_query($connect,$query)){
	//thanh cong
	echo "success";
}else{
	echo "fail";
}

?>