delimiter $$

CREATE DATABASE `biblioteca` /*!40100 DEFAULT CHARACTER SET latin1 */$$
delimiter $$

CREATE TABLE `departamento` (
  `CodigoDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `NomeDepartamento` varchar(45) DEFAULT NULL,
  `CodigoChefeDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodigoDepartamento`),
  KEY `FKFuncionarioChefe` (`CodigoChefeDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `editora` (
  `CodigoEditora` int(11) NOT NULL AUTO_INCREMENT,
  `NomeEditora` varchar(45) DEFAULT NULL,
  `CidadeEditora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CodigoEditora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `funcionario` (
  `NumeroMatricula` int(11) NOT NULL,
  `NomeCompleto` varchar(45) DEFAULT NULL,
  `CodigoDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`NumeroMatricula`),
  KEY `FKCodigoDepartamento` (`CodigoDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$



