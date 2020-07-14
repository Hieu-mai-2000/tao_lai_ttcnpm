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
-- Database: `quay_hang`
--

-- --------------------------------------------------------

--
-- Table structure for table `QuayHang`
--

CREATE TABLE `QuayHang` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `QuayHang`
--

INSERT INTO `QuayHang` (`id`, `name`, `image`) VALUES
(1, 'KFC', 'https://w7.pngwing.com/pngs/318/361/png-transparent-kfc-fried-chicken-logo-chicken-as-food-fried-chicken.png'),
(2, 'Gong Cha', 'https://marketingai.admicro.vn/wp-content/uploads/2018/11/nhuong-quyen-tra-sua-3.png'),
(3, 'Pizza Hut', 'https://www.brandsvietnam.com/upload/news/480px/2014/PizzaHut_1389144765.jpg'),
(4, 'King BBQ', 'https://vincom.com.vn/sites/default/files/2016-11/King-BBQ-vua-nuong-han-quoc.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `QuayHang`
--
ALTER TABLE `QuayHang`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `QuayHang`
--
ALTER TABLE `QuayHang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
