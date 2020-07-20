<?php

$connect = mysqli_connect("localhost","root","","quay_hang");
mysqli_query($connect,"SET NAMES 'utf8'");


$query = "SELECT * FROM QuayHang";

$data = mysqli_query($connect,$query);


class QuayHang{
 	function QuayHang($id,$name,$image){
 		$this->Id = $id;
 		$this->hoten = $name;
 		$this->hinhanh = $image;
 		
 	}
 }

 $mangSV = array();

 while ($row = mysqli_fetch_assoc($data)) {


array_push($mangSV, new QuayHang($row["id"],$row['name'],$row['image']));

 
}


 echo json_encode($mangSV);


?>