CREATE TABLE "faculties" (
                             "id" SERIAL PRIMARY KEY,
                             "faculty_name" varchar
);

CREATE TABLE "student_groups" (
                                  "id" SERIAL PRIMARY KEY,
                                  "group_name" varchar,
                                  "faculty_id" int
);

CREATE TABLE "departments" (
                               "id" SERIAL PRIMARY KEY,
                               "department_name" varchar,
                               "faculty_id" int
);

CREATE TABLE "students" (
                            "id" SERIAL PRIMARY KEY,
                            "student_name" varchar,
                            "student_surname" varchar,
                            "age" int,
                            "student_group_id" int
);

CREATE TABLE "teachers" (
                            "id" SERIAL PRIMARY KEY,
                            "teacher_name" varchar,
                            "teacher_surname" varchar,
                            "age" int,
                            "department_id" int
);

CREATE TABLE "schedule_time" (
                                 "id" SERIAL PRIMARY KEY,
                                 "begin_time" timestamp,
                                 "end_time" timestamp
);

CREATE TABLE "classroom" (
                             "id" SERIAL PRIMARY KEY,
                             "classroom_name" varchar,
                             "classroom_number" int
);

CREATE TABLE "schedule_items" (
                                  "id" SERIAL PRIMARY KEY,
                                  "schedule_time_id" int,
                                  "classroom_id" int,
                                  "student_group_id" int,
                                  "teacher_id" int
);

ALTER TABLE "student_groups" ADD FOREIGN KEY ("faculty_id") REFERENCES "faculties" ("id");

ALTER TABLE "departments" ADD FOREIGN KEY ("faculty_id") REFERENCES "faculties" ("id");

ALTER TABLE "students" ADD FOREIGN KEY ("student_group_id") REFERENCES "student_groups" ("id");

ALTER TABLE "teachers" ADD FOREIGN KEY ("department_id") REFERENCES "departments" ("id");

ALTER TABLE "schedule_items" ADD FOREIGN KEY ("schedule_time_id") REFERENCES "schedule_time" ("id");

ALTER TABLE "schedule_items" ADD FOREIGN KEY ("classroom_id") REFERENCES "classroom" ("id");

ALTER TABLE "schedule_items" ADD FOREIGN KEY ("student_group_id") REFERENCES "student_groups" ("id");

ALTER TABLE "schedule_items" ADD FOREIGN KEY ("teacher_id") REFERENCES "teachers" ("id");