-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema stormrider
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `first_name` VARCHAR(80) NOT NULL COMMENT 'First name of the customer\n\ne.g. John',
  `last_name` VARCHAR(45) NOT NULL COMMENT 'Last name of the customer\n\ne.g. Green',
  `email` VARCHAR(120) NOT NULL COMMENT 'Email address of the customer\n\ne.g. john.green@gmail.com',
  `phone` VARCHAR(45) NOT NULL COMMENT 'Phone number of the customer\n\ne.g. +45 50 50 50 50 ',
  `cvr_number` VARCHAR(10) NULL COMMENT 'Company\'s registration number (only if customer represents some company)\n\ne.g. 36729929',
  `company_name` VARCHAR(120) NULL COMMENT 'Company\'s name (only if customer represents some company)\n\ne.g. Novo Nordisk',
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_group` ;

CREATE TABLE IF NOT EXISTS `product_group` (
  `product_group_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `base_price` DOUBLE NOT NULL COMMENT 'Base price (net) of the product group\n\nFull price (gross) = base_price + vat\n\ne.g. ',
  `vat` DOUBLE NOT NULL COMMENT 'VAT amount\n\nFull price (gross) = base_price + vat\n\ne.g. ',
  PRIMARY KEY (`product_group_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filling`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `filling` ;

CREATE TABLE IF NOT EXISTS `filling` (
  `filling_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  PRIMARY KEY (`filling_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `color`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `color` ;

CREATE TABLE IF NOT EXISTS `color` (
  `color_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  PRIMARY KEY (`color_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `size`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `size` ;

CREATE TABLE IF NOT EXISTS `size` (
  `size_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  PRIMARY KEY (`size_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gender` ;

CREATE TABLE IF NOT EXISTS `gender` (
  `gender_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  PRIMARY KEY (`gender_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `inventory` SMALLINT NOT NULL COMMENT 'Current amount in the invenory of the specified product\n\ne.g. 56, 0',
  `product_group_id` INT NOT NULL COMMENT 'Identifies the product group ID from the product_group table\n\nWorks as a foreign key on:\nproduct.product_group_id = product_group.product_group_id\n\ne.g. 1, 2, 3',
  `gender_id` INT NULL COMMENT 'Identifies the gender ID from the gender table\n\nWorks as a foreign key on:\nproduct.gender_id = gender.gender_id\n\ne.g. 1, 2, 3',
  `filling_id` INT NULL COMMENT 'Identifies the filling ID from the filling table\n\nWorks as a foreign key on:\nproduct.filling_id = filling.filling_id\n\ne.g. 1, 2, 3',
  `color_id` INT NULL COMMENT 'Identifies the color ID from the color table\n\nWorks as a foreign key on:\nproduct.color_id = color.color_id\n\ne.g. 1, 2, 3',
  `size_id` INT NULL COMMENT 'Identifies the size ID from the size table\n\nWorks as a foreign key on:\nproduct.size_id = size.size_id\n\ne.g. 1, 2, 3',
  `last_updated` DATE NOT NULL COMMENT 'Date when the product has been last updated\n\ne.g. ',
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
  `address_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `address` VARCHAR(100) NOT NULL COMMENT 'Adress (street, house & apartment number)\n\ne.g. Lygten 37',
  `zip` VARCHAR(15) NOT NULL COMMENT 'Zip code of the address\n\ne.g. 2400',
  `city` VARCHAR(45) NOT NULL COMMENT 'City of the address\n\ne.g. Copenhagen',
  `country` VARCHAR(56) NOT NULL COMMENT 'Country of the address\n\ne.g. Denmark',
  `county` VARCHAR(45) NOT NULL COMMENT 'County of the address\n\ne.g. ',
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cart` ;

CREATE TABLE IF NOT EXISTS `cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `status` VARCHAR(45) NULL COMMENT 'Status of the cart\n\ne.g. abandoned / ',
  `total_price` DOUBLE NOT NULL COMMENT 'Total NET price of the cart \n\ntotal_price + vat = what customer ends up paying\n\ne.g. 10000',
  `vat` DOUBLE NOT NULL COMMENT 'Total VAT (amount, not the percentage) of the cart \n\ntotal_price + vat = what customer ends up paying\n\ne.g. 2500',
  `total_discount` DOUBLE NOT NULL COMMENT 'Total amount of discount applied through the voucher (**OR PRICE REDUCTIONS ALSO COUNT?)\n\ne.g. 3000',
  `billing_address_id` INT NULL COMMENT 'Identifies the billing address ID from the address table\n\nWorks as a foreign key on:\ncart.billing_address_id = address.address_id\n\ne.g. 1, 2, 3',
  `shipping_address_id` INT NULL COMMENT 'Identifies the shipping address ID from the address table\n\nWorks as a foreign key on:\ncart.shipping_address_id = address.address_id\n\ne.g. 1, 2, 3',
  `customer_id` INT NULL COMMENT 'Identifies the customer ID from the customer table\n\nWorks as a foreign key on:\ncart.customer_id = customer.customer_id\n\ne.g. 1, 2, 3',
  `created` DATE NULL COMMENT 'Date when the cart was first created\n\ne.g. 2020-11-11',
  `voucher_id` INT NULL COMMENT 'Identifies the voucher ID from the voucher table (if used)\n\nWorks as a foreign key on:\ncart.voucher_id = voucher.voucher_id\n\ne.g. 1, 2, 3',
  `tracking_number` VARCHAR(45) NULL COMMENT 'Tracking number for the order, if it has been shipped\n\ne.g. EHT2342353456',
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
  `category_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subcategory` ;

CREATE TABLE IF NOT EXISTS `subcategory` (
  `sub_category_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  PRIMARY KEY (`sub_category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `admin` ;

CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` INT NOT NULL COMMENT 'Unique ID of each row in the table',
  `user_name` VARCHAR(45) NULL COMMENT 'Username of the admin\'s account',
  `password` VARCHAR(45) NULL COMMENT 'Password of the admin\'s account',
  `email` VARCHAR(100) NULL COMMENT 'Email address of the admin\'s account',
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `invoice` ;

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `date` DATE NOT NULL COMMENT 'Date of the Invoice (date when the cart has been purchased)\n\ne.g. 2020-11-21',
  `cart_id` INT NOT NULL COMMENT 'Identifies the cart ID from the cart table\n\nWorks as a foreign key on:\ninvoice.cart_id = cart.cart_id\n\ne.g. 1, 2, 3',
  `status` VARCHAR(25) NOT NULL COMMENT 'Status of the cart\n\ne.g. abandoned, processed, ready for shipping, shipped',
  `payment_method` VARCHAR(45) NULL COMMENT 'Payment method used\n\ne.g. mastercard',
  `paid` TINYINT(1) NOT NULL COMMENT 'Identifies whether the cart has been paid for \n\ne.g. true - paid; false - unpaid',
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
  `cart_has_product_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `product_id` INT NOT NULL COMMENT 'Identifies the product ID from the product table\n\nWorks as a foreign key on:\ncart_has_products.product_id = product.product_id\n\ne.g. 1, 2, 3',
  `amount` INT NOT NULL COMMENT 'Amount of the same product in the cart\n\ne.g. 5, 2',
  `cart_id` INT NOT NULL COMMENT 'Identifies the cart ID from the cart table\n\nWorks as a foreign key on:\ncart_has_products.cart_id = cart.cart_id\n\ne.g. 1, 2, 3',
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
  `code` CHAR(2) NOT NULL COMMENT 'Unique code of each language\n\ne.g. EN, IS',
  `language` VARCHAR(20) NULL COMMENT 'Name of the language\n\ne.g. English, Icelandic',
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category_language` ;

CREATE TABLE IF NOT EXISTS `category_language` (
  `category_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\ncategory_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `category_id` INT NOT NULL COMMENT 'Identifies the category ID from the category table\n\nWorks as a foreign key on:\ncategory_language.category_id = category.category_id\n\ne.g. 1, 2, 3',
  `name` VARCHAR(100) NOT NULL COMMENT 'Name of the category in a specified language\n\ne.g. ',
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
  `category_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\nsubcategory_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `subcategory_id` INT NOT NULL COMMENT 'Identifies the subcategory ID from the subcategory table\n\nWorks as a foreign key on:\nsubcategory_language.subcategory_id = subcategory.sub_category_id\n\ne.g. 1, 2, 3',
  `name` VARCHAR(100) NOT NULL COMMENT 'Name of the subcategory in a specified language\n\ne.g. ',
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
  `product_group_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\nproduct_group_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `product_group_id` INT NOT NULL COMMENT 'Identifies the product group ID from the product_group table\n\nWorks as a foreign key on:\nproduct_group_language.product_group_id = product_group.product_group_id\n\ne.g. 1, 2, 3',
  `product_group_name` VARCHAR(100) NOT NULL COMMENT 'Name of the product group in a specified language\n\ne.g. ',
  `product_group_description` VARCHAR(500) NULL COMMENT 'Description of the product group in a specified language\n\ne.g. ',
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
  `gender_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\ngender_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `gender_id` INT NOT NULL COMMENT 'Identifies the gender ID from the gender table\n\nWorks as a foreign key on:\ngender_language.gender_id = gender.gender_id\n\ne.g. 1, 2, 3',
  `name` VARCHAR(45) NOT NULL COMMENT 'Name of the gender in a specified language\n\ne.g. female, ',
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
  `size_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\nsize_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `size_id` INT NOT NULL COMMENT 'Identifies the size ID from the size table\n\nWorks as a foreign key on:\nsize_language.size_id = size.size_id\n\ne.g. 1, 2, 3',
  `name` VARCHAR(45) NOT NULL COMMENT 'Name of the size in a specified language\n\ne.g. ',
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
  `color_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\ncolor_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `color_id` INT NOT NULL COMMENT 'Identifies the color ID from the color table\n\nWorks as a foreign key on:\ncolor_language.color_id = color.color_id\n\ne.g. 1, 2, 3',
  `name` VARCHAR(45) NOT NULL COMMENT 'Name of the color in a specified language\n\ne.g. black, ',
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
  `filling_language_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `app_language_code` CHAR(2) NOT NULL COMMENT 'Identifies the language code from the app_language table\n\nWorks as a foreign key on:\nfilling_language.app_language_code = app_language.code\n\ne.g. EN, IS',
  `filling_id` INT NOT NULL COMMENT 'Identifies the filling ID from the filling table\n\nWorks as a foreign key on:\nfilling_language.filling_id = filling.filling_id\n\ne.g. 1, 2, 3',
  `name` VARCHAR(45) NOT NULL COMMENT 'Name of the filling in a specified language\n\ne.g. wool, ',
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
  `product_image_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `product_group_id` INT NOT NULL COMMENT 'Identifies the product group ID from the product_group table\n\nWorks as a foreign key on:\nproduct_image.product_group_id = product_group.product_group_id\n\ne.g. 1, 2, 3',
  `image` VARCHAR(256) NOT NULL COMMENT 'Link to the image\n\ne.g. ',
  `name` VARCHAR(45) NOT NULL COMMENT 'Name of the image\n\ne.g. ',
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
  `voucher_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `redeem_code` VARCHAR(25) NULL COMMENT 'Redeem code of the voucher\n\ne.g. ',
  `valid_from` DATE NULL COMMENT 'Date from when the voucher starts to be valid\n\ne.g. 2020-11-22',
  `valid_until` DATE NULL COMMENT 'Date until when the voucher is valid\n\ne.g. 2020-11-22',
  `times_used` INT NULL COMMENT 'Identifies how many times each voucher has been used\n\ne.g. 4',
  `max_times_used` INT NULL COMMENT 'Maximum limit for the times voucher can be used \n\ne.g. 10',
  `active` TINYINT(1) NOT NULL COMMENT 'Identifies whether the voucher is active\n\ne.g. true - active; false - not active',
  `comment` VARCHAR(255) NULL COMMENT 'Any additional comments (if any)\n\ne.g.',
  `discount` DOUBLE NULL COMMENT 'Discount of the voucher (in percentage)\n\ne.g. 25',
  PRIMARY KEY (`voucher_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `voucher_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `voucher_has_category` ;

CREATE TABLE IF NOT EXISTS `voucher_has_category` (
  `voucher_id` INT NOT NULL COMMENT 'Identifies the voucher ID from the voucher table (multiple rows with the same voucher ID identifies multiple categories to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_category.voucher_id = voucher.voucher_id\n\ne.g. 1, 2, 3',
  `category_id` INT NOT NULL COMMENT 'Identifies the category ID to which the voucher applies to (multiple rows with the same voucher ID identifies multiple categories to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_category.category_id = category.category_id\n\ne.g. 1, 2, 3',
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
  `voucher_id` INT NOT NULL COMMENT 'Identifies the voucher ID from the voucher table (multiple rows with the same voucher ID identifies multiple subcategories to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_subcategory.voucher_id = voucher.voucher_id\n\ne.g. 1, 2, 3',
  `subcategory_id` INT NOT NULL COMMENT 'Identifies the subcategory ID to which the voucher applies to (multiple rows with the same voucher ID identifies multiple subcategories to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_subcategory.subcategory_id = subcategory.sub_category_id\n\ne.g. 1, 2, 3',
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
  `voucher_id` INT NOT NULL COMMENT 'Identifies the voucher ID from the voucher table (multiple rows with the same voucher ID identifies multiple product groups to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_product_group.voucher_id = voucher.voucher_id\n\ne.g. 1, 2, 3',
  `group_product_id` INT NOT NULL COMMENT 'Identifies the product group ID to which the voucher applies to (multiple rows with the same voucher ID identifies multiple product groups to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_product_group.group_product_id = product_group.product_group_id\n\ne.g. 1, 2, 3',
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
  `voucher_id` INT NOT NULL COMMENT 'Identifies the voucher ID from the voucher table (multiple rows with the same voucher ID identifies multiple products to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_product.voucher_id = voucher.voucher_id\n\ne.g. 1, 2, 3',
  `product_id` INT NOT NULL COMMENT 'Identifies the product ID to which the voucher applies to (multiple rows with the same voucher ID identifies multiple products to whom it applies to)\n\nWorks as a foreign key on:\nvoucher_has_product.product_id = product.product_id\n\ne.g. 1, 2, 3',
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
  `receipt_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table\n',
  `invoice_id` INT NOT NULL COMMENT 'Identifies the invoice ID from the invoide table\n\nWorks as a foreign key on:\nreceipt.invoice_id = invoice.invoice_id\n\ne.g. 1, 2, 3',
  `receipt_info` VARCHAR(255) NULL COMMENT 'Since the receipt is generated only when the cart is paid for, it contains the general payment information \n\ne.g. ',
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
  `order_id` INT NOT NULL AUTO_INCREMENT COMMENT 'Unique ID of each row in the table',
  `status` VARCHAR(45) NULL COMMENT 'Status of the order from supplier\n\ne.g. placed, shipped, received',
  `product_id` INT NOT NULL COMMENT 'Identifies the product which has been ordered from the supplier\n\nWorks as a foreign key on:\nproduct_order.product_id = product.product_id\n\ne.g. 1, 2, 3',
  `cost_unit` DOUBLE NULL COMMENT 'GROSS price for each product\n\ncost_unit * unit_amount +  shipping_cost  = total amount of the order before tax\n\ne.g. 3200',
  `unit_amount` INT NULL COMMENT 'Amount of each product ordered\n\ncost_unit * unit_amount +  shipping_cost  = total amount of the order before tax\n\ne.g. 3200',
  `tax_percentage` DOUBLE NULL COMMENT 'Tax percentage for the whole order\n\ne.g. 25%',
  `shipping_cost` DOUBLE NULL COMMENT 'Shipping cost for the order\n\ncost_unit * unit_amount + shipping_cost = total amount of the order before tax\n\ne.g. 120',
  `order_date` DATE NULL COMMENT 'Date when the order has been placed\n\ne.g. 2020-11-22',
  `eta_date` DATE NULL COMMENT 'Estimated delivery date (after delivery - the date when delivered)\n\ne.g. 2020-11-22',
  `comment` VARCHAR(255) NULL COMMENT 'Any additional comments (if any)\n\ne.g.',
  `tracking_number` VARCHAR(45) NULL COMMENT 'Tracking number for the order, if it has been shipped\n\ne.g. EHT2342353456',
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
  `subcategory_id` INT NOT NULL COMMENT 'Identifies the subcategory ID from the subcategory table\n\nWorks as a foreign key on:\nsubcategory_has_category.subcategory_id = subcategory.sub_category_id\n\ne.g. 1, 2, 3',
  `category_id` INT NOT NULL COMMENT 'Identifies the category ID from the category table\n\nWorks as a foreign key on:\nsubcategory_has_category.category_id = category.category_id\n\ne.g. 1, 2, 3',
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
  `product_group_id` INT NOT NULL COMMENT 'Identifies the product group ID from the product_group table\n\nWorks as a foreign key on:\nproduct_group_has_subcategory.product_group_id = product_group.product_group_id\n\ne.g. 1, 2, 3',
  `subcategory_id` INT NOT NULL COMMENT 'Identifies the subcategory ID from the subcategory table\n\nWorks as a foreign key on:\nproduct_group_has_subcategory.subcategory_id = subcategory.sub_category_id\n\ne.g. 1, 2, 3',
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
