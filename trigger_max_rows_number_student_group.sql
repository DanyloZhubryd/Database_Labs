USE students_db;
DELIMITER //
DROP trigger if exists max_rows_number_before_insert_student_group//

CREATE trigger max_rows_number_before_insert_student_group
before insert 
on student_group
for each row
begin
		if (SELECT COUNT(*) FROM student_group) = 6 then
			SIGNAL SQLSTATE '45000'
            set MESSAGE_TEXT = "No more groups can be added. Max number of groups = 6";
		end if;
end//