-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2024 at 07:49 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javacms`
--

-- --------------------------------------------------------

--
-- Table structure for table `coursestable`
--

CREATE TABLE `coursestable` (
  `courseId` varchar(10) NOT NULL,
  `courseName` varchar(255) NOT NULL,
  `availability` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coursestable`
--

INSERT INTO `coursestable` (`courseId`, `courseName`, `availability`) VALUES
('BS01', 'BSc Business', 'yes'),
('CS01', 'BSc Computer Science', 'yes'),
('CS02', 'BSc IT and Networking', 'yes'),
('CS03', 'BSc Cyber Security', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `learningstudents`
--

CREATE TABLE `learningstudents` (
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `courseId` varchar(10) DEFAULT NULL,
  `semester` varchar(1) NOT NULL,
  `level` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `learningstudents`
--

INSERT INTO `learningstudents` (`email`, `name`, `courseId`, `semester`, `level`) VALUES
('st01@hck.com', 'Ram KC', 'CS02', '2', '4'),
('st02@hck.com', 'Shyam Jha', 'BS01', '1', '5'),
('st03@hck.com', 'Dev Khadka', 'CS01', '2', '6');

-- --------------------------------------------------------

--
-- Table structure for table `logins`
--

CREATE TABLE `logins` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `studentCourseId` varchar(10) DEFAULT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logins`
--

INSERT INTO `logins` (`id`, `name`, `email`, `password`, `studentCourseId`, `role`) VALUES
(1, 'Admin HCK', 'adm01@hck.com', 'Admin001!', NULL, 'admin'),
(2, 'Sulov Sir', 'sulov.sir1@hck.com', 'Sulov001!', '', 'Teacher'),
(3, 'Aatiz Sir', 'aatiz.sir2@hck.com', 'Aatiz001!', '', 'Teacher'),
(4, 'Yogesh Sir', 'yogesh.sir3@hck.com', 'Yogesh001!', '', 'Teacher'),
(5, 'Ram KC', 'st01@hck.com', 'Stud001!', 'CS02', 'Student'),
(6, 'Shyam Jha', 'st02@hck.com', 'Stud002!', 'BS01', 'Student'),
(7, 'Dev Khadka', 'st03@hck.com', 'Stud003!', 'CS01', 'Student');

-- --------------------------------------------------------

--
-- Table structure for table `modulestable`
--

CREATE TABLE `modulestable` (
  `moduleId` varchar(10) NOT NULL,
  `courseId` varchar(10) DEFAULT NULL,
  `moduleName` varchar(255) NOT NULL,
  `level` int(11) NOT NULL,
  `optional` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `modulestable`
--

INSERT INTO `modulestable` (`moduleId`, `courseId`, `moduleName`, `level`, `optional`) VALUES
('M01', 'CS01', 'FOC', 4, 'no'),
('M02', 'CS01', 'ISA', 4, 'no'),
('M03', 'CS01', 'NMC', 5, 'no'),
('M04', 'CS01', 'Cloud Systems', 5, 'no'),
('M05', 'CS01', 'BigData', 6, 'no'),
('M06', 'CS01', 'HCI', 6, 'no'),
('M07', 'CS01', 'Softwares and Applications', 6, 'yes'),
('M21', 'BS01', 'Business Intro', 4, 'no'),
('M22', 'BS01', 'Statistics', 5, 'no'),
('M23', 'BS01', 'Business Math', 6, 'no'),
('M24', 'BS01', 'Share Market', 6, 'yes'),
('M41', 'CS02', 'Network and Internet', 4, 'no'),
('M42', 'CS02', 'Network Security', 5, 'no'),
('M43', 'CS02', 'Complex Networks', 6, 'no'),
('M44', 'CS02', 'Internet', 6, 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `studentsresults`
--

CREATE TABLE `studentsresults` (
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `moduleId` varchar(10) DEFAULT NULL,
  `moduleName` varchar(255) DEFAULT NULL,
  `level` varchar(1) NOT NULL,
  `marks` varchar(3) NOT NULL,
  `remark` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentsresults`
--

INSERT INTO `studentsresults` (`email`, `name`, `moduleId`, `moduleName`, `level`, `marks`, `remark`) VALUES
('st01@hck.com', 'Ram KC', 'M41', 'Network and Internet', '4', '-', '-'),
('st02@hck.com', 'Shyam Jha', 'M21', 'Business Intro', '4', '-', '-'),
('st03@hck.com', 'Dev Khadka', 'M01', 'FOC', '4', '-', '-'),
('st03@hck.com', 'Dev Khadka', 'M02', 'ISA', '4', '-', '-'),
('st03@hck.com', 'Dev Khadka', 'M03', 'NMC', '5', '-', '-'),
('st03@hck.com', 'Dev Khadka', 'M04', 'Cloud Systems', '5', '-', '-'),
('st03@hck.com', 'Dev Khadka', 'M05', 'BigData', '6', '71', 'PASS'),
('st03@hck.com', 'Dev Khadka', 'M06', 'HCI', '6', '38', 'FAIL'),
('st02@hck.com', 'Shyam Jha', 'M22', 'Statistics', '5', '-', '-'),
('st03@hck.com', 'Dev Khadka', 'M44', 'Internet', '6', '-', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `teachersmoduletable`
--

CREATE TABLE `teachersmoduletable` (
  `email` varchar(255) DEFAULT NULL,
  `moduleId` varchar(10) NOT NULL,
  `moduleName` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachersmoduletable`
--

INSERT INTO `teachersmoduletable` (`email`, `moduleId`, `moduleName`, `name`) VALUES
('sulov.sir1@hck.com', 'M02', 'ISA', 'Sulov Sir'),
('aatiz.sir2@hck.com', 'M05', 'BigData', 'Aatiz Sir'),
('aatiz.sir2@hck.com', 'M06', 'HCI', 'Aatiz Sir'),
('aatiz.sir2@hck.com', 'M04', 'CloudSystems', 'Aatiz Sir'),
('aatiz.sir2@hck.com', 'M21', 'Business Math', 'Aatiz Sir'),
('sulov.sir1@hck.com', 'M03', 'NMC', 'Sulov Sir'),
('sulov.sir1@hck.com', 'M43', 'Complex Networks', 'Sulov Sir'),
('sulov.sir1@hck.com', 'M22', 'Statistics', 'Sulov Sir'),
('yogesh.sir3@hck.com', 'M01', 'FOC', 'Yogesh Sir'),
('yogesh.sir3@hck.com', 'M42', 'Network Security', 'Yogesh Sir'),
('yogesh.sir3@hck.com', 'M43', 'Complex Networks', 'Yogesh Sir'),
('yogesh.sir3@hck.com', 'M41', 'Network and Internet', 'Yogesh Sir');

--
-- Triggers `teachersmoduletable`
--
DELIMITER $$
CREATE TRIGGER `MaxFourModules` BEFORE INSERT ON `teachersmoduletable` FOR EACH ROW BEGIN DECLARE modules_count INTEGER; SET modules_count =(SELECT COUNT(*) FROM teachersModuleTable WHERE email = NEW.email );IF modules_count >= 4 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No more than 4 modules'; END IF; END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coursestable`
--
ALTER TABLE `coursestable`
  ADD PRIMARY KEY (`courseId`);

--
-- Indexes for table `learningstudents`
--
ALTER TABLE `learningstudents`
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modulestable`
--
ALTER TABLE `modulestable`
  ADD PRIMARY KEY (`moduleId`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `studentsresults`
--
ALTER TABLE `studentsresults`
  ADD KEY `moduleId` (`moduleId`);

--
-- Indexes for table `teachersmoduletable`
--
ALTER TABLE `teachersmoduletable`
  ADD KEY `moduleId` (`moduleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logins`
--
ALTER TABLE `logins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `learningstudents`
--
ALTER TABLE `learningstudents`
  ADD CONSTRAINT `learningstudents_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `coursestable` (`courseId`);

--
-- Constraints for table `modulestable`
--
ALTER TABLE `modulestable`
  ADD CONSTRAINT `modulestable_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `coursestable` (`courseId`);

--
-- Constraints for table `studentsresults`
--
ALTER TABLE `studentsresults`
  ADD CONSTRAINT `studentsresults_ibfk_1` FOREIGN KEY (`moduleId`) REFERENCES `modulestable` (`moduleId`);

--
-- Constraints for table `teachersmoduletable`
--
ALTER TABLE `teachersmoduletable`
  ADD CONSTRAINT `teachersmoduletable_ibfk_1` FOREIGN KEY (`moduleId`) REFERENCES `modulestable` (`moduleId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
