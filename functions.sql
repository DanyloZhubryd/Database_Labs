USE students_db;
set global log_bin_trust_function_creators = 1;
DELIMITER //

DROP function if exists student_avg_overall_rate//
DROP function if exists get_region//

CREATE function student_avg_overall_rate() returns decimal
begin
		return(select avg(overall_rate) from student);
end;

SELECT * FROM student
WHERE overall_rate > student_avg_overall_rate()//

CREATE function get_region(id_select int) returns VARCHAR(48)
begin
		return(select CONCAT(`name`,' ', `code`) from region
        where `code` = (select region_code from city
						where city.id = id_select));
end;

SELECT id, `name`, get_region(id) as region from city//