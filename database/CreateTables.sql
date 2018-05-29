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
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Retailer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Retailer` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `rootUrl` VARCHAR(45) NOT NULL,
  `parserClassName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rootUrl_UNIQUE` (`rootUrl` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `ParserClassName_UNIQUE` (`parserClassName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Gender` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Country` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Product` (
  `id` BIGINT NOT NULL,
  `idRetailer` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `idCategory` BIGINT NOT NULL,
  `price` DECIMAL NOT NULL,
  `priceCurrency` VARCHAR(45) NOT NULL,
  `brandName` VARCHAR(45) NOT NULL,
  `url` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NOT NULL,
  `idGender` BIGINT NULL,
  `manufacturedCountryId` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_store_id_idx` (`idRetailer` ASC),
  INDEX `fk_category_id_idx` (`idCategory` ASC),
  INDEX `fk_Product_1_idx` (`idGender` ASC),
  INDEX `fk_Product_3_idx` (`manufacturedCountryId` ASC),
  CONSTRAINT `fk_store_id`
    FOREIGN KEY (`idRetailer`)
    REFERENCES `MarketPlaceDB`.`Retailer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_id`
    FOREIGN KEY (`idCategory`)
    REFERENCES `MarketPlaceDB`.`ProductCategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_1`
    FOREIGN KEY (`idGender`)
    REFERENCES `MarketPlaceDB`.`Gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_3`
    FOREIGN KEY (`manufacturedCountryId`)
    REFERENCES `MarketPlaceDB`.`Country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`Colour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`Colour` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NULL,
  `hex` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `hex_UNIQUE` (`hex` ASC));


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ProductColour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ProductColour` (
  `id` BIGINT NOT NULL,
  `idProduct` BIGINT NOT NULL,
  `idColour` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_colour_id_idx` (`idColour` ASC),
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_colour_id`
    FOREIGN KEY (`idColour`)
    REFERENCES `MarketPlaceDB`.`Colour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ProductImage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ProductImage` (
  `id` BIGINT NOT NULL,
  `idProduct` BIGINT NOT NULL,
  `imageUrl` VARCHAR(45) NOT NULL,
  `createdAt` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Images_1`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`UserGroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`UserGroup` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`User` (
  `id` BIGINT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `birthDate` DATE NULL,
  `idGender` BIGINT NULL,
  `registartionDate` DATETIME NOT NULL,
  `idCountry` BIGINT NULL,
  `idGroup` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `passwordHashSum_UNIQUE` (`password` ASC),
  UNIQUE INDEX `nickname_UNIQUE` (`username` ASC),
  INDEX `fk_Users_2_idx` (`idGroup` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_Users_1_idx` (`idCountry` ASC),
  INDEX `fk_User_1_idx` (`idGender` ASC),
  CONSTRAINT `fk_Users_1`
    FOREIGN KEY (`idCountry`)
    REFERENCES `MarketPlaceDB`.`Country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_2`
    FOREIGN KEY (`idGroup`)
    REFERENCES `MarketPlaceDB`.`UserGroup` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_1`
    FOREIGN KEY (`idGender`)
    REFERENCES `MarketPlaceDB`.`Gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ActiveSearch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ActiveSearch` (
  `id` BIGINT NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `idUser` BIGINT NOT NULL,
  `idCategory` BIGINT NULL,
  `idColour` BIGINT NULL,
  `idCategorySize` BIGINT NULL,
  INDEX `fk_ActiveSearch_1_idx` (`idUser` ASC),
  INDEX `fk_ActiveSearch_2_idx` (`idCategory` ASC),
  INDEX `fk_ActiveSearch_3_idx` (`idColour` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ActiveSearch_1`
    FOREIGN KEY (`idUser`)
    REFERENCES `MarketPlaceDB`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ActiveSearch_2`
    FOREIGN KEY (`idCategory`)
    REFERENCES `MarketPlaceDB`.`ProductCategory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ActiveSearch_3`
    FOREIGN KEY (`idColour`)
    REFERENCES `MarketPlaceDB`.`Colour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`ProductSize`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`ProductSize` (
  `id` BIGINT NOT NULL,
  `idProduct` BIGINT NOT NULL,
  `size` VARCHAR(45) NOT NULL,
  `sizeCounrtyId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ProductSize_1_idx` (`sizeCounrtyId` ASC),
  CONSTRAINT `fk_ProductSizes_2`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProductSize_1`
    FOREIGN KEY (`sizeCounrtyId`)
    REFERENCES `MarketPlaceDB`.`Country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MarketPlaceDB`.`UserBookmark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MarketPlaceDB`.`UserBookmark` (
  `id` BIGINT NOT NULL,
  `idUser` BIGINT NOT NULL,
  `idProduct` BIGINT NOT NULL,
  `createdAt` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_UserBookmarks_1_idx` (`idProduct` ASC),
  CONSTRAINT `fk_UserBookmarks_1`
    FOREIGN KEY (`idProduct`)
    REFERENCES `MarketPlaceDB`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserBookmarks_2`
    FOREIGN KEY (`idUser`)
    REFERENCES `MarketPlaceDB`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
