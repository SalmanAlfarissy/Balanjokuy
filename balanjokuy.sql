-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2020 at 03:38 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `balanjokuy`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_trans`
--

CREATE TABLE `detail_trans` (
  `id_trans` varchar(10) NOT NULL,
  `kode_menu` varchar(10) NOT NULL,
  `jml_terjual` int(10) NOT NULL,
  `keuntungan` int(10) NOT NULL,
  `idkasir` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_trans`
--

INSERT INTO `detail_trans` (`id_trans`, `kode_menu`, `jml_terjual`, `keuntungan`, `idkasir`) VALUES
('T001', 'M001', 2, 4000, '1811082027'),
('T001', 'M002', 2, 8000, '1811082027'),
('T001', 'M011', 2, 2000, '1811082027'),
('T001', 'M107', 4, 12000, '1811082027'),
('T003', 'M001', 1, 2000, '1811082026'),
('T004', 'M001', 1, 2000, '1811082026'),
('T005', 'M001', 1, 2000, '1811082026'),
('T002', 'M007', 2, 4000, '12345'),
('T002', 'M014', 5, 2500, '12345'),
('T002', 'M102', 3, 6000, '12345'),
('T002', 'M107', 4, 12000, '12345'),
('T006', 'M001', 2, 4000, '12345'),
('T007', 'M001', 2, 4000, '12345'),
('T007', 'M101', 2, 4000, '12345'),
('T008', 'M003', 2, 6000, '1811082023'),
('T008', 'M101', 3, 6000, '1811082023');

-- --------------------------------------------------------

--
-- Table structure for table `tkasir`
--

