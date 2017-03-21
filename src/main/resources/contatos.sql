-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21-Mar-2017 às 21:11
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `contatos`
--

CREATE TABLE `contatos` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(256) NOT NULL,
  `telefone` varchar(256) NOT NULL,
  `celular` varchar(256) DEFAULT NULL,
  `endereco` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contatos`
--

INSERT INTO `contatos` (`id`, `nome`, `telefone`, `celular`, `endereco`) VALUES
(2, 'Jean Carlos', '321456879', '4565878942', 'Rua da Varzea 899'),
(3, 'Carlos Oliveira', '78945354', '55246871', 'Rua do Campo 579'),
(6, 'Eduardo Rodrigues', '98748596', '4568798752', 'Rua José Quintana, 759'),
(7, 'Thiago Vinicius Molin', '49 99346420', NULL, 'Rua Oliveira Pires, 943'),
(8, 'Maria Lourdes', '8789756387', '24687658', 'Rua 5, 568'),
(9, 'Ricardo Soares', '456789459', '45984752325', 'Rua 2, 568'),
(10, 'Renan Borba', '489582638', '245895589', 'Rua Central, 456'),
(11, 'Juvenal Antunes', '789825898', '1526845295', 'Rua 2 de Setembro, 456'),
(12, 'Caio', '48981269', '152684595', 'Rua General Osório, 123'),
(13, 'Morgana Pires', '789852368', '1598765898', 'Av. Salomão C. de Almeida, 456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contatos`
--
ALTER TABLE `contatos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contatos`
--
ALTER TABLE `contatos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
