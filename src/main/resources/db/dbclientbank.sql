-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 16, 2021 at 12:47 AM
-- Server version: 5.7.24
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbclientbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `id` bigint(20) NOT NULL,
  `idClient` bigint(20) NOT NULL,
  `idCredit` bigint(20) NOT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `credit_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `idClient`, `idCredit`, `client_id`, `credit_id`) VALUES
(1, 1, 1, NULL, NULL),
(2, 2, 1, NULL, NULL),
(3, 3, 2, NULL, NULL),
(4, 4, 2, NULL, NULL),
(5, 5, 3, NULL, NULL),
(7, 12, 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `FIO` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `numberPassport` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `FIO`, `phone`, `email`, `numberPassport`) VALUES
(1, 'Тонких Кирилл Кириллович', '8900433211', 'example1@gmail.com', '1212 244414'),
(2, 'Иванов Иван Иванович', '8900435454', 'example2@gmail.com', '1452 424578'),
(3, 'Гришко Татьяна Валерьевна', '8900433489', 'example3@gmail.com', '7755 436576'),
(4, 'Мич Анастасия Олеговна', '8900433231', 'exampl4e@gmail.com', '4422 554433'),
(5, 'Петров Иван владимирович', '8905433211', 'examp5le@gmail.com', '9988 121212'),
(12, 'TEST TEST22', '89050525823', 'egordolgih7@gmail.com', '2112 222222');

-- --------------------------------------------------------

--
-- Table structure for table `credit`
--

CREATE TABLE `credit` (
  `id` bigint(20) NOT NULL,
  `CreditLimit` float NOT NULL,
  `InterestRate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `credit`
--

INSERT INTO `credit` (`id`, `CreditLimit`, `InterestRate`) VALUES
(1, 100000, 10.3),
(2, 150000, 19.2),
(3, 200000, 21.3),
(4, 50000, 35.6),
(5, 450000, 12.6),
(6, 100022, 31.2),
(9, 1000000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `creditoffer`
--

CREATE TABLE `creditoffer` (
  `id` bigint(20) NOT NULL,
  `idClient` bigint(20) NOT NULL,
  `idCredit` bigint(20) NOT NULL,
  `LoanAmount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `creditoffer`
--

INSERT INTO `creditoffer` (`id`, `idClient`, `idCredit`, `LoanAmount`) VALUES
(1, 1, 1, 10000),
(2, 2, 2, 45000),
(3, 2, 3, 89000),
(4, 3, 4, 100000),
(5, 4, 2, 125000),
(6, 12, 9, 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `paymentschedule`
--

CREATE TABLE `paymentschedule` (
  `id` bigint(20) NOT NULL,
  `idCreditOffer` bigint(20) NOT NULL,
  `PaymentDate` datetime NOT NULL,
  `PaymentAmount` float NOT NULL,
  `AmountBody` float NOT NULL,
  `AmountPercent` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idCredit` (`idCredit`),
  ADD KEY `FK8uma4gavs0crdv478oui0cua3` (`client_id`),
  ADD KEY `FKpbf2xwxkt2cyt948ad4a5o90c` (`credit_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `credit`
--
ALTER TABLE `credit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `creditoffer`
--
ALTER TABLE `creditoffer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idCredit` (`idCredit`);

--
-- Indexes for table `paymentschedule`
--
ALTER TABLE `paymentschedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCreditOffer` (`idCreditOffer`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `credit`
--
ALTER TABLE `credit`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `creditoffer`
--
ALTER TABLE `creditoffer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `paymentschedule`
--
ALTER TABLE `paymentschedule`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bank`
--
ALTER TABLE `bank`
  ADD CONSTRAINT `FK8uma4gavs0crdv478oui0cua3` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKpbf2xwxkt2cyt948ad4a5o90c` FOREIGN KEY (`credit_id`) REFERENCES `credit` (`id`),
  ADD CONSTRAINT `bank_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `bank_ibfk_2` FOREIGN KEY (`idCredit`) REFERENCES `credit` (`id`);

--
-- Constraints for table `creditoffer`
--
ALTER TABLE `creditoffer`
  ADD CONSTRAINT `creditoffer_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `creditoffer_ibfk_2` FOREIGN KEY (`idCredit`) REFERENCES `credit` (`id`);

--
-- Constraints for table `paymentschedule`
--
ALTER TABLE `paymentschedule`
  ADD CONSTRAINT `paymentschedule_ibfk_1` FOREIGN KEY (`idCreditOffer`) REFERENCES `creditoffer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
