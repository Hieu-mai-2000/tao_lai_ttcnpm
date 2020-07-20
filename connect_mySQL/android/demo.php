<?php

 class Sinhvien{
 	function Sinhvien($hoten, $namsinh , $diachi){
 		$this->hoten = $hoten;
 		$this->namsinh = $namsinh;
 		$this->diachi = $diachi;


 	}
 }

 $mangSV = array();

 array_push($mangSV, new Sinhvien("nguyen van A",1999,"ha noi"));
 array_push($mangSV, new Sinhvien("nguyen van S",1990,"viet nam"));
 array_push($mangSV, new Sinhvien("nguyen van S",1990,"viet nam"));
 

 echo json_encode($mangSV);

?>