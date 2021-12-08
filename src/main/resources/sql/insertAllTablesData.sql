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

insert into classroom (classroom_name, classroom_number, department_id)  values ('LP-1',1,1);
insert into classroom (classroom_name, classroom_number, department_id)  values ('LP-2',2,1);
insert into classroom (classroom_name, classroom_number, department_id)  values ('LP-3',3,1);
insert into classroom (classroom_name, classroom_number, department_id)  values ('LP-4',4,1);
insert into classroom (classroom_name, classroom_number, department_id)  values ('LP-5',5,1);
insert into classroom (classroom_name, classroom_number, department_id)  values ('LP-6',6,1);

insert into classroom (classroom_name, classroom_number, department_id)  values ('HP-1',7,2);
insert into classroom (classroom_name, classroom_number, department_id)  values ('HP-2',8,2);
insert into classroom (classroom_name, classroom_number, department_id)  values ('HP-3',9,2);
insert into classroom (classroom_name, classroom_number, department_id)  values ('HP-4',10,2);
insert into classroom (classroom_name, classroom_number, department_id)  values ('HP-5',11,2);
insert into classroom (classroom_name, classroom_number, department_id)  values ('HP-6',12,2);

insert into classroom (classroom_name, classroom_number, department_id)  values ('SQL-1',13,3);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SQL-2',14,3);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SQL-3',15,3);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SQL-4',16,3);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SQL-5',17,3);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SQL-5',18,3);

insert into classroom (classroom_name, classroom_number, department_id)  values ('SS-1',19,4);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SS-2',20,4);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SS-3',21,4);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SS-4',22,4);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SS-5',23,4);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SS-6',24,4);

insert into classroom (classroom_name, classroom_number, department_id)  values ('MNG-1',25,5);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MNG-2',26,5);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MNG-3',27,5);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MNG-4',28,5);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MNG-5',29,5);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MNG-6',30,5);

insert into classroom (classroom_name, classroom_number, department_id)  values ('SC-1',31,6);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SC-2',32,6);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SC-3',33,6);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SC-4',34,6);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SC-5',35,6);
insert into classroom (classroom_name, classroom_number, department_id)  values ('SC-6',36,6);

insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-1',37,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-1',38,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-1',39,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-1',40,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-1',41,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-1',42,7);

insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',43,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',44,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',45,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',46,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',47,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',48,8);

insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-1',49,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-2',50,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-3',51,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-4',52,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-5',53,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-6',54,8);