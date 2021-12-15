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

--create classrooms data
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
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-2',38,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-3',39,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-4',40,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-5',41,7);
insert into classroom (classroom_name, classroom_number, department_id)  values ('MT-6',42,7);

insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-1',43,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-2',44,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-3',45,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-4',46,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-5',47,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AT-6',48,8);

insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-1',49,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-2',50,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-3',51,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-4',52,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-5',53,8);
insert into classroom (classroom_name, classroom_number, department_id)  values ('AI-6',54,8);

--insert schedule items data

insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 08:30','2021-12-01 09:25','Algorithms',3,1,1);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 09:35','2021-12-01 10:30','Java',9,2,4);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 10:40','2021-12-01 11:35','SQL Queries',13,3,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 11:45','2021-12-01 12:40','Public Performance',21,4,10);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 12:50','2021-12-01 13:45','Self-Management',25,5,13);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 13:55','2021-12-01 14:50','In-Team Communication',32,6,16);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 15:00','2021-12-01 15:55','Unit Testing',41,7,19);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 16:05','2021-12-01 17:00','Script Testing',48,8,22);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 08:30','2021-12-02 09:25','Python AI Testing',50,9,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 09:35','2021-12-02 10:30','C',3,3,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 10:40','2021-12-02 11:35','Python',10,2,5);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 11:45','2021-12-02 12:40','SQL Stored Procedures',16,4,8);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 12:50','2021-12-02 13:45','Mentoring',22,6,11);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 13:55','2021-12-02 14:50','Team Leader Management',28,1,14);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 15:00','2021-12-02 15:55','out-Team Communication',34,7,17);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-02 16:05','2021-12-02 17:00','Low-Level Testing',40,5,20);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 08:30','2021-12-03 09:25','Data-driven testing',43,9,23);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 09:35','2021-12-03 10:30','R AI Testing',54,8,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 10:40','2021-12-03 11:35','Assembler',4,1,3);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 11:45','2021-12-03 12:40','C#',9,4,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 12:50','2021-12-03 13:45','NoSQL',18,6,9);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 13:55','2021-12-03 14:50','Emotional Intelligence',22,2,12);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 15:00','2021-12-03 15:55','PM Management',26,7,15);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-03 16:05','2021-12-03 17:00','Team-Building Communication',36,5,18);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 08:30','2021-12-06 09:25','High-Level Testing',41,3,21);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 09:35','2021-12-06 10:30','Keyword-based',47,8,24);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 10:40','2021-12-06 11:35','Java AI Testing',52,9,27);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 11:45','2021-12-06 12:40','Algorithms',4,5,1);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 12:50','2021-12-06 13:45','Emotional Intelligence',21,1,12);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 13:55','2021-12-06 14:50','R AI Testing',49,9,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 15:00','2021-12-06 15:55','out-Team Communication',31,4,17);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-06 16:05','2021-12-06 17:00','Python',7,2,5);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 08:30','2021-12-07 09:25','Script Testing',43,8,22);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 09:35','2021-12-07 10:30','Public Performance',21,3,10);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 10:40','2021-12-07 11:35','Java',7,6,4);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 11:45','2021-12-07 12:40','SQL Queries',16,7,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 12:50','2021-12-07 13:45','Self-Management',25,4,13);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 13:55','2021-12-07 14:50','In-Team Communication',34,5,16);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 15:00','2021-12-07 15:55','Unit Testing',38,7,19);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-07 16:05','2021-12-07 17:00','Mentoring',23,1,11);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 08:30','2021-12-08 09:25','Data-driven testing',45,9,23);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 09:35','2021-12-08 10:30','Low-Level Testing',37,6,20);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 10:40','2021-12-08 11:35','Python AI Testing',52,2,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 11:45','2021-12-08 12:40','C',3,8,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 12:50','2021-12-08 13:45','SQL Stored Procedures',14,3,8);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 13:55','2021-12-08 14:50','Team Leader Management',30,1,14);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 15:00','2021-12-08 15:55','NoSQL',15,5,9);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-08 16:05','2021-12-08 17:00','Java AI Testing',52,9,27);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 08:30','2021-12-09 09:25','High-Level Testing',40,2,21);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 09:35','2021-12-09 10:30','PM Management',27,6,15);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 10:40','2021-12-09 11:35','Assembler',6,8,3);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 11:45','2021-12-09 12:40','C#',9,3,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 12:50','2021-12-09 13:45','Team-Building Communication',33,7,18);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 13:55','2021-12-09 14:50','Keyword-based',45,4,24);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 15:00','2021-12-09 15:55','Algorithms',4,4,1);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-09 16:05','2021-12-09 17:00','Java',7,6,4);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 08:30','2021-12-10 09:25','Unit Testing',40,7,19);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 09:35','2021-12-10 10:30','Low-Level Testing',40,1,20);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 10:40','2021-12-10 11:35','SQL Stored Procedures',17,9,8);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 11:45','2021-12-10 12:40','Java AI Testing',52,5,27);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 12:50','2021-12-10 13:45','Assembler',4,2,3);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 13:55','2021-12-10 14:50','High-Level Testing',42,8,21);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 15:00','2021-12-10 15:55','Python AI Testing',50,3,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-10 16:05','2021-12-10 17:00','Self-Management',27,3,13);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 08:30','2021-12-13 09:25','Script Testing',45,6,22);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 09:35','2021-12-13 10:30','Emotional Intelligence',20,2,12);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 10:40','2021-12-13 11:35','R AI Testing',51,8,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 11:45','2021-12-13 12:40','Python',8,4,5);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 12:50','2021-12-13 13:45','out-Team Communication',35,9,17);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 13:55','2021-12-13 14:50','Public Performance',23,1,10);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 15:00','2021-12-13 15:55','SQL Queries',13,7,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-13 16:05','2021-12-13 17:00','In-Team Communication',35,5,16);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 08:30','2021-12-14 09:25','Mentoring',23,3,11);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 09:35','2021-12-14 10:30','Data-driven testing',43,7,23);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 10:40','2021-12-14 11:35','C',5,4,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 11:45','2021-12-14 12:40','NoSQL',14,2,9);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 12:50','2021-12-14 13:45','Team Leader Management',30,6,14);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 13:55','2021-12-14 14:50','C#',10,8,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 15:00','2021-12-14 15:55','PM Management',25,1,15);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-14 16:05','2021-12-14 17:00','Team-Building Communication',35,9,18);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 08:30','2021-12-15 09:25','Keyword-based',47,5,24);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 09:35','2021-12-15 10:30','Assembler',6,3,3);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 10:40','2021-12-15 11:35','Java AI Testing',50,2,27);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 11:45','2021-12-15 12:40','Self-Management',29,5,13);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 12:50','2021-12-15 13:45','Python',11,7,5);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 13:55','2021-12-15 14:50','In-Team Communication',33,1,16);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 15:00','2021-12-15 15:55','NoSQL',17,8,9);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-15 16:05','2021-12-15 17:00','Public Performance',23,4,10);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 08:30','2021-12-16 09:25','Java',9,9,4);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 09:35','2021-12-16 10:30','Algorithms',4,6,1);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 10:40','2021-12-16 11:35','Emotional Intelligence',22,4,12);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 11:45','2021-12-16 12:40','out-Team Communication',31,3,17);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 12:50','2021-12-16 13:45','Data-driven testing',45,6,23);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 13:55','2021-12-16 14:50','Keyword-based',44,1,24);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 15:00','2021-12-16 15:55','C#',9,7,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-16 16:05','2021-12-16 17:00','Team Leader Management',27,5,14);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 08:30','2021-12-17 09:25','SQL Queries',14,2,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 09:35','2021-12-17 10:30','R AI Testing',49,9,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 10:40','2021-12-17 11:35','High-Level Testing',41,8,21);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 11:45','2021-12-17 12:40','Unit Testing',41,1,19);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 12:50','2021-12-17 13:45','Python AI Testing',51,6,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 13:55','2021-12-17 14:50','Script Testing',46,7,22);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 15:00','2021-12-17 15:55','Mentoring',22,2,11);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-17 16:05','2021-12-17 17:00','C',1,8,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 08:30','2021-12-20 09:25','Team-Building Communication',34,3,18);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 09:35','2021-12-20 10:30','PM Management',26,9,15);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 10:40','2021-12-20 11:35','SQL Stored Procedures',18,4,8);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 11:45','2021-12-20 12:40','Low-Level Testing',38,5,20);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 12:50','2021-12-20 13:45','Self-Management',28,3,13);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 13:55','2021-12-20 14:50','Assembler',4,8,3);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 15:00','2021-12-20 15:55','Java',8,6,4);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-20 16:05','2021-12-20 17:00','Data-driven testing',48,1,23);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 08:30','2021-12-21 09:25','Team Leader Management',30,4,14);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 09:35','2021-12-21 10:30','High-Level Testing',38,7,21);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 10:40','2021-12-21 11:35','Script Testing',45,9,22);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 11:45','2021-12-21 12:40','Team-Building Communication',36,2,18);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 12:50','2021-12-21 13:45','SQL Stored Procedures',16,5,8);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 13:55','2021-12-21 14:50','Low-Level Testing',40,5,20);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 15:00','2021-12-21 15:55','Mentoring',20,1,11);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-21 16:05','2021-12-21 17:00','SQL Queries',13,4,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 08:30','2021-12-22 09:25','Algorithms',3,8,1);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 09:35','2021-12-22 10:30','Python',10,2,5);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 10:40','2021-12-22 11:35','Java AI Testing',53,9,27);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 11:45','2021-12-22 12:40','Public Performance',23,6,10);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 12:50','2021-12-22 13:45','In-Team Communication',35,3,16);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 13:55','2021-12-22 14:50','NoSQL',15,7,9);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 15:00','2021-12-22 15:55','Emotional Intelligence',23,1,12);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-22 16:05','2021-12-22 17:00','out-Team Communication',33,4,17);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 08:30','2021-12-23 09:25','Keyword-based',45,5,24);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 09:35','2021-12-23 10:30','R AI Testing',53,2,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 10:40','2021-12-23 11:35','Python AI Testing',51,6,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 11:45','2021-12-23 12:40','C#',7,3,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 12:50','2021-12-23 13:45','Unit Testing',38,8,19);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 13:55','2021-12-23 14:50','C',3,7,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 15:00','2021-12-23 15:55','PM Management',30,9,15);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-23 16:05','2021-12-23 17:00','Data-driven testing',45,4,23);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 08:30','2021-12-24 09:25','High-Level Testing',41,8,21);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 09:35','2021-12-24 10:30','Mentoring',23,1,11);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 10:40','2021-12-24 11:35','Self-Management',28,7,13);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 11:45','2021-12-24 12:40','Assembler',5,5,3);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 12:50','2021-12-24 13:45','Script Testing',47,2,22);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 13:55','2021-12-24 14:50','SQL Stored Procedures',17,9,8);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 15:00','2021-12-24 15:55','Python',10,3,5);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-24 16:05','2021-12-24 17:00','NoSQL',13,6,9);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 08:30','2021-12-28 09:25','out-Team Communication',31,4,17);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 09:35','2021-12-28 10:30','R AI Testing',53,9,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 10:40','2021-12-28 11:35','Python AI Testing',54,3,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 11:45','2021-12-28 12:40','C',1,5,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 12:50','2021-12-28 13:45','C#',9,7,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 13:55','2021-12-28 14:50','Java AI Testing',49,2,27);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 15:00','2021-12-28 15:55','SQL Queries',13,8,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-28 16:05','2021-12-28 17:00','Java',12,6,4);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 08:30','2021-12-29 09:25','Team-Building Communication',31,1,18);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 09:35','2021-12-29 10:30','Team Leader Management',30,4,14);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 10:40','2021-12-29 11:35','Public Performance',23,3,10);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 11:45','2021-12-29 12:40','Keyword-based',48,5,24);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 12:50','2021-12-29 13:45','Low-Level Testing',41,1,20);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 13:55','2021-12-29 14:50','In-Team Communication',35,6,16);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 15:00','2021-12-29 15:55','Unit Testing',39,2,19);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-29 16:05','2021-12-29 17:00','PM Management',30,7,15);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 08:30','2021-12-30 09:25','Emotional Intelligence',20,8,12);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 09:35','2021-12-30 10:30','Algorithms',6,9,1);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 10:40','2021-12-30 11:35','Python AI Testing',49,3,25);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 11:45','2021-12-30 12:40','R AI Testing',54,1,26);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 12:50','2021-12-30 13:45','C#',10,4,6);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 13:55','2021-12-30 14:50','C',4,2,2);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 15:00','2021-12-30 15:55','SQL Queries',17,6,7);
insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-30 16:05','2021-12-30 17:00','Java AI Testing',53,5,27);