-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 20, 2020 at 06:30 AM
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
-- Database: `History`
--

-- --------------------------------------------------------

--
-- Table structure for table `History_KH`
--

CREATE TABLE `History_KH` (
  `Ma_Food` int(11) NOT NULL,
  `id_KH` int(11) NOT NULL,
  `Time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `History_KH`
--

INSERT INTO `History_KH` (`Ma_Food`, `id_KH`, `Time`) VALUES
(41, 1, '2020-07-20 02:19'),
(42, 1, '2020-07-20 02:20'),
(43, 1, '2020-07-20 02:21'),
(44, 1, '2020-07-20 02:22'),
(45, 5, '2020-07-20 02:24'),
(46, 5, '2020-07-20 02:25'),
(47, 5, '2020-07-20 02:25'),
(48, 5, '2020-07-20 04:12');

-- --------------------------------------------------------

--
-- Table structure for table `History_test`
--

CREATE TABLE `History_test` (
  `id` int(11) NOT NULL,
  `id_KH` int(11) NOT NULL,
  `Ma_Food` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `nameFood` varchar(255) NOT NULL,
  `Note` text NOT NULL,
  `NumberOrder` int(11) NOT NULL,
  `Raise` int(11) NOT NULL,
  `Time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `History_test`
--

INSERT INTO `History_test` (`id`, `id_KH`, `Ma_Food`, `image`, `nameFood`, `Note`, `NumberOrder`, `Raise`, `Time`) VALUES
(72, 1, 42, 'https://www.vietnammm.com/blog/wp-content/uploads/2018/03/kfc-logo.jpeg', 'Khoai Tây chiên vị phô mai', '', 1, 20000, '2020-07-20 02:21'),
(73, 1, 43, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSHbUAaCDCgfvkjMVkOgY7PlMuy6C1-DwrCFw&usqp=CAU', 'Red Bean Smoothie', '', 1, 39000, '2020-07-20 02:22'),
(74, 1, 44, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSHbUAaCDCgfvkjMVkOgY7PlMuy6C1-DwrCFw&usqp=CAU', 'Red Bean Smoothie', '', 3, 39000, '2020-07-20 02:22'),
(75, 1, 44, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSHbUAaCDCgfvkjMVkOgY7PlMuy6C1-DwrCFw&usqp=CAU', 'Red Bean Smoothie', '', 2, 39000, '2020-07-20 02:22'),
(76, 5, 45, 'https://gongcha.com.vn/wp-content/uploads/2018/10/kem.png', 'Kem Trà Sữa', '', 2, 29000, '2020-07-20 02:24'),
(77, 5, 45, 'https://gongcha.com.vn/wp-content/uploads/2018/10/kem.png', 'Kem Trà Sữa', '', 4, 29000, '2020-07-20 02:24'),
(78, 5, 45, 'https://gongcha.com.vn/wp-content/uploads/2018/10/kem.png', 'Kem Trà Sữa', '', 3, 29000, '2020-07-20 02:24'),
(79, 5, 46, 'https://kenh14cdn.com/2018/1b-1516449654868.jpg', 'Trà sữa ngũ vị', '', 2, 59000, '2020-07-20 02:25'),
(80, 5, 46, 'https://kenh14cdn.com/2018/1b-1516449654868.jpg', 'Trà sữa ngũ vị', '', 3, 59000, '2020-07-20 02:25'),
(81, 5, 47, 'https://pasgo.vn/Upload/anh-chi-tiet/nha-hang-king-bbq-buffet-discovery-complex-cau-giay-1-normal-503563629870.jpg', 'COMBO Cặp Đôi', '', 1, 99000, '2020-07-20 02:25'),
(82, 5, 47, 'https://pasgo.vn/Upload/anh-chi-tiet/nha-hang-king-bbq-buffet-discovery-complex-cau-giay-1-normal-503563629870.jpg', 'COMBO Cặp Đôi', '', 2, 99000, '2020-07-20 02:25'),
(83, 5, 47, 'https://kingbbq.com.vn/wp-content/uploads/2014/05/king-a_tinh-hoa-thit-nuong-hoang-cung-_banner-01-1500x1000.jpg', 'COMBO Cung Đình', '', 3, 199000, '2020-07-20 04:12'),
(84, 5, 47, 'https://kingbbq.com.vn/wp-content/uploads/2014/05/king-a_tinh-hoa-thit-nuong-hoang-cung-_banner-01-1500x1000.jpg', 'COMBO Cung Đình', '', 2, 199000, '2020-07-20 04:12');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `id_KH` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`id_KH`, `Name`, `email`) VALUES
(1, 'Mai Nguyễn Minh Hiếu', 'hieu@gmail.com'),
(5, 'test', '1234@'),
(6, 'toi day la amin', 'amin@');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `History_KH`
--
ALTER TABLE `History_KH`
  ADD PRIMARY KEY (`Ma_Food`),
  ADD KEY `id_KH` (`id_KH`);

--
-- Indexes for table `History_test`
--
ALTER TABLE `History_test`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ma_food` (`Ma_Food`),
  ADD KEY `id` (`id_KH`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`id_KH`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `History_KH`
--
ALTER TABLE `History_KH`
  MODIFY `Ma_Food` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `History_test`
--
ALTER TABLE `History_test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `id_KH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `History_KH`
--
ALTER TABLE `History_KH`
  ADD CONSTRAINT `id_KH` FOREIGN KEY (`id_KH`) REFERENCES `khach_hang` (`id_KH`);

--
-- Constraints for table `History_test`
--
ALTER TABLE `History_test`
  ADD CONSTRAINT `Ma_food` FOREIGN KEY (`Ma_Food`) REFERENCES `History_KH` (`Ma_Food`),
  ADD CONSTRAINT `id` FOREIGN KEY (`id_KH`) REFERENCES `khach_hang` (`id_KH`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
