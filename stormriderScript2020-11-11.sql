-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema stormrider
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `stormrider` ;

-- -----------------------------------------------------
-- Schema stormrider
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stormrider` DEFAULT CHARACTER SET utf8 ;
USE `stormrider` ;

-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(80) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(120) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `cvr_number` VARCHAR(10) NULL,
  `company_name` VARCHAR(120) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_group` ;

CREATE TABLE IF NOT EXISTS `product_group` (
  `product_group_id` INT NOT NULL AUTO_INCREMENT,
  `base_price` DOUBLE NOT NULL,
  `vat` DOUBLE NOT NULL,
  PRIMARY KEY (`product_group_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filling`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filling` ;

CREATE TABLE IF NOT EXISTS `filling` (
  `filling_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`filling_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `color` ;

CREATE TABLE IF NOT EXISTS `color` (
  `color_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`color_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `size`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `size` ;

CREATE TABLE IF NOT EXISTS `size` (
  `size_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`size_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gender` ;

CREATE TABLE IF NOT EXISTS `gender` (
  `gender_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`gender_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `inventory` SMALLINT NOT NULL,
  `gender_id` INT NULL,
  `product_group_id` INT NOT NULL,
  `filling_id` INT NULL,
  `color_id` INT NULL,
  `size_id` INT NULL,
  `last_updated` DATE NOT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `product_product_group_id`
    FOREIGN KEY (`product_group_id`)
    REFERENCES `product_group` (`product_group_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `product_filling_id`
    FOREIGN KEY (`filling_id`)
    REFERENCES `filling` (`filling_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `product_color_id`
    FOREIGN KEY (`color_id`)
    REFERENCES `color` (`color_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `product_size_id`
    FOREIGN KEY (`size_id`)
    REFERENCES `size` (`size_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `product_gender_id`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gender` (`gender_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `productgroup_id_idx` ON `product` (`product_group_id` ASC) VISIBLE;

CREATE INDEX `size_id_idx` ON `product` (`size_id` ASC) VISIBLE;

CREATE INDEX `color_id_idx` ON `product` (`color_id` ASC) VISIBLE;

CREATE INDEX `filling_id_idx` ON `product` (`filling_id` ASC) VISIBLE;

CREATE INDEX `fk_gender_id_idx` ON `product` (`gender_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `zip` VARCHAR(15) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(56) NOT NULL,
  `county` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart` ;

CREATE TABLE IF NOT EXISTS `cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL,
  `total_price` DOUBLE NULL,
  `vat` DOUBLE NULL,
  `total_discount` DOUBLE NULL,
  `billing_address_id` INT NULL,
  `shipping_address_id` INT NULL,
  `customer_id` INT NULL,
  `created` DATE NULL,
  `voucher_id` INT NULL,
  PRIMARY KEY (`cart_id`),
  CONSTRAINT `cart_customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer` (`customer_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `cart_billing_address_id`
    FOREIGN KEY (`billing_address_id`)
    REFERENCES `address` (`address_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `cart_shipping_address_id`
    FOREIGN KEY (`shipping_address_id`)
    REFERENCES `address` (`address_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `customer_id_idx` ON `cart` (`customer_id` ASC) VISIBLE;

CREATE INDEX `billing_address_id_idx` ON `cart` (`billing_address_id` ASC) VISIBLE;

CREATE INDEX `shipping_address_id_idx` ON `cart` (`shipping_address_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subcategory` ;

CREATE TABLE IF NOT EXISTS `subcategory` (
  `sub_category_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sub_category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `admin` ;

CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `invoice` ;

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `cart_id` INT NOT NULL,
  `status` VARCHAR(25) NOT NULL,
  `payment_method` VARCHAR(45) NOT NULL,
  `paid` TINYINT(1) NOT NULL,
  PRIMARY KEY (`invoice_id`),
  CONSTRAINT `invoice_cart_id`
    FOREIGN KEY (`cart_id`)
    REFERENCES `cart` (`cart_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `cart_id_idx` ON `invoice` (`cart_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `cart_has_products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart_has_products` ;

CREATE TABLE IF NOT EXISTS `cart_has_products` (
  `cart_has_product_id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `amount` INT NOT NULL,
  `cart_id` INT NOT NULL,
  PRIMARY KEY (`cart_has_product_id`),
  CONSTRAINT `cart_has_products_cart_id`
    FOREIGN KEY (`cart_id`)
    REFERENCES `cart` (`cart_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `cart_has_products_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`product_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `cart_id_idx` ON `cart_has_products` (`cart_id` ASC) VISIBLE;

CREATE INDEX `product_id_idx` ON `cart_has_products` (`product_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `app_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `app_language` ;

CREATE TABLE IF NOT EXISTS `app_language` (
  `code` CHAR(2) NOT NULL,
  `language` VARCHAR(20) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category_language` ;

CREATE TABLE IF NOT EXISTS `category_language` (
  `category_language_id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `app_language_code` CHAR(2) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`category_language_id`),
  CONSTRAINT `category_language_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`category_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `category_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_category_id_idx` ON `category_language` (`category_id` ASC) VISIBLE;

CREATE INDEX `fk_app_language_code_idx` ON `category_language` (`app_language_code` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `subcategory_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subcategory_language` ;

CREATE TABLE IF NOT EXISTS `subcategory_language` (
  `category_language_id` INT NOT NULL AUTO_INCREMENT,
  `subcategory_id` INT NOT NULL,
  `app_language_code` CHAR(2) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`category_language_id`),
  CONSTRAINT `subcategory_language_subcategory_id`
    FOREIGN KEY (`subcategory_id`)
    REFERENCES `subcategory` (`sub_category_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `subcategory_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_app_language_code_idx` ON `subcategory_language` (`app_language_code` ASC) VISIBLE;

CREATE INDEX `fk_subcategory_id_idx` ON `subcategory_language` (`subcategory_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `product_group_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_group_language` ;

CREATE TABLE IF NOT EXISTS `product_group_language` (
  `product_group_language_id` INT NOT NULL AUTO_INCREMENT,
  `product_group_id` INT NOT NULL,
  `product_group_description` VARCHAR(500) NULL,
  `product_group_name` VARCHAR(100) NOT NULL,
  `app_language_code` CHAR(2) NOT NULL,
  PRIMARY KEY (`product_group_language_id`),
  CONSTRAINT `product_group_language_product_group_id`
    FOREIGN KEY (`product_group_id`)
    REFERENCES `product_group` (`product_group_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `product_group_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_product_group_id_idx` ON `product_group_language` (`product_group_id` ASC) VISIBLE;

CREATE INDEX `fk_app_language_code_idx` ON `product_group_language` (`app_language_code` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `gender_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gender_language` ;

CREATE TABLE IF NOT EXISTS `gender_language` (
  `gender_language_id` INT NOT NULL AUTO_INCREMENT,
  `app_language_code` CHAR(2) NOT NULL,
  `gender_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`gender_language_id`),
  CONSTRAINT `gender_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `gender_language_gender_id`
    FOREIGN KEY (`gender_id`)
    REFERENCES `gender` (`gender_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_app_language_code_idx` ON `gender_language` (`app_language_code` ASC) VISIBLE;

CREATE INDEX `fk_gender_id_idx` ON `gender_language` (`gender_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `size_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `size_language` ;

CREATE TABLE IF NOT EXISTS `size_language` (
  `size_language_id` INT NOT NULL AUTO_INCREMENT,
  `size_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `app_language_code` CHAR(2) NOT NULL,
  PRIMARY KEY (`size_language_id`),
  CONSTRAINT `size_language_size_id`
    FOREIGN KEY (`size_id`)
    REFERENCES `size` (`size_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `size_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_size_id_idx` ON `size_language` (`size_id` ASC) VISIBLE;

CREATE INDEX `fk_app_language_code_idx` ON `size_language` (`app_language_code` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `color_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `color_language` ;

CREATE TABLE IF NOT EXISTS `color_language` (
  `color_language_id` INT NOT NULL AUTO_INCREMENT,
  `app_language_code` CHAR(2) NOT NULL,
  `color_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`color_language_id`),
  CONSTRAINT `color_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `color_language_color_id`
    FOREIGN KEY (`color_id`)
    REFERENCES `color` (`color_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_app_language_code_idx` ON `color_language` (`app_language_code` ASC) VISIBLE;

CREATE INDEX `fk_color_id_idx` ON `color_language` (`color_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `filling_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filling_language` ;

CREATE TABLE IF NOT EXISTS `filling_language` (
  `filling_language_id` INT NOT NULL AUTO_INCREMENT,
  `app_language_code` CHAR(2) NOT NULL,
  `filling_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`filling_language_id`),
  CONSTRAINT `filling_language_app_language_code`
    FOREIGN KEY (`app_language_code`)
    REFERENCES `app_language` (`code`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `filling_language_filling_id`
    FOREIGN KEY (`filling_id`)
    REFERENCES `filling` (`filling_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_app_language_code_idx` ON `filling_language` (`app_language_code` ASC) VISIBLE;

CREATE INDEX `fk_filling_id_idx` ON `filling_language` (`filling_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `product_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_image` ;

CREATE TABLE IF NOT EXISTS `product_image` (
  `product_image_id` INT NOT NULL AUTO_INCREMENT,
  `product_group_id` INT NOT NULL,
  `image` VARCHAR(256) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`product_image_id`),
  CONSTRAINT `product_image_product_group_id`
    FOREIGN KEY (`product_group_id`)
    REFERENCES `product_group` (`product_group_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_product_group_id_idx` ON `product_image` (`product_group_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `voucher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voucher` ;

CREATE TABLE IF NOT EXISTS `voucher` (
  `voucher_id` INT NOT NULL AUTO_INCREMENT,
  `redeem_code` VARCHAR(25) NULL,
  `valid_from` DATE NULL,
  `valid_until` DATE NULL,
  `times_used` INT NULL,
  `max_times_used` INT NULL,
  `active` TINYINT(1) NOT NULL,
  `comment` VARCHAR(255) NULL,
  PRIMARY KEY (`voucher_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voucher_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voucher_has_category` ;

CREATE TABLE IF NOT EXISTS `voucher_has_category` (
  `voucher_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`voucher_id`, `category_id`),
  CONSTRAINT `voucher_has_category_voucher_id`
    FOREIGN KEY (`voucher_id`)
    REFERENCES `voucher` (`voucher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `voucher_has_category_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `category_id_idx` ON `voucher_has_category` (`category_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `voucher_has_subcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voucher_has_subcategory` ;

CREATE TABLE IF NOT EXISTS `voucher_has_subcategory` (
  `voucher_id` INT NOT NULL,
  `subcategory_id` INT NOT NULL,
  PRIMARY KEY (`voucher_id`, `subcategory_id`),
  CONSTRAINT `voucher_has_subcategory_voucher_sub_id`
    FOREIGN KEY (`voucher_id`)
    REFERENCES `voucher` (`voucher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `voucher_has_subcategory_subcatgeory_vou_id`
    FOREIGN KEY (`subcategory_id`)
    REFERENCES `subcategory` (`sub_category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_subcatgeory_vou_id_idx` ON `voucher_has_subcategory` (`subcategory_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `voucher_has_product_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voucher_has_product_group` ;

CREATE TABLE IF NOT EXISTS `voucher_has_product_group` (
  `voucher_id` INT NOT NULL,
  `group_product_id` INT NOT NULL,
  PRIMARY KEY (`voucher_id`, `group_product_id`),
  CONSTRAINT `voucher_has_product_group_voucher_pro_gro_id`
    FOREIGN KEY (`voucher_id`)
    REFERENCES `voucher` (`voucher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `voucher_has_product_group_product_group_vou_id`
    FOREIGN KEY (`group_product_id`)
    REFERENCES `product_group` (`product_group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_product_group_vou_id_idx` ON `voucher_has_product_group` (`group_product_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `voucher_has_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voucher_has_product` ;

CREATE TABLE IF NOT EXISTS `voucher_has_product` (
  `voucher_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`voucher_id`, `product_id`),
  CONSTRAINT `voucher_has_product_voucher_pro_id`
    FOREIGN KEY (`voucher_id`)
    REFERENCES `voucher` (`voucher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `voucher_has_product_product_vou_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_product_vou_id_idx` ON `voucher_has_product` (`product_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `receipt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `receipt` ;

CREATE TABLE IF NOT EXISTS `receipt` (
  `receipt_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT NOT NULL,
  `receipt_info` VARCHAR(255) NULL,
  PRIMARY KEY (`receipt_id`),
  CONSTRAINT `receipt_invoice_id`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `invoice` (`invoice_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_invoice_id_idx` ON `receipt` (`invoice_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `product_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_order` ;

CREATE TABLE IF NOT EXISTS `product_order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `cost_unit` DOUBLE NULL,
  `unit_amount` INT NULL,
  `tax_percentage` DOUBLE NULL,
  `shipping_cost` DOUBLE NULL,
  `order_date` DATE NULL,
  `eta_date` DATE NULL,
  `comment` VARCHAR(255) NULL,
  PRIMARY KEY (`order_id`),
  CONSTRAINT `product_order_product_order_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`product_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_product_order_product_id_idx` ON `product_order` (`product_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `subcategory_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subcategory_has_category` ;

CREATE TABLE IF NOT EXISTS `subcategory_has_category` (
  `subcategory_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`subcategory_id`, `category_id`),
  CONSTRAINT `subcategory_has_category_subcategory_has_category_subcategory_id`
    FOREIGN KEY (`subcategory_id`)
    REFERENCES `subcategory` (`sub_category_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `subcategory_has_category_subcategory_has_category_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`category_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_subcategory_has_category_category_id_idx` ON `subcategory_has_category` (`category_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `product_group_has_subcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_group_has_subcategory` ;

CREATE TABLE IF NOT EXISTS `product_group_has_subcategory` (
  `product_group_id` INT NOT NULL,
  `subcategory_id` INT NOT NULL,
  PRIMARY KEY (`product_group_id`, `subcategory_id`),
  CONSTRAINT `product_group_has_subcategory_product_group_id`
    FOREIGN KEY (`product_group_id`)
    REFERENCES `product_group` (`product_group_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `product_group_has_subcategory_subcategory_id`
    FOREIGN KEY (`subcategory_id`)
    REFERENCES `subcategory` (`sub_category_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_product_group_has_subcategory_subcategory_id_idx` ON `product_group_has_subcategory` (`subcategory_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
