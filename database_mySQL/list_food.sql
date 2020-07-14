-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 14, 2020 at 03:34 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `list_food`
--

-- --------------------------------------------------------

--
-- Table structure for table `BBQ_`
--

CREATE TABLE `BBQ_` (
  `Id` int(11) NOT NULL,
  `NameFood` varchar(255) NOT NULL,
  `Raise` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `BBQ_`
--

INSERT INTO `BBQ_` (`Id`, `NameFood`, `Raise`, `Number`, `Image`) VALUES
(1, 'COMBO Cung Đình', 199000, 39, 'https://kingbbq.com.vn/wp-content/uploads/2014/05/king-a_tinh-hoa-thit-nuong-hoang-cung-_banner-01-1500x1000.jpg'),
(2, 'Đại Tiệc Hoàng Gia', 169000, 55, 'https://farm2.static.flickr.com/1667/26503737006_dd1e75295e_o.png'),
(3, 'COMBO Cặp Đôi', 99000, 52, 'https://pasgo.vn/Upload/anh-chi-tiet/nha-hang-king-bbq-buffet-discovery-complex-cau-giay-1-normal-503563629870.jpg'),
(4, '40000', 40000, 33, 'https://redsun-iti.com.vn/wp-content/uploads/2015/03/mon-ngon-chao-nong.jpg'),
(5, 'COMBO Hàng Tre', 39000, 59, 'https://pasgo.vn/Upload/anh-chi-tiet/nha-hang-king-bbq-hang-tre-slide-1-normal-130997114708.jpg'),
(6, 'Thịt Nướng Sông Khói', 29000, 59, 'https://icdn.dantri.com.vn/lsvaPE0d7foDdfJ7sLS/Image/2011/10/IMG0070_30b6e.jpg'),
(7, 'COMBO NGŨ VỊ', 169000, 55, 'https://images.foody.vn/video/s800x450/foody-king%20as-636197583421602935.jpg'),
(8, 'Bạch Tuộc Nướng', 39000, 59, 'https://kingbbq.com.vn/wp-content/uploads/2014/09/bach-tuoc-nuong-900x600.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `GongCha`
--

CREATE TABLE `GongCha` (
  `Id` int(11) NOT NULL,
  `NameFood` varchar(255) NOT NULL,
  `Raise` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `GongCha`
--

INSERT INTO `GongCha` (`Id`, `NameFood`, `Raise`, `Number`, `Image`) VALUES
(1, 'Red Bean Smoothie', 39000, 39, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSHbUAaCDCgfvkjMVkOgY7PlMuy6C1-DwrCFw&usqp=CAU'),
(2, 'Chocolate Smmothie', 409000, 55, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQT4hgGdIy23gcZhyOGR9_FeVNJeHRsh-4kZw&usqp=CAU'),
(3, 'Straberry Chocolate', 99000, 52, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQHTFVzhIkZyopFgPtKgOGOulKBSeeL4F3sDA&usqp=CAU'),
(4, 'Chocolate Đá Xay', 40000, 33, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTip139xhXv6fruq-bvYTauxxSVzDMoKwt0pg&usqp=CAU'),
(5, 'Trà tươi', 39000, 59, 'https://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Oolong-Milkfoam-3.png'),
(6, 'Trà Oolong', 29000, 59, 'https://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Oolong-2.png'),
(7, 'Kem Trà Sữa', 29000, 55, 'https://gongcha.com.vn/wp-content/uploads/2018/10/kem.png'),
(8, 'Trà sữa ngũ vị', 59000, 59, 'https://kenh14cdn.com/2018/1b-1516449654868.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `KFC_`
--

CREATE TABLE `KFC_` (
  `Id` int(11) NOT NULL,
  `NameFood` varchar(255) NOT NULL,
  `Raise` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `KFC_`
--

INSERT INTO `KFC_` (`Id`, `NameFood`, `Raise`, `Number`, `Image`) VALUES
(1, 'Khoai Tây chiên vị phô mai', 20000, 30, 'https://www.vietnammm.com/blog/wp-content/uploads/2018/03/kfc-logo.jpeg'),
(2, 'Gà Ráng', 30000, 59, 'https://i.pinimg.com/originals/31/d1/00/31d100367f8fb8ff7a9ac69a40f29910.jpg'),
(3, 'KFC_Chizza', 20000, 39, 'https://channel.vcmedia.vn/thumb_w/640/prupload/164/2017/03/img20170316154952482.jpg'),
(4, 'HamBerGer', 35000, 55, 'https://toplist.vn/images/800px/kfc-449643.jpg'),
(5, 'COMBO Gà Ngũ Vị', 59000, 52, 'https://icdn.dantri.com.vn/lsvaPE0d7foDdfJ7sLS/Image/2011/07/0705/1_51ef9.jpg'),
(6, 'Cánh Gà Chiên Giòn', 40000, 33, 'https://i.a4vn.com/2019/10/9/cong-thuc-chuan-nhat-lam-mon-ga-ran-kfc-ngon-nhu-nha-hang-045f3f.jpg'),
(7, 'Gà Ráng Nhân Sầu Riêng', 39000, 59, 'https://genk.mediacdn.vn/2019/9/18/durian-nuggets2-15687744982735702433.jpg'),
(8, 'COMBO Cặp Đôi ', 79000, 59, 'https://timviec365.vn/pictures/images/KFC-la-gi-1-min.jpg'),
(9, 'Giỏ Gà Chiên Giòn', 60000, 55, 'https://toplist.vn/images/800px/kfc-30330.jpg'),
(10, 'Gà Khoai vị truyền thống', 39000, 59, 'https://photo-1-baomoi.zadn.vn/w1000_r1/2019_06_07_541_31004628/b815febdf7fd1ea347ec.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `PIZZAHUT`
--

CREATE TABLE `PIZZAHUT` (
  `Id` int(11) NOT NULL,
  `NameFood` varchar(255) NOT NULL,
  `Raise` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `PIZZAHUT`
--

INSERT INTO `PIZZAHUT` (`Id`, `NameFood`, `Raise`, `Number`, `Image`) VALUES
(1, 'Pizza nồi đất', 199000, 39, 'https://images.foody.vn/res/g17/165268/s/foody-pizza-hut-nguyen-anh-thu-532-635777000563030256.jpg'),
(2, 'Pizza truyền thống', 169000, 55, 'https://d3tosvr3yotk6r.cloudfront.net/Content/UserUploads/Images/Locations/4/1054/medium_Pizza%20Hut%20-%20L%C3%AA%20Du%E1%BA%A9n%208.jpg'),
(3, 'Pizza vị dâu tây', 99000, 52, 'https://monngondathanh.com/wp-content/uploads/2018/07/hut-min.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `BBQ_`
--
ALTER TABLE `BBQ_`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `GongCha`
--
ALTER TABLE `GongCha`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `KFC_`
--
ALTER TABLE `KFC_`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `PIZZAHUT`
--
ALTER TABLE `PIZZAHUT`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BBQ_`
--
ALTER TABLE `BBQ_`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `GongCha`
--
ALTER TABLE `GongCha`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `KFC_`
--
ALTER TABLE `KFC_`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `PIZZAHUT`
--
ALTER TABLE `PIZZAHUT`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
