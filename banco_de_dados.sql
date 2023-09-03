-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.51 - MySQL Community Server (GPL)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para ahoy
DROP DATABASE IF EXISTS `ahoy`;
CREATE DATABASE IF NOT EXISTS `ahoy` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ahoy`;

-- Copiando estrutura para tabela ahoy.Agente
DROP TABLE IF EXISTS `Agente`;
CREATE TABLE IF NOT EXISTS `Agente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `id_arquivo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_arquivo_agente` (`id_arquivo`),
  CONSTRAINT `id_arquivo_agente` FOREIGN KEY (`id_arquivo`) REFERENCES `Arquivo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2237 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela ahoy.Arquivo
DROP TABLE IF EXISTS `Arquivo`;
CREATE TABLE IF NOT EXISTS `Arquivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela ahoy.Compra
DROP TABLE IF EXISTS `Compra`;
CREATE TABLE IF NOT EXISTS `Compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `id_regiao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_regiao_compra` (`id_regiao`),
  CONSTRAINT `id_regiao_compra` FOREIGN KEY (`id_regiao`) REFERENCES `Regiao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62581 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela ahoy.Geracao
DROP TABLE IF EXISTS `Geracao`;
CREATE TABLE IF NOT EXISTS `Geracao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `id_regiao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_regiao` (`id_regiao`),
  CONSTRAINT `id_regiao` FOREIGN KEY (`id_regiao`) REFERENCES `Regiao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62553 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela ahoy.Preco_Medio
DROP TABLE IF EXISTS `Preco_Medio`;
CREATE TABLE IF NOT EXISTS `Preco_Medio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `id_regiao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_regiao_preco` (`id_regiao`),
  CONSTRAINT `id_regiao_preco` FOREIGN KEY (`id_regiao`) REFERENCES `Regiao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62553 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela ahoy.Regiao
DROP TABLE IF EXISTS `Regiao`;
CREATE TABLE IF NOT EXISTS `Regiao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sigla` varchar(10) NOT NULL,
  `id_agente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_agente_regiao` (`id_agente`),
  CONSTRAINT `id_agente_regiao` FOREIGN KEY (`id_agente`) REFERENCES `Agente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8941 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
