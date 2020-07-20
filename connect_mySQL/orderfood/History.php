<?php


$connect = mysqli_connect("localhost","root","","History");
$connect_ = mysqli_connect("localhost","root","","Person");
mysqli_query($connect,"SET NAMES 'utf8'");

/////////lay thong tin duoc truyen tu android////////
$email = $_POST['email'];
$image 			= $_POST['image'];
$nameFood  		= $_POST['nameFood'];
$note  			= $_POST['note'];
$numberOrder  	= $_POST['numberOrder'];
$Raise  		= $_POST['Raise'];




$Time = "SELECT NOW()";
$result = mysqli_query($connect,$Time);
   while ($row = mysqli_fetch_assoc($result)) 
    {
		$Time = $row['NOW()'];    
    }
$Time = substr($Time,0,-3);
// //////lay id_KH va Ma_Food from bang History_KH///////////
$customer = "SELECT id_KH FROM Customer WHERE email ='".$email."' ";

$result = mysqli_query($connect_,$customer);
   while ($row = mysqli_fetch_assoc($result)) 
    {
		$id_KH = $row['id_KH'];    
    }

$Ma_Food = "SELECT MAX(Ma_Food) AS Ma_Food FROM History_KH WHERE id_KH ='".$id_KH."' ";

$result = mysqli_query($connect,$Ma_Food);
   while ($row = mysqli_fetch_assoc($result)) 
    {  
		$Ma_Food = $row['Ma_Food'];    
    }


$query = "SELECT * FROM History_test";

// $image 			= "hinh anh";
// $nameFood  		= "mon an";
// $note  			= "ghi chu";
// $numberOrder  	= "3";
// $Raise  		= "10000";



$query = "INSERT INTO History_test VALUES(null,'$id_KH','$Ma_Food','$image','$nameFood','$note',
'$numberOrder','$Raise','$Time')";

if(mysqli_query($connect,$query)){
	echo "success";
}else{
	echo "fail";
}

?>