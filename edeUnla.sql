-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema edeunla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `edeunla` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Table `edeunla`.`inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`inspector` (
  `nroLegajo` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  PRIMARY KEY (`nroLegajo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`contacto` (
  `idContacto` INT(11) NOT NULL AUTO_INCREMENT,
  `telefono` VARCHAR(20) NOT NULL,
  `movil` VARCHAR(20) NOT NULL,
  `domicilio` VARCHAR(30) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idContacto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`cliente` (
  `nroCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `idContacto` INT(11) NOT NULL,
  PRIMARY KEY (`nroCliente`),
  INDEX `fkContacto_idx` (`idContacto` ASC),
  CONSTRAINT `fkContacto`
    FOREIGN KEY (`idContacto`)
    REFERENCES `edeunla`.`contacto` (`idContacto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`medidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`medidor` (
  `nroSerie` INT(11) NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `energiaConsumida` DECIMAL(8,2) NOT NULL,
  `nroCliente` INT(11) NOT NULL,
  PRIMARY KEY (`nroSerie`),
  INDEX `fkCliente_idx` (`nroCliente` ASC),
  CONSTRAINT `fkCliente`
    FOREIGN KEY (`nroCliente`)
    REFERENCES `edeunla`.`cliente` (`nroCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`lectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`lectura` (
  `idLectura` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `nroSerie` INT(11) NOT NULL,
  `nroLegajo` INT(11) NOT NULL,
  `factura_nroFactura` INT(11) NOT NULL,
  PRIMARY KEY (`idLectura`),
  INDEX `fkMedidor_idx` (`nroSerie` ASC),
  INDEX `fkInspector_idx` (`nroLegajo` ASC),
  INDEX `fk_lectura_factura1_idx` (`factura_nroFactura` ASC),
  CONSTRAINT `fk_lectura_factura1`
    FOREIGN KEY (`factura_nroFactura`)
    REFERENCES `edeunla`.`factura` (`nroFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nroLegajo`
    FOREIGN KEY (`nroLegajo`)
    REFERENCES `edeunla`.`inspector` (`nroLegajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nroSerie`
    FOREIGN KEY (`nroSerie`)
    REFERENCES `edeunla`.`medidor` (`nroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`altalectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`altalectura` (
  `idAltaLectura` INT(11) NOT NULL,
  `consumoHoraValle` INT(11) NOT NULL,
  `consumoHoraPico` INT(11) NOT NULL,
  `consumoHoraResto` INT(11) NOT NULL,
  PRIMARY KEY (`idAltaLectura`),
  CONSTRAINT `fkLectura`
    FOREIGN KEY (`idAltaLectura`)
    REFERENCES `edeunla`.`lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`bajalectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`bajalectura` (
  `idBajaLectura` INT(11) NOT NULL,
  `consumo` INT(11) NOT NULL,
  PRIMARY KEY (`idBajaLectura`),
  CONSTRAINT `idBajaLectura`
    FOREIGN KEY (`idBajaLectura`)
    REFERENCES `edeunla`.`lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`clientealtademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`clientealtademanda` (
  `idClienteAltaDemanda` INT(11) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  `cuit` VARCHAR(45) NOT NULL,
  `potencia` INT(11) NOT NULL,
  `tension` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idClienteAltaDemanda`),
  CONSTRAINT `fkClienteAltaDemanda_1`
    FOREIGN KEY (`idClienteAltaDemanda`)
    REFERENCES `edeunla`.`cliente` (`nroCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`clientebajademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`clientebajademanda` (
  `idClienteBajaDemanda` INT(11) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` INT(11) NOT NULL,
  PRIMARY KEY (`idClienteBajaDemanda`),
  CONSTRAINT `fkClienteBajaDemanda_1`
    FOREIGN KEY (`idClienteBajaDemanda`)
    REFERENCES `edeunla`.`cliente` (`nroCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `edeunla`.`zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`zona` (
  `idZona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nroSerie` INT(11) NOT NULL,
  PRIMARY KEY (`idZona`),
  INDEX `fkMedidor_idx` (`nroSerie` ASC),
  CONSTRAINT `fkMedidor`
    FOREIGN KEY (`nroSerie`)
    REFERENCES `edeunla`.`medidor` (`nroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `edeunla`.`inspectorxzona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`inspectorxzona` (
  `nroLegajo` INT(11) NOT NULL,
  `idZona` INT(11) NOT NULL,
  PRIMARY KEY (`nroLegajo`, `idZona`),
  INDEX `fk_inspector_has_zona_zona1_idx` (`idZona` ASC),
  INDEX `fk_inspector_has_cliente_inspector1_idx` (`nroLegajo` ASC),
  CONSTRAINT `fk_inspector_has_zona_inspector1`
    FOREIGN KEY (`nroLegajo`)
    REFERENCES `edeunla`.`inspector` (`nroLegajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inspector_has_zona_zona1`
    FOREIGN KEY (`idZona`)
    REFERENCES `edeunla`.`zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `edeunla`.`itemfactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edeunla`.`itemfactura` (
  `idItemFactura` INT(11) NOT NULL AUTO_INCREMENT,
  `detalle` VARCHAR(45) NOT NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `nroFactura` INT(11) NOT NULL,
  PRIMARY KEY (`idItemFactura`),
  INDEX `fkFactura_idx` (`nroFactura` ASC),
  CONSTRAINT `fkFactura`
    FOREIGN KEY (`nroFactura`)
    REFERENCES `edeunla`.`factura` (`nroFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
