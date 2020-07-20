<?php

$connect = mysqli_connect("localhost","root","","list_food");
mysqli_query($connect,"SET NAMES 'utf8'");


$query = "SELECT * FROM KFC_";

$data = mysqli_query($connect,$query);


class KFC{
 	function KFC($Id,$NameFood,$Raise,$Number,$Image){
 		$this->Id 			= $Id;
 		$this->NameFood 	= $NameFood;
 		$this->Raise 		= $Raise;
 		$this->Number 		= $Number;
 		$this->Image 		= $Image;
 		
 	}
 }

 $mangKFC = array();

 while ($row = mysqli_fetch_assoc($data)) {


array_push($mangKFC, new KFC($row["Id"],$row['NameFood'],$row['Raise'],$row['Number'],$row['Image']));

 
}


 echo json_encode($mangKFC);


?>