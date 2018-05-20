-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema MarketPlaceDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MarketPlaceDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MarketPlaceDB` DEFAULT CHARACTER SET utf8 ;
USE `MarketPlaceDB` ;

-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ProductCategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ProductCategory` (
  `idCategory` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Retailer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Retailer` (
  `idRetailer` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRetailer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Product` (
  `idProduct` INT NOT NULL,
  `idRetailer` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `idCategory` INT NULL,
  `price` VARCHAR(45) NULL,
  `brandName` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  PRIMARY KEY (`idProduct`, `idRetailer`),
  INDEX `fk_store_id_idx` (`idRetailer` ASC),
  INDEX `fk_category_id_idx` (`idCategory` ASC),
  CONSTRAINT `fk_store_id`
    FOREIGN KEY (`idRetailer`)
    REFERENCES `MarketPlaceDB`.`Retailer` (`idRetailer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_id`
    FOREIGN KEY (`idCategory`)
    REFERENCES `MarketPlaceDB`.`ProductCategory` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Colour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Colour` (
  `colour_id` INT NOT NULL,
  `colour_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`colour_id`));


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ProductColour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ProductColour` (
  `idProduct` INT NOT NULL,
  `idColour` INT NOT NULL,
  PRIMARY KEY (`idProduct`, `idColour`),
  INDEX `fk_colour_id_idx` (`idColour` ASC),
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_colour_id`
    FOREIGN KEY (`idColour`)
    REFERENCES `MarketPlaceDB`.`Colour` (`colour_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Image` (
  `idProduct` INT NOT NULL,
  `imageUrl` VARCHAR(45) NULL,
  CONSTRAINT `fk_Images_1`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Country` (
  `idCountry` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCountry`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Group` (
  `idGroup` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idGroup`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`User` (
  `idUser` INT NOT NULL,
  `usernamename` VARCHAR(45) NOT NULL,
  `passwordHashSum` VARCHAR(45) NOT NULL,
  `birthDate` DATE NOT NULL,
  `gender` TINYINT(1) NOT NULL,
  `registartionDate` DATETIME NOT NULL,
  `idCountry` INT NULL,
  `idGroup` INT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `passwordHashSum_UNIQUE` (`passwordHashSum` ASC),
  UNIQUE INDEX `nickname_UNIQUE` (`usernamename` ASC),
  INDEX `fk_Users_1_idx` (`idCountry` ASC),
  INDEX `fk_Users_2_idx` (`idGroup` ASC),
  CONSTRAINT `fk_Users_1`
    FOREIGN KEY (`idCountry`)
    REFERENCES `MarketPlaceDB`.`Country` (`idCountry`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_2`
    FOREIGN KEY (`idGroup`)
    REFERENCES `MarketPlaceDB`.`Group` (`idGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`CategorySize`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`CategorySize` (
  `idCategorySize` INT NOT NULL,
  `idCategory` INT NOT NULL,
  `ruSize` INT NOT NULL,
  `ukSize` INT NOT NULL,
  `usSize` INT NOT NULL,
  `euSize` INT NOT NULL,
  `itSize` INT NOT NULL,
  UNIQUE INDEX `ruSize_UNIQUE` (`ruSize` ASC),
  UNIQUE INDEX `ukSize_UNIQUE` (`ukSize` ASC),
  UNIQUE INDEX `usSize_UNIQUE` (`usSize` ASC),
  UNIQUE INDEX `euSize_UNIQUE` (`euSize` ASC),
  UNIQUE INDEX `itSize_UNIQUE` (`itSize` ASC),
  PRIMARY KEY (`idCategorySize`),
  UNIQUE INDEX `idSize_UNIQUE` (`idCategorySize` ASC),
  CONSTRAINT `fk_ClothingSizes_1`
    FOREIGN KEY (`idCategory`)
    REFERENCES `MarketPlaceDB`.`ProductCategory` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ActiveSearch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ActiveSearch` (
  `idActiveSearch` INT NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `idUser` INT NOT NULL,
  `idCategory` INT NULL,
  `idColour` INT NULL,
  `idCategorySize` INT NULL,
  INDEX `fk_ActiveSearch_1_idx` (`idUser` ASC),
  INDEX `fk_ActiveSearch_2_idx` (`idCategory` ASC),
  INDEX `fk_ActiveSearch_3_idx` (`idColour` ASC),
  INDEX `fk_ActiveSearch_4_idx` (`idCategorySize` ASC),
  PRIMARY KEY (`idActiveSearch`),
  CONSTRAINT `fk_ActiveSearch_1`
    FOREIGN KEY (`idUser`)
    REFERENCES `MarketPlaceDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ActiveSearch_2`
    FOREIGN KEY (`idCategory`)
    REFERENCES `MarketPlaceDB`.`ProductCategory` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ActiveSearch_3`
    FOREIGN KEY (`idColour`)
    REFERENCES `MarketPlaceDB`.`Colour` (`colour_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ActiveSearch_4`
    FOREIGN KEY (`idCategorySize`)
    REFERENCES `MarketPlaceDB`.`CategorySize` (`idCategorySize`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ProductSize`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ProductSize` (
  `idProduct` INT NOT NULL,
  `idSize` INT NOT NULL,
  PRIMARY KEY (`idProduct`, `idSize`),
  INDEX `fk_ProductSizes_1_idx` (`idSize` ASC),
  CONSTRAINT `fk_ProductSizes_1`
    FOREIGN KEY (`idSize`)
    REFERENCES `MarketPlaceDB`.`CategorySize` (`idCategorySize`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProductSizes_2`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`UserBookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`UserBookmark` (
  `idUser` INT NOT NULL,
  `idProduct` INT NOT NULL,
  PRIMARY KEY (`idUser`, `idProduct`),
  INDEX `fk_UserBookmarks_1_idx` (`idProduct` ASC),
  CONSTRAINT `fk_UserBookmarks_1`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserBookmarks_2`
    FOREIGN KEY (`idUser`)
    REFERENCES `MarketPlaceDB`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
