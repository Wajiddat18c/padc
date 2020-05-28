-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema padc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema padc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `padc` DEFAULT CHARACTER SET utf8 ;
USE `padc` ;

-- -----------------------------------------------------
-- Table `padc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`user` (
  `USER_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(128) NOT NULL,
  `PASSWORD` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`auth_user_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`auth_user_group` (
  `AUTH_USER_GROUP_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(128) NOT NULL,
  `AUTH_GROUP` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`AUTH_USER_GROUP_ID`),
  UNIQUE INDEX `USERNAME` (`USERNAME` ASC, `AUTH_GROUP` ASC) VISIBLE,
  CONSTRAINT `USER_AUTH_USER_GROUP_FK`
    FOREIGN KEY (`USERNAME`)
    REFERENCES `padc`.`user` (`USERNAME`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`basket` (
  `id_Basket` INT(11) NOT NULL AUTO_INCREMENT,
  `created` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Basket`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`categories` (
  `id_Categories` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_Categories`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`products` (
  `id_Products` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `brand` VARCHAR(100) NOT NULL,
  `pris` INT(8) NOT NULL,
  `description` VARCHAR(800) NOT NULL,
  `categories_id_Categories` INT(11) NOT NULL,
  PRIMARY KEY (`id_Products`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `productscol_UNIQUE` (`pris` ASC) VISIBLE,
  UNIQUE INDEX `brand_UNIQUE` (`brand` ASC) VISIBLE,
  INDEX `fk_products_categories_idx` (`categories_id_Categories` ASC) VISIBLE,
  CONSTRAINT `fk_products_categories`
    FOREIGN KEY (`categories_id_Categories`)
    REFERENCES `padc`.`categories` (`id_Categories`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`basketproducts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`basketproducts` (
  `idbasket_Products` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` INT(30) NOT NULL,
  `products_id_Products` INT(11) NOT NULL,
  `basket_id_Basket` INT(11) NOT NULL,
  PRIMARY KEY (`idbasket_Products`),
  INDEX `fk_basketProducts_products_idx` (`products_id_Products` ASC) VISIBLE,
  INDEX `fk_basket_idx` (`basket_id_Basket` ASC) VISIBLE,
  CONSTRAINT `fk_basketProducts_products`
    FOREIGN KEY (`products_id_Products`)
    REFERENCES `padc`.`products` (`id_Products`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_basket_id`
    FOREIGN KEY (`basket_id_Basket`)
    REFERENCES `padc`.`basket` (`id_Basket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`customerinformation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`customerinformation` (
  `idcustomer_Information` INT(11) NOT NULL AUTO_INCREMENT,
  `first_Name` VARCHAR(45) NOT NULL,
  `last_Name` VARCHAR(45) NOT NULL,
  `phone_Number` INT(11) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idcustomer_Information`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`files`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`files` (
  `id` VARCHAR(255) NOT NULL,
  `data` LONGBLOB NULL DEFAULT NULL,
  `file_name` VARCHAR(255) NULL DEFAULT NULL,
  `file_type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`newsletter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`newsletter` (
  `id_News` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_News`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`newspaper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`newspaper` (
  `idNews` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idNews`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`product_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`product_orders` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `o_date` VARCHAR(45) NOT NULL,
  `o_status` VARCHAR(45) NOT NULL,
  `o_link` VARCHAR(45) NOT NULL,
  `basket_id_basket` INT(11) NOT NULL,
  `customer_id_customer` INT(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  INDEX `fk_order_basket1_idx` (`basket_id_basket` ASC) VISIBLE,
  INDEX `fk_order_customer_idx` (`customer_id_customer` ASC) VISIBLE,
  CONSTRAINT `fk_basket_id_basket`
    FOREIGN KEY (`basket_id_basket`)
    REFERENCES `padc`.`basket` (`id_Basket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_info_id`
    FOREIGN KEY (`customer_id_customer`)
    REFERENCES `padc`.`customerinformation` (`idcustomer_Information`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`productstoimages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`productstoimages` (
  `id_Products_To_Images` INT(11) NOT NULL AUTO_INCREMENT,
  `files_id` VARCHAR(255) NULL DEFAULT NULL,
  `products_id_Products` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Products_To_Images`),
  INDEX `fk_ProductsToImages_files_idx` (`files_id` ASC) VISIBLE,
  INDEX `fk_ProductsToImages_products1_idx` (`products_id_Products` ASC) VISIBLE,
  CONSTRAINT `fk_ProductsToImages_files`
    FOREIGN KEY (`files_id`)
    REFERENCES `padc`.`files` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProductsToImages_products1`
    FOREIGN KEY (`products_id_Products`)
    REFERENCES `padc`.`products` (`id_Products`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`store` (
  `id_Store` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `opening_hours` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `vat` INT(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Store`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `address_UNIQUE` (`address` ASC) VISIBLE,
  UNIQUE INDEX `opening_hours_UNIQUE` (`opening_hours` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `description_UNIQUE` (`description` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `padc`.`termsofservice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `padc`.`termsofservice` (
  `idTermsOfService` INT(11) NOT NULL AUTO_INCREMENT,
  `termsOfServicecol` LONGTEXT NOT NULL,
  PRIMARY KEY (`idTermsOfService`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
