-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-06-2022 a las 21:33:10
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

drop database sistema_bancario;

create database sistema_bancario;

use sistema_bancario;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_bancario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `nro_cliente` int(3) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `dni` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `nro_sucursal` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nro_cliente`, `nombre`, `dni`, `telefono`, `nro_sucursal`) VALUES
(2, 'Diego Agudo', '25951864	', '1234-5678', 9),
(6, 'Alberto Ross', '11500600', '4587-2516', 2),
(7, 'Pepito Ruiz', '20000000', '7458-6522', 2),
(8, 'Nestor Perez', '45000000', '7845-2356', 9),
(11, 'Beto Casella', '12000333', '4587-9652', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `num_cuenta` int(3) NOT NULL,
  `tipo` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  `moneda` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `saldo` double NOT NULL,
  `nro_cliente` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`num_cuenta`, `tipo`, `moneda`, `saldo`, `nro_cliente`) VALUES
(1, 'CA', 'Pesos', 32000, 2),
(3, 'CA', 'Pesos', 8000, 6),
(4, 'CA', 'Dolares', 7500, 2),
(5, 'CA', 'Pesos', 11000, 7),
(6, 'CA', 'Pesos', 7500, 8),
(7, 'CC', 'Pesos', 22000, 6),
(8, 'CA', 'Pesos', 0, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `nro_sucursal` int(3) NOT NULL,
  `direccion` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`nro_sucursal`, `direccion`) VALUES
(2, 'Mitre 4003'),
(9, 'Gregoria Matorras 234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`nro_cliente`),
  ADD KEY `FKClienteSucursal` (`nro_sucursal`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`num_cuenta`),
  ADD KEY `FKcuentas_cliente` (`nro_cliente`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`nro_sucursal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `nro_cliente` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `num_cuenta` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  MODIFY `nro_sucursal` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `FKClienteSucursal` FOREIGN KEY (`nro_sucursal`) REFERENCES `sucursales` (`nro_sucursal`);

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `FKcuentas_cliente` FOREIGN KEY (`nro_cliente`) REFERENCES `clientes` (`nro_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
