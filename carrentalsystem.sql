-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2018 at 01:11 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrentalsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminId` int(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminId`, `name`, `username`, `password`, `email`, `phone`) VALUES
(1, 'Dilshan Wimalasuriya', 'dila', '123456789', 'dilshanw32@gmail.com', '94775310224'),
(2, 'Pesh Herath', 'peshaa', '123456789', 'pesh@gmail.com', '94775310225'),
(3, 'timie ghgh', 'timi', '123456789', 'ti@gmail.com', '94756789456');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bid` int(50) NOT NULL,
  `vehicleId` int(50) NOT NULL,
  `vtId` int(50) NOT NULL,
  `customerId` int(50) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bid`, `vehicleId`, `vtId`, `customerId`, `startDate`, `endDate`, `charge`) VALUES
(1, 1, 1, 1, '2017-05-19', '2017-05-22', 15000),
(2, 2, 3, 1, '2017-05-19', '2017-05-25', 13000),
(3, 0, 2, 1, '2017-05-19', '2017-05-22', 30000),
(4, 0, 3, 1, '2017-05-19', '2017-05-25', 13000),
(5, 0, 2, 1, '2017-05-20', '2017-05-25', 40000),
(6, 0, 2, 1, '2017-05-25', '2017-05-27', 25000),
(7, 0, 1, 1, '2017-05-19', '2017-05-23', 17500);

-- --------------------------------------------------------

--
-- Table structure for table `bookingpayment`
--

CREATE TABLE `bookingpayment` (
  `bpId` int(50) NOT NULL,
  `rId` int(50) NOT NULL,
  `payDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookingpayment`
--

INSERT INTO `bookingpayment` (`bpId`, `rId`, `payDate`, `amount`) VALUES
(1, 1, '2017-05-19 09:14:48', 26000),
(2, 2, '2017-05-19 11:02:04', 15500);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerId` int(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `dLNumber` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `loyaltyPoints` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerId`, `name`, `username`, `password`, `dLNumber`, `phone`, `email`, `address`, `loyaltyPoints`) VALUES
(1, 'Dilshan Wimalasuriya', 'dila', '123456789', 'B11111111111', '94775310224', 'dilshanw32@gmail.com', 'Kesbawa', 415);

-- --------------------------------------------------------

--
-- Table structure for table `make`
--

CREATE TABLE `make` (
  `makeId` int(50) NOT NULL,
  `makeName` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `make`
--

INSERT INTO `make` (`makeId`, `makeName`) VALUES
(1, 'NISSAN'),
(2, 'TOYOTA');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE `model` (
  `modelID` int(50) NOT NULL,
  `modelName` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `model`
--

INSERT INTO `model` (`modelID`, `modelName`) VALUES
(1, 'AXIO'),
(2, 'LANCER');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleId` int(100) NOT NULL,
  `make` int(50) NOT NULL,
  `model` int(50) NOT NULL,
  `type` int(50) NOT NULL,
  `year` varchar(4) NOT NULL,
  `fuelType` set('Petrol','Diesel','Hybrid','Electric') NOT NULL,
  `availability` set('Available','Unavailable','Rented') NOT NULL,
  `transmission` set('Automatic','Manual') NOT NULL,
  `regNumber` varchar(7) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicleId`, `make`, `model`, `type`, `year`, `fuelType`, `availability`, `transmission`, `regNumber`) VALUES
(1, 1, 2, 1, '2017', 'Diesel', 'Available', 'Automatic', 'CC2020'),
(2, 2, 1, 3, '2017', 'Petrol', 'Available', 'Automatic', 'CC2021');

-- --------------------------------------------------------

--
-- Table structure for table `vehicletype`
--

CREATE TABLE `vehicletype` (
  `vtId` int(50) NOT NULL,
  `typeName` varchar(50) NOT NULL,
  `keymoney` double NOT NULL,
  `dailycharge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicletype`
--

INSERT INTO `vehicletype` (`vtId`, `typeName`, `keymoney`, `dailycharge`) VALUES
(1, 'SEDAN', 5000, 2500),
(2, 'SUV', 10000, 5000),
(3, 'HATCHBACK', 2500, 1500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bid`);

--
-- Indexes for table `bookingpayment`
--
ALTER TABLE `bookingpayment`
  ADD PRIMARY KEY (`bpId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `make`
--
ALTER TABLE `make`
  ADD PRIMARY KEY (`makeId`);

--
-- Indexes for table `model`
--
ALTER TABLE `model`
  ADD PRIMARY KEY (`modelID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleId`);

--
-- Indexes for table `vehicletype`
--
ALTER TABLE `vehicletype`
  ADD PRIMARY KEY (`vtId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `bookingpayment`
--
ALTER TABLE `bookingpayment`
  MODIFY `bpId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `make`
--
ALTER TABLE `make`
  MODIFY `makeId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `model`
--
ALTER TABLE `model`
  MODIFY `modelID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `vehicletype`
--
ALTER TABLE `vehicletype`
  MODIFY `vtId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
