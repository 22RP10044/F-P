-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2024 at 04:16 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mission__order`
--

-- --------------------------------------------------------

--
-- Table structure for table `approval`
--

CREATE TABLE `approval` (
  `OrderId` int(20) NOT NULL,
  `Approved_By` varchar(40) NOT NULL,
  `Approval_Status` int(30) NOT NULL,
  `Approval_Date` date NOT NULL,
  `Comments` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `approval`
--

INSERT INTO `approval` (`OrderId`, `Approved_By`, `Approval_Status`, `Approval_Date`, `Comments`) VALUES
(2, 'sd', 123, '2024-07-09', 'zjjsdv'),
(3, 'dfg', 567, '2024-07-02', 'sdfghj'),
(6, 'asdf', 23, '2024-07-02', 'zxcv'),
(8, 'cvb n', 4356, '2024-07-02', 'dcfgvbhjn'),
(9, 'xfg', 2345, '2024-07-02', 'dfgh');

-- --------------------------------------------------------

--
-- Table structure for table `creation`
--

CREATE TABLE `creation` (
  `Id` int(20) NOT NULL,
  `Person_Name` varchar(40) NOT NULL,
  `email` varchar(255) NOT NULL,
  `Function_of_person` varchar(40) NOT NULL,
  `Purpose_of_mission` varchar(200) NOT NULL,
  `Destination` varchar(30) NOT NULL,
  `Means_of_transportation` varchar(40) NOT NULL,
  `Date_of_Depature` date NOT NULL,
  `Return_Date` date NOT NULL,
  `Duration_days` int(20) NOT NULL,
  `Account_number` varchar(30) NOT NULL,
  `Mission_Allowance` varchar(40) NOT NULL,
  `Name_of_supervisor` varchar(30) NOT NULL,
  `Status` enum('Pending','Approved','Rejected') NOT NULL DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `creation`
--

INSERT INTO `creation` (`Id`, `Person_Name`, `email`, `Function_of_person`, `Purpose_of_mission`, `Destination`, `Means_of_transportation`, `Date_of_Depature`, `Return_Date`, `Duration_days`, `Account_number`, `Mission_Allowance`, `Name_of_supervisor`, `Status`) VALUES
(47, 'umurerwa', 'mukarusangaagne@gmail.com', 'manager', 'training', 'kigali', 'car', '2024-08-23', '2024-08-22', 8, '8765', '10000', 'muhire', 'Approved'),
(58, 'Kamana', 'vincentshm200@gmail.com', 'manager', 'works', 'Nyanza', 'car', '2024-08-30', '2024-09-07', 7, '7655', '0', 'Akimana', 'Rejected'),
(60, 'clement', 'vincentshm200@gmail.com', 'student', 'training', 'Nyanza', 'car', '2024-08-31', '2024-09-05', 3, '7655', '', 'Akimana', 'Approved'),
(61, 'Kamanzi', 'vincentshm200@gmail.com', 'student', 'training', 'Nyanza', 'car', '2024-08-30', '2024-09-05', 3, '7655', '', 'Karenzi', 'Approved'),
(62, 'Karenzi', 'vincentshm200@gmail.com', 'student', 'training', 'Nyanza', 'car', '2024-08-30', '2024-09-06', 3, '7655', '0', 'Kamana', 'Approved'),
(63, 'kayezu', 'niyitiephr04@gmail.com', 'manager', 'training', 'kigali', 'private', '2024-08-29', '2024-08-31', 7, '876', '', 'noella', 'Rejected');

-- --------------------------------------------------------

--
-- Table structure for table `csdm`
--

CREATE TABLE `csdm` (
  `csdm_id` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `person_name` int(255) NOT NULL,
  `Purpose_of_mission` varchar(255) NOT NULL,
  `Destination` varchar(255) NOT NULL,
  `Date_of_dispatcher` date NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `daf`
--

CREATE TABLE `daf` (
  `daf_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `person_name` varchar(255) NOT NULL,
  `Purpose_of_mission` varchar(255) NOT NULL,
  `Destination` varchar(255) NOT NULL,
  `Date_of_dispatcher` date NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `User_id` int(30) NOT NULL,
  `Username` varchar(40) NOT NULL,
  `Password` varchar(40) NOT NULL,
  `Role` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `Rep_Id` int(11) NOT NULL,
  `Report_Title` varchar(100) NOT NULL,
  `Report_Description` varchar(100) NOT NULL,
  `Upload_Report` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`Rep_Id`, `Report_Title`, `Report_Description`, `Upload_Report`) VALUES
(7, 'trainning', 'well', 'C:\\Users\\user\\Downloads\\Newproject\\build\\web\\uploads\\Document1 (1).pdf');

-- --------------------------------------------------------

--
-- Table structure for table `supervisor`
--

CREATE TABLE `supervisor` (
  `csdm_id` int(11) DEFAULT NULL,
  `Id` int(11) DEFAULT NULL,
  `person_name` int(255) DEFAULT NULL,
  `Purpose_of_mission` varchar(255) DEFAULT NULL,
  `Destination` varchar(255) DEFAULT NULL,
  `Date_of_dispatcher` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Role` varchar(40) NOT NULL,
  `Password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `Name`, `Role`, `Password`) VALUES
(18, 'noella', 'Supervisor', 'Agnes123@'),
(22, 'kayezu', 'Receiver', 'Agnes123@'),
(23, 'keza', 'Admin', 'Agnes123@'),
(27, 'agnes', 'Secretary', 'Agnes123@'),
(31, 'umwiza', 'daf', 'Agnes123@'),
(35, 'vincent', 'CSDM', 'Agnes123@');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `creation`
--
ALTER TABLE `creation`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`Rep_Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `creation`
--
ALTER TABLE `creation`
  MODIFY `Id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `Rep_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
