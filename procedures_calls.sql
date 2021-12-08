USE students_db;

call insert_into_student("Загаєвич", "Берта", "Панасівна", 54.0, "1999-02-27", "2021-04-17", "Fascinated@gmail.com", "87439882", 2, 5, 1);
call get_student_has_debt(0, 0);
call shuffle_student();