USE students_db;
DELIMiTER //

DROP trigger if exists before_insert_student;
DROP trigger if exists before_update_student;
DROP trigger if exists before_delete_student;
DROP trigger if exists before_delete_student_group;
DROP trigger if exists before_delete_debt;
DROP trigger if exists before_insert_student_has_debt;
DROP trigger if exists before_update_student_has_debt;
DROP trigger if exists before_insert_graduated_secondary_school;
DROP trigger if exists before_update_graduated_secondary_school;
DROP trigger if exists before_delete_graduated_secondary_school;
DROP trigger if exists before_insert_city;
DROP trigger if exists before_update_city;
DROP trigger if exists before_delete_city;
DROP trigger id exists before_delete_region;

-- Table student

CREATE trigger before_insert_student
before insert on student 
for each row
begin
		if  (new.student_group_id not in (select id from student_group)) or 
			(new.graduated_secondary_school_id not in (select id from graduated_secondary_school)) or
            (new.city_id not in (select id from city)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_update_student
before update on student 
for each row
begin
		if  (new.student_group_id not in (select id from student_group)) or 
			(new.graduated_secondary_school_id not in (select id from graduated_secondary_school)) or
            (new.city_id not in (select id from city)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_delete_student
before delete on student
for each row
begin
		DELETE FROM student_has_debt
        WHERE student_id = old.id;
end//

-- Table student_group

CREATE trigger before_delete_student_group
before delete on student_group
for each row
begin
		if (old.id in (select student_group_id from student)) then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "Cannot be deleted. This record is used in one of student table records";
		end if;
end//

-- Table debt

CREATE trigger before_delete_debt
before delete on debt
for each row
begin
		DELETE FROM student_has_debt
        WHERE debt_id = old.id;
end//

-- Table student_has_debt

CREATE trigger before_insert_student_has_debt
before insert on student_has_debt
for each row
begin
		if  (new.student_id not in (select id from student)) or 
			(new.debt_id not in (select id from debt)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_update_student_has_debt
before update on student_has_debt
for each row
begin
		if  (new.student_id not in (select id from student)) or 
			(new.debt_id not in (select id from debt)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

-- Table graduated_secondary_school

CREATE trigger before_insert_graduated_secondary_school
before insert on graduated_secondary_school
for each row
begin
		if  (new.city_id not in (select id from city)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_update_graduated_secondary_school
before update on graduated_secondary_school
for each row
begin
		if  (new.city_id not in (select id from city)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_delete_graduated_secondary_school
before delete on graduated_secondary_school
for each row
begin
		if (old.id in (select graduated_secondary_school_id from student)) then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "Cannot be deleted. This record is used in one of student table records";
		end if;
end//

-- Table city

CREATE trigger before_insert_city
before insert on city
for each row
begin
		if  (new.region_code not in (select `code` from region)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_update_city
before update on city
for each row
begin
		if  (new.region_code not in (select `code` from region)) then 
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "One of foreign keys doesn't exist";
		end if;
end//

CREATE trigger before_delete_city
before delete on city
for each row
begin
		if  (old.id in (select city_id from student)) or 
			(old.id in (select city_id from graduated_secondary_school)) then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "Cannot be deleted. This record is used in one of student or graduated_secondary_school table records";
		end if;
end//

-- Table region

CREATE trigger before_delete_region
before delete on region
for each row
begin
		if  (old.`code` in (select region_code from city)) then
				SIGNAL SQLSTATE '45000'
                set MESSAGE_TEXT = "Cannot be deleted. This record is used in one of city table records";
		end if;
end//