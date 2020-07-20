<?php

require "connect.php";

$query = "SELECT * FROM studentt";

$data = mysqli_query($connect,$query);


class Sinhvien{
 	function Sinhvien($id,$hoten, $namsinh , $diachi){
 		$this->Id = $id;
 		$this->hoten = $hoten;
 		$this->namsinh = $namsinh;
 		$this->diachi = $diachi;


 	}
 }

 $mangSV = array();

 while ($row = mysqli_fetch_assoc($data)) {


array_push($mangSV, new Sinhvien($row["id"],$row['hoten'],$row['namsinh'],$row['diachi']));

 
}


 echo json_encode($mangSV);

?>