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
delimiter $$

CREATE TABLE `autor` (
  `CodigoAutor` int(11) NOT NULL AUTO_INCREMENT,
  `NomeAutor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CodigoAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `obra` (
  `CodigoObra` int(11) NOT NULL AUTO_INCREMENT,
  `TituloObra` varchar(45) DEFAULT NULL,
  `CodigoAutorPrincipal` int(11) DEFAULT NULL,
  `AnoPublicacaoObra` varchar(5) DEFAULT NULL,
  `SituacaoObra` varchar(30) DEFAULT NULL,
  `CodigoEditoraObra` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodigoObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `autor_obra` (
  `CodigoAutorObra` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoAutor` int(11) DEFAULT NULL,
  `CodigoObra` int(11) DEFAULT NULL,
  `OrdemAutor` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodigoAutorObra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$

CREATE TABLE `exemplar` (
  `CodigoExemplar` int(11) NOT NULL,
  `CodigoObra` int(11) NOT NULL,
  `DataAquisicaoExemplar` datetime DEFAULT NULL,
  `SituacaoExemplar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CodigoExemplar`,`CodigoObra`)
)