CREATE TABLE `tkasir` (
  `idkasir` varchar(50) NOT NULL,
  `namakasir` varchar(50) NOT NULL,
  `password` varchar(40) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tkasir`
--

INSERT INTO `tkasir` (`idkasir`, `namakasir`, `password`, `alamat`) VALUES
('12345', 'admin', '12345', 'padang'),
('1811082023', 'ricy', '12345', 'pasaman'),
('1811082026', 'Tulsi', '12345', 'padang'),
('1811082027', 'Salman Alfarissy', '12345', 'kec.patamuan,kab.padang Pariaman,Sumatera barat');

-- --------------------------------------------------------

--
-- Table structure for table `tmenu`
--

CREATE TABLE `tmenu` (
  `kode_menu` varchar(10) NOT NULL,
  `namamenu` varchar(50) NOT NULL,
  `stock` int(20) NOT NULL,
  `harga_jual` int(20) NOT NULL,
  `harga_modal` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tmenu`
--

INSERT INTO `tmenu` (`kode_menu`, `namamenu`, `stock`, `harga_jual`, `harga_modal`) VALUES
('M001', 'Pecel Ayam', 30, 13000, 11000),
('M002', 'Ayam Crispy', 30, 13000, 9000),
('M003', 'Soto', 30, 10000, 7000),
('M004', 'Mie Rebus', 50, 8000, 6000),
('M005', 'Mie Goreng', 50, 8000, 5000),
('M006', 'MieNas', 50, 10000, 8000),
('M007', 'Nasi Goreng', 50, 8000, 6000),
('M008', 'Lontong Gulai', 50, 7000, 5000),
('M009', 'Lontong Pical', 50, 8000, 6000),
('M010', 'Lontong Mie', 50, 7000, 5000),
('M011', 'Nasi', 100, 3000, 2000),
('M012', 'Ayam Goreng', 50, 8000, 6000),
('M013', 'Ayam Gulai', 50, 8000, 6000),
('M014', 'Gorengan', 50, 1000, 500),
('M101', 'Tehmanis', 50, 5000, 3000),
('M102', 'Teh es', 50, 5000, 3000),
('M103', 'Teh Panas', 50, 4000, 3000),
('M104', 'Kofe', 50, 5000, 3000),
('M105', 'Es Kosong', 50, 1000, 500),
('M106', 'Juice Orange', 50, 7000, 5000),
('M107', 'Juice Naga', 50, 10000, 7000),
('M108', 'Juice Mangga', 50, 10000, 7000),
('M109', 'Wortel', 50, 7000, 5000),
('M110', 'Nutrisari', 50, 4000, 3000),
('M111', 'Capucino', 50, 7000, 5000),
('M112', 'Teh Botol', 50, 4000, 3000),
('M113', 'Sprite', 50, 5000, 4000),
('M114', 'CocaCola', 50, 5000, 4000),
('M115', 'Fanta', 50, 5000, 4000),
('M116', 'Nutriboost', 50, 7000, 6000),
('M117', 'Le Minereal', 50, 3000, 2000),
('M118', 'Teh Sosro', 50, 6000, 5000),
('M119', 'Kopi 78', 50, 8000, 7000),
('M120', 'Aqua', 50, 3500, 3000);

-- --------------------------------------------------------

--
-- Table structure for table `tpelanggan`
--

CREATE TABLE `tpelanggan` (
  `nopel` int(11) NOT NULL,
  `nama_pel` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tpelanggan`
--

INSERT INTO `tpelanggan` (`nopel`, `nama_pel`) VALUES
(1, 'salman'),
(2, 'abdi'),
(4, 'alfa'),
(5, 'aan'),
(6, 'riky');

-- --------------------------------------------------------

--
-- Table structure for table `ttrans`
--

CREATE TABLE `ttrans` (
  `id_trans` varchar(20) NOT NULL,
  `nopel` int(11) NOT NULL,
  `tgltrans` date NOT NULL,
  `jml_pesanan` int(10) NOT NULL,
  `totalbyr` int(20) NOT NULL,
  `jml_bayar` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ttrans`
--

INSERT INTO `ttrans` (`id_trans`, `nopel`, `tgltrans`, `jml_pesanan`, `totalbyr`, `jml_bayar`) VALUES
('T001', 1, '2020-06-01', 10, 98000, 100000),
('T002', 2, '2020-06-07', 14, 76000, 100000),
('T003', 1, '2019-10-16', 1, 13000, 15000),
('T004', 1, '2018-10-16', 1, 13000, 15000),
('T005', 1, '2017-10-16', 1, 13000, 15000),
('T006', 4, '2020-06-07', 2, 26000, 30000),
('T007', 5, '2020-06-08', 4, 36000, 40000),
('T008', 6, '2020-06-08', 5, 35000, 35000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_trans`
--
ALTER TABLE `detail_trans`
  ADD KEY `id_trans` (`id_trans`),
  ADD KEY `kode_menu` (`kode_menu`),
  ADD KEY `idkasir` (`idkasir`);

--
-- Indexes for table `tkasir`
--
ALTER TABLE `tkasir`
  ADD PRIMARY KEY (`idkasir`);

--
-- Indexes for table `tmenu`
--
ALTER TABLE `tmenu`
  ADD PRIMARY KEY (`kode_menu`);

--
-- Indexes for table `tpelanggan`
--
ALTER TABLE `tpelanggan`
  ADD PRIMARY KEY (`nopel`);

--
-- Indexes for table `ttrans`
--
ALTER TABLE `ttrans`
  ADD PRIMARY KEY (`id_trans`),
  ADD KEY `nopel` (`nopel`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tpelanggan`
--
ALTER TABLE `tpelanggan`
  MODIFY `nopel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_trans`
--
ALTER TABLE `detail_trans`
  ADD CONSTRAINT `detail_trans_ibfk_1` FOREIGN KEY (`id_trans`) REFERENCES `ttrans` (`id_trans`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_trans_ibfk_2` FOREIGN KEY (`kode_menu`) REFERENCES `tmenu` (`kode_menu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_trans_ibfk_3` FOREIGN KEY (`idkasir`) REFERENCES `tkasir` (`idkasir`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ttrans`
--
ALTER TABLE `ttrans`
  ADD CONSTRAINT `ttrans_ibfk_1` FOREIGN KEY (`nopel`) REFERENCES `tpelanggan` (`nopel`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
