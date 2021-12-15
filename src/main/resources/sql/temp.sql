select classroom.id, classroom.classroom_name, classroom.classroom_number, departments.department_name
from classroom
         join departments on classroom.department_id = departments.id;

select * from student_groups;

select student_groups.id,student_groups.group_name, faculties.faculty_name from student_groups join faculties on student_groups.faculty_id = faculties.id;


insert into  schedule_items (begin_time, end_time, lesson_name,classroom_id, student_group_id, teacher_id) values ('2021-12-01 08:30','2021-12-01 09:25','Algorithms',3,1,1);
