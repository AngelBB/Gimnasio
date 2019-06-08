-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-12-2014 a las 19:17:30
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gimnasio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`dni`, `nombre`, `apellidos`, `telefono`) VALUES
('11111111A', 'Catalina', 'Garrido Nuñez', 958523024),
('22222222B', 'Jorge', 'Bazan Fernandez', 700421921),
('33333333C', 'Sara', 'Herrero Hidalgo', 600254351),
('44444444D', 'Jesus', 'Muros Navarro', 983351215);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquinas`
--

CREATE TABLE IF NOT EXISTS `maquinas` (
`id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `maquinas`
--

INSERT INTO `maquinas` (`id`, `nombre`) VALUES
(1, 'cinta estatica'),
(2, 'banca de abdominales'),
(3, 'bici estatica'),
(4, 'saco de boxeo'),
(5, 'palo'),
(6, 'maquina biceps');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE IF NOT EXISTS `reservas` (
  `id_usuario` varchar(9) NOT NULL,
  `id_maquina` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id_usuario`, `id_maquina`, `fecha`, `hora`) VALUES
('11111111A', 3, '2014-02-02', '14:50:00'),
('11111111A', 4, '2014-12-10', '00:01:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
 ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `maquinas`
--
ALTER TABLE `maquinas`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
 ADD PRIMARY KEY (`id_usuario`,`id_maquina`,`fecha`), ADD UNIQUE KEY `fecha` (`fecha`), ADD UNIQUE KEY `fecha_2` (`fecha`), ADD KEY `fk_maquina` (`id_maquina`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `maquinas`
--
ALTER TABLE `maquinas`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`id_usuario`) REFERENCES `clientes` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_maquina` FOREIGN KEY (`id_maquina`) REFERENCES `maquinas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
