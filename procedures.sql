USE students_db;
DELIMITER //

DROP procedure if exists insert_into_student//
DROP procedure if exists get_student_has_debt//
DROP procedure if exists shuffle_student//

CREATE procedure `insert_into_student` (
in `surname` VARCHAR(20),
in `name` VARCHAR(20),
in `patronymic` VARCHAR(20),
in `overall_rate` FLOAT,
in `birth_date` DATE,
in `entry_date` DATE,
in `email` VARCHAR(45),
in `student_identity_card` VARCHAR(20),
in `student_group_id` INT,
in `graduated_secondary_school_id` INT,
in `city_id` INT
)
begin
	INSERT into student(surname ,`name`, patronymic, overall_rate, birth_date, entry_date, email, student_identity_card, student_group_id, graduated_secondary_school_id, city_id) VALUES
    (surname ,`name`, patronymic, overall_rate, birth_date, entry_date, email, student_identity_card, student_group_id, graduated_secondary_school_id, city_id);
end//

CREATE procedure `get_student_has_debt` (
in student_id INT,
in debt_id INT
)
begin
	SELECT s.surname, d.lesson_name FROM student_has_debt sd
		INNER JOIN student s ON sd.student_id = s.id
        INNER JOIN debt d ON sd.debt_id = d.id
	WHERE (student_id = 0 or student_id = s.id) and (debt_id = 0 or debt_id = d.id);
end//

CREATE procedure `shuffle_student`()
begin
DECLARE done bool default false;

DECLARE id INT;
DECLARE  surname VARCHAR(20);
DECLARE  `name` VARCHAR(20);
DECLARE  patronymic VARCHAR(20);
DECLARE  overall_rate FLOAT;
DECLARE  birth_date DATE;
DECLARE  entry_date DATE;
DECLARE  email VARCHAR(45);
DECLARE  student_identity_card VARCHAR(20);
DECLARE  student_group_id INT;
DECLARE  graduated_secondary_school_id INT;
DECLARE  city_id INT;

DECLARE student_cursor cursor for select * from student;
declare continue handler for not found set done = true;

set @cur_datetime = current_timestamp();

set @create_query = concat("CREATE TABLE `student_", @cur_datetime, "_first` (", 
	"id INT NOT NULL AUTO_INCREMENT,",
    "`surname` VARCHAR(20) NOT NULL,",
	"`name` VARCHAR(20) NOT NULL,",
	"`patronymic` VARCHAR(20) NULL,",
	"`overall_rate` FLOAT NULL,",
	"`birth_date` DATE NOT NULL,",
	"`entry_date` DATE NULL,",
	"`email` VARCHAR(45) NULL,",
	"`student_identity_card` VARCHAR(20) NULL,",
	"`student_group_id` INT NULL,",
	"`graduated_secondary_school_id` INT NULL,",
	"`city_id` INT NOT NULL,",
  "constraint pk_student primary key(id)",
    ");"); 
prepare create_statement from @create_query;
execute create_statement;
deallocate prepare create_statement; 
   
set @create_query = concat("CREATE TABLE `student_", @cur_datetime, "_second` (", 
	"id INT NOT NULL AUTO_INCREMENT,",
    "`surname` VARCHAR(20) NOT NULL,",
	"`name` VARCHAR(20) NOT NULL,",
	"`patronymic` VARCHAR(20) NULL,",
	"`overall_rate` FLOAT NULL,",
	"`birth_date` DATE NOT NULL,",
	"`entry_date` DATE NULL,",
	"`email` VARCHAR(45) NULL,",
	"`student_identity_card` VARCHAR(20) NULL,",
	"`student_group_id` INT NULL,",
	"`graduated_secondary_school_id` INT NULL,",
	"`city_id` INT NOT NULL,",
  "constraint pk_student primary key(id)",
    ");"); 
prepare create_statement from @create_query;
execute create_statement;
deallocate prepare create_statement;

open student_cursor;
student_loop: loop
		fetch student_cursor into id, surname, `name`, patronymic,
        overall_rate, birth_date, entry_date, email, student_identity_card,
        student_group_id, graduated_secondary_school_id, city_id;
        IF done=true THEN
				LEAVE student_loop;
		END IF;
        
        IF rand()>0.5 THEN
				set @temp_query=CONCAT("INSERT into `student_", @cur_datetime, "_first`",
                "(surname, `name`, patronymic,
			overall_rate, birth_date, entry_date, email, student_identity_card,
			student_group_id, graduated_secondary_school_id, city_id) VALUES(", 
            "'", surname, "',", "'", `name`, "',", "'", patronymic, "',", 
            overall_rate, ",", "'", birth_date, "',", "'", entry_date, "',", "'", email, "',", 
            "'", student_identity_card, "',", student_group_id, ",", graduated_secondary_school_id, ",", city_id, ");");
        ELSE
				set @temp_query=CONCAT("INSERT into `student_", @cur_datetime, "_second`",
                "(surname, `name`, patronymic,
			overall_rate, birth_date, entry_date, email, student_identity_card,
			student_group_id, graduated_secondary_school_id, city_id) VALUES(", 
            "'", surname, "',", "'", `name`, "',", "'", patronymic, "',", 
            overall_rate, ",", "'", birth_date, "',", "'", entry_date, "',", "'", email, "',", 
            "'", student_identity_card, "',", student_group_id, ",", graduated_secondary_school_id, ",", city_id, ");");
		END IF;
        PREPARE temp_statement FROM @temp_query;
        EXECUTE temp_statement;
        DEALLOCATE PREPARE temp_statement;
end loop;
close student_cursor;
end//

