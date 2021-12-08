# Database_Labs

## Task
1. Create a database (DB) with 3 normal
forms. To ensure the integrity of the values used
triggers instead of foreign keys. Database name in format:
student's last name, laboratory number, option number,
for example, Pavelchak_9_23.
2. Fill in each database table at least 10 records (if
the number of course is not limited by logic).
3. Implement these software designs. 
### <a name="procedures"></a> SAVED PROCEDURES
1. Ensure parameterized insertion of new values in
Students table.
2. Output data from the connection table M: M between
tables Students and Debts, replacing the numbers
meaning real names. As an additional option to provide
the ability to filter data for the names of the table Students,
that is, we can display either everything or something specific.
3. Using the cursor, ensure the dynamic creation of 2x
tables with names containing time stamp, table structure
identical to the structure of the Students table. Then random
way to ribbon copy ribbons students table or
one, or another additional table. Restart
procedure again creates new similar tables in which
the data from the table will be randomly scattered again
Students.
### CUSTOM FUNCTIONS <a name="functions"></a>
1. For the Students table write the function as it will search for AVG
column Overall rating. Then sample the data
(SELECT) greater than the average using this
function.
2. Write a function that extracts the key between the tables
City and Region are the combined values of the Region and Code fields
area. Then make a sample of all data (SELECT) from the table
City using this feature.
### TRIGGERS <a name="triggers"></a>
1. <a name="triggers/fk"></a> Ensure the integrity of the values for the database structure.
2. <a name="triggers/format"></a>for Students → Provide a student ticket number
format: 'A' + 8 digits + any letter except S;
3. <a name="triggers/age"></a>the difference between Students → Date of Admission and Students → Date
birth must be at least 16 years old.
4. <a name="triggers/limit"></a>Ensure a maximum of 6 tapes for
Group tables. 
## DATABASE STRUCTURE
![image](https://user-images.githubusercontent.com/74894799/145216229-993d0ea9-de52-43f7-983b-69b106a37d95.png)
### FILES
1. `ER_diagram.mwb` - database diagram
2. `create_script.sql` - recreates database(drops all tables and recreates them)
3. `inserts.sql` - inserts data into tables
4. `procedures.sql` - procedures that are described in [Procedures](#procedures)
5. `procedures_calls.sql` - runs procedures
6. `functions.sql` - functions that are described in [Functions](#functions)
7. `trigger_foreign_key_management.sql` - triggers that do foreign key logic and are decribed in [Triggers](#triggers/fk)
8. `triggers_student_identity_card.sql` - triigers that controlls the format of `student_identity_card` column and are described in [Triggers](#triggers/format)
9. `triggers_get_older.sql` - triggers that check if `student` is 16+yo, described in [Triggers](#triggers/age)
10. `trigger_max_rows_number_student_group.sql` - triggers that limit amount of rows in table `child_group` to 6, described in [Triggers](#triggers/limit)
