-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`street`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`street` ;

CREATE TABLE IF NOT EXISTS `mydb`.`street` (
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`district`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`district` ;

CREATE TABLE IF NOT EXISTS `mydb`.`district` (
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`address` ;

CREATE TABLE IF NOT EXISTS `mydb`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(5) NOT NULL,
  `street_name` VARCHAR(50) NOT NULL,
  `district_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_street1_idx` (`street_name` ASC) VISIBLE,
  INDEX `fk_address_district1_idx` (`district_name` ASC) VISIBLE,
  CONSTRAINT `fk_address_street1`
    FOREIGN KEY (`street_name`)
    REFERENCES `mydb`.`street` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_district1`
    FOREIGN KEY (`district_name`)
    REFERENCES `mydb`.`district` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`kindergarden`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`kindergarden` ;

CREATE TABLE IF NOT EXISTS `mydb`.`kindergarden` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `flats_count` INT NOT NULL,
  `workers_count` INT NULL DEFAULT NULL,
  `group_count` INT NULL DEFAULT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_kindergarden_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_kindergarden_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `mydb`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



	

-- -----------------------------------------------------
-- Table `mydb`.`position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`position` ;

CREATE TABLE IF NOT EXISTS `mydb`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `salary` FLOAT NOT NULL,
  `bonus` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`worker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`worker` ;

CREATE TABLE IF NOT EXISTS `mydb`.`worker` (
  `passport` VARCHAR(9) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(20) NOT NULL,
  `hire_date` DATE NOT NULL,
  `fire_date` DATE NULL DEFAULT NULL,
  `kindergarden_id` INT NULL DEFAULT NULL,
  `position_id` INT NULL,
  PRIMARY KEY (`passport`),
  INDEX `fk_worker_kindergarden1_idx` (`kindergarden_id` ASC) VISIBLE,
  INDEX `fk_worker_position1_idx` (`position_id` ASC) VISIBLE,
  CONSTRAINT `fk_worker_kindergarden1`
    FOREIGN KEY (`kindergarden_id`)
    REFERENCES `mydb`.`kindergarden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_worker_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `mydb`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`child_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`child_group` ;

CREATE TABLE IF NOT EXISTS `mydb`.`child_group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `bedroom_number` INT NOT NULL,
  `kindergarden_id` INT NOT NULL,
  `worker_passport` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_child_group_kindergarden1_idx` (`kindergarden_id` ASC) VISIBLE,
  INDEX `fk_child_group_worker1_idx` (`worker_passport` ASC) VISIBLE,
  CONSTRAINT `fk_child_group_kindergarden1`
    FOREIGN KEY (`kindergarden_id`)
    REFERENCES `mydb`.`kindergarden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_group_worker1`
    FOREIGN KEY (`worker_passport`)
    REFERENCES `mydb`.`worker` (`passport`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`child`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`child` ;

CREATE TABLE IF NOT EXISTS `mydb`.`child` (
  `birth_certificate` VARCHAR(15) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(20) NOT NULL,
  `birth_date` DATE NOT NULL,
  `child_group_id` INT NOT NULL,
  PRIMARY KEY (`birth_certificate`),
  INDEX `fk_child_child_group1_idx` (`child_group_id` ASC) VISIBLE,
  CONSTRAINT `fk_child_child_group1`
    FOREIGN KEY (`child_group_id`)
    REFERENCES `mydb`.`child_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`lesson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`lesson` ;

CREATE TABLE IF NOT EXISTS `mydb`.`lesson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `classroom` INT NULL DEFAULT NULL,
  `lesson_day` VARCHAR(10) NOT NULL,
  `lesson_time` TIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`kindergarden_has_position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`kindergarden_has_position` ;

CREATE TABLE IF NOT EXISTS `mydb`.`kindergarden_has_position` (
  `kindergarden_id` INT NOT NULL,
  `position_id` INT NOT NULL,
  PRIMARY KEY (`kindergarden_id`, `position_id`),
  INDEX `fk_kindergarden_has_position_position1_idx` (`position_id` ASC) VISIBLE,
  INDEX `fk_kindergarden_has_position_kindergarden1_idx` (`kindergarden_id` ASC) VISIBLE,
  CONSTRAINT `fk_kindergarden_has_position_kindergarden1`
    FOREIGN KEY (`kindergarden_id`)
    REFERENCES `mydb`.`kindergarden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kindergarden_has_position_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `mydb`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`schedule` ;

CREATE TABLE IF NOT EXISTS `mydb`.`schedule` (
  `child_group_id` INT NOT NULL,
  `lesson_id` INT NOT NULL,
  PRIMARY KEY (`child_group_id`, `lesson_id`),
  INDEX `fk_child_group_has_lesson_lesson1_idx` (`lesson_id` ASC) VISIBLE,
  INDEX `fk_child_group_has_lesson_child_group1_idx` (`child_group_id` ASC) VISIBLE,
  CONSTRAINT `fk_child_group_has_lesson_child_group1`
    FOREIGN KEY (`child_group_id`)
    REFERENCES `mydb`.`child_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_group_has_lesson_lesson1`
    FOREIGN KEY (`lesson_id`)
    REFERENCES `mydb`.`lesson` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Inserts

INSERT INTO street(`name`) VALUES
("Городоцька"), ("Стрийська"), ("Антоновича"),
("Замарстинівська"), ("Богдана Хмельницького"), ("Зелена"), 
("Івана Франка"), ("Пекарська"), ("Івана Мазепи");

INSERT INTO district(`name`) VALUES
("Шевченківський"), ("Галицький"), ("Залізничний"), 
("Сихівський"), ("Личаківський"), ("Франківський");

INSERT INTO address(`number`, street_name, district_name) VALUES
("32", "Івана Франка", "Франківський"), 
("156", "Городоцька", "Залізничний"), 
("56", "Пекарська", "Галицький"), 
("137а", "Зелена", "Личаківський"), 
("78", "Стрийська", "Сихівський"), 
("42", "Івана Мазепи", "Шевченківський");

INSERT INTO kindergarden(flats_count, address_id) VALUES
(2, 2),
(3, 1),
(1, 5),
(4, 3),
(2, 6),
(3, 4);

INSERT INTO `position`(`name`, salary, bonus) VALUES
("Вихователь", 7000, 5000),
("Кухар", 8000, 6000), 
("Прибиральник", 6000, 4000),
("Вихователь", 9000, 8000), 
("Директор", 15000, 10000),
("Кухар", 10000, 9000);

INSERT INTO kindergarden_has_position(kindergarden_id, position_id) VALUES
(1, 1), (1, 6), (1, 3), (1, 5),
(2, 4), (2, 2), (2, 5),
(3, 4), (3, 2), (3, 5),
(4, 3), (4, 4), (4, 5),
(5, 1), (5, 6), 
(6, 1), (6, 3);

INSERT INTO worker(passport, `name`, surname, hire_date, fire_date, kindergarden_id, position_id) VALUES
("964650559", "Еразм", "Овчарук", '2008-05-26','2010-08-17', 1, 4),
("569652257", "Йошка", "Скрипник", '2009-07-10', null, 3, 5),
("689649222", "Чеслава", "Радчук", '2013-08-15', '2016-02-27', 2, 4),
("503576754", "Ростичара", "Колосюк", '2000-09-20', '2002-01-23', 5, 6),
("071726730", "Атена", "Юрковська", '2011-11-19', null, 4, 2),
("864378669", "Христина", "Скалозуб", '2021-07-03', null, 5, 4 ),
("009352365", "Леонід", "Бутницький", '2020-10-02', '2021-04-28', 6, 2),
("851265302", "Юхим", "Грабар", '2011-11-19', null, 6, 4),
("153497805", "Троян", "Устименко", '2009-07-10', null, 1, 2),
("011111110", "Півонія", "Макотерська", '2016-09-01', null, 1, 1),
("520821572", "Фотинія", "Покотило", '2013-08-15', null, 2, 5),
("146785884", "Ярина", "Рудченко", '2002-02-10', '2004-05-15', 5, 1);

INSERT INTO child_group(`name`, bedroom_number, kindergarden_id, worker_passport) VALUES
("Молодша група 1", 208, 1, "964650559"),
("Страша група 1", 104, 1, "011111110"), 
("Молодша група 2", 203, 5, "864378669"), 
("Молодша група 3", 109, 6, "851265302"),
("Страша група 2", 206, 5, "146785884"), 
("Старша група 3", 301, 2, "689649222");

INSERT INTO child(birth_certificate, `name`, `surname`, `birth_date`, `child_group_id`)VALUES
("І-ВЛ 597684", "Юрій", "Ткачик", "2018-10-28", 1),
("І-ЕГ 530633", "Юрій", "Могилянський", "2015-02-08", 2),
("І-МИ 940512", "Іван", "Глобенко", "2017-03-06", 3),
("І-ВЛ 632546", "Ничипір", "Худоб'як", "2016-01-19", 5),
("І-ВЛ 563964", "Яків", "Горянський", "2017-09-17", 4),
("І-КГ 600831", "Марко", "Вороний", "2014-12-24", 6),
("І-ЕГ 582766", "Іван", "Лазарук", "2015-11-30", 2),
("І-ВЛ 261990", "Юліан", "Габелко", "2014-06-18", 5),
("І-ОК 617612", "Корнелій", "Борковський", "2018-04-25", 3),
("І-КГ 975279", "Лев", "Вороновський", "2014-11-30", 6),
("І-ОК 855627", "Діана", "Жаліло", "2015-12-28", 2),
("І-ОК 497017", "Лілея", "Кабак", "2015-10-23", 5),
("І-МИ 723563", "Яна", "Блажевська", "2016-11-11", 4),
("І-ВЛ 323989", "Олівія", "Шкурат", "2014-04-28", 2),
("АИ 968027", "Уляна", "Лавренюк", "2014-01-21", 2);

INSERT INTO lesson(`name`, classroom, lesson_day, lesson_time) VALUES
("Малювання", 109, "Понеділок", '09:00:00'),
("Англійська мова", 105, "Вівторок", '12:10:00'),
("Виховна година", 104, "Понеділок", '13:45:00'),
("Плавання", 201, "Середа", '9:00:00'),
("Малювання", 206, "Четвер", '10:20:00'),
("Англійська мова", 306, "П'ятниця", '12:10:00'),
("Малювання", 107, "Середа", '10:20:00'),
("Виховна година", 304, "П'ятниця", '12:10:00'),
("Англійська мова", 205,  "Середа", '9:00:00'),
("Плавання", 108, "Понеділок", '10:20:00');

INSERT INTO `schedule`(child_group_id, lesson_id) VALUES
(1, 3), (1, 5), (1, 7), (1, 4), 
(2, 2), (2, 6), (2, 8), (2, 9), 
(3, 3), (3, 10), (3, 5), 
(4, 1), (4, 4), (4, 9), 
(5, 2), (5, 7), (5, 8), (5, 4), 
(6, 1), (6, 3), (6, 6), (6, 7), (6, 10);

SET SQL_SAFE_UPDATES = 0;

UPDATE kindergarden 
LEFT JOIN (SELECT kindergarden_id, COUNT(*) as worker_counter
FROM worker 
WHERE fire_date IS NULL 
GROUP BY kindergarden_id) AS w 
ON w.kindergarden_id = id
LEFT JOIN (SELECT kindergarden_id, COUNT(*) as group_counter
FROM child_group
GROUP BY kindergarden_id) AS gr
ON gr.kindergarden_id = id
SET workers_count = w.worker_counter,
group_count = gr.group_counter;



SET SQL_SAFE_UPDATES = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
