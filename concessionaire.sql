-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2020 at 02:49 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `concessionaire`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `motor` varchar(45) DEFAULT NULL,
  `brakes` varchar(45) DEFAULT NULL,
  `concessionaire_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`id`, `type`, `motor`, `brakes`, `concessionaire_id`) VALUES
(1, 'Bi-articulado', 'Diesel', 'abs', 1),
(2, 'articulado', 'Gas', 'abs', 1),
(3, 'Semi-articulado', 'Electric', 'abs', 2),
(4, 'Bi-articulado', 'Hybrid', 'abs', 1),
(5, 'Bi-articulado', 'Electric', 'abs', 3);

-- --------------------------------------------------------

--
-- Table structure for table `concessionaire`
--

CREATE TABLE `concessionaire` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `concessionaire`
--

INSERT INTO `concessionaire` (`id`, `name`) VALUES
(1, 'Concessionaire 1'),
(2, 'Concessionaire 2'),
(3, 'Concessionaire 3');

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE `device` (
  `id` int(11) NOT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '[NULL] Active\\n[1] Inactive',
  `bus_id` int(11) NOT NULL,
  `device_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device`
--

INSERT INTO `device` (`id`, `ip`, `status`, `bus_id`, `device_type_id`) VALUES
(1, '123456', NULL, 1, 2),
(2, '3216', 1, 4, 2),
(3, NULL, NULL, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `device_type`
--

CREATE TABLE `device_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `device_type`
--

INSERT INTO `device_type` (`id`, `name`) VALUES
(1, 'CANBUS'),
(2, 'NVR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bus_concessionaire_idx` (`concessionaire_id`);

--
-- Indexes for table `concessionaire`
--
ALTER TABLE `concessionaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_device_bus1_idx` (`bus_id`),
  ADD KEY `fk_device_device_type1_idx` (`device_type_id`);

--
-- Indexes for table `device_type`
--
ALTER TABLE `device_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `concessionaire`
--
ALTER TABLE `concessionaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `device`
--
ALTER TABLE `device`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `device_type`
--
ALTER TABLE `device_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `fk_bus_concessionaire` FOREIGN KEY (`concessionaire_id`) REFERENCES `concessionaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `device`
--
ALTER TABLE `device`
  ADD CONSTRAINT `fk_device_bus1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_device_device_type1` FOREIGN KEY (`device_type_id`) REFERENCES `device_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
