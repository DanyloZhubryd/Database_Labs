-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema students_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `students_db` DEFAULT CHARACTER SET utf8 ;
USE `students_db` ;

DROP TABLE IF EXISTS `students_db`.`student_group` ;
DROP TABLE IF EXISTS `students_db`.`region` ;
DROP TABLE IF EXISTS `students_db`.`city` ;
DROP TABLE IF EXISTS `students_db`.`graduated_secondary_school` ;
DROP TABLE IF EXISTS `students_db`.`student` ;
DROP TABLE IF EXISTS `students_db`.`debt` ;
DROP TABLE IF EXISTS `students_db`.`student_has_debt` ;
-- -----------------------------------------------------
-- Table `student_group`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `students_db`.`student_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  `number` VARCHAR(2) NOT NULL,
  `entry_year` YEAR(4) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `region`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `students_db`.`region` (
  `code` VARCHAR(2) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `city`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `students_db`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `region_code` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `graduated_secondary_school`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `students_db`.`graduated_secondary_school` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NULL,
  `director_fullname` VARCHAR(45) NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `students_db`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `patronymic` VARCHAR(20) NULL,
  `overall_rate` FLOAT NULL,
  `birth_date` DATE NOT NULL,
  `entry_date` DATE NULL,
  `email` VARCHAR(45) NULL,
  `student_identity_card` VARCHAR(20) NULL,
  `student_group_id` INT NULL,
  `graduated_secondary_school_id` INT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `debt`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `students_db`.`debt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lesson_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student_has_debt`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `students_db`.`student_has_debt` (
  `student_id` INT NOT NULL,
  `debt_id` INT NOT NULL,
  PRIMARY KEY (`student_id`, `debt_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
