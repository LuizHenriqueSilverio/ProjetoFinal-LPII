-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
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


-- Copiando estrutura do banco de dados para lojadepartamento
DROP DATABASE IF EXISTS `lojadepartamento`;
CREATE DATABASE IF NOT EXISTS `lojadepartamento` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;
USE `lojadepartamento`;

-- Copiando estrutura para tabela lojadepartamento.clientes
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `codCLIENTES` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(50) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codCLIENTES`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Copiando dados para a tabela lojadepartamento.clientes: ~0 rows (aproximadamente)
INSERT INTO `clientes` (`codCLIENTES`, `cpf`, `nome`, `dataNascimento`, `telefone`, `endereco`) VALUES
	(2, '123.456.789-10', 'Gabriel Caproni', '2003-08-14', '(35) 4002-8922', 'Rua Pica-Pau, nº 48, Centro, Carvalhópolis-MG');

-- Copiando estrutura para tabela lojadepartamento.estoque
DROP TABLE IF EXISTS `estoque`;
CREATE TABLE IF NOT EXISTS `estoque` (
  `codESTOQUE` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` double NOT NULL,
  `dataValidade` date DEFAULT NULL,
  `lote` varchar(200) DEFAULT NULL,
  `PRODUTOS_codPRODUTOS` int(11) NOT NULL,
  PRIMARY KEY (`codESTOQUE`,`PRODUTOS_codPRODUTOS`),
  KEY `fk_ESTOQUE_PRODUTOS1_idx` (`PRODUTOS_codPRODUTOS`),
  CONSTRAINT `fk_ESTOQUE_PRODUTOS1` FOREIGN KEY (`PRODUTOS_codPRODUTOS`) REFERENCES `produtos` (`codPRODUTOS`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Copiando dados para a tabela lojadepartamento.estoque: ~1 rows (aproximadamente)
INSERT INTO `estoque` (`codESTOQUE`, `quantidade`, `dataValidade`, `lote`, `PRODUTOS_codPRODUTOS`) VALUES
	(1, 100, NULL, '0001', 1);

-- Copiando estrutura para tabela lojadepartamento.funcionarios
DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `codFUNCIONARIOS` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `cpf` varchar(200) NOT NULL,
  `dataAdmissao` date NOT NULL,
  `dataRescisao` date DEFAULT NULL,
  `departamento` varchar(200) NOT NULL,
  `salario` double NOT NULL,
  `cargo` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`codFUNCIONARIOS`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Copiando dados para a tabela lojadepartamento.funcionarios: ~1 rows (aproximadamente)
INSERT INTO `funcionarios` (`codFUNCIONARIOS`, `nome`, `cpf`, `dataAdmissao`, `dataRescisao`, `departamento`, `salario`, `cargo`) VALUES
	(2, 'Guilherme', '222.222.222-22', '2023-02-01', NULL, 'Vendas', 5500, 'Gerente');

-- Copiando estrutura para tabela lojadepartamento.produtos
DROP TABLE IF EXISTS `produtos`;
CREATE TABLE IF NOT EXISTS `produtos` (
  `codPRODUTOS` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(300) NOT NULL,
  `precoCusto` double NOT NULL,
  `precoVenda` double NOT NULL,
  PRIMARY KEY (`codPRODUTOS`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Copiando dados para a tabela lojadepartamento.produtos: ~0 rows (aproximadamente)
INSERT INTO `produtos` (`codPRODUTOS`, `descricao`, `precoCusto`, `precoVenda`) VALUES
	(1, 'Notebook Dell i5, 8GB RAM, SSD 512GB, Tela 17"', 2750.75, 3440.85);

-- Copiando estrutura para tabela lojadepartamento.venda
DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `codVENDA` int(11) NOT NULL AUTO_INCREMENT,
  `valorVenda` double NOT NULL,
  `dataVenda` date NOT NULL,
  `FUNCIONARIOS_codFUNCIONARIOS` int(11) NOT NULL,
  `CLIENTES_codCLIENTES` int(11) NOT NULL,
  PRIMARY KEY (`codVENDA`,`FUNCIONARIOS_codFUNCIONARIOS`,`CLIENTES_codCLIENTES`),
  KEY `fk_VENDA_FUNCIONARIOS1_idx` (`FUNCIONARIOS_codFUNCIONARIOS`),
  KEY `fk_VENDA_CLIENTES1_idx` (`CLIENTES_codCLIENTES`),
  CONSTRAINT `fk_VENDA_CLIENTES1` FOREIGN KEY (`CLIENTES_codCLIENTES`) REFERENCES `clientes` (`codCLIENTES`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_VENDA_FUNCIONARIOS1` FOREIGN KEY (`FUNCIONARIOS_codFUNCIONARIOS`) REFERENCES `funcionarios` (`codFUNCIONARIOS`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Copiando dados para a tabela lojadepartamento.venda: ~1 rows (aproximadamente)
INSERT INTO `venda` (`codVENDA`, `valorVenda`, `dataVenda`, `FUNCIONARIOS_codFUNCIONARIOS`, `CLIENTES_codCLIENTES`) VALUES
	(1, 3440.85, '2023-04-15', 2, 2);

-- Copiando estrutura para tabela lojadepartamento.vendasprodutos
DROP TABLE IF EXISTS `vendasprodutos`;
CREATE TABLE IF NOT EXISTS `vendasprodutos` (
  `VENDA_codVENDA` int(11) NOT NULL,
  `PRODUTOS_codPRODUTOS` int(11) NOT NULL,
  `quantidade` double NOT NULL,
  PRIMARY KEY (`VENDA_codVENDA`,`PRODUTOS_codPRODUTOS`),
  KEY `fk_VENDA_has_PRODUTOS_PRODUTOS1_idx` (`PRODUTOS_codPRODUTOS`),
  KEY `fk_VENDA_has_PRODUTOS_VENDA_idx` (`VENDA_codVENDA`),
  CONSTRAINT `fk_VENDA_has_PRODUTOS_PRODUTOS1` FOREIGN KEY (`PRODUTOS_codPRODUTOS`) REFERENCES `produtos` (`codPRODUTOS`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_VENDA_has_PRODUTOS_VENDA` FOREIGN KEY (`VENDA_codVENDA`) REFERENCES `venda` (`codVENDA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- Copiando dados para a tabela lojadepartamento.vendasprodutos: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
