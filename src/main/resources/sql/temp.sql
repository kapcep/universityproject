select classroom.id, classroom.classroom_name, classroom.classroom_number, departments.department_name
from classroom
         join departments on classroom.department_id = departments.id;

select * from student_groups;

select student_groups.id,student_groups.group_name, faculties.faculty_name from student_groups join faculties on student_groups.faculty_id = faculties.id;