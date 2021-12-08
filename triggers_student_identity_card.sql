USE students_db;
DELIMITER //

DROP trigger if exists check_identity_card_before_insert_student//
DROP trigger if exists check_identity_card_before_update_student//

CREATE trigger check_identity_card_before_insert_student
before insert
on student for each row
begin
		if not (new.student_identity_card regexp('^A[0-9]{8}[^S]$')) then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "Wrong student identity card fromat. Must be 'A' + 8 digits + any symbol except S";
		end if;
end//

CREATE trigger check_identity_card_before_update_student
before update
on student for each row
begin
		if not (new.student_identity_card regexp('^A[0-9]{8}[^S]$')) then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "Wrong student identity card fromat. Must be 'A' + 8 digits + any symbol except S";
		end if;
end//
