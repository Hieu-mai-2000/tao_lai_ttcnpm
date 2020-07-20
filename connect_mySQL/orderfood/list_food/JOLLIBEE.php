<?php

$connect = mysqli_connect("localhost","root","","list_food");
mysqli_query($connect,"SET NAMES 'utf8'");


$query = "SELECT * FROM JOLLIBEE";

$data = mysqli_query($connect,$query);


class Sinhvien{
 	function Sinhvien($id,$tenmon,$hinhanh,$gia,$soluong){
 		$this->id 		= $id;
 		$this->ten_mon 	= $tenmon;
 		$this->hinh_anh = $hinhanh;
 		$this->gia 		= $gia;
 		$this->so_luong = $soluong;
 		
 	}
 }

 $mangSV = array();

 while ($row = mysqli_fetch_assoc($data)) {


array_push($mangSV, new Sinhvien($row["id"],$row['tenmon'],$row['hinhanh'],$row['gia'],$row['soluong']));

 
}


 echo json_encode($mangSV);


?>