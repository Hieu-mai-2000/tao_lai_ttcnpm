<?php

$connect = mysqli_connect("localhost","root","","History");
mysqli_query($connect,"SET NAMES 'utf8'");


$query = "SELECT History_test.image,History_test.nameFood,History_test.Note,History_test.NumberOrder ,History_test.Raise FROM History_test AS History_test,History_KH AS History_KH,khach_hang AS khach_hang WHERE History_test.id_KH = 1 = khach_hang.id_KH AND History_test.Ma_Food = 44 AND History_KH.Ma_Food =44";

$data = mysqli_query($connect,$query);


class detail_history{
 	function detail_history($image,$nameFood,$Note,$NumberOrder,$Raise){
 		$this->image 			= $image;
 		$this->nameFood 		= $nameFood;
 		$this->Note 			= $Note;
 		$this->NumberOrder 		= $NumberOrder;
 		$this->Raise 			= $Raise;
 		
 	}
 }

 $mangHistory = array();

 while ($row = mysqli_fetch_assoc($data)) {


array_push($mangHistory, new detail_history($row["image"],$row['nameFood'],$row['Note'],$row['NumberOrder'],$row['Raise']));

 
}


 echo json_encode($mangHistory);


?>