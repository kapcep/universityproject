insert into faculties (faculty_name) values ('IT');
insert into faculties (faculty_name) values ('HR');
insert into faculties (faculty_name) values ('QA');

--insert into IT faculty
insert into student_groups (group_name,faculty_id) values ('IT-1',1);
insert into student_groups (group_name,faculty_id) values ('IT-2',1);
insert into student_groups (group_name,faculty_id) values ('IT-3',1);

--insert into HR faculty
insert into student_groups (group_name,faculty_id) values ('HR-1',2);
insert into student_groups (group_name,faculty_id) values ('HR-2',2);
insert into student_groups (group_name,faculty_id) values ('HR-3',2);

--insert into QA faculty
insert into student_groups (group_name,faculty_id) values ('QA-1',3);
insert into student_groups (group_name,faculty_id) values ('QA-2',3);
insert into student_groups (group_name,faculty_id) values ('QA-3',3);

--insert into IT faculty
insert into departments (department_name,faculty_id) values ('Low-Level Programming',1);
insert into departments (department_name,faculty_id) values ('Hi-Level Programming',1);
insert into departments (department_name,faculty_id) values ('SQL',1);

--insert into HR faculty
insert into departments (department_name,faculty_id) values ('Soft Skill',2);
insert into departments (department_name,faculty_id) values ('Management',2);
insert into departments (department_name,faculty_id) values ('Social Communication',2);

--insert into QA faculty
insert into departments (department_name,faculty_id) values ('Manual Testing',3);
insert into departments (department_name,faculty_id) values ('Automation Testing',3);
insert into departments (department_name,faculty_id) values ('AI Testing',3);

--insert students to groups

INSERT into students (student_group_id,student_name,student_surname,age) values (1,'Mykola','Lutiy',18);
INSERT into students (student_group_id,student_name,student_surname,age) values (1,'Stepan','Bulatenko',17);
INSERT into students (student_group_id,student_name,student_surname,age) values (1,'Natalia','Zelena',19);

INSERT into students (student_group_id,student_name,student_surname,age) values (2,'Irina','Nesvitaylo',17);
INSERT into students (student_group_id,student_name,student_surname,age) values (2,'Serhii','Voitenko',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (2,'Yevgen','Nesterenko',17);

INSERT into students (student_group_id,student_name,student_surname,age) values (3,'Iurii','Rudiy',17);
INSERT into students (student_group_id,student_name,student_surname,age) values (3,'Olga','Didenko',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (3,'Oxana','Zhmiruk',16);

INSERT into students (student_group_id,student_name,student_surname,age) values (4,'Vasya','Tishchenko',17);
INSERT into students (student_group_id,student_name,student_surname,age) values (4,'Olena','Vagova',18);
INSERT into students (student_group_id,student_name,student_surname,age) values (4,'Oxana','Bichuk',17);

INSERT into students (student_group_id,student_name,student_surname,age) values (5,'Ilya','Zalizniy',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (5,'Ivan','Golopak',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (5,'Irina','Stepova',16);

INSERT into students (student_group_id,student_name,student_surname,age) values (6,'Igor','Velikiy',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (6,'Serhii','Volshchak',17);
INSERT into students (student_group_id,student_name,student_surname,age) values (6,'Snizhana','Bilogorodkska',18);

INSERT into students (student_group_id,student_name,student_surname,age) values (7,'Yulya','Dmitrikivska',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (7,'Oelena','Zelena',18);
INSERT into students (student_group_id,student_name,student_surname,age) values (7,'Petro','Zabudskiy',17);

INSERT into students (student_group_id,student_name,student_surname,age) values (8,'Vasya','Gotsa',17);
INSERT into students (student_group_id,student_name,student_surname,age) values (8,'Olexandr','Siviy',18);
INSERT into students (student_group_id,student_name,student_surname,age) values (8,'Valya','Gorina',18);

INSERT into students (student_group_id,student_name,student_surname,age) values (9,'Olexandr','Dovgiy',19);
INSERT into students (student_group_id,student_name,student_surname,age) values (9,'Kolya','Senin',16);
INSERT into students (student_group_id,student_name,student_surname,age) values (9,'Inokentiy','Griboyedov',16);

--insert teachers to departments

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (1,'Galina','Vasilieva',25);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (1,'Stepan','Rogatkin',27);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (1,'Igor','Veseliy',28);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (2,'Bogdan','Pravdich',30);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (2,'Serhii','Semikin',27);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (2,'Yulya','Chorna',28);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (3,'Vasya','Kondruk',31);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (3,'Inna','Semenova',28);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (3,'Slava','Yezhov',27);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (4,'Anton','Rikov',33);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (4,'Natalia','Ritova',40);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (4,'Dmytro','Kaban',28);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (5,'Volodymyr','Yasniy',32);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (5,'Marina','Osinnikova',35);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (5,'Anna','Rezova',29);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (6,'Iurii','Kopotiev',28);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (6,'Vadym','Siniy',33);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (6,'Inna','Bugatina',30);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (7,'Matviy','Rokoschev',43);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (7,'Pavlo','Viter',29);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (7,'Lubov','Denikina',29);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (8,'Andriy','Vchorashniy',32);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (8,'Misha','Verba',33);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (8,'Tanya','Konieva',35);

INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (9,'Irina','Dmytrenko',39);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (9,'Yulya','Sidorova',35);
INSERT into teachers (department_id,teacher_name,teacher_surname,age) values (9,'Lilya','Pilugina',31);