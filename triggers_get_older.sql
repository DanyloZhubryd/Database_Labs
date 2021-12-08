USE students_db;
DELIMITER //

DROP trigger if exists check_before_insert_student//
DROP trigger if exists check_before_update_student//

CREATE trigger check_age_before_insert_student
before insert
on student for each row
begin
		if YEAR(new.entry_date)-YEAR(new.birth_date) < 16 then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "GET OLDER";
		end if;
end//

CREATE trigger check_age_before_update_student
before update
on student for each row
begin
		if YEAR(new.entry_date)-YEAR(new.birth_date) < 16 then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "TOO YOUNG";
		end if;
end